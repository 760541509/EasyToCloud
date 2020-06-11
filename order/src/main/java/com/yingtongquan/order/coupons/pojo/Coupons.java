package com.yingtongquan.order.coupons.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Coupons implements Serializable {

    @ApiModelProperty(value = "优惠卷ID")
    private Long id;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "是否过期")
    private String isLate;

    @ApiModelProperty(value = "用户获得优惠卷的时间")
    private Long getTheTime;

    @ApiModelProperty(value = "优惠卷名称")
    private String couponName;

    @ApiModelProperty(value = "优惠卷总数量")
    private Long totalNumber;

    @ApiModelProperty(value = "满足")
    private Integer meet;

    @ApiModelProperty(value = "减少")
    private Integer reduce;

    @ApiModelProperty(value = "打多少折")
    private Integer discount;

    @ApiModelProperty(value = "使用条件（0 无条件，满多少使用）")
    private Long conditionsOfUse;

    @ApiModelProperty(value = "会员等级")
    private Integer memberLevelId;

    @ApiModelProperty(value = "每人领取的次数（0无限次）")
    private Integer getTheNumber;

    @ApiModelProperty(value = "使用说明")
    private String directionsForUse;

    @ApiModelProperty(value = "所有商品")
    private Integer shopAllGoods;

    @ApiModelProperty(value = "某商品")
    private String specifyTheCommodity;

    @ApiModelProperty(value = "某品类")
    private String certainCategory;

    @ApiModelProperty(value = "开始时间")
    private Long effectOfTime;

    @ApiModelProperty(value = "结束时间")
    private Long endOfTime;

    @ApiModelProperty(value = "领到券当日开始 N 天内有效")
    private Integer onTheDay;

    @ApiModelProperty(value = "领到券次日开始 N 天内有效")
    private Integer theNextDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getMeet() {
        return meet;
    }

    public void setMeet(Integer meet) {
        this.meet = meet;
    }

    public Integer getReduce() {
        return reduce;
    }

    public void setReduce(Integer reduce) {
        this.reduce = reduce;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Long getConditionsOfUse() {
        return conditionsOfUse;
    }

    public void setConditionsOfUse(Long conditionsOfUse) {
        this.conditionsOfUse = conditionsOfUse;
    }

    public Integer getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Integer memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public Integer getGetTheNumber() {
        return getTheNumber;
    }

    public void setGetTheNumber(Integer getTheNumber) {
        this.getTheNumber = getTheNumber;
    }

    public String getDirectionsForUse() {
        return directionsForUse;
    }

    public void setDirectionsForUse(String directionsForUse) {
        this.directionsForUse = directionsForUse;
    }

    public Integer getShopAllGoods() {
        return shopAllGoods;
    }

    public void setShopAllGoods(Integer shopAllGoods) {
        this.shopAllGoods = shopAllGoods;
    }

    public String getSpecifyTheCommodity() {
        return specifyTheCommodity;
    }

    public void setSpecifyTheCommodity(String specifyTheCommodity) {
        this.specifyTheCommodity = specifyTheCommodity;
    }

    public String getCertainCategory() {
        return certainCategory;
    }

    public void setCertainCategory(String certainCategory) {
        this.certainCategory = certainCategory;
    }

    public Long getEffectOfTime() {
        return effectOfTime;
    }

    public void setEffectOfTime(Long effectOfTime) {
        this.effectOfTime = effectOfTime;
    }

    public Long getEndOfTime() {
        return endOfTime;
    }

    public void setEndOfTime(Long endOfTime) {
        this.endOfTime = endOfTime;
    }

    public Integer getOnTheDay() {
        return onTheDay;
    }

    public void setOnTheDay(Integer onTheDay) {
        this.onTheDay = onTheDay;
    }

    public Integer getTheNextDay() {
        return theNextDay;
    }

    public void setTheNextDay(Integer theNextDay) {
        this.theNextDay = theNextDay;
    }

    @Override
    public String toString() {
        return "Coupons{" +
                "id=" + id +
                ", userId=" + userId +
                ", isLate='" + isLate + '\'' +
                ", getTheTime=" + getTheTime +
                ", couponName='" + couponName + '\'' +
                ", totalNumber=" + totalNumber +
                ", meet=" + meet +
                ", reduce=" + reduce +
                ", discount=" + discount +
                ", conditionsOfUse=" + conditionsOfUse +
                ", memberLevelId=" + memberLevelId +
                ", getTheNumber=" + getTheNumber +
                ", directionsForUse='" + directionsForUse + '\'' +
                ", shopAllGoods=" + shopAllGoods +
                ", specifyTheCommodity='" + specifyTheCommodity + '\'' +
                ", certainCategory='" + certainCategory + '\'' +
                ", effectOfTime=" + effectOfTime +
                ", endOfTime=" + endOfTime +
                ", onTheDay=" + onTheDay +
                ", theNextDay=" + theNextDay +
                '}';
    }
}
