package com.yingtongquan.checkstand;

import com.github.wxpay.sdk.WXPay;
import com.yingtongquan.checkstand.config.WxPayConfig;
import com.yingtongquan.checkstand.pojo.WeChatBarCode;
import org.junit.jupiter.api.Test;

import java.util.Map;

class CheckstandApplicationTests {

    private static WXPay wxpay = null;

    @Test
    void contextLoads() throws Exception {

        WeChatBarCode weChatBarCode = new WeChatBarCode();
        weChatBarCode.setAuthCode("134617700036960993");
        weChatBarCode.setBody("张三专卖店-购买了一堆商品");
        weChatBarCode.setOutTradeNo("00969E398DA74F1");
        weChatBarCode.setSpbillCreateIp("8:8:8:8");
        weChatBarCode.setTotalFee(1);
        System.out.println(weChatBarCode.mapParam());

        wxpay = new WXPay(new WxPayConfig("1561606541","967c2d9020274c93989d78498a103824"));

        Map<String, String> map = weChatBarCode.mapParam();
        Map<String, String> stringStringMap = wxpay.unifiedOrder(map);
        System.out.println(stringStringMap);

    }

}
