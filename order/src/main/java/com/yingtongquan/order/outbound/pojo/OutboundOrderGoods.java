package com.yingtongquan.order.outbound.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OutboundOrderGoods implements Serializable {

    @ApiModelProperty(value = "订单商品ID")
    private Integer orderGoodsId;

    @ApiModelProperty(value = "订单商品数量")
    private Integer amount;

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
