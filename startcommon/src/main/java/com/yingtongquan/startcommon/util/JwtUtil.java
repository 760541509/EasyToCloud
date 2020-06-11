package com.yingtongquan.startcommon.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.shiro.codec.Base64;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    // 密钥
    public static final String SECRET = "SECRET";
    // 过期时间:7天
    public static final int EXPIRATION_TIME = 7 * 24 * 60 * 60 *1000;

    /**
     * 生成Token
     *
     * @param userId token中存的参数 用户ID
     * @return token
     */
    public static String createToken(Integer userId,String MAC,String password,String WX,Integer shopId,Integer staffId) throws UnsupportedEncodingException {
        long endTime = System.currentTimeMillis() + EXPIRATION_TIME ;
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token;
        if(WX == ""){
            token = JWT.create()
                    .withHeader(map)
                    .withClaim("mac", MAC)
                    .withClaim("password", password)
                    .withClaim("id", userId.toString())
                    .withClaim("wx", WX)
                    .withClaim("shopId",shopId.toString())
                    .withClaim("staffId",staffId.toString())
                    .withSubject("Pang")
                    // 签名时间
                    .withIssuedAt(new Date())
                    // 过期时间
                    .withExpiresAt(new Date(endTime))
                    // 签名
                    .sign(Algorithm.HMAC256(SECRET));
        }else {
            token = JWT.create()
                    .withHeader(map)
                    .withClaim("openId", MAC)                   //这个为微信授权登陆时的openID
                    .withClaim("sessionKey", password)          //这个为微信授权登陆时的sessionKey
                    .withClaim("wxUserId", userId.toString())   //这个为微信授权登陆时的微信用户记录表的ID
                    .withClaim("wx", WX)
                    .withSubject("Pang")
                    // 签名时间
                    .withIssuedAt(new Date())
                    // 过期时间
                    .withExpiresAt(new Date(endTime))
                    // 签名
                    .sign(Algorithm.HMAC256(SECRET));
        }



        byte[] encode = org.apache.shiro.codec.Base64.encode(token.getBytes("UTF-8"));
        return new String(encode, "UTF-8");

    }

    /**
     * 验证Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) {
        byte[] decode = Base64.decode(token);
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(new String(decode, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jwt.getClaims();
    }

    /**
     * 解析Token
     *
     * @param token
     * @return
     */
    public static Map<String, Claim> parseToken(String token) throws UnsupportedEncodingException {
        byte[] decode = Base64.decode(token);
        DecodedJWT decodedJWT = JWT.decode(new String(decode, "UTF-8"));
        return decodedJWT.getClaims();
    }

    /**
     * 获取某个值
     *
     * @param key
     * @param token
     * @return
     */
    public static String getVal(String key, String token) {
        return verifyToken(token).get(key).asString();
    }
}
