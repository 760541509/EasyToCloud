package com.yingtongquan.customer.order.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrderGoods implements Serializable {

    @ApiModelProperty(value = "商品的名字")
    private String orderGoodsName;

    @ApiModelProperty(value = "商品的图片")
    private String image;

    @ApiModelProperty(value = "共用商品单位id")
    private Integer goodsSkuUnitId;

    @ApiModelProperty(value = "商品单位名称")
    private String GoodsSpuName;

    @ApiModelProperty(value = "共用商品sku的id")
    private Integer goodsSkuId;

    @ApiModelProperty(value = "规格值的id组合")
    private String specValueIds;

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

    public Integer getGoodsSkuUnitId() {
        return goodsSkuUnitId;
    }

    public void setGoodsSkuUnitId(Integer goodsSkuUnitId) {
        this.goodsSkuUnitId = goodsSkuUnitId;
    }

    public String getGoodsSpuName() {
        return GoodsSpuName;
    }

    public void setGoodsSpuName(String goodsSpuName) {
        GoodsSpuName = goodsSpuName;
    }

    public Integer getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Integer goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public String getSpecValueIds() {
        return specValueIds;
    }

    public void setSpecValueIds(String specValueIds) {
        this.specValueIds = specValueIds;
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
                ", goodsSkuUnitId=" + goodsSkuUnitId +
                ", GoodsSpuName='" + GoodsSpuName + '\'' +
                ", goodsSkuId=" + goodsSkuId +
                ", specValueIds='" + specValueIds + '\'' +
                ", price=" + price +
                ", originalPrice=" + originalPrice +
                ", amount=" + amount +
                '}';
    }
}
