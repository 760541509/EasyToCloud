package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class StoresInformation implements Serializable {

    @ApiModelProperty(value = "门店名称")
    private String storesName;

    @ApiModelProperty(value = "商品的库存数量")
    private Integer goodsNumber;

    @ApiModelProperty(value = "门店的ID")
    private Integer id;

    public String getStoresName() {
        return storesName;
    }

    public void setStoresName(String storesName) {
        this.storesName = storesName;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StoresInformation{" +
                "storesName='" + storesName + '\'' +
                ", goodsNumber=" + goodsNumber +
                ", id=" + id +
                '}';
    }
}
