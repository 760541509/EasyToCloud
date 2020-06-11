package com.yingtongquan.employees.goods.entity;

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
* @since 2020-05-29
*/

@TableName("tbl_shop_goods")
public class TblShopGoodsPo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "商品spu的id")
    private Integer fkGoodsSpuId;

    @ApiModelProperty(value = "店铺分类id")
    private Integer fkGoodsCsId;

    @ApiModelProperty(value = "运费模板表id")
    private Integer fkFareTemplateId;

    @ApiModelProperty(value = "门店id")
    private Integer fkShopId;

    @ApiModelProperty(value = "员工佣金百分比（按销售价格）")
    private Integer staffCommissionRate;

    @ApiModelProperty(value = "分销商佣金百分比（按销售价格）")
    private Integer distributorCommissionRate;

    public Integer getId() {
    return id;
    }
    public void setId(Integer id) {
    this.id = id;
    }
    public Integer getFkGoodsSpuId() {
    return fkGoodsSpuId;
    }
    public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
    this.fkGoodsSpuId = fkGoodsSpuId;
    }
    public Integer getFkGoodsCsId() {
    return fkGoodsCsId;
    }
    public void setFkGoodsCsId(Integer fkGoodsCsId) {
    this.fkGoodsCsId = fkGoodsCsId;
    }
    public Integer getFkFareTemplateId() {
    return fkFareTemplateId;
    }
    public void setFkFareTemplateId(Integer fkFareTemplateId) {
    this.fkFareTemplateId = fkFareTemplateId;
    }
    public Integer getFkShopId() {
    return fkShopId;
    }
    public void setFkShopId(Integer fkShopId) {
    this.fkShopId = fkShopId;
    }
    public Integer getStaffCommissionRate() {
    return staffCommissionRate;
    }
    public void setStaffCommissionRate(Integer staffCommissionRate) {
    this.staffCommissionRate = staffCommissionRate;
    }
    public Integer getDistributorCommissionRate() {
    return distributorCommissionRate;
    }
    public void setDistributorCommissionRate(Integer distributorCommissionRate) {
    this.distributorCommissionRate = distributorCommissionRate;
    }



    /**
    * 添加的参数
    */
    @ApiModel(value="TblShopGoodsPoAddPa对象", description="添加的参数")
    public static class TblShopGoodsPoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识",hidden = true )
        private Integer id;

        @ApiModelProperty(value = "商品spu的id")
        private Integer fkGoodsSpuId;

        @ApiModelProperty(value = "店铺分类id")
        private Integer fkGoodsCsId;

        @ApiModelProperty(value = "运费模板表id")
        private Integer fkFareTemplateId;

        @ApiModelProperty(value = "门店id")
        private Integer fkShopId;

        @ApiModelProperty(value = "员工佣金百分比（按销售价格）")
        private Integer staffCommissionRate;

        @ApiModelProperty(value = "分销商佣金百分比（按销售价格）")
        private Integer distributorCommissionRate;

        public Integer getId() {
        return id;
        }
        public void setId(Integer id) {
        this.id = id;
        }
        public Integer getFkGoodsSpuId() {
        return fkGoodsSpuId;
        }
        public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
        this.fkGoodsSpuId = fkGoodsSpuId;
        }
        public Integer getFkGoodsCsId() {
        return fkGoodsCsId;
        }
        public void setFkGoodsCsId(Integer fkGoodsCsId) {
        this.fkGoodsCsId = fkGoodsCsId;
        }
        public Integer getFkFareTemplateId() {
        return fkFareTemplateId;
        }
        public void setFkFareTemplateId(Integer fkFareTemplateId) {
        this.fkFareTemplateId = fkFareTemplateId;
        }
        public Integer getFkShopId() {
        return fkShopId;
        }
        public void setFkShopId(Integer fkShopId) {
        this.fkShopId = fkShopId;
        }
        public Integer getStaffCommissionRate() {
        return staffCommissionRate;
        }
        public void setStaffCommissionRate(Integer staffCommissionRate) {
        this.staffCommissionRate = staffCommissionRate;
        }
        public Integer getDistributorCommissionRate() {
        return distributorCommissionRate;
        }
        public void setDistributorCommissionRate(Integer distributorCommissionRate) {
        this.distributorCommissionRate = distributorCommissionRate;
        }

    }


    /**
    * 修改的参数
    */
    @ApiModel(value="TblShopGoodsPoUpPa对象", description="修改的参数")
    public static class TblShopGoodsPoUpPa implements Serializable {
        private Integer id;
        @ApiModelProperty(value = "商品spu的id")
        private Integer fkGoodsSpuId;
        @ApiModelProperty(value = "店铺分类id")
        private Integer fkGoodsCsId;
        @ApiModelProperty(value = "运费模板表id")
        private Integer fkFareTemplateId;
        @ApiModelProperty(value = "门店id")
        private Integer fkShopId;
        @ApiModelProperty(value = "员工佣金百分比（按销售价格）")
        private Integer staffCommissionRate;
        @ApiModelProperty(value = "分销商佣金百分比（按销售价格）")
        private Integer distributorCommissionRate;

        public Integer getId() {
        return id;
        }
        public void setId(Integer id) {
        this.id = id;
        }

        public Integer getFkGoodsSpuId() {
        return fkGoodsSpuId;
        }
        public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
        this.fkGoodsSpuId = fkGoodsSpuId;
        }

        public Integer getFkGoodsCsId() {
        return fkGoodsCsId;
        }
        public void setFkGoodsCsId(Integer fkGoodsCsId) {
        this.fkGoodsCsId = fkGoodsCsId;
        }

        public Integer getFkFareTemplateId() {
        return fkFareTemplateId;
        }
        public void setFkFareTemplateId(Integer fkFareTemplateId) {
        this.fkFareTemplateId = fkFareTemplateId;
        }

        public Integer getFkShopId() {
        return fkShopId;
        }
        public void setFkShopId(Integer fkShopId) {
        this.fkShopId = fkShopId;
        }

        public Integer getStaffCommissionRate() {
        return staffCommissionRate;
        }
        public void setStaffCommissionRate(Integer staffCommissionRate) {
        this.staffCommissionRate = staffCommissionRate;
        }

        public Integer getDistributorCommissionRate() {
        return distributorCommissionRate;
        }
        public void setDistributorCommissionRate(Integer distributorCommissionRate) {
        this.distributorCommissionRate = distributorCommissionRate;
        }

    }

    /**
    * 删除的参数
    */
    @ApiModel(value="TblShopGoodsPoDelPa对象", description="删除的参数")
    public static class TblShopGoodsPoDelPa implements Serializable {

    }

    /**
    * 查询单个的参数
    */
    @ApiModel(value="TblShopGoodsPoGetPa对象", description="查询单个的参数")
    public static class TblShopGoodsPoGetPa implements Serializable {

    }


    /**
    * 查询集合的参数
    */
    @ApiModel(value="TblShopGoodsPoGetListPa对象", description="查询集合的参数")
    public static class TblShopGoodsPoGetListPa extends CommonGetListPa  implements Serializable {

    }



}


