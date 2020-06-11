package com.yingtongquan.checkstand.pojo;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang.RandomStringUtils;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class WeChatBarCode implements Serializable {

    /**
     * @Date 2020/6/3 9:54
     * @Author 胖
     * 商品描述
     * 示例：image形象店-深圳腾大- QQ公仔
     **/
    private String body;

    /**
     * @Date 2020/6/3 9:55
     * @Author 胖
     * 商户订单号
     * 示例：00969E398DA74F1
     **/
    private String outTradeNo;

    /**
     * @Date 2020/6/3 9:56
     * @Author 胖
     * 订单金额
     **/
    private int totalFee;

    /**
     * @Date 2020/6/3 9:56
     * @Author 胖
     * 设备IP地址
     **/
    private String spbillCreateIp;

    /**
     * @Date 2020/6/3 9:56
     * @Author 胖
     * 付款码
     * 示例：120061098828009406（注：用户付款码条形码规则：18位纯数字，以10、11、12、13、14、15开头）
     **/
    private String authCode;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Map<String, String> mapParam() {
        String filename= RandomStringUtils.randomAlphanumeric(18);
        Map<String, String> targetMap = new LinkedHashMap<>();
        Editor<String> keyEditor = StrUtil::toUnderlineCase;
        final Collection<BeanDesc.PropDesc> props = BeanUtil.getBeanDesc(this.getClass()).getProps();
        String key;
        Method getter;
        Object value;
        for (BeanDesc.PropDesc prop : props) {
            key = prop.getFieldName();
            // 过滤class属性
            // 得到property对应的getter方法
            getter = prop.getGetter();
            if (null != getter) {
                // 只读取有getter方法的属性
                try {
                    value = getter.invoke(this);
                } catch (Exception ignore) {
                    continue;
                }
                if ((null != value && !value.equals(this))) {
                    key = keyEditor.edit(key);
                    if (null != key) {
                        targetMap.put(key, String.valueOf(value));
                    }
                }
            }
        }
        targetMap.put("appid", "wxc0ed33ca8c933f1a");
//        targetMap.put("mch_id","1561606541");
//        targetMap.put("tnonce_str",filename);
        return targetMap;
    }

    @Override
    public String toString() {
        return "WeChatBarCode{" +
                "body='" + body + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", totalFee=" + totalFee +
                ", spbillCreateIp='" + spbillCreateIp + '\'' +
                ", authCode='" + authCode + '\'' +
                '}';
    }
}
