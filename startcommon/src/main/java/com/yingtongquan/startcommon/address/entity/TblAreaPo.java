package com.yingtongquan.startcommon.address.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 地区码表
 * </p>
 *
 * @author Pang
 * @since 2020-05-11
 */
@TableName("tbl_area")
@ApiModel(value = "TblAreaPo对象", description = "地区码表")
public class TblAreaPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "地区Id")
    @TableId(value = "area_id", type = IdType.AUTO)
    private Integer areaId;

    @ApiModelProperty(value = "地区编码")
    private String areaCode;

    @ApiModelProperty(value = "地区名")
    private String areaName;

    @ApiModelProperty(value = "地区级别（1:省份province,2:市city,3:区县district,4:街道street）")
    private Integer areaLevel;

    @ApiModelProperty(value = "城市编码")
    private String cityCode;

    @ApiModelProperty(value = "城市中心点（即：经纬度坐标）")
    private String center;

    @ApiModelProperty(value = "地区父节点")
    private Integer parentId;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getareaLevel() {
        return areaLevel;
    }

    public void setLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "TblAreaPo{" +
                "areaId=" + areaId +
                ", areaCode=" + areaCode +
                ", areaName=" + areaName +
                ", areaLevel=" + areaLevel +
                ", cityCode=" + cityCode +
                ", center=" + center +
                ", parentId=" + parentId +
                "}";
    }
}
