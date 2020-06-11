package com.yingtongquan.checkstand.config;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import com.github.wxpay.sdk.WXPayConfig;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class WxPayConfig implements WXPayConfig {
    private String appid = "wxc0ed33ca8c933f1a";

    private String mchId;

    private String mchKey;

    private static byte[] certData;

    static {
        //证书位置 通过流可以读取到Jar包中的路径，因为打包后是一个文件 所有通过地址就访问不到了
        ClassPathResource resource = new ClassPathResource("apiclient_cert.p12");
        //
        InputStream stream = resource.getStream();
        certData = IoUtil.readBytes(stream);
    }

    public WxPayConfig(String mchId, String mchKey) {
        this.mchId = mchId;
        this.mchKey = mchKey;
    }

    @Override
    public String getAppID() {
        return appid;
    }

    @Override
    public String getMchID() {
        return mchId;
    }

    @Override
    public String getKey() {
        return mchKey;
    }

    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(certData);
        return certBis;
    }
    @Override
    public int getHttpConnectTimeoutMs() {
        return 60000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 60000;
    }
}
