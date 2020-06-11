package com.yingtongquan.system.util;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.lang.Assert;
import cn.hutool.log.StaticLog;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import javax.security.cert.X509Certificate;
import java.io.*;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtil {

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


    /**
     * 上传图片到微信
     *
     * @param file     文件
     * @param fileName 文件名
     */
    public static String upload(File file, String fileName) {

        try {
            String media_hash = md5HashCode(new FileInputStream(file));
            String sign_type = "HMAC-SHA256";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("mch_id", MCH_ID);
            paramMap.put("media_hash", media_hash);
            paramMap.put("sign_type", sign_type);
            String sign = sha256Sign(paramMap, MCH_KEY);

            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            multipartEntityBuilder.addTextBody("mch_id", MCH_ID, ContentType.MULTIPART_FORM_DATA);
            fileName = fileName.toLowerCase();
            Assert.isTrue(fileName.endsWith("jpeg") || fileName.endsWith("jpg") || fileName.endsWith("bmp") || fileName.endsWith("png"), "图片不符合规范");
            String substring = fileName.substring(fileName.lastIndexOf('.') + 1);
            multipartEntityBuilder.addBinaryBody("media", file, ContentType.create("image/" + substring), fileName);
            multipartEntityBuilder.addTextBody("media_hash", media_hash, ContentType.MULTIPART_FORM_DATA);
            multipartEntityBuilder.addTextBody("sign_type", sign_type, ContentType.MULTIPART_FORM_DATA);
            multipartEntityBuilder.addTextBody("sign", sign, ContentType.MULTIPART_FORM_DATA);

            ByteArrayInputStream instream = null;
            SSLContext sslcontext = null;
            try {
                KeyStore keyStore = KeyStore.getInstance("PKCS12");
                ClassPathResource resource = new ClassPathResource("apiclient_cert.p12");
                InputStream stream = resource.getStream();
                instream = new ByteArrayInputStream(IoUtil.readBytes(stream));
                keyStore.load(instream, MCH_ID.toCharArray());// 这里写密码..默认是你的MCHID
                sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, MCH_ID.toCharArray()).build();
            } catch (Exception e) {
                StaticLog.error("官方微信--证书加载失败!{}", e);
            } finally {
                try {
                    if (instream != null) {
                        instream.close();
                    }
                } catch (IOException e) {
                    StaticLog.error("官方微信--证书加载失败!{}", e);
                }
            }
            @SuppressWarnings("deprecation")
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            try {
                HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/secapi/mch/uploadmedia");
                RequestConfig config = RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(10000).setSocketTimeout(10000).build();
                httpPost.setConfig(config);
                ////这里的Content-type要设置为"multipart/form-data"，否则返回“参数填写有误，请检查后重试”
                httpPost.addHeader(HTTP.CONTENT_TYPE, "multipart/form-data; charset=UTF-8");
                httpPost.addHeader(HTTP.USER_AGENT, "wxpay sdk java v1.0 " + MCH_ID);
                httpPost.setEntity(multipartEntityBuilder.build());
                CloseableHttpResponse response = httpclient.execute(httpPost);
                String result = EntityUtils.toString(response.getEntity(), "UTF-8");
                return result;
            } catch (Exception e) {
                StaticLog.error("官方微信--请求失败！{}", e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 对上次文件进行MD5获取其Hash值
     *
     * @param fis
     * @return
     */
    private static String md5HashCode(InputStream fis) {
        try {
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[8192];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                MD5.update(buffer, 0, length);
            }
            return new String(Hex.encodeHex(MD5.digest()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取HMAC-SHA256签名
     *
     * @param paramMap 签名参数（sign不参与签名）
     * @param key      签名密钥
     * @return HMAC-SHA256签名结果
     */
    private final static String sha256Sign(Map<String, Object> paramMap, String key) {
        try {
            String payParam = getSignTemp(paramMap, key);
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] array = sha256_HMAC.doFinal(payParam.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            String sign = sb.toString().toUpperCase();
            return sign;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取签名参数字符串
     *
     * @param paramMap 签名参数（sign字段不参与签名）
     * @param payKey   签名密钥
     * @return 待签名字符串
     */
    private final static String getSignTemp(Map<String, Object> paramMap, String payKey) {
        ArrayList<String> keyList = new ArrayList<>(paramMap.keySet());
        Collections.sort(keyList);

        StringBuilder signParam = new StringBuilder();
        for (String key : keyList) {
            if (!"sign".equals(key) && (paramMap.get(key) != null)) {
                signParam.append(key).append("=").append(paramMap.get(key)).append("&");
            }
        }
        signParam.delete(signParam.length() - 1, signParam.length());
        signParam.append("&key=").append(payKey);
        return signParam.toString();
    }

    //数据加密方法
    private static byte[] encryptPkcs1padding(PublicKey publicKey, byte[] data) throws Exception {
        Cipher ci = Cipher.getInstance(TRANSFORMATION_PKCS1Paddiing, CIPHER_PROVIDER);
        ci.init(Cipher.ENCRYPT_MODE, publicKey);
        return ci.doFinal(data);
    }


    //加密后的秘文，使用base64编码方法
    private static String encodeBase64(byte[] bytes) throws Exception {
        return Base64.getEncoder().encodeToString(bytes);
    }


    /**
     * 对敏感内容（入参Content）加密，其中PUBLIC_KEY_FILENAME为存放平台证书的路径，平台证书文件存放明文平台证书内容，且为pem格式的平台证书（平台证书的获取方式参照平台证书及序列号获取接口，通过此接口得到的参数certificates包含了加密的平台证书内容ciphertext，然后根据接口文档中平台证书解密指引，最终得到明文平台证书内容）
     *
     * @param content 需要加密的类容
     * @return 加密后的密文
     */
    public static String wxRsaEncrypt(String content) throws Exception {
        if (content == null || content.isEmpty()) {
            return null;
        }
        X509Certificate certificate = X509Certificate.getInstance(PUBLIC_KEY_BYTES);
        PublicKey publicKey = certificate.getPublicKey();
        return encodeBase64(encryptPkcs1padding(publicKey, content.getBytes(CHAR_ENCODING)));
    }
}
