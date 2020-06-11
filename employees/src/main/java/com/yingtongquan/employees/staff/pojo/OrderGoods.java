package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrderGoods implements Serializable {

    @ApiModelProperty(value = "商品名称")
    private String orderGoodsName;

    @ApiModelProperty(value = "商品单位名称")
    private String spuUnitName;

    @ApiModelProperty(value = "条形码")
    private String barCode;

    @ApiModelProperty(value = "货号")
    private String artNo;

    @ApiModelProperty(value = "图片")
    private String image;

    @ApiModelProperty(value = "商品规格名称")
    private String specName;

    @ApiModelProperty(value = "商品规格值")
    private String specValue;

    public String getOrderGoodsName() {
        return orderGoodsName;
    }

    public void setOrderGoodsName(String orderGoodsName) {
        this.orderGoodsName = orderGoodsName;
    }

    public String getSpuUnitName() {
        return spuUnitName;
    }

    public void setSpuUnitName(String spuUnitName) {
        this.spuUnitName = spuUnitName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getArtNo() {
        return artNo;
    }

    public void setArtNo(String artNo) {
        this.artNo = artNo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "orderGoodsName='" + orderGoodsName + '\'' +
                ", spuUnitName='" + spuUnitName + '\'' +
                ", barCode='" + barCode + '\'' +
                ", artNo='" + artNo + '\'' +
                ", image='" + image + '\'' +
                ", specName='" + specName + '\'' +
                ", specValue='" + specValue + '\'' +
                '}';
    }
}
