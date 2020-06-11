package com.yingtongquan.system.user.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yingtongquan.startcommon.base.ResultVo;
import com.yingtongquan.startcommon.util.JwtUtil;
import com.yingtongquan.startcommon.util.MD5;
import com.yingtongquan.system.user.entity.TblUserPo;
import com.yingtongquan.system.user.entity.TblUserWxPo;
import com.yingtongquan.system.user.mapper.TblUserWxMapper;
import com.yingtongquan.system.user.pojo.WXUserBindPhone;
import com.yingtongquan.system.user.pojo.WXUserInformation;
import com.yingtongquan.system.user.service.TblUserService;
import com.yingtongquan.system.user.service.TblUserWxService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class TblUserWxServiceImpl implements TblUserWxService {

    @Resource
    private TblUserWxMapper userWxMapper;
    @Resource
    private TblUserService userService;

    @Override
    public ResultVo login(TblUserWxPo userWxPo) {
        Map<String, Object> param = new HashMap<>();
        param.put("grant_type", "authorization_code");
        param.put("appid", "wx6fed689550449033");
        param.put("secret", "03f81d45023a9e642d6d9f7cdf706179");
        param.put("js_code", userWxPo.getCode());
        String post = HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session", param);
        JSONObject jsonObject = JSONUtil.parseObj(post);
        // errCode 微信返回状态码 -1 系统繁忙，此时请开发者稍候再试，0请求成功，40163 code已被使用,40029 code 无效，45011 频率限制，每个用户每分钟100次
        //用户openId
        String openid = String.valueOf(jsonObject.get("openid"));
        if (!"null".equals(openid)) {
            // 登录成功
            // openid是微信通过 appid+secret+微信号 生成的，那么一个微信号对一个小程序的openid是永恒不变的
            TblUserWxPo tblUserWxPo = queryTheUserWithOPENID(openid);
            //用户sessionKey
            String sessionKey = String.valueOf(jsonObject.get("session_key"));
            if (tblUserWxPo == null) {
                userWxPo.setOpenId(openid);
                userWxPo.setSessionKey(sessionKey);
                addWXUserInformation(userWxPo);
                tblUserWxPo = queryTheUserWithOPENID(openid);
            }
            String token = null;
            try {
                token = JwtUtil.createToken(tblUserWxPo.getId(), openid, sessionKey, "WX",0,0);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return ResultVo.successResult(token);
        } else {
            return ResultVo.buildResult(400, "微信授权登录失败：" + jsonObject.get("errmsg"), null);
        }
    }

    @Override
    public TblUserWxPo queryTheUserWithOPENID(String openId) {
        return userWxMapper.queryTheUserWithOPENID(openId);
    }


    @Override
    public void addWXUserInformation(TblUserWxPo userWxPo) {
        userWxMapper.addWXUserInformation(userWxPo);
    }

    @Override
    public WXUserInformation theUserIDIsQueriedByTheMobilePhoneNumber(String phone) {
        return userWxMapper.theUserIDIsQueriedByTheMobilePhoneNumber(phone);
    }

    @Override
    public TblUserWxPo queryWXUserInformation(Integer id) {
        return userWxMapper.queryWXUserInformation(id);
    }

    @Override
    public void addWeChatUserPhone(String phone, String openId, String sessionKey) {
        userWxMapper.addWeChatUserPhone(phone, openId, sessionKey);
    }

    @Override
    public void modifyTheUserSessionKey(String openId, String sessionKey) {
        userWxMapper.modifyTheUserSessionKey(openId, sessionKey);
    }

    @Override
    public void bindWXUserPhone(WXUserBindPhone userBindPhone, Integer userId) {
        TblUserWxPo tblUserWxPo = queryWXUserInformation(userId);
        byte[] decode = Base64.decode(userBindPhone.getIv());
        byte[] key = Base64.decode(tblUserWxPo.getSessionKey());
        AES aes = new AES("CBC", "PKCS5Padding", key, decode);
        String decryptStr = aes.decryptStr(userBindPhone.getEncryptedData());
        JSONObject target = JSONUtil.parseObj(decryptStr);
        //用户手机号
        String phoneNumber = String.valueOf(target.get("purePhoneNumber"));
        addWeChatUserPhone(phoneNumber, tblUserWxPo.getOpenId(), tblUserWxPo.getSessionKey());

        TblUserPo userPo = new TblUserPo();
        userPo.setMac("");
        userPo.setPhone(phoneNumber);
        userPo.setUsername(tblUserWxPo.getName());
        userPo.setAccount(phoneNumber);
        userPo.setAddTime(System.currentTimeMillis());
        userPo.setSaltValue(Base64.encode(RandomStringUtils.randomAlphanumeric(20)).toUpperCase());
        userPo.setPassword(MD5.encryption(tblUserWxPo.getName(), RandomStringUtils.randomAlphanumeric(6), userPo.getSaltValue()));
        userService.registeredAccount(userPo);
    }
}
