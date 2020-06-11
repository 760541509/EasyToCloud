package com.yingtongquan.checkstand.pojo;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.util.StrUtil;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Refund implements Serializable {

    /**
     * @Date 2020/5/19 14:48
     * @Author 胖
     * 订单号
     **/
    private String outTradeNo;

    /**
     * @Date 2020/5/19 14:48
     * @Author 胖
     * 退款单号
     **/
    private String outRefundNo;

    /**
     * @Date 2020/5/19 14:49
     * @Author 胖
     * 订单金额
     **/
    private Integer totalFee;

    /**
     * @Date 2020/5/19 14:50
     * @Author 胖
     * 退款金额
     **/
    private Integer refundFee;

    /**
     * @Date 2020/5/19 14:50
     * @Author 胖
     * 退款原因
     **/
    private String refundDesc;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
    }

    public Map<String, String> mapParam() {
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
        targetMap.put("sub_appid", "wx6fed689550449033");
        return targetMap;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", outRefundNo='" + outRefundNo + '\'' +
                ", totalFee=" + totalFee +
                ", refundFee=" + refundFee +
                ", refundDesc='" + refundDesc + '\'' +
                '}';
    }
}
