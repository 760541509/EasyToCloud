package com.yingtongquan.startcommon.util;

public class HttpUtil {

    /**
     * @Date 2020/5/11 16:01
     * @Author 胖虎
     * 获取token中的用户ID
     **/
    public static Integer getCurUserId(String token) {
        String userId = JwtUtil.getVal("id", token);
        return Integer.valueOf(userId);
    }

    /**
     * @Date 2020/5/11 16:01
     * @Author 胖虎
     * 获取token中的员工ID
     **/
    public static Integer getStaffId(String token) {
        String staffId = JwtUtil.getVal("staffId", token);
        return Integer.valueOf(staffId);
    }

    /**
     * @Date 2020/5/11 16:01
     * @Author 胖虎
     * 获取token中的店铺ID
     **/
    public static Integer getShopId(String token) {
        String shopId = JwtUtil.getVal("shopId", token);
        return Integer.valueOf(shopId);
    }

    /**
     * @Date 2020/5/11 16:01
     * @Author 胖虎
     * 获取token中的用户密码
     **/
    public static Integer getUserPassword(String token) {
        String password = JwtUtil.getVal("password", token);
        return Integer.valueOf(password);
    }

    /**
     * @Date 2020/5/16 14:00
     * @Author 胖
     * 获取token中的WX这个字段   用于判断这个token是微信小程序还是APP
     **/
    public static String getWX(String token) {
        String wx = JwtUtil.getVal("wx", token);
        return wx;
    }

    /**
     * @Date 2020/5/15 12:23
     * @Author 胖虎
     * 获取token中的微信用户ID
     **/
    public static Integer getWXUserId(String token) {
        String wxUserId = JwtUtil.getVal("wxUserId", token);
        return Integer.valueOf(wxUserId);
    }

    /**
     * @Date 2020/5/15 12:23
     * @Author 胖虎
     * 获取token中的微信用户openId
     **/
    public static Integer getWXUserOpenId(String token) {
        String openid = JwtUtil.getVal("openId", token);
        return Integer.valueOf(openid);
    }

    /**
     * @Date 2020/5/15 12:23
     * @Author 胖虎
     * 获取token中的微信用户sessionKey
     **/
    public static Integer getWXUserSessionKey(String token) {
        String sessionKey = JwtUtil.getVal("sessionKey", token);
        return Integer.valueOf(sessionKey);
    }
}
