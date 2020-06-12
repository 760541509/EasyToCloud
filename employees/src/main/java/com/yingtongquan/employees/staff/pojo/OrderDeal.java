package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrderDeal implements Serializable {

    @ApiModelProperty(value = "订单的id")
    private Integer orderId;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty(value = "支付金额")
    private Integer payAmount;

    @ApiModelProperty(value = "支付方式（0 现金，1 微信 ，2支付宝，3 信用卡，4 银联）")
    private Integer payWay;

    @ApiModelProperty(value = "交易流水号")
    private String serialNo;

    @ApiModelProperty(value = "员工ID")
    private Integer staffId;

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

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "OrderDeal{" +
                "orderId=" + orderId +
                ", addTime=" + addTime +
                ", payAmount=" + payAmount +
                ", payWay=" + payWay +
                ", serialNo='" + serialNo + '\'' +
                ", staffId=" + staffId +
                '}';
    }
}
