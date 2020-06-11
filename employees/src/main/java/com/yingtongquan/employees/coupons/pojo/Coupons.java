package com.yingtongquan.employees.coupons.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Coupons implements Serializable {

    @ApiModelProperty(value = "优惠卷名称")
    private String couponName;

    @ApiModelProperty(value = "优惠卷总数量")
    private Integer totalNumber;

    @ApiModelProperty(value = "满足")
    private Integer meet;

    @ApiModelProperty(value = "减少")
    private Integer reduce;

    @ApiModelProperty(value = "打多少折")
    private Integer discount;

    @ApiModelProperty(value = "使用条件（0 无条件，满多少使用）")
    private Integer conditionsOfUse;

    @ApiModelProperty(value = "会员等级")
    private Integer memberLevelId;

    @ApiModelProperty(value = "每人领取的次数（0无限次）")
    private Integer getTheNumber;

    @ApiModelProperty(value = "有效期ID")
    private Integer periodOfValidityId;

    @ApiModelProperty(value = "开始时间")
    private Long effectOfTime;

    @ApiModelProperty(value = "结束时间")
    private Long endOfTime;

    @ApiModelProperty(value = "领到券当日开始 N 天内有效")
    private Integer onTheDay;

    @ApiModelProperty(value = "领到券次日开始 N 天内有效")
    private Integer theNextDay;

    @ApiModelProperty(value = "所有商品")
    private Integer shopAllGoods;

    @ApiModelProperty(value = "某商品")
    private String specifyTheCommodity;

    @ApiModelProperty(value = "某品类")
    private String certainCategory;

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
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

    public Integer getConditionsOfUse() {
        return conditionsOfUse;
    }

    public void setConditionsOfUse(Integer conditionsOfUse) {
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

    public Integer getPeriodOfValidityId() {
        return periodOfValidityId;
    }

    public void setPeriodOfValidityId(Integer periodOfValidityId) {
        this.periodOfValidityId = periodOfValidityId;
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

    @Override
    public String toString() {
        return "Coupons{" +
                "couponName='" + couponName + '\'' +
                ", totalNumber=" + totalNumber +
                ", meet=" + meet +
                ", reduce=" + reduce +
                ", discount=" + discount +
                ", conditionsOfUse=" + conditionsOfUse +
                ", memberLevelId=" + memberLevelId +
                ", getTheNumber=" + getTheNumber +
                ", periodOfValidityId=" + periodOfValidityId +
                ", effectOfTime=" + effectOfTime +
                ", endOfTime=" + endOfTime +
                ", onTheDay=" + onTheDay +
                ", theNextDay=" + theNextDay +
                ", shopAllGoods=" + shopAllGoods +
                ", specifyTheCommodity='" + specifyTheCommodity + '\'' +
                ", certainCategory='" + certainCategory + '\'' +
                '}';
    }
}
