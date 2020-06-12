package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class StaffOrderGoods implements Serializable {

    @ApiModelProperty(value = "商品图片")
    private String goodsImg;

    @ApiModelProperty(value = "商品名字")
    private String goodsName;

    @ApiModelProperty(value = "规格描述")
    private String skuName;

    @ApiModelProperty(value = "单位名字")
    private String skuUnitName;

    @ApiModelProperty(value = "购买数量")
    private Integer goodsNumber;

    @ApiModelProperty(value = "购买价格")
    private Integer price;

    @ApiModelProperty(value = "商品原价")
    private Integer originalPrice;

    @ApiModelProperty(value = "已发货数量")
    private Integer quantityShipped;

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuUnitName() {
        return skuUnitName;
    }

    public void setSkuUnitName(String skuUnitName) {
        this.skuUnitName = skuUnitName;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getQuantityShipped() {
        return quantityShipped;
    }

    public void setQuantityShipped(Integer quantityShipped) {
        this.quantityShipped = quantityShipped;
    }

    @Override
    public String toString() {
        return "StaffOrderGoods{" +
                "goodsImg='" + goodsImg + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", skuName='" + skuName + '\'' +
                ", skuUnitName='" + skuUnitName + '\'' +
                ", goodsNumber=" + goodsNumber +
                ", price=" + price +
                ", originalPrice=" + originalPrice +
                ", quantityShipped=" + quantityShipped +
                '}';
    }
}
