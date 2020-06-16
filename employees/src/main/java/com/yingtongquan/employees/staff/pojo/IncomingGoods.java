package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class IncomingGoods implements Serializable {

    private Integer orderGoodsId;

    @ApiModelProperty(value = "出库单号")
    private String outboundOrderNo;

    @ApiModelProperty(value = "出库数量")
    private Integer amount;

    @ApiModelProperty(value = "店铺ID")
    private Integer shopId;

    @ApiModelProperty(value = "仓库ID")
    private Integer warehouseId;

    @ApiModelProperty(value = "单位ID")
    private Integer goodsSkuId;

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public String getOutboundOrderNo() {
        return outboundOrderNo;
    }

    public void setOutboundOrderNo(String outboundOrderNo) {
        this.outboundOrderNo = outboundOrderNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Integer goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    @Override
    public String toString() {
        return "IncomingGoods{" +
                "orderGoodsId=" + orderGoodsId +
                ", outboundOrderNo='" + outboundOrderNo + '\'' +
                ", amount=" + amount +
                ", shopId=" + shopId +
                ", warehouseId=" + warehouseId +
                ", goodsSkuId=" + goodsSkuId +
                '}';
    }
}
