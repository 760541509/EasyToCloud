package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class StaffOrderPayment implements Serializable {

    @ApiModelProperty(value = "支付金额")
    private Integer payTheAmount;

    @ApiModelProperty(value = "支付类型")
    private Integer payType;

    @ApiModelProperty(value = "支付时间")
    private Long payTime;

    @ApiModelProperty(value = "支付的流水号")
    private String paySerialNumber;

    public Integer getPayTheAmount() {
        return payTheAmount;
    }

    public void setPayTheAmount(Integer payTheAmount) {
        this.payTheAmount = payTheAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public String getPaySerialNumber() {
        return paySerialNumber;
    }

    public void setPaySerialNumber(String paySerialNumber) {
        this.paySerialNumber = paySerialNumber;
    }

    @Override
    public String toString() {
        return "StaffOrderPayment{" +
                "payTheAmount=" + payTheAmount +
                ", payType=" + payType +
                ", payTime=" + payTime +
                ", paySerialNumber='" + paySerialNumber + '\'' +
                '}';
    }
}
