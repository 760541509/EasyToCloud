package com.yingtongquan.employees.brand.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yingtongquan.startcommon.pojo.CommonGetListPa;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* <p>
    * 
    * </p>
*
* @author ML
* @since 2020-05-23
*/

@TableName("tbl_goods_brand")
public class TblGoodsBrandPo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *
     **/
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     *品牌名称
     **/
    private String name;
    /**
     *品牌图标
     **/
    private String icon;
    /**
     *排序
     **/
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
    public Integer getSortIndex() {
    return sortIndex;
    }
    public void setSortIndex(Integer sortIndex) {
    this.sortIndex = sortIndex;
    }



    /**
    * 添加的参数
    */
    @ApiModel(value="TblGoodsBrandPoAddPa对象", description="添加的参数")
    public static class TblGoodsBrandPoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识",hidden = true )
        private Integer id;

        @ApiModelProperty(value = "品牌名称")
        private String name;

        @ApiModelProperty(value = "品牌图标")
        private String icon;

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
        public Integer getSortIndex() {
        return sortIndex;
        }
        public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
        }

    }


    /**
    * 修改的参数
    */
    @ApiModel(value="TblGoodsBrandPoUpPa对象", description="修改的参数")
    public static class TblGoodsBrandPoUpPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "品牌名称")
        private String name;
        @ApiModelProperty(value = "品牌图标")
        private String icon;
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
    @ApiModel(value="TblGoodsBrandPoDelPa对象", description="删除的参数")
    public static class TblGoodsBrandPoDelPa implements Serializable {
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
    @ApiModel(value="TblGoodsBrandPoGetPa对象", description="查询单个的参数")
    public static class TblGoodsBrandPoGetPa implements Serializable {
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
    @ApiModel(value="TblGoodsBrandPoGetListPa对象", description="查询集合的参数")
    public static class TblGoodsBrandPoGetListPa extends CommonGetListPa implements Serializable {

        @ApiModelProperty(value = "门店id")
        private Integer fkShopId;

        @Override
        public Integer getFkShopId() {
            return fkShopId;
        }

        @Override
        public void setFkShopId(Integer fkShopId) {
            this.fkShopId = fkShopId;
        }
    }



}


