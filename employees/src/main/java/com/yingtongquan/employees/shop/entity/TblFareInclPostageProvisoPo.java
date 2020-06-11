package com.yingtongquan.employees.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@TableName("tbl_fare_incl_postage_proviso")
public class TblFareInclPostageProvisoPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "模板表id")
    private Integer fareTemplateId;

    @ApiModelProperty(value = "包邮的地区(存id',以'|'分隔)")
    private String areaIds;

    @ApiModelProperty(value = "包邮件数")
    private Integer pieceNo;

    @ApiModelProperty(value = "包邮重量")
    private Integer weightNo;

    @ApiModelProperty(value = "包邮体积")
    private Integer bulkNo;

    @ApiModelProperty(value = "包邮金额")
    private Integer amount;

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
    public String getAreaIds() {
        return areaIds;
    }

    public void setAreaIds(String areaIds) {
        this.areaIds = areaIds;
    }
    public Integer getPieceNo() {
        return pieceNo;
    }

    public void setPieceNo(Integer pieceNo) {
        this.pieceNo = pieceNo;
    }
    public Integer getWeightNo() {
        return weightNo;
    }

    public void setWeightNo(Integer weightNo) {
        this.weightNo = weightNo;
    }
    public Integer getBulkNo() {
        return bulkNo;
    }

    public void setBulkNo(Integer bulkNo) {
        this.bulkNo = bulkNo;
    }
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TblFareInclPostageProvisoPo{" +
        "id=" + id +
        ", fareTemplateId=" + fareTemplateId +
        ", areaIds=" + areaIds +
        ", pieceNo=" + pieceNo +
        ", weightNo=" + weightNo +
        ", bulkNo=" + bulkNo +
        ", amount=" + amount +
        "}";
    }
}
