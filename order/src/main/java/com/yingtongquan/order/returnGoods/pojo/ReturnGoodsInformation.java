package com.yingtongquan.order.returnGoods.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ReturnGoodsInformation implements Serializable {

    @ApiModelProperty(value = "商品ID")
    private Integer goodsId;

    @ApiModelProperty(value = "商品的数量")
    private Integer goodsAmount;

    @ApiModelProperty(value = "门店商品单位id")
    private Integer goodsSkuUnitId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Integer getGoodsSkuUnitId() {
        return goodsSkuUnitId;
    }

    public void setGoodsSkuUnitId(Integer goodsSkuUnitId) {
        this.goodsSkuUnitId = goodsSkuUnitId;
    }
}
