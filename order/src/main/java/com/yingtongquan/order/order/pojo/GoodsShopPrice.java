package com.yingtongquan.order.order.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class GoodsShopPrice implements Serializable {

    @ApiModelProperty(value = "商品sku的单位id")
    private Integer goodsSkuUnitId;

    @ApiModelProperty(value = "商品单位的价格")
    private Integer price;

    @ApiModelProperty(value = "会员价格表id")
    private Integer memberPriceShopId;

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

    public Integer getMemberPriceShopId() {
        return memberPriceShopId;
    }

    public void setMemberPriceShopId(Integer memberPriceShopId) {
        this.memberPriceShopId = memberPriceShopId;
    }

    @Override
    public String toString() {
        return "GoodsShopPrice{" +
                "goodsSkuUnitId=" + goodsSkuUnitId +
                ", price=" + price +
                ", memberPriceShopId=" + memberPriceShopId +
                '}';
    }
}
