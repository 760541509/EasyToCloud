package com.yingtongquan.checkstand.util;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class PaymentUtil {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    private static final String ALGORITHOM = "RSA";//固定值，无须修改

    private static final String CIPHER_PROVIDER = "SunJCE";
    private static final String MCH_ID = "1561606541";
    private static final String MCH_KEY = "967c2d9020274c93989d78498a103824";
    private static final String TRANSFORMATION_PKCS1Paddiing = "RSA/ECB/PKCS1Padding"; //RSAES-PKCS1-v1_5 RSA/ECB/PKCS1Padding

    private static final String CHAR_ENCODING = "UTF-8";//固定值，无须修改
    private static final byte[] PUBLIC_KEY_BYTES;//平台证书路径，开发人员需根据具体路径修改

    static {
        //证书位置 通过流可以读取到Jar包中的路径，因为打包后是一个文件 所有通过地址就访问不到了
        ClassPathResource resource = new ClassPathResource("apiclient_cert.pem");
        InputStream stream = resource.getStream();
        PUBLIC_KEY_BYTES = IoUtil.readBytes(stream);
    }

    public static String toWxTime(Long time) {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        System.out.println(simpleDateFormat.format(new Date(time)));
        return simpleDateFormat.format(new Date(time));
    }

    public static Long wxTime2Num(String timeEnd) throws ParseException {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return simpleDateFormat.parse(timeEnd).getTime();
    }

}
