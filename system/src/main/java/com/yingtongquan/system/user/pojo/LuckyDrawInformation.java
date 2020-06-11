package com.yingtongquan.system.user.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class LuckyDrawInformation implements Serializable {

    @ApiModelProperty(value = "店铺ID")
    private Integer shopId;

    @ApiModelProperty(value = "转盘编号")
    private Integer dialNumber;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getDialNumber() {
        return dialNumber;
    }

    public void setDialNumber(Integer dialNumber) {
        this.dialNumber = dialNumber;
    }

    @Override
    public String toString() {
        return "LuckyDrawInformation{" +
                "shopId=" + shopId +
                ", dialNumber=" + dialNumber +
                '}';
    }
}
