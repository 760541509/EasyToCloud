package com.yingtongquan.checkstand.pojo;

import java.io.Serializable;

public class OrderDeal implements Serializable {

    private Integer id;

    //订单的id
    private Integer orderId;

    //创建时间
    private Long addTime;

    //支付金额
    private Integer payAmount;

    //支付方式（0 现金，1 微信 ，2支付宝，3 信用卡，4 银联）
    private Integer payWay;

    //交易流水号
    private String serialNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
