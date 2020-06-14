package com.yingtongquan.system.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yingtongquan.startcommon.util.HttpRequest;

public class PrinterUtil {

    //映美云APPID
    private static final String APPID = "190523175020826";

    /**
     * @Date 2020/6/14 16:31
     * @Author 胖
     * 获取映美云token
     **/
    public static String getAccessToken() {
        String _url = "https://mcp.jolimark.com/mcp/v2/sys/GetAccessToken";
        Long time = System.currentTimeMillis() / 1000;// 时间戳
        // MD5签名
        String base = "app_id=" + APPID + "&sign_type=MD5&time_stamp=" + time + "&key=4fednaehe8janrd9";
        String _params = "app_id=" + APPID +
                "&time_stamp=" + time + // 时间戳
                "&sign=" + Md5.encrypt(base) +
                "&sign_type=MD5";
        HttpRequest r = new HttpRequest(_url, _params, "get"); // get请求方式
        String res = r.send();
        return res;
    }

    /**
     * @param checkCode 打印机编码
     * @param codes     校验码
     * @Date 2020/6/14 16:56
     * @Author 胖
     * 绑定打印机
     **/
    public static String bindPrinter(String codes, String checkCode, String token) {
        String _url = "https://mcp.jolimark.com/mcp/v3/sys/BindPrinter";
        String _params = "app_id=" + APPID +
                "&access_token=" + token + // 时间戳
                "&device_codes=" + codes + "#" + checkCode;
        HttpRequest r = new HttpRequest(_url, _params, "post"); // get请求方式
        String res = r.send();
        JSONObject jsonObject = JSONUtil.parseObj(res);
        if ("10103".equals(jsonObject.get("return_code")) || "10102".equals(jsonObject.get("return_code"))) {
            return "服务器开小差了，请重试";
        } else if ("0".equals(jsonObject.get("return_code"))) {
            return "成功绑定";
        }
        String return_msg = String.valueOf(jsonObject.get("return_msg"));
        return return_msg;
    }

    /**
     * @Author:胖虎
     * @Date 2020/4/11 12:18
     * 解绑打印机
     **/
    public static Boolean unbindPrinter(String printerCode, String token) {
        String url = "https://mcp.jolimark.com/mcp/v3/sys/UnBindPrinter";
        String params = "app_id=" + APPID +
                "&access_token=" + token + // 时间戳
                "&device_id=" + printerCode;
        HttpRequest r = new HttpRequest(url, params, "post"); // get请求方式
        String res = r.send();
        JSONObject jsonObject = JSONUtil.parseObj(res);
        if ("0".equals(jsonObject.get("return_code"))) {
            return true;
        } else {
            return false;
        }
    }


}
