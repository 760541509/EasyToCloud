package com.yingtongquan.employees.staff.pojo;

import java.io.Serializable;

public class IncomingGoods implements Serializable {

    private String outboundOrderNo;

    private Integer amount;

    private Integer shopId;

    private Integer warehouseId;

    private Integer goodsSkuId;

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
                "outboundOrderNo='" + outboundOrderNo + '\'' +
                ", amount=" + amount +
                ", shopId=" + shopId +
                ", warehouseId=" + warehouseId +
                ", goodsSkuId=" + goodsSkuId +
                '}';
    }
}
