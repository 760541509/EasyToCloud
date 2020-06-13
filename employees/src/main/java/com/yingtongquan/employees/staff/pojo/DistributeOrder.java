package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DistributeOrder implements Serializable {

    @ApiModelProperty(value = "是否自动领单（0关闭 1开启）")
    private Integer automaticLedSingle;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "商品信息")
    private List<DistributeOrderGoods> distributeOrderGoods = new ArrayList<>();

    public Integer getAutomaticLedSingle() {
        return automaticLedSingle;
    }

    public void setAutomaticLedSingle(Integer automaticLedSingle) {
        this.automaticLedSingle = automaticLedSingle;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<DistributeOrderGoods> getDistributeOrderGoods() {
        return distributeOrderGoods;
    }

    public void setDistributeOrderGoods(List<DistributeOrderGoods> distributeOrderGoods) {
        this.distributeOrderGoods = distributeOrderGoods;
    }

    @Override
    public String toString() {
        return "DistributeOrder{" +
                "automaticLedSingle=" + automaticLedSingle +
                ", orderNo='" + orderNo + '\'' +
                ", distributeOrderGoods=" + distributeOrderGoods +
                '}';
    }
}
