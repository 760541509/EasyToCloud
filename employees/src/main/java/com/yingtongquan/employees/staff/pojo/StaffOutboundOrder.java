package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class StaffOutboundOrder implements Serializable {

    @ApiModelProperty(value = "领单人名称")
    private String leadSingleName;

    @ApiModelProperty(value = "领单人头像")
    private String leadSingleNameHeadPortrait;

    @ApiModelProperty(value = "出库单状态")
    private Integer outboundType;

    @ApiModelProperty(value = "出库单号")
    private String outboundNo;

    public String getLeadSingleName() {
        return leadSingleName;
    }

    public void setLeadSingleName(String leadSingleName) {
        this.leadSingleName = leadSingleName;
    }

    public String getLeadSingleNameHeadPortrait() {
        return leadSingleNameHeadPortrait;
    }

    public void setLeadSingleNameHeadPortrait(String leadSingleNameHeadPortrait) {
        this.leadSingleNameHeadPortrait = leadSingleNameHeadPortrait;
    }

    public Integer getOutboundType() {
        return outboundType;
    }

    public void setOutboundType(Integer outboundType) {
        this.outboundType = outboundType;
    }

    public String getOutboundNo() {
        return outboundNo;
    }

    public void setOutboundNo(String outboundNo) {
        this.outboundNo = outboundNo;
    }

    @Override
    public String toString() {
        return "StaffOutboundOrder{" +
                "leadSingleName='" + leadSingleName + '\'' +
                ", leadSingleNameHeadPortrait='" + leadSingleNameHeadPortrait + '\'' +
                ", outboundType=" + outboundType +
                ", outboundNo='" + outboundNo + '\'' +
                '}';
    }
}
