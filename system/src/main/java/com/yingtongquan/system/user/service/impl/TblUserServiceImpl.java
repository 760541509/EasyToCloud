package com.yingtongquan.system.user.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.startcommon.util.HttpUtil;
import com.yingtongquan.startcommon.util.JwtUtil;
import com.yingtongquan.startcommon.util.MD5;
import com.yingtongquan.system.user.entity.TblUserAndShopPo;
import com.yingtongquan.system.user.entity.TblUserPo;
import com.yingtongquan.system.user.mapper.TblUserMapper;
import com.yingtongquan.system.user.mapper.UserAndShopMapper;
import com.yingtongquan.system.user.pojo.LoginSuccess;
import com.yingtongquan.system.user.pojo.ShopInfromation;
import com.yingtongquan.system.user.pojo.UserLogin;
import com.yingtongquan.system.user.pojo.UserRegis;
import com.yingtongquan.system.user.service.TblUserService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Pang
 * @since 2020-05-06
 */
@Service
public class TblUserServiceImpl extends ServiceImpl<TblUserMapper, TblUserPo> implements TblUserService {

    @Resource
    private TblUserMapper userMapper;
    @Resource
    private UserAndShopMapper userAndShopMapper;

    @Resource
    private HttpServletRequest request;

    @Override
    public Boolean addUserInformation(UserRegis userRegis) {
        TblUserPo userPo = new TblUserPo();
        userPo.setUsername(userRegis.getPhone());
        userPo.setAddTime(System.currentTimeMillis());
        userPo.setPhone(userRegis.getPhone());
        userPo.setSaltValue(Base64.encode(RandomStringUtils.randomAlphanumeric(20)).toUpperCase());
        userPo.setAccount(userRegis.getPhone());
        userPo.setPassword(MD5.encryption(userRegis.getPhone(), userRegis.getPassword(), userPo.getSaltValue()));
        userPo.setMac("");
        userPo.setHeadPortrait("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F%E5%9B%BE%E7%89%87&step_word=&hs=2&pn=1&spn=0&di=43120&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=-1&cs=1618065806%2C14298536&os=2605524294%2C2363748290&simid=3179791506%2C2868578070&adpicid=0&lpn=0&ln=1029&fr=&fmq=1590475748938_R&fm=rs1&ic=undefined&s=undefined&hd=1&latest=0&copyright=0&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F%20%E5%8E%9F%E5%9B%BE&objurl=http%3A%2F%2Fwww.yozrun.com%2FUploadFiles%2Fimg_3_2774380917_512880114_26.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3By5z67g_z%26e3Bv54AzdH3FrtvAzdH3F%25El%25BB%25lb%25Eb%25AE%25A9%25Ec%25b8%25lA%25E0%25BE%25A9%25Ec%25A9%25B9%25Ec%25bn%25bF%25E0%25lA%25b9%25Ec%25lB%25BE%25E0%25bl%25b0%25E0%25B9%25Aa%25Em%25lD%25laAzdH3F&gsm=2&rpstart=0&rpnum=0&islist=&querylist=&force=undefined");
        return userMapper.addUserInformation(userPo);
    }

