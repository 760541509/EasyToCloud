package com.yingtongquan.employees.outbound.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OutboundOrderGoodsPo implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "订单商品id")
    private Integer orderGoodsId;

    @ApiModelProperty(value = "出库的数量（需大于0并且小于或等于购买数量）")
    private Integer amount;

    @ApiModelProperty(value = "出库单id")
    private Integer outboundOrderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getOutboundOrderId() {
        return outboundOrderId;
    }

    public void setOutboundOrderId(Integer outboundOrderId) {
        this.outboundOrderId = outboundOrderId;
    }

    @Override
    public String toString() {
        return "OutboundOrderGoodsPo{" +
                "id=" + id +
                ", orderGoodsId=" + orderGoodsId +
                ", amount=" + amount +
                ", outboundOrderId=" + outboundOrderId +
                '}';
    }
}
