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

@TableName("tbl_warehouse_goods")
public class TblWarehouseGoodsPo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "商品spu的id")
    private Integer fkGoodsSpuId;

    @ApiModelProperty(value = "仓库区域id")
    private Integer fkGoodsWarehouseAreaId;

    @ApiModelProperty(value = "运费模板表id")
    private Integer fkFareTemplateId;

    @ApiModelProperty(value = "仓库的id")
    private Integer fkWarehouseId;

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
    public Integer getFkGoodsWarehouseAreaId() {
    return fkGoodsWarehouseAreaId;
    }
    public void setFkGoodsWarehouseAreaId(Integer fkGoodsWarehouseAreaId) {
    this.fkGoodsWarehouseAreaId = fkGoodsWarehouseAreaId;
    }
    public Integer getFkFareTemplateId() {
    return fkFareTemplateId;
    }
    public void setFkFareTemplateId(Integer fkFareTemplateId) {
    this.fkFareTemplateId = fkFareTemplateId;
    }
    public Integer getFkWarehouseId() {
    return fkWarehouseId;
    }
    public void setFkWarehouseId(Integer fkWarehouseId) {
    this.fkWarehouseId = fkWarehouseId;
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
    @ApiModel(value="TblWarehouseGoodsPoAddPa对象", description="添加的参数")
    public static class TblWarehouseGoodsPoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识",hidden = true )
        private Integer id;

        @ApiModelProperty(value = "商品spu的id",hidden = true)
        private Integer fkGoodsSpuId;

        @ApiModelProperty(value = "仓库区域id")
        private Integer fkGoodsWarehouseAreaId;

        @ApiModelProperty(value = "运费模板表id",hidden = true)
        private Integer fkFareTemplateId;

        @ApiModelProperty(value = "仓库的id")
        private Integer fkWarehouseId;

        @ApiModelProperty(value = "员工佣金百分比（按销售价格）",hidden = true)
        private Integer staffCommissionRate;

        @ApiModelProperty(value = "分销商佣金百分比（按销售价格）",hidden = true)
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
        public Integer getFkGoodsWarehouseAreaId() {
        return fkGoodsWarehouseAreaId;
        }
        public void setFkGoodsWarehouseAreaId(Integer fkGoodsWarehouseAreaId) {
        this.fkGoodsWarehouseAreaId = fkGoodsWarehouseAreaId;
        }
        public Integer getFkFareTemplateId() {
        return fkFareTemplateId;
        }
        public void setFkFareTemplateId(Integer fkFareTemplateId) {
        this.fkFareTemplateId = fkFareTemplateId;
        }
        public Integer getFkWarehouseId() {
        return fkWarehouseId;
        }
        public void setFkWarehouseId(Integer fkWarehouseId) {
        this.fkWarehouseId = fkWarehouseId;
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
    @ApiModel(value="TblWarehouseGoodsPoUpPa对象", description="修改的参数")
    public static class TblWarehouseGoodsPoUpPa implements Serializable {
        private Integer id;
        @ApiModelProperty(value = "商品spu的id")
        private Integer fkGoodsSpuId;
        @ApiModelProperty(value = "仓库区域id")
        private Integer fkGoodsWarehouseAreaId;
        @ApiModelProperty(value = "运费模板表id")
        private Integer fkFareTemplateId;
        @ApiModelProperty(value = "仓库的id")
        private Integer fkWarehouseId;
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

        public Integer getFkGoodsWarehouseAreaId() {
        return fkGoodsWarehouseAreaId;
        }
        public void setFkGoodsWarehouseAreaId(Integer fkGoodsWarehouseAreaId) {
        this.fkGoodsWarehouseAreaId = fkGoodsWarehouseAreaId;
        }

        public Integer getFkFareTemplateId() {
        return fkFareTemplateId;
        }
        public void setFkFareTemplateId(Integer fkFareTemplateId) {
        this.fkFareTemplateId = fkFareTemplateId;
        }

        public Integer getFkWarehouseId() {
        return fkWarehouseId;
        }
        public void setFkWarehouseId(Integer fkWarehouseId) {
        this.fkWarehouseId = fkWarehouseId;
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
    @ApiModel(value="TblWarehouseGoodsPoDelPa对象", description="删除的参数")
    public static class TblWarehouseGoodsPoDelPa implements Serializable {

    }

    /**
    * 查询单个的参数
    */
    @ApiModel(value="TblWarehouseGoodsPoGetPa对象", description="查询单个的参数")
    public static class TblWarehouseGoodsPoGetPa implements Serializable {

    }


    /**
    * 查询集合的参数
    */
    @ApiModel(value="TblWarehouseGoodsPoGetListPa对象", description="查询集合的参数")
    public static class TblWarehouseGoodsPoGetListPa extends CommonGetListPa  implements Serializable {

    }



}


