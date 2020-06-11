package com.yingtongquan.order.returnGoods.pojo;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class CustomerReturns implements Serializable {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "退货商品信息")
    private List<ReturnGoodsInformation> returnGoodsInformations = Lists.newArrayList();

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<ReturnGoodsInformation> getReturnGoodsInformations() {
        return returnGoodsInformations;
    }

    public void setReturnGoodsInformations(List<ReturnGoodsInformation> returnGoodsInformations) {
        this.returnGoodsInformations = returnGoodsInformations;
    }

}
