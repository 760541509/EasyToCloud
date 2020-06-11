package com.yingtongquan.order.returnGoods.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class EmployessReturn implements Serializable {

    @ApiModelProperty(value = "退款单号")
    private String returnOrderNo;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "支付凭证")
    private String serialNo;

    @ApiModelProperty(value = "退款的金额（不能大于订单中原本的金额）")
    private Integer refundAmount;

    @ApiModelProperty(value = "退款原因")
    private String refundReason;

    public String getReturnOrderNo() {
        return returnOrderNo;
    }

    public void setReturnOrderNo(String returnOrderNo) {
        this.returnOrderNo = returnOrderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Integer refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }
}
