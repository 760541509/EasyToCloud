package com.yingtongquan.order.order.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrderGoodsInformation implements Serializable {

    @ApiModelProperty(value = "门店商品id")
    private Integer shopGoodsId;

    @ApiModelProperty(value = "共用商品单位id")
    private Integer goodsSkuUnitId;

    @ApiModelProperty(value = "共用商品sku的id")
    private Integer goodsSkuId;

    @ApiModelProperty(value = "购买的数量")
    private Integer amount;

    @ApiModelProperty(value = "购买的单价")
    private Integer price;

    @ApiModelProperty(value = "分摊的优惠券价格（用于计算出库员提成）")
    private Integer shareCouponsPrice;

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

    public Integer getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Integer goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getShareCouponsPrice() {
        return shareCouponsPrice;
    }

    public void setShareCouponsPrice(Integer shareCouponsPrice) {
        this.shareCouponsPrice = shareCouponsPrice;
    }

    @Override
    public String toString() {
        return "OrderGoodsInformation{" +
                "shopGoodsId=" + shopGoodsId +
                ", goodsSkuUnitId=" + goodsSkuUnitId +
                ", goodsSkuId=" + goodsSkuId +
                ", amount=" + amount +
                ", price=" + price +
                ", shareCouponsPrice=" + shareCouponsPrice +
                '}';
    }
}
