package com.yingtongquan.employees.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@TableName("tbl_fare_carry_mode")
public class TblFareCarryModePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "模板表id")
    private Integer fareTemplateId;

    @ApiModelProperty(value = "首件数量")
    private Integer firstPiece;

    @ApiModelProperty(value = "首重重量")
    private BigDecimal firstWeight;

    @ApiModelProperty(value = "首体积大小")
    private BigDecimal firstBulk;

    @ApiModelProperty(value = "首费")
    private Integer firstAmount;

    @ApiModelProperty(value = "续件")
    private Integer secondPiece;

    @ApiModelProperty(value = "续重")
    private BigDecimal secondWeight;

    @ApiModelProperty(value = "续体积")
    private BigDecimal secondBulk;

    @ApiModelProperty(value = "续费")
    private Integer secondAmount;

    @ApiModelProperty(value = "运输公司id")
    private Integer logisticsCompany;

    @ApiModelProperty(value = "是否默认（0 否，1是）")
    private Integer isDefault;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFareTemplateId() {
        return fareTemplateId;
    }

    public void setFareTemplateId(Integer fareTemplateId) {
        this.fareTemplateId = fareTemplateId;
    }

    public Integer getFirstPiece() {
        return firstPiece;
    }

    public void setFirstPiece(Integer firstPiece) {
        this.firstPiece = firstPiece;
    }

    public BigDecimal getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(BigDecimal firstWeight) {
        this.firstWeight = firstWeight;
    }

    public BigDecimal getFirstBulk() {
        return firstBulk;
    }

    public void setFirstBulk(BigDecimal firstBulk) {
        this.firstBulk = firstBulk;
    }

    public Integer getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Integer firstAmount) {
        this.firstAmount = firstAmount;
    }

    public Integer getSecondPiece() {
        return secondPiece;
    }

    public void setSecondPiece(Integer secondPiece) {
        this.secondPiece = secondPiece;
    }

    public BigDecimal getSecondWeight() {
        return secondWeight;
    }

    public void setSecondWeight(BigDecimal secondWeight) {
        this.secondWeight = secondWeight;
    }

    public BigDecimal getSecondBulk() {
        return secondBulk;
    }

    public void setSecondBulk(BigDecimal secondBulk) {
        this.secondBulk = secondBulk;
    }

    public Integer getSecondAmount() {
        return secondAmount;
    }

    public void setSecondAmount(Integer secondAmount) {
        this.secondAmount = secondAmount;
    }

    public Integer getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(Integer logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "TblFareCarryModePo{" +
                "id=" + id +
                ", fareTemplateId=" + fareTemplateId +
                ", firstPiece=" + firstPiece +
                ", firstWeight=" + firstWeight +
                ", firstBulk=" + firstBulk +
                ", firstAmount=" + firstAmount +
                ", secondPiece=" + secondPiece +
                ", secondWeight=" + secondWeight +
                ", secondBulk=" + secondBulk +
                ", secondAmount=" + secondAmount +
                ", logisticsCompany=" + logisticsCompany +
                ", isDefault=" + isDefault +
                "}";
    }
}
