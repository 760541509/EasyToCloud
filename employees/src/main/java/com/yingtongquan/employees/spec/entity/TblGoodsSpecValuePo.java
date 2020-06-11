package com.yingtongquan.employees.spec.entity;

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

@TableName("tbl_goods_spec_value")
public class TblGoodsSpecValuePo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *
     **/
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     *规格值(如 白色)
     **/
    private String name;
    /**
     *规格名称id
     **/
    private Integer fkGoodsSpecNameId;

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
    public Integer getFkGoodsSpecNameId() {
    return fkGoodsSpecNameId;
    }
    public void setFkGoodsSpecNameId(Integer fkGoodsSpecNameId) {
    this.fkGoodsSpecNameId = fkGoodsSpecNameId;
    }



    /**
    * 添加的参数
    */
    @ApiModel(value="TblGoodsSpecValuePoAddPa对象", description="添加的参数")
    public static class TblGoodsSpecValuePoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识",hidden = true )
        private Integer id;

        @ApiModelProperty(value = "规格值(如 白色)")
        private String name;

        @ApiModelProperty(value = "规格名称id",hidden = true)
        private Integer fkGoodsSpecNameId;


        public String getName() {
        return name;
        }
        public void setName(String name) {
        this.name = name;
        }

        public Integer getFkGoodsSpecNameId() {
        return fkGoodsSpecNameId;
        }
        public void setFkGoodsSpecNameId(Integer fkGoodsSpecNameId) {
        this.fkGoodsSpecNameId = fkGoodsSpecNameId;
        }


    }


    /**
    * 修改的参数
    */
    @ApiModel(value="TblGoodsSpecValuePoUpPa对象", description="修改的参数")
    public static class TblGoodsSpecValuePoUpPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "规格值(如 白色)")
        private String name;
        @ApiModelProperty(value = "规格名称id")
        private Integer fkGoodsSpecNameId;

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

        public Integer getFkGoodsSpecNameId() {
        return fkGoodsSpecNameId;
        }
        public void setFkGoodsSpecNameId(Integer fkGoodsSpecNameId) {
        this.fkGoodsSpecNameId = fkGoodsSpecNameId;
        }

    }

    /**
    * 删除的参数
    */
    @ApiModel(value="TblGoodsSpecValuePoDelPa对象", description="删除的参数")
    public static class TblGoodsSpecValuePoDelPa implements Serializable {
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
    @ApiModel(value="TblGoodsSpecValuePoGetPa对象", description="查询单个的参数")
    public static class TblGoodsSpecValuePoGetPa implements Serializable {
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
    @ApiModel(value="TblGoodsSpecValuePoGetListPa对象", description="查询集合的参数")
    public static class TblGoodsSpecValuePoGetListPa  implements Serializable {

        /**
        * 当前页最大id  第一页传0
        */
        @ApiModelProperty(value = "当前页最大id",required = true,notes = "第一页传0")
        private Integer currentPageMaxId;
        /**
        * 每页的大小
        */
        @ApiModelProperty(value = "每页的大小",required = true)
        private Integer pagePumber;

        /**
        * 搜索的关键字
        */
        @ApiModelProperty(value = "关键字")
        private String keyword;


        public Integer getCurrentPageMaxId() {
            return currentPageMaxId;
        }

        public void setCurrentPageMaxId(Integer currentPageMaxId) {
            this.currentPageMaxId = currentPageMaxId;
        }

        public Integer getPagePumber() {
            return pagePumber;
        }

        public void setPagePumber(Integer pagePumber) {
            this.pagePumber = pagePumber;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

    }



}


