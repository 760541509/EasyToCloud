package com.yingtongquan.employees.coupons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ML
 * @since 2020-06-05
 */
@TableName("tbl_coupons")
@ApiModel(value="TblCouponsPo对象", description="")
public class TblCouponsPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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

    @ApiModelProperty(value = "使用范围ID")
    private Integer usingRangeId;

    @ApiModelProperty(value = "使用说明")
    private String directionsForUse;

    @ApiModelProperty(value = "状态（0 没得卷了，1 还有卷，可继续获取）")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
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
    public Integer getUsingRangeId() {
        return usingRangeId;
    }

    public void setUsingRangeId(Integer usingRangeId) {
        this.usingRangeId = usingRangeId;
    }
    public String getDirectionsForUse() {
        return directionsForUse;
    }

    public void setDirectionsForUse(String directionsForUse) {
        this.directionsForUse = directionsForUse;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblCouponsPo{" +
        "id=" + id +
        ", couponName=" + couponName +
        ", totalNumber=" + totalNumber +
        ", meet=" + meet +
        ", reduce=" + reduce +
        ", discount=" + discount +
        ", conditionsOfUse=" + conditionsOfUse +
        ", memberLevelId=" + memberLevelId +
        ", getTheNumber=" + getTheNumber +
        ", periodOfValidityId=" + periodOfValidityId +
        ", usingRangeId=" + usingRangeId +
        ", directionsForUse=" + directionsForUse +
        ", status=" + status +
        "}";
    }
}
