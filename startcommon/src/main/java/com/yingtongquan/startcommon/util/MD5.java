package com.yingtongquan.startcommon.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.security.MessageDigest;

public class MD5 {
    public static String encrypt(String dataStr) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte s[] = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result.toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String encryption(String username, String password,String saltValue) {
        String md5 = "MD5";//MD5加密
        Object credentials = password;//密码
        Object salt = ByteSource.Util.bytes(username);//用户名
        int hashIterations = 1024;//加密多少次
        Object result = new SimpleHash(md5, credentials, salt, hashIterations);//运行加密及最终结果
        SimpleHash simpleHash = new SimpleHash(md5, result, saltValue, hashIterations);
        return simpleHash.toString();//返回成一个字符串
    }


}
