package com.yingtongquan.order.order.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrderGoods implements Serializable {

    @ApiModelProperty(value = "商品的名字")
    private String orderGoodsName;

    @ApiModelProperty(value = "商品的图片")
    private String image;

    @ApiModelProperty(value = "商品ID")
    private Integer shopGoodsId;

    @ApiModelProperty(value = "共用商品单位id")
    private Integer goodsSkuUnitId;

    @ApiModelProperty(value = "共用商品单位名称")
    private String goodsSkuUnitName;

    @ApiModelProperty(value = "共用商品sku的id")
    private Integer goodsSkuId;

    @ApiModelProperty(value = "共用商品单位名称")
    private String goodsSkuName;

    @ApiModelProperty(value = "购买的单价")
    private Integer price;

    @ApiModelProperty(value = "商品的原单价")
    private Integer originalPrice;

    @ApiModelProperty(value = "购买的数量")
    private Integer amount;

    public String getOrderGoodsName() {
        return orderGoodsName;
    }

    public void setOrderGoodsName(String orderGoodsName) {
        this.orderGoodsName = orderGoodsName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getShopGoodsId() {
        return shopGoodsId;
    }

    public void setShopGoodsId(Integer shopGoodsId) {
        this.shopGoodsId = shopGoodsId;
    }

    public Integer getGoodsSkuUnitId() {
        return goodsSkuUnitId;
    }

    public void setGoodsSkuUnitId(Integer goodsSkuUnitId) {
        this.goodsSkuUnitId = goodsSkuUnitId;
    }

    public String getGoodsSkuUnitName() {
        return goodsSkuUnitName;
    }

    public void setGoodsSkuUnitName(String goodsSkuUnitName) {
        this.goodsSkuUnitName = goodsSkuUnitName;
    }

    public Integer getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Integer goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public String getGoodsSkuName() {
        return goodsSkuName;
    }

    public void setGoodsSkuName(String goodsSkuName) {
        this.goodsSkuName = goodsSkuName;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "orderGoodsName='" + orderGoodsName + '\'' +
                ", image='" + image + '\'' +
                ", shopGoodsId=" + shopGoodsId +
                ", goodsSkuUnitId=" + goodsSkuUnitId +
                ", goodsSkuUnitName='" + goodsSkuUnitName + '\'' +
                ", goodsSkuId=" + goodsSkuId +
                ", goodsSkuName='" + goodsSkuName + '\'' +
                ", price=" + price +
                ", originalPrice=" + originalPrice +
                ", amount=" + amount +
                '}';
    }
}
