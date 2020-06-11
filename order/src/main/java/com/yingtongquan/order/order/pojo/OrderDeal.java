package com.yingtongquan.order.order.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrderDeal implements Serializable {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "支付金额")
    private Integer payAmount;

    @ApiModelProperty(value = "支付方式（0 现金，1 微信 ，2支付宝，3 信用卡，4 银联）")
    private Integer payWay;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    @Override
    public String toString() {
        return "OrderDeal{" +
                "orderNo='" + orderNo + '\'' +
                ", payAmount=" + payAmount +
                ", payWay=" + payWay +
                '}';
    }
}
