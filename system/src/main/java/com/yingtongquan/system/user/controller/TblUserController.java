package com.yingtongquan.system.user.controller;


import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.yingtongquan.startcommon.base.ResultVo;
import com.yingtongquan.startcommon.pojo.LatAndLon;
import com.yingtongquan.startcommon.util.ServiceUtil;
import com.yingtongquan.system.user.entity.TblUserPo;
import com.yingtongquan.system.user.entity.TblUserWxPo;
import com.yingtongquan.system.user.pojo.*;
import com.yingtongquan.system.user.service.TblUserService;
import com.yingtongquan.system.user.service.TblUserWxService;
import com.yingtongquan.system.user.service.UserAndShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Pang
 * @since 2020-05-06
 */
@RestController
@RequestMapping("/system/tblUserPo")
@Api(tags = "系统相关")
public class TblUserController {

    private static AES aes;

    static {
        aes = new AES("CBC", "PKCS5Padding", "81d3d6a45b08b86259caa3e338551e38".getBytes(), "5b08b86259caa3e3".getBytes());
    }

    public static AES getAes() {
        return aes;
    }

    private static final String END_POINT = "https://oss-cn-beijing.aliyuncs.com";
    private static final String ACCESS_KEY_ID = "LTAIefR8cOkQ0YBD";
    private static final String SECRET_ACCESS_KEY = "jzgF7I8R1ClyHv4P3RhcdLHq9yVjzS";
    private static final String BUCKET_NAME = "ytq";

    @Resource
    private TblUserService userService;
    @Resource
    private TblUserWxService tblUserWxService;
    @Resource
    private UserAndShopService userAndShopService;

    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private HttpServletRequest request;


    @ApiOperation("注册账号")
    @PostMapping("/addUserInfromation")
    public ResultVo addUserInformation(@RequestBody UserRegis userRegis) {
        TblUserPo tblUserPo = userService.checkIfTheAccountExists(userRegis.getPhone());
        Assert.isNull(tblUserPo, "该账号已存在，请重新输入");
        Assert.isTrue(checkPhoneCode(userRegis.getCheckCode(), userRegis.getPhone()), "验证码输入错误，请重新输入");
        return ResultVo.successResult(userService.addUserInformation(userRegis));
    }

    @ApiOperation("登陆")
    @PostMapping("/userLogin")
    public ResultVo userLogin(@RequestBody UserLogin login) {
        return new ServiceUtil().execute(() -> userService.login(login));
    }

    @ApiOperation("修改密码")
    @PostMapping("/updateUserPassword")
    public ResultVo updateUserPassword(@RequestBody UserLogin login, String codes) throws UnsupportedEncodingException {
        TblUserPo tblUserPo = userService.checkIfTheAccountExists(login.getAccount());
        Assert.isNull(tblUserPo, "该账号不存在，请确认是否输入有误");
        Assert.isTrue(checkPhoneCode(codes, login.getAccount()), "验证码输入错误，请重新输入");
        return ResultVo.successResult(userService.login(login));
    }


