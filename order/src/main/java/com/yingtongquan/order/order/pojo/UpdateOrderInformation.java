package com.yingtongquan.order.order.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UpdateOrderInformation implements Serializable {

    @ApiModelProperty(value = "商品的总数量")
    private Integer goodsCount;

    @ApiModelProperty(value = "商品的总价格")
    private Integer goodsAmountTotal;

    @ApiModelProperty(value = "实际需要支付的价格")
    private Integer orderAmountTotal;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getGoodsAmountTotal() {
        return goodsAmountTotal;
    }

    public void setGoodsAmountTotal(Integer goodsAmountTotal) {
        this.goodsAmountTotal = goodsAmountTotal;
    }

    public Integer getOrderAmountTotal() {
        return orderAmountTotal;
    }

    public void setOrderAmountTotal(Integer orderAmountTotal) {
        this.orderAmountTotal = orderAmountTotal;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "UpdateOrderInformation{" +
                "goodsCount=" + goodsCount +
                ", goodsAmountTotal=" + goodsAmountTotal +
                ", orderAmountTotal=" + orderAmountTotal +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }
}
