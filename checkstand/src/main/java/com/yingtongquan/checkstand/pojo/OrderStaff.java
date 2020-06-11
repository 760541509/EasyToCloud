package com.yingtongquan.checkstand.pojo;

import java.io.Serializable;

public class OrderStaff implements Serializable {
    private Integer id;

    //员工的id
    private Integer staffId;

    //订单的id
    private Integer orderId;

    //创建时间
    private Long addTime;

    //提成金额
    private Integer commissionAmount;

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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Integer getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(Integer commissionAmount) {
        this.commissionAmount = commissionAmount;
    }
}