    @ApiOperation(value = "传入手机号，获取验证码")
    @PostMapping("/getPhoneCheckCode")
    public ResultVo getPhoneCheckCode(@RequestBody String phone) {
        JSONObject jsonObject = new JSONObject(phone);
        Object userPhone = jsonObject.get("phone");
        try {
            String msgId = null;
            Assert.notNull(phone, "用户手机号不能为空");
            HttpRequest post = HttpUtil.createPost("https://api.sms.jpush.cn/v1/codes");
            post.header("Authorization", "Basic YzI5MzY1ZjE0ODg1ZjVjNTAxMGE3NTEwOjkzNzg4MzU4YjNlYjI4MTBmZjZiMmQ1Yg==");
            post.body("{\"mobile\":\"" + userPhone + "\",\"ttl\":11129,\"temp_id\":1}");
            HttpResponse execute = post.execute();
            JSONObject result = JSONUtil.parseObj(execute.body());
            System.out.println(result);
            msgId = String.valueOf(result.get("msg_id"));
            redisTemplate.opsForValue().set(userPhone, msgId);
            redisTemplate.expire(userPhone, 300 * 5, TimeUnit.SECONDS);
            return ResultVo.successResult(msgId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.errorResult("获取手机号失败");
        }
    }

    //验证码检验
    private Boolean checkPhoneCode(String codes, String phone) {
        String msgId = (String) redisTemplate.opsForValue().get(phone);
        Assert.notNull(redisTemplate.opsForValue().get(phone), "验证码已过期，请重新获取！");
        // HttpUtil 请求第三方接口
        // 消息ID 和验证嘛， 如果需要手动实现，将发出去的验证码作为value 消息ID作为key 放入map，验证后在删除
        HttpRequest post = HttpUtil.createPost("https://api.sms.jpush.cn/v1/codes/" + msgId + "/valid");
        post.header("Authorization", "Basic YzI5MzY1ZjE0ODg1ZjVjNTAxMGE3NTEwOjkzNzg4MzU4YjNlYjI4MTBmZjZiMmQ1Yg==");
        post.body("{\"code\":\"" + codes + "\"}");
        HttpResponse execute = post.execute();
        JSONObject result = JSONUtil.parseObj(execute.body());
        Boolean isValid = Boolean.valueOf(String.valueOf(result.get("is_valid")));
        return isValid;
    }

    @ApiOperation(value = "加密")
    @PostMapping("/encode")
    public String encode(String content) throws Exception {
        return TblUserController.getAes().encryptBase64(content.getBytes());
    }

    @ApiOperation(value = "解密")
    @PostMapping("/decode")
    public String decode(String content) throws Exception {
        String s = TblUserController.getAes().decryptStr(content);
        return s;
    }

    @ApiOperation(value = "微信授权登陆")
    @PostMapping("/WXLogin")
    public ResultVo WXLogin(@RequestBody TblUserWxPo userWxPo) {
        return ResultVo.successResult(tblUserWxService.login(userWxPo));
    }

    @ApiOperation(value = "微信小程序绑定手机号")
    @PostMapping("/WXBindPhone")
    public ResultVo WXBindPhone(@RequestBody WXUserBindPhone userBindPhone) {
        Integer wxUserId = com.yingtongquan.startcommon.util.HttpUtil.getWXUserId(request.getHeader("token"));
        tblUserWxService.bindWXUserPhone(userBindPhone, wxUserId);
        return ResultVo.successResult();
    }

    @ApiOperation(value = "上传图片/文件")
    @PostMapping("/upload")
    public ResultVo fileUpload(MultipartHttpServletRequest multiRequest, String typeName) {
        try {
            //获取到io流
            Iterator<String> iter = multiRequest.getFileNames();
            if (iter.hasNext()) {
                //得到multiRequest中的相关数据
                MultipartFile multipartFile = multiRequest.getFile(iter.next());
                //将multiRequest转换为file形式的io流
                InputStream inputStream = multipartFile.getInputStream();
                //请求中的token
                String token = request.getHeader("token");
                //token中包含的shopId
                Integer shopId = com.yingtongquan.startcommon.util.HttpUtil.getShopId(token);
                //文件名字
                String fileName = "" + shopId + System.currentTimeMillis();
                String upload = upload(inputStream, typeName, fileName);
                return ResultVo.successResult(upload);
            }
            return ResultVo.successResult();
        } catch (IOException e) {
            return ResultVo.errorResult("图片上传异常");
        }
    }

    @ApiOperation(value = "抽奖")
    @PostMapping("/luckyDraw")
    public ResultVo luckyDraw(@RequestBody LuckyDrawInformation luckyDrawInformation) {
        return ResultVo.successResult(userAndShopService.lotteryTurntable(luckyDrawInformation.getShopId(), luckyDrawInformation.getDialNumber()));
    }

    @ApiOperation(value = "根据经纬度获取地址ID")
    @PostMapping("/latAndLotGetAddress")
    public ResultVo latAndLotGetAddress(@RequestBody LatAndLon latAndLon) {
        return ResultVo.successResult(userAndShopService.queryAreaId(latAndLon));
    }

    @ApiOperation(value = "切换店铺")
    @PostMapping("/switchTheStore")
    public ResultVo latAndLotGetAddress(@RequestBody SwitchStore switchStore) {
        return ResultVo.successResult(userService.switchTheStore(switchStore.getShopId()));
    }

    @ApiOperation(value = "根据手机号查询信息")
    @PostMapping("/switchTheStore")
    public ResultVo latAndLotGetAddress(@RequestBody UserLogin login) {
        return ResultVo.successResult(userService.queryUserInformation(login.getAccount()));
    }

    public String upload(InputStream is, String typeName, String fileName) {
        String objectName = "ryy/" + typeName + "/" + fileName;
        OSS ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, SECRET_ACCESS_KEY);
        ossClient.putObject(BUCKET_NAME, objectName, is);
        ossClient.shutdown();
        StaticLog.info("https://ytq.oss-cn-beijing.aliyuncs.com/" + objectName);
        return objectName;
    }
}
