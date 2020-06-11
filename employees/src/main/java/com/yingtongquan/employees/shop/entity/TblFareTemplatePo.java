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
@TableName("tbl_fare_template")
public class TblFareTemplatePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "模板名称")
    private String templateName;

    @ApiModelProperty(value = "地区外键id(发货地)")
    private Integer areaId;

    @ApiModelProperty(value = "发货时间（0 ：当天，1 ：次日，2：2天内发货，3：三天内发货 ）")
    private Long dispatchTime;

    @ApiModelProperty(value = "是否包邮（0 否，1是）")
    private Integer isInclPostage;

    @ApiModelProperty(value = "计价方式(1:按件 2:按重量 3:按体积)")
    private Integer valuationModel;

    private Integer isInclPostageByif;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
    public Long getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(Long dispatchTime) {
        this.dispatchTime = dispatchTime;
    }
    public Integer getIsInclPostage() {
        return isInclPostage;
    }

    public void setIsInclPostage(Integer isInclPostage) {
        this.isInclPostage = isInclPostage;
    }
    public Integer getValuationModel() {
        return valuationModel;
    }

    public void setValuationModel(Integer valuationModel) {
        this.valuationModel = valuationModel;
    }
    public Integer getIsInclPostageByif() {
        return isInclPostageByif;
    }

    public void setIsInclPostageByif(Integer isInclPostageByif) {
        this.isInclPostageByif = isInclPostageByif;
    }

    @Override
    public String toString() {
        return "TblFareTemplatePo{" +
        "id=" + id +
        ", templateName=" + templateName +
        ", areaId=" + areaId +
        ", dispatchTime=" + dispatchTime +
        ", isInclPostage=" + isInclPostage +
        ", valuationModel=" + valuationModel +
        ", isInclPostageByif=" + isInclPostageByif +
        "}";
    }
}
