package com.yingtongquan.system;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

public class JwtTest {
    @Test
    public void test() throws Exception {
        Map<String, Object> param = Maps.newHashMap();
        param.put("grant_type", "client_credential");
        param.put("appid", "wx6fed689550449033");
        param.put("secret", "03f81d45023a9e642d6d9f7cdf706179");
        JSONObject tokenResult = JSONUtil.parseObj(HttpUtil.get("https://api.weixin.qq.com/cgi-bin/token", param));
        String access_token = String.valueOf(tokenResult.get("access_token"));
        Map<String, Object> param2 = Maps.newHashMap();
        param2.put("access_token", access_token);
        param2.put("path", "pages/home/home?shopId=" + 1 );
        HttpRequest post = HttpUtil.createPost("https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=" + access_token);
        post.body(JSONUtil.toJsonStr(param2));
        HttpResponse execute = post.execute();
        InputStream inputStream = execute.bodyStream();
        FileOutputStream out = new FileOutputStream("D:/code/test.jpg");
        int j = 0;
        while ((j = inputStream.read()) != -1) {
            out.write(j);
        }
        inputStream.close();
    }


}
