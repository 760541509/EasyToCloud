package com.yingtongquan.employees.spec.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yingtongquan.startcommon.pojo.CommonGetListPa;
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
* @since 2020-05-21
*/

@TableName("tbl_goods_spec_name")
public class TblGoodsSpecNamePo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *
     **/
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     *规格名称
     **/
    private String name;
    /**
     *门店的Id
     **/
    private Integer fkShopId;

    /**
     * 规格值集合
     */
    private List<TblGoodsSpecValuePo> goodsSpecValuePoList;


    public List<TblGoodsSpecValuePo> getGoodsSpecValuePoList() {
        return goodsSpecValuePoList;
    }

    public void setGoodsSpecValuePoList(List<TblGoodsSpecValuePo> goodsSpecValuePoList) {
        this.goodsSpecValuePoList = goodsSpecValuePoList;
    }

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
    public Integer getFkShopId() {
    return fkShopId;
    }
    public void setFkShopId(Integer fkShopId) {
    this.fkShopId = fkShopId;
    }



    /**
    * 添加的参数
    */
    @ApiModel(value="TblGoodsSpecNamePoAddPa对象", description="添加的参数")
    public static class TblGoodsSpecNamePoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识",hidden = true )
        private Integer id;

        @ApiModelProperty(value = "规格名称")
        private String name;

        @ApiModelProperty(value = "门店的Id",hidden = true)
        private Integer fkShopId;

        @ApiModelProperty(value = "修改的时间",hidden = true)
        private Long upTime;

        @ApiModelProperty(value = "规格值集合")
        private List<TblGoodsSpecValuePo.TblGoodsSpecValuePoAddPa> goodsSpecValuePoAddPaList;

        public String getName() {
        return name;
        }
        public void setName(String name) {
        this.name = name;
        }

        public Integer getFkShopId() {
        return fkShopId;
        }
        public void setFkShopId(Integer fkShopId) {
        this.fkShopId = fkShopId;
        }

        public List<TblGoodsSpecValuePo.TblGoodsSpecValuePoAddPa> getGoodsSpecValuePoAddPaList() {
            return goodsSpecValuePoAddPaList;
        }

        public void setGoodsSpecValuePoAddPaList(List<TblGoodsSpecValuePo.TblGoodsSpecValuePoAddPa> goodsSpecValuePoAddPaList) {
            this.goodsSpecValuePoAddPaList = goodsSpecValuePoAddPaList;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Long getUpTime() {
            return upTime;
        }

        public void setUpTime(Long upTime) {
            this.upTime = upTime;
        }
    }


    /**
    * 修改的参数
    */
    @ApiModel(value="TblGoodsSpecNamePoUpPa对象", description="修改的参数")
    public static class TblGoodsSpecNamePoUpPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "规格名称")
        private String name;
        @ApiModelProperty(value = "门店的Id")
        private Integer fkShopId;

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

        public Integer getFkShopId() {
        return fkShopId;
        }
        public void setFkShopId(Integer fkShopId) {
        this.fkShopId = fkShopId;
        }

    }

    /**
    * 删除的参数
    */
    @ApiModel(value="TblGoodsSpecNamePoDelPa对象", description="删除的参数")
    public static class TblGoodsSpecNamePoDelPa implements Serializable {
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
    @ApiModel(value="TblGoodsSpecNamePoGetPa对象", description="查询单个的参数")
    public static class TblGoodsSpecNamePoGetPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "规格名称")
        private String name;
        @ApiModelProperty(value = "门店的Id")
        private Integer fkShopId;




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

        public Integer getFkShopId() {
            return fkShopId;
        }

        public void setFkShopId(Integer fkShopId) {
            this.fkShopId = fkShopId;
        }
    }


    /**
    * 查询集合的参数
    */
    @ApiModel(value="TblGoodsSpecNamePoGetListPa对象", description="查询集合的参数")
    public static class TblGoodsSpecNamePoGetListPa extends CommonGetListPa implements Serializable {



    }



}


