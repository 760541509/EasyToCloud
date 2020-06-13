package com.yingtongquan.employees.goods.entity;

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
 * @since 2020-05-29
 */

@TableName("tbl_warehouse_goods_sku_store")
public class TblWarehouseGoodsSkuStorePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一标识", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品sku的id")
    private Integer fkGoodsSkuId;

    @ApiModelProperty(value = "库存")
    private Integer store;

    @ApiModelProperty(value = "入库时间")
    private Long addTime;

    @ApiModelProperty(value = "生产时间")
    private Long productionTime;

    @ApiModelProperty(value = "保质期时间")
    private Long expirationDate;

    @ApiModelProperty(value = "该次进货的价格")
    private Integer costPrice;

    @ApiModelProperty(value = "录入员工ID")
    private Integer fkIdStaff;

    @ApiModelProperty(value = "仓库id")
    private Integer fkWarehouseId;

    @ApiModelProperty(value = "类型（0 员工入库或出库，1 出库单入库或出库 ）")
    private Integer type;

    @ApiModelProperty(value = "出库单号", hidden = true)
    private String outboundOrderNo;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOutboundOrderNo() {
        return outboundOrderNo;
    }

    public void setOutboundOrderNo(String outboundOrderNo) {
        this.outboundOrderNo = outboundOrderNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkGoodsSkuId() {
        return fkGoodsSkuId;
    }

    public void setFkGoodsSkuId(Integer fkGoodsSkuId) {
        this.fkGoodsSkuId = fkGoodsSkuId;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Long getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Long productionTime) {
        this.productionTime = productionTime;
    }

    public Long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getFkIdStaff() {
        return fkIdStaff;
    }

    public void setFkIdStaff(Integer fkIdStaff) {
        this.fkIdStaff = fkIdStaff;
    }

    public Integer getFkWarehouseId() {
        return fkWarehouseId;
    }

    public void setFkWarehouseId(Integer fkWarehouseId) {
        this.fkWarehouseId = fkWarehouseId;
    }


    /**
     * 添加的参数
     */
    @ApiModel(value = "TblWarehouseGoodsSkuStorePoAddPa对象", description = "添加的参数")
    public static class TblWarehouseGoodsSkuStorePoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识", hidden = true)
        private Integer id;

        @ApiModelProperty(value = "商品sku的id")
        private Integer fkGoodsSkuId;

        @ApiModelProperty(value = "该次入库的数量，可为负数")
        private Integer store;

        @ApiModelProperty(value = "入库时间", hidden = true)
        private Long addTime;

        @ApiModelProperty(value = "生产时间")
        private Long productionTime;

        @ApiModelProperty(value = "保质期时间")
        private Long expirationDate;

        @ApiModelProperty(value = "该次进货的价格")
        private Integer costPrice;

        @ApiModelProperty(value = "录入员工ID", hidden = true)
        private Integer fkIdStaff;

        @ApiModelProperty(value = "仓库id")
        private Integer fkWarehouseId;

        @ApiModelProperty(value = "类型（0 员工入库或出库，1 出库单入库或出库 ）")
        private Integer type;

        @ApiModelProperty(value = "出库单号", hidden = true)
        private String outboundOrderNo;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getOutboundOrderNo() {
            return outboundOrderNo;
        }

        public void setOutboundOrderNo(String outboundOrderNo) {
            this.outboundOrderNo = outboundOrderNo;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getFkGoodsSkuId() {
            return fkGoodsSkuId;
        }

        public void setFkGoodsSkuId(Integer fkGoodsSkuId) {
            this.fkGoodsSkuId = fkGoodsSkuId;
        }

        public Integer getStore() {
            return store;
        }

        public void setStore(Integer store) {
            this.store = store;
        }

        public Long getAddTime() {
            return addTime;
        }

        public void setAddTime(Long addTime) {
            this.addTime = addTime;
        }

        public Long getProductionTime() {
            return productionTime;
        }

        public void setProductionTime(Long productionTime) {
            this.productionTime = productionTime;
        }

        public Long getExpirationDate() {
            return expirationDate;
        }

        public void setExpirationDate(Long expirationDate) {
            this.expirationDate = expirationDate;
        }

        public Integer getCostPrice() {
            return costPrice;
        }

        public void setCostPrice(Integer costPrice) {
            this.costPrice = costPrice;
        }

        public Integer getFkIdStaff() {
            return fkIdStaff;
        }

        public void setFkIdStaff(Integer fkIdStaff) {
            this.fkIdStaff = fkIdStaff;
        }

        public Integer getFkWarehouseId() {
            return fkWarehouseId;
        }

        public void setFkWarehouseId(Integer fkWarehouseId) {
            this.fkWarehouseId = fkWarehouseId;
        }


    }


    /**
     * 修改的参数
     */
    @ApiModel(value = "TblWarehouseGoodsSkuStorePoUpPa对象", description = "修改的参数")
    public static class TblWarehouseGoodsSkuStorePoUpPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "商品sku的id")
        private Integer fkGoodsSkuId;
        @ApiModelProperty(value = "库存")
        private Integer store;
        @ApiModelProperty(value = "入库时间")
        private Long addTime;
        @ApiModelProperty(value = "生产时间")
        private Long productionTime;
        @ApiModelProperty(value = "保质期时间")
        private Long expirationDate;
        @ApiModelProperty(value = "该次进货的价格")
        private Integer costPrice;
        @ApiModelProperty(value = "录入员工ID")
        private Integer fkIdStaff;
        @ApiModelProperty(value = "仓库id")
        private Integer fkWarehouseId;
        @ApiModelProperty(value = "类型（0 员工入库或出库，1 出库单入库或出库 ）")
        private Integer type;

        @ApiModelProperty(value = "出库单号", hidden = true)
        private String outboundOrderNo;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getOutboundOrderNo() {
            return outboundOrderNo;
        }

        public void setOutboundOrderNo(String outboundOrderNo) {
            this.outboundOrderNo = outboundOrderNo;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getFkGoodsSkuId() {
            return fkGoodsSkuId;
        }

        public void setFkGoodsSkuId(Integer fkGoodsSkuId) {
            this.fkGoodsSkuId = fkGoodsSkuId;
        }

        public Integer getStore() {
            return store;
        }

        public void setStore(Integer store) {
            this.store = store;
        }

        public Long getAddTime() {
            return addTime;
        }

        public void setAddTime(Long addTime) {
            this.addTime = addTime;
        }

        public Long getProductionTime() {
            return productionTime;
        }

        public void setProductionTime(Long productionTime) {
            this.productionTime = productionTime;
        }

        public Long getExpirationDate() {
            return expirationDate;
        }

        public void setExpirationDate(Long expirationDate) {
            this.expirationDate = expirationDate;
        }

        public Integer getCostPrice() {
            return costPrice;
        }

        public void setCostPrice(Integer costPrice) {
            this.costPrice = costPrice;
        }

        public Integer getFkIdStaff() {
            return fkIdStaff;
        }

        public void setFkIdStaff(Integer fkIdStaff) {
            this.fkIdStaff = fkIdStaff;
        }

        public Integer getFkWarehouseId() {
            return fkWarehouseId;
        }

        public void setFkWarehouseId(Integer fkWarehouseId) {
            this.fkWarehouseId = fkWarehouseId;
        }

    }

    /**
     * 删除的参数
     */
    @ApiModel(value = "TblWarehouseGoodsSkuStorePoDelPa对象", description = "删除的参数")
    public static class TblWarehouseGoodsSkuStorePoDelPa implements Serializable {
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
    @ApiModel(value = "TblWarehouseGoodsSkuStorePoGetPa对象", description = "查询单个的参数")
    public static class TblWarehouseGoodsSkuStorePoGetPa implements Serializable {
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
    @ApiModel(value = "TblWarehouseGoodsSkuStorePoGetListPa对象", description = "查询集合的参数")
    public static class TblWarehouseGoodsSkuStorePoGetListPa extends CommonGetListPa implements Serializable {

    }


}


