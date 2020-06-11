package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Outbound implements Serializable {

    @ApiModelProperty(value = "出库订单号")
    private String outboundOrderNO;

    @ApiModelProperty(value = "出库商品")
    private List<OutboundGoods> outboundGoods = new ArrayList<>();

    public String getOutboundOrderNO() {
        return outboundOrderNO;
    }

    public void setOutboundOrderNO(String outboundOrderNO) {
        this.outboundOrderNO = outboundOrderNO;
    }

    public List<OutboundGoods> getOutboundGoods() {
        return outboundGoods;
    }

    public void setOutboundGoods(List<OutboundGoods> outboundGoods) {
        this.outboundGoods = outboundGoods;
    }

    @Override
    public String toString() {
        return "Outbound{" +
                "outboundOrderNO='" + outboundOrderNO + '\'' +
                ", outboundGoods=" + outboundGoods +
                '}';
    }
}
