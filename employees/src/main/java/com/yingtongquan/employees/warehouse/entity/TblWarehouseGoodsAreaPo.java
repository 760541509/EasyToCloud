package com.yingtongquan.employees.warehouse.entity;

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
 * @since 2020-05-21
 */
@TableName("tbl_warehouse_goods_area")
@ApiModel(value="TblWarehouseGoodsAreaPo对象", description="")
public class TblWarehouseGoodsAreaPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "上级区域id")
    private Integer supId;

    @ApiModelProperty(value = "仓库id")
    private Integer fkWarehouseId;

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
    public Integer getFkWarehouseId() {
        return fkWarehouseId;
    }

    public void setFkWarehouseId(Integer fkWarehouseId) {
        this.fkWarehouseId = fkWarehouseId;
    }
    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    @Override
    public String toString() {
        return "TblWarehouseGoodsAreaPo{" +
        "id=" + id +
        ", name=" + name +
        ", icon=" + icon +
        ", supId=" + supId +
        ", fkWarehouseId=" + fkWarehouseId +
        ", sortIndex=" + sortIndex +
        "}";
    }
}