    @Override
    public LoginSuccess login(UserLogin login) throws UnsupportedEncodingException {
        //查询数据库
        TblUserPo userPo = userMapper.queryUserInformation(login.getAccount());
        Assert.notNull(userPo, "账号不存在，请注册账号");
        //检验密码
        String password = MD5.encryption(login.getAccount(), login.getPassword(), userPo.getSaltValue());
        Assert.isTrue(password.equals(userPo.getPassword()), "账号或密码错误，请检查输入的是否真确！");
        LoginSuccess loginSuccess = new LoginSuccess();
        LoginSuccess success = userAndShopMapper.queryUserInformation(login.getAccount());
        Integer shopId = userAndShopMapper.queryUserShopId(success.getId());
        String storeIcon = "";
        LoginSuccess userStaff = null;
        //生成token
        String token = null;
        if (shopId != null) {
            userStaff = userAndShopMapper.queryUserStaff(shopId, success.getId());
            storeIcon = userAndShopMapper.queryShopStoreIcon(shopId);
            token = JwtUtil.createToken(userPo.getId(), login.getMac(), password, "", shopId,userStaff.getStaffId());
            loginSuccess.setShopId(shopId);
        } else {
            token = JwtUtil.createToken(userPo.getId(), login.getMac(), password, "", 0,0);
        }
        loginSuccess.setId(success.getId());
        loginSuccess.setAccount(success.getAccount());
        loginSuccess.setAddTime(success.getAddTime());
        loginSuccess.setHeadPortrait(success.getHeadPortrait());
        loginSuccess.setPhone(success.getPhone());
        loginSuccess.setStoreIcon(storeIcon);
        loginSuccess.setUsername(success.getUsername());
        loginSuccess.setToken(token);
        loginSuccess.setStaffId(userStaff.getStaffId());
        loginSuccess.setStaffName(userStaff.getStaffName());
        loginSuccess.setStaffPhone(userStaff.getStaffPhone());
        loginSuccess.setRoleName(userStaff.getRoleName());
        loginSuccess.setResources(userStaff.getResources());
        return loginSuccess;
    }

    @Override
    public Boolean updateUserInformation(UserLogin login) {
        //查询数据库
        TblUserPo userPo = userMapper.queryUserInformation(login.getAccount());
        login.setPassword(MD5.encryption(login.getAccount(), login.getPassword(), userPo.getSaltValue()));
        return userMapper.updateUserPassword(login.getAccount(), login.getPassword());
    }

    @Override
    public TblUserPo checkIfTheAccountExists(String account) {
        return userMapper.checkIfTheAccountExists(account);
    }

    @Override
    public void registeredAccount(TblUserPo userPo) {
        userMapper.addUserInformation(userPo);
    }

    @Override
    public LoginSuccess switchTheStore(Integer shopId) {
        String token = request.getHeader("token");
        Integer userId = 0;
        String wx = HttpUtil.getWX(token);
        if ("".equals(wx)) {
            userId = HttpUtil.getCurUserId(token);
        } else if ("WX".equals(wx)) {
            userId = userMapper.queryUserId(HttpUtil.getWXUserId(token));
        }
        userMapper.updateUserAndShopRelationshipBetween(userId);
        TblUserAndShopPo userAndShopPo = new TblUserAndShopPo();
        userAndShopPo.setIsDefault(1);
        userAndShopPo.setShopId(shopId);
        userAndShopPo.setUserId(userId);
        userMapper.addUserAndShopRelationshipBetween(userAndShopPo);
        TblUserPo userPo = userMapper.queryUser(userId);
        ShopInfromation shopInfromation = userMapper.queryShopInformation(shopId);

        LoginSuccess success = userAndShopMapper.queryUserStaff(shopId, userId);
        LoginSuccess loginSuccess = new LoginSuccess();
        //店铺图标
        loginSuccess.setStoreIcon(shopInfromation.getStoreIcon());
        loginSuccess.setId(userPo.getId());
        //电话
        loginSuccess.setPhone(userPo.getPhone());
        //用户头像
        loginSuccess.setHeadPortrait(userPo.getHeadPortrait());
        //用户注册时间
        loginSuccess.setAddTime(userPo.getAddTime());
        //用户账号
        loginSuccess.setAccount(userPo.getAccount());
        //店铺ID
        loginSuccess.setShopId(shopId);
        //用户名称
        loginSuccess.setUsername(userPo.getUsername());

        loginSuccess.setStaffId(success.getStaffId());
        loginSuccess.setStaffName(success.getStaffName());
        loginSuccess.setStaffPhone(success.getStaffPhone());
        loginSuccess.setRoleName(success.getRoleName());
        loginSuccess.setResources(success.getResources());

        try {
            token = JwtUtil.createToken(userPo.getId(), userPo.getMac(), userPo.getPassword(), "", shopId,success.getStaffId());
            //token
            loginSuccess.setToken(token);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return loginSuccess;
    }

    @Override
    public TblUserPo queryUserInformation(String account) {
        return userMapper.queryUserInformation(account);
    }
}
