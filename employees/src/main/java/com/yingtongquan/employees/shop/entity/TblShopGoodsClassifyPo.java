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
@TableName("tbl_shop_goods_classify")
public class TblShopGoodsClassifyPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "上级分类id")
    private Integer supId;

    @ApiModelProperty(value = "门店id")
    private Integer fkShopId;

    @ApiModelProperty(value = "平台分类id")
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
    public Integer getFkShopId() {
        return fkShopId;
    }

    public void setFkShopId(Integer fkShopId) {
        this.fkShopId = fkShopId;
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
        return "TblShopGoodsClassifyPo{" +
        "id=" + id +
        ", name=" + name +
        ", icon=" + icon +
        ", supId=" + supId +
        ", fkShopId=" + fkShopId +
        ", fkGoodsCpId=" + fkGoodsCpId +
        ", sortIndex=" + sortIndex +
        "}";
    }
}
