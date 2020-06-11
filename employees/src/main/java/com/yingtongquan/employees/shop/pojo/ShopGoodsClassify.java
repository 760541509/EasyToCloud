package com.yingtongquan.employees.shop.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ShopGoodsClassify implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "分类图标")
    private String icon;

    @ApiModelProperty(value = "对应上级的ID")
    private Integer supId;

    @ApiModelProperty(value = "平台分类ID")
    private Integer fkGoodsCpId;

    @ApiModelProperty(value = "排序")
    private Integer sortIndex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public Integer getFkGoodsCpId() {
        return fkGoodsCpId;
    }

    public void setFkGoodsCpId(Integer fkGoodsCpId) {
        this.fkGoodsCpId = fkGoodsCpId;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    @Override
    public String toString() {
        return "ShopGoodsClassify{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", supId=" + supId +
                ", fkGoodsCpId=" + fkGoodsCpId +
                ", sortIndex=" + sortIndex +
                '}';
    }
}
