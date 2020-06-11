package com.yingtongquan.checkstand.payment;


import com.github.wxpay.sdk.WXPay;
import com.yingtongquan.checkstand.config.WxPayConfig;
import com.yingtongquan.checkstand.pojo.UnifiedOrderParam;

import java.util.Map;

public class WXPayment {

    private static WXPay wxpay = null;

    public static Map<String, String> creatWxOrder(UnifiedOrderParam param) throws Exception {
        // 构建微信支付配置
        wxpay = new WXPay(new WxPayConfig("1561606541","967c2d9020274c93989d78498a103824"));
        // 统一下单
        Map<String, String> map = param.mapParam();
        return wxpay.unifiedOrder(map);
    }

}
