package com.yingtongquan.employees.outbound.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OutboundOrderStaffPo implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "员工的id")
    private Integer staffId;

    @ApiModelProperty(value = "出库单的id")
    private Integer outboundOrderId;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty(value = "提成金额（计算方式，另考虑）")
    private Long commissionAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getOutboundOrderId() {
        return outboundOrderId;
    }

    public void setOutboundOrderId(Integer outboundOrderId) {
        this.outboundOrderId = outboundOrderId;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Long getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(Long commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    @Override
    public String toString() {
        return "OutboundOrderStaffPo{" +
                "id=" + id +
                ", staffId=" + staffId +
                ", outboundOrderId=" + outboundOrderId +
                ", addTime=" + addTime +
                ", commissionAmount=" + commissionAmount +
                '}';
    }
}
