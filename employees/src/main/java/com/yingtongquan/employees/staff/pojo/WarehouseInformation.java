package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class WarehouseInformation implements Serializable {

    @ApiModelProperty(value = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "商品的库存数量")
    private Integer goodsNumber;

    @ApiModelProperty(value = "仓库的ID")
    private Integer id;

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
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
        return "WarehouseInformation{" +
                "warehouseName='" + warehouseName + '\'' +
                ", goodsNumber=" + goodsNumber +
                ", id=" + id +
                '}';
    }
}
