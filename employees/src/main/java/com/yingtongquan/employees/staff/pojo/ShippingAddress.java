package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ShippingAddress implements Serializable {

    @ApiModelProperty(value = "区域ID")
    private Integer areaId;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "收货人")
    private String consignee;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "会员ID")
    private Integer memberId;

    @ApiModelProperty(value = "是否自提")
    private Integer isSince;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getIsSince() {
        return isSince;
    }

    public void setIsSince(Integer isSince) {
        this.isSince = isSince;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "areaId=" + areaId +
                ", address='" + address + '\'' +
                ", consignee='" + consignee + '\'' +
                ", phone='" + phone + '\'' +
                ", memberId=" + memberId +
                ", isSince=" + isSince +
                '}';
    }
}
