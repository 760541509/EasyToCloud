package com.yingtongquan.checkstand.payment;

import com.github.wxpay.sdk.WXPay;
import com.yingtongquan.checkstand.config.WxPayConfig;
import com.yingtongquan.checkstand.pojo.Refund;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class WXRefund {

    private static WXPay wxpay = null;

    public static Map<String, String> WXRefund(Refund param) {
        Map<String, String> result = null;
        wxpay = new WXPay(new WxPayConfig("1561606541", "967c2d9020274c93989d78498a103824"));
        Map<String, String> map = param.mapParam();
        try {
            result = wxpay.refund(map);
            log.info("[refund] [退款API响应参数] [uid:{}] [out_trade_no:{}] [resultMap:{}]");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("[refund] [uid:{}] [out_trade_no:{}]  [调用微信SDK过程中出现异常:{}]");
        }
        return result;
    }
}
