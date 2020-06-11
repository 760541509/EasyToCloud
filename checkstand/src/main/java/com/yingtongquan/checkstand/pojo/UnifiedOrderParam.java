package com.yingtongquan.checkstand.pojo;


import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.util.StrUtil;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author a
 */
public class UnifiedOrderParam {
    /**
     * 商品描述
     * 例：腾讯充值中心-QQ会员充值
     */
    private String body;
    /**
     * 附加数据
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。
     * 例：深圳分店
     */
    private String attach;

    /**
     * 商户订单号
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。
     * 例：	20150806125346
     */
    private String outTradeNo;

    /**
     * 标价金额
     * 订单总金额，单位为分
     * 例：88
     */
    private Integer totalFee;

    /**
     * 终端IP
     * 支持IPV4和IPV6两种格式的IP地址。用户的客户端IP
     * 例：123.12.12.123
     */
    private String spbillCreateIp;

    /**
     * 交易起始时间
     * 订单生成时间，格式为yyyyMMddHHmmss
     * 例：20091225091010
     */
    private String timeStart;

    /**
     * 交易结束时间
     * 订单失效时间，格式为yyyyMMddHHmmss
     * 例：20091225091010
     */
    private String timeExpire;

    /**
     * 通知地址
     * 异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
     * 例：http://www.weixin.qq.com/wxpay/pay.php
     */
    private String notifyUrl;

    /**
     * 交易类型
     * JSAPI -JSAPI支付
     * NATIVE -Native支付
     * APP -APP支付
     */
    private String tradeType;

    /**
     * 指定支付方式
     * 上传此参数no_credit--可限制用户不能使用信用卡支付
     * 例：no_credit
     */
    private String limitPay;

    /**
     * 用户标识
     * trade_type=JSAPI时（即JSAPI支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识。
     * 例：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
     */
    private String openid;
    private String subOpenid;
    private String subMchId;

    /**
     * 电子发票入口开放标识
     * Y，传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，
     * 传此字段才可生效
     * 例：Y
     */
    private String receipt;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getSubOpenid() {
        return subOpenid;
    }

    public void setSubOpenid(String subOpenid) {
        this.subOpenid = subOpenid;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    /**
     * 将参数转换为map，可以封装进工具类
     * 驼峰转下划线、忽略空字段、
     *
     * @return Map格式的参数
     */

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
        return "UnifiedOrderParam{" +
                "body='" + body + '\'' +
                ", attach='" + attach + '\'' +
                ", outTradeNo=" + outTradeNo +
                ", totalFee=" + totalFee +
                ", spbillCreateIp='" + spbillCreateIp + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeExpire='" + timeExpire + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", limitPay='" + limitPay + '\'' +
                ", openid='" + openid + '\'' +
                ", receipt='" + receipt + '\'' +
                '}';
    }
}
