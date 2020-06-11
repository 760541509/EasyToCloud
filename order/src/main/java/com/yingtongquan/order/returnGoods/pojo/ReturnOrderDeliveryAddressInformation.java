package com.yingtongquan.order.returnGoods.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ReturnOrderDeliveryAddressInformation implements Serializable {

    @ApiModelProperty(value = "退货订单号")
    private String returnOrderNo;

    @ApiModelProperty(value = "门店收货地址外键")
    private Integer shopDeliveryAddressId;

    public String getReturnOrderNo() {
        return returnOrderNo;
    }

    public void setReturnOrderNo(String returnOrderNo) {
        this.returnOrderNo = returnOrderNo;
    }

    public Integer getShopDeliveryAddressId() {
        return shopDeliveryAddressId;
    }

    public void setShopDeliveryAddressId(Integer shopDeliveryAddressId) {
        this.shopDeliveryAddressId = shopDeliveryAddressId;
    }
}
