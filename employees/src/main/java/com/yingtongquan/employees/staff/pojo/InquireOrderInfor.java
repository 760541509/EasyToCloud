package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class InquireOrderInfor implements Serializable {

    @ApiModelProperty(value = "订单主状态")
    private Integer status;

    @ApiModelProperty(value = "订单副状态")
    private Integer statusVice;

    @ApiModelProperty(hidden = true)
    private Integer shopId;

    @ApiModelProperty(value = "手机号、名字、订单号")
    private String phoneAndNameAndOrderNo;

    @ApiModelProperty(value = "金额排序")
    private String money;

    @ApiModelProperty(value = "时间排序")
    private String time;

    @ApiModelProperty(value = "第几页")
    private Integer page;

    @ApiModelProperty(hidden = true)
    private Integer pageStart;

    @ApiModelProperty(value = "每页多少")
    private Integer pageEnd;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatusVice() {
        return statusVice;
    }

    public void setStatusVice(Integer statusVice) {
        this.statusVice = statusVice;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getPhoneAndNameAndOrderNo() {
        return phoneAndNameAndOrderNo;
    }

    public void setPhoneAndNameAndOrderNo(String phoneAndNameAndOrderNo) {
        this.phoneAndNameAndOrderNo = phoneAndNameAndOrderNo;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(Integer pageEnd) {
        this.pageEnd = pageEnd;
    }

    @Override
    public String toString() {
        return "InquireOrderInfor{" +
                "status=" + status +
                ", statusVice=" + statusVice +
                ", shopId=" + shopId +
                ", phoneAndNameAndOrderNo='" + phoneAndNameAndOrderNo + '\'' +
                ", money='" + money + '\'' +
                ", time='" + time + '\'' +
                ", page=" + page +
                ", pageStart=" + pageStart +
                ", pageEnd=" + pageEnd +
                '}';
    }
}
