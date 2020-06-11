package com.yingtongquan.employees.goodsShopClassify.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
* <p>
    * 
    * </p>
*
* @author ML
* @since 2020-05-27
*/

@TableName("tbl_shop_goods_classify")
public class TblShopGoodsClassifyPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一标识",hidden = true )
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "上级分类id")
    private Integer supId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value = "门店id")
    private Integer fkShopId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value = "平台分类id")
    private Integer fkGoodsCpId;

    @ApiModelProperty(value = "排序")
    private Integer sortIndex;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TblShopGoodsClassifyPo> thirdList;

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

    public List<TblShopGoodsClassifyPo> getThirdList() {
        return thirdList;
    }

    public void setThirdList(List<TblShopGoodsClassifyPo> thirdList) {
        this.thirdList = thirdList;
    }

    /**
    * 添加的参数
    */
    @ApiModel(value="TblShopGoodsClassifyPoAddPa对象", description="添加的参数")
    public static class TblShopGoodsClassifyPoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识",hidden = true )
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

        @ApiModelProperty(value = "子分类")
        private List<TblShopGoodsClassifyPoAddPa> childList;

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

        public List<TblShopGoodsClassifyPoAddPa> getChildList() {
            return childList;
        }

        public void setChildList(List<TblShopGoodsClassifyPoAddPa> childList) {
            this.childList = childList;
        }
    }


    /**
    * 修改的参数
    */
    @ApiModel(value="TblShopGoodsClassifyPoUpPa对象", description="修改的参数")
    public static class TblShopGoodsClassifyPoUpPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
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

    }

    /**
    * 删除的参数
    */
    @ApiModel(value="TblShopGoodsClassifyPoDelPa对象", description="删除的参数")
    public static class TblShopGoodsClassifyPoDelPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;

        public Integer getId() {
        return id;
        }
        public void setId(Integer id) {
        this.id = id;
        }
    }

    /**
    * 查询单个的参数
    */
    @ApiModel(value="TblShopGoodsClassifyPoGetPa对象", description="查询单个的参数")
    public static class TblShopGoodsClassifyPoGetPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;

        public Integer getId() {
        return id;
        }
        public void setId(Integer id) {
        this.id = id;
        }
    }


    /**
    * 查询集合的参数
    */
    @ApiModel(value="TblShopGoodsClassifyPoGetListPa对象", description="查询集合的参数")
    public static class TblShopGoodsClassifyPoGetListPa   implements Serializable {

        @ApiModelProperty(value = "一级分类id")
        private Integer primaryId;

        public Integer getPrimaryId() {
            return primaryId;
        }

        public void setPrimaryId(Integer primaryId) {
            this.primaryId = primaryId;
        }

    }



}


