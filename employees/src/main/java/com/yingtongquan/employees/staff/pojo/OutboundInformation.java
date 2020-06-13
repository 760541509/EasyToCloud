package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OutboundInformation implements Serializable {

    @ApiModelProperty(value = "头像")
    private String headPortrait;

    @ApiModelProperty(value = "会员名字")
    private String name;

    @ApiModelProperty(value = "出库单状态")
    private String outboundStatus;

    @ApiModelProperty(value = "出库时间")
    private Long addTime;

    @ApiModelProperty(value = "第一个商品名字")
    private String goodsName;

    @ApiModelProperty(value = "商品总数量")
    private Integer goodsAmount;

    @ApiModelProperty(value = "出库单号")
    private String outboundOrderNo;

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutboundStatus() {
        return outboundStatus;
    }

    public void setOutboundStatus(String outboundStatus) {
        this.outboundStatus = outboundStatus;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public String getOutboundOrderNo() {
        return outboundOrderNo;
    }

    public void setOutboundOrderNo(String outboundOrderNo) {
        this.outboundOrderNo = outboundOrderNo;
    }

    @Override
    public String toString() {
        return "OutboundInformation{" +
                "headPortrait='" + headPortrait + '\'' +
                ", name='" + name + '\'' +
                ", outboundStatus='" + outboundStatus + '\'' +
                ", addTime=" + addTime +
                ", goodsName='" + goodsName + '\'' +
                ", goodsAmount=" + goodsAmount +
                ", outboundOrderNo='" + outboundOrderNo + '\'' +
                '}';
    }
}
