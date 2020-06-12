package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class StaffCollection implements Serializable {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "收款金额")
    private Integer moeny;

    @ApiModelProperty(value = "支付类型")
    private Integer payType;

    @ApiModelProperty(value = "员工ID")
    private Integer staffId;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getMoeny() {
        return moeny;
    }

    public void setMoeny(Integer moeny) {
        this.moeny = moeny;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "StaffCollection{" +
                "orderNo='" + orderNo + '\'' +
                ", moeny=" + moeny +
                ", payType=" + payType +
                ", staffId=" + staffId +
                '}';
    }
}
