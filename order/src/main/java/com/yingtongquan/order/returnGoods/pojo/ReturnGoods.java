package com.yingtongquan.order.returnGoods.pojo;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class ReturnGoods implements Serializable {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "支付凭证")
    private String serialNo;

    @ApiModelProperty(value = "店铺ID")
    private Integer shopId;

    @ApiModelProperty(value = "商品")
    private List<ReturnGoodsInformation> returnGoodsInformations = Lists.newArrayList();

    @ApiModelProperty(value = "退款的金额（不能大于订单中原本的金额）")
    private Integer refundAmount;

    @ApiModelProperty(value = "退款原因")
    private String refundReason;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public List<ReturnGoodsInformation> getReturnGoodsInformations() {
        return returnGoodsInformations;
    }

    public void setReturnGoodsInformations(List<ReturnGoodsInformation> returnGoodsInformations) {
        this.returnGoodsInformations = returnGoodsInformations;
    }

    public Integer getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Integer refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }
}
