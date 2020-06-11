package com.yingtongquan.employees.goodsClassify.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

@TableName("tbl_goods_classify")
@JsonSerialize
public class TblGoodsClassifyPo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *
     **/
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     *分类名称
     **/
    private String name;
    /**
     *分类图标
     **/
    private String icon;
    /**
     *分类的上级id
     **/
    private Integer supId;
    /**
     *排序
     **/
    private Integer sortIndex;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TblGoodsClassifyPo> thirdList;

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
    public Integer getSortIndex() {
    return sortIndex;
    }
    public void setSortIndex(Integer sortIndex) {
    this.sortIndex = sortIndex;
    }

    public List<TblGoodsClassifyPo> getThirdList() {
        return thirdList;
    }

    public void setThirdList(List<TblGoodsClassifyPo> thirdList) {
        this.thirdList = thirdList;
    }

    /**
    * 添加的参数
    */
    @ApiModel(value="TblGoodsClassifyPoAddPa对象", description="添加的参数")
    public static class TblGoodsClassifyPoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识",hidden = true )
        private Integer id;

        @ApiModelProperty(value = "分类名称")
        private String name;

        @ApiModelProperty(value = "分类图标")
        private String icon;

        @ApiModelProperty(value = "分类的上级id")
        private Integer supId;

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
    @ApiModel(value="TblGoodsClassifyPoUpPa对象", description="修改的参数")
    public static class TblGoodsClassifyPoUpPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "分类名称")
        private String name;
        @ApiModelProperty(value = "分类图标")
        private String icon;
        @ApiModelProperty(value = "分类的上级id")
        private Integer supId;
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
    @ApiModel(value="TblGoodsClassifyPoDelPa对象", description="删除的参数")
    public static class TblGoodsClassifyPoDelPa implements Serializable {
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
    @ApiModel(value="TblGoodsClassifyPoGetPa对象", description="查询单个的参数")
    public static class TblGoodsClassifyPoGetPa implements Serializable {
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
    @ApiModel(value="TblGoodsClassifyPoGetListPa对象", description="查询集合的参数")
    public static class TblGoodsClassifyPoGetListPa  implements Serializable {


        @ApiModelProperty(value = "一级分类id")
        private Integer primaryId;

        @ApiModelProperty(value = "分类的上级id")
        private Integer supId;

        public Integer getPrimaryId() {
            return primaryId;
        }

        public void setPrimaryId(Integer primaryId) {
            this.primaryId = primaryId;
        }

        public Integer getSupId() {
            return supId;
        }

        public void setSupId(Integer supId) {
            this.supId = supId;
        }

    }



}


