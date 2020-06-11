package com.yingtongquan.order.returnGoods.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrderGoodsInformation implements Serializable {

    @ApiModelProperty(value = "商品名字")
    private String orderGoodsName;

    @ApiModelProperty(value = "店铺商品ID")
    private Integer shopGoodsId;

    @ApiModelProperty(value = "共用商品单位id")
    private Integer goodsSkuUnitId;

    @ApiModelProperty(value = "购买的单价")
    private Integer price;

    @ApiModelProperty(value = "购买的数量")
    private Integer amount;

    public String getOrderGoodsName() {
        return orderGoodsName;
    }

    public void setOrderGoodsName(String orderGoodsName) {
        this.orderGoodsName = orderGoodsName;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
