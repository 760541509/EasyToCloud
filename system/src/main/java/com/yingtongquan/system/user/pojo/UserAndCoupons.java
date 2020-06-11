package com.yingtongquan.system.user.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserAndCoupons implements Serializable {

    private Long id;

    @ApiModelProperty(value = "优惠卷ID")
    private Integer couponsId;

    @ApiModelProperty(value = "商品ID")
    private Integer productId;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "是否过期")
    private String isLate;

    @ApiModelProperty(value = "获取优惠卷的时间")
    private Long getTheTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCouponsId() {
        return couponsId;
    }

    public void setCouponsId(Integer couponsId) {
        this.couponsId = couponsId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIsLate() {
        return isLate;
    }

    public void setIsLate(String isLate) {
        this.isLate = isLate;
    }

    public Long getGetTheTime() {
        return getTheTime;
    }

    public void setGetTheTime(Long getTheTime) {
        this.getTheTime = getTheTime;
    }

    @Override
    public String toString() {
        return "TblCouponsUserPo{" +
                "id=" + id +
                ", couponsId=" + couponsId +
                ", productId=" + productId +
                ", userId=" + userId +
                ", isLate='" + isLate + '\'' +
                ", getTheTime=" + getTheTime +
                '}';
    }
}
