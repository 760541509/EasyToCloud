package com.yingtongquan.checkstand.controller;


import com.github.wxpay.sdk.WXPayUtil;
import com.yingtongquan.checkstand.payment.WXPaid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

@RestController
@RequestMapping("/checkstand")
public class WXPaymentController {

    @PostMapping("/WXPaid")
    public String wxPaid(HttpServletRequest req) throws Exception {
        WXPaid wxPaid = new WXPaid();
        // 1.解析参数，封装为map
        ServletInputStream in = req.getInputStream();
        BufferedReader reader =new BufferedReader(new InputStreamReader(in));
        String sReqData="";
        String itemStr;
        while(null!=(itemStr=reader.readLine())){
            sReqData+=itemStr;
        }
        Map<String, String> param = WXPayUtil.xmlToMap(sReqData);
        return wxPaid.wxPaid(param);
    }

}
