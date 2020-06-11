//package com.yingtongquan.employees.util;
//
//import cn.hutool.json.JSONObject;
//import cn.hutool.json.JSONUtil;
//import cn.hutool.log.StaticLog;
//import com.yingtongquan.startcommon.util.HttpRequest;
//import com.yingtongquan.startcommon.util.MD5;
//import com.yingtongquan.startcommon.util.TimeUtil;
//import com.yingtongquan.employees.shop.entity.PrinterPo;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.util.Map;
//
//public class PrinterUtil {
//    //映美云APPID
//    private static final String APPID = "190523175020826";
//
//
//    /**
//     * @Author:胖虎
//     * @Date 2020/4/16 15:38
//     * 获取token
//     **/
//    public static PrinterPo getAccessToken() {
//        String _url = "https://mcp.jolimark.com/mcp/v2/sys/GetAccessToken";
//        Long time = System.currentTimeMillis() / 1000;// 时间戳
//        // MD5签名
//        String base = "app_id=" + APPID + "&sign_type=MD5&time_stamp=" + time + "&key=4fednaehe8janrd9";
//        String _params = "app_id=" + APPID +
//                "&time_stamp=" + time + // 时间戳
//                "&sign=" + MD5.encrypt(base) +
//                "&sign_type=MD5";
//        HttpRequest r = new HttpRequest(_url, _params, "get"); // get请求方式
//        String res = r.send();
//        JSONObject jsonObject = JSONUtil.parseObj(res);
//        PrinterPo printerPo = new PrinterPo();
//        TimeUtil timeUtil = new TimeUtil();
//        if ("0".equals(String.valueOf(jsonObject.get("return_code")))) {
//            Object result = jsonObject.get("return_data");
//            JSONObject data = JSONUtil.parseObj(result);
//            printerPo.setTime(timeUtil.timeConversionMilliseconds(String.valueOf(data.get("create_time"))));
//            printerPo.setToken(String.valueOf(data.get("access_token")));
//        }
//        return printerPo;
//    }
//
//    /**
//     * @Author:胖虎
//     * @Date 2020/4/16 15:39
//     * 绑定打印机
//     **/
//    public static String bindPrinter(String codes, String checkCode,String token) {
//        String _url = "https://mcp.jolimark.com/mcp/v3/sys/BindPrinter";
//        String _params = "app_id=" + APPID +
//                "&access_token=" + token + // 时间戳
//                "&device_codes=" + codes + "#" + checkCode;
//        HttpRequest r = new HttpRequest(_url, _params, "post"); // get请求方式
//        String res = r.send();
//        JSONObject jsonObject = JSONUtil.parseObj(res);
//        if (444444 == getReturnCode(jsonObject)) {
//            return "服务器开小差了，请重试";
//        }
//        String return_msg = String.valueOf(jsonObject.get("return_msg"));
//        return return_msg;
//    }
//    private static int getReturnCode(JSONObject jsonObject) {
//        if (jsonObject == null) {
//            return -1;
//        }
//        Integer return_code = Integer.valueOf(String.valueOf(jsonObject.get("return_code")));
//        if (10103 == return_code || 10102 == return_code) {
//            return 444444;
//        }
//        return return_code;
//    }
//
//    /**
//    *@Author:胖虎
//    *@Date 2020/4/16 15:42
//    *打印HTML页面打印
//    **/
//    public static String printHtml(String deviceId, String tradeNum, String content, Integer width,String token) {
//        String _url = "https://mcp.jolimark.com/mcp/v3/sys/PrintRichHtmlCode";
//        String _params = null;
//        try {
//            _params = "app_id=" + APPID +
//                    "&access_token=" + token + // 时间戳
//                    "&device_ids=" + deviceId +
//                    "&cus_orderid=" + tradeNum +
//                    "&bill_content=" + URLEncoder.encode(content, "utf-8") +
//                    "&paper_width=" + width +
//                    "&paper_type=1" +
//                    "&device_ids=" + deviceId;
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        HttpRequest r = new HttpRequest(_url, _params, "post"); // get请求方式
//        JSONObject jsonObject = JSONUtil.parseObj(r.send());
//        if (444444 == getReturnCode(jsonObject)) {
//            return "服务器开小差了，请重试";
//        }
//        String return_data = String.valueOf(jsonObject.get("return_data"));
//        StaticLog.info(return_data);
//        return return_data;
//    }
//
//    /**
//     * 打印商品条码
//     *
//     * @param deviceIds 设备ID列表
//     * @param copies    打印份数
//     * @param data      参数
//     * @return
//     */
//    public static String printBarCode(String deviceIds, String copies, Map<String, String> data,String token) {
//        String _url = "https://mcp.jolimark.com/mcp/v3/sys/PrintHtmlTemplate";
//        String _params = "app_id=" + APPID +
//                "&access_token=" + token + // 时间戳
//                "&device_ids=" + deviceIds +
//                "&template_id=30efe2b9282f26b4&cus_orderid=" + System.currentTimeMillis() +
//                "&bill_content=" + JSONUtil.parse(data).toString() +
//                "&copies=" + copies +
//                "&paper_type=2" +
//                "&device_ids=" + deviceIds;
//        HttpRequest r = new HttpRequest(_url, _params, "post"); // get请求方式
//        JSONObject jsonObject = JSONUtil.parseObj(r.send());
//        if (444444 == getReturnCode(jsonObject)) {
//            return "服务器开小差了，请重试";
//        }
//        String return_data = String.valueOf(jsonObject.get("return_data"));
//        StaticLog.info(return_data);
//        return return_data;
//    }
//
//    /**
//     * @Author:胖虎
//     * @Date 2020/4/11 12:18
//     * 解绑打印机
//     **/
//    public static Boolean unbindPrinter(String printerCode, String token) {
//        String url = "https://mcp.jolimark.com/mcp/v3/sys/UnBindPrinter";
//        String params = "app_id=" + APPID +
//                "&access_token=" + token + // 时间戳
//                "&device_id=" + printerCode;
//
//        HttpRequest r = new HttpRequest(url, params, "post"); // get请求方式
//        String res = r.send();
//        JSONObject jsonObject = JSONUtil.parseObj(res);
//        if ("0".equals(String.valueOf(jsonObject.get("return_code")))) {
//            return true;
//        }
//        return false;
//    }
//}
