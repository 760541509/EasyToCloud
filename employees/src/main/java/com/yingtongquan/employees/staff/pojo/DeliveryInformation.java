package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class DeliveryInformation implements Serializable {

    @ApiModelProperty(value = "出库单号")
    private String outboundNo;

    @ApiModelProperty(value = "收货地址ID")
    private Integer addressId;

    @ApiModelProperty(value = "物流公司名字")
    private String name;

    @ApiModelProperty(value = "物流单号")
    private String logisticsNo;

    public String getOutboundNo() {
        return outboundNo;
    }

    public void setOutboundNo(String outboundNo) {
        this.outboundNo = outboundNo;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }

    @Override
    public String toString() {
        return "DeliveryInformation{" +
                "outboundNo='" + outboundNo + '\'' +
                ", addressId=" + addressId +
                ", name='" + name + '\'' +
                ", logisticsNo='" + logisticsNo + '\'' +
                '}';
    }
}
