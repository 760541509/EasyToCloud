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
@TableName("tbl_coupons_period_of_validity")
@ApiModel(value="TblCouponsPeriodOfValidityPo对象", description="")
public class TblCouponsPeriodOfValidityPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
        return "TblCouponsPeriodOfValidityPo{" +
        "id=" + id +
        ", effectOfTime=" + effectOfTime +
        ", endOfTime=" + endOfTime +
        ", onTheDay=" + onTheDay +
        ", theNextDay=" + theNextDay +
        "}";
    }
}
