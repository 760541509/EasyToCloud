package com.yingtongquan.employees.goods.entity;

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
* @since 2020-05-29
*/

@TableName("tbl_goods_spu")
public class TblGoodsSpuPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一标识",hidden = true )
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "发布时间")
    private Long addTime;

    @ApiModelProperty(value = "修改时间")
    private Long upTime;

    @ApiModelProperty(value = "商品轮播图")
    private String carouselImage;

    @ApiModelProperty(value = "图文详情，放html")
    private String details;

    @ApiModelProperty(value = "商品状态（-1 已删除，0 下架，1 上架）")
    private Integer status;

    @ApiModelProperty(value = "平台品牌id")
    private Integer fkGoodsBrandId;

    @ApiModelProperty(value = "平台分类id")
    private Integer fkGoodsCpId;

    @ApiModelProperty(value = "参数值的id组合(“参数名称id”:[参数值id])")
    private String fkParameterValueIds;

    @ApiModelProperty(value = "商品的最低价")
    private Integer lowestPrice;

    @ApiModelProperty(value = "商品的最高价")
    private Integer highestPrice;

    @ApiModelProperty(value = "录入员工的id")
    private Integer fkStaffId;

    @ApiModelProperty(value = "总库存")
    private Integer totalStore;

    @ApiModelProperty(value = "月销量")
    private Integer monthlySales;

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
    public Long getAddTime() {
    return addTime;
    }
    public void setAddTime(Long addTime) {
    this.addTime = addTime;
    }
    public Long getUpTime() {
    return upTime;
    }
    public void setUpTime(Long upTime) {
    this.upTime = upTime;
    }
    public String getCarouselImage() {
    return carouselImage;
    }
    public void setCarouselImage(String carouselImage) {
    this.carouselImage = carouselImage;
    }
    public String getDetails() {
    return details;
    }
    public void setDetails(String details) {
    this.details = details;
    }
    public Integer getStatus() {
    return status;
    }
    public void setStatus(Integer status) {
    this.status = status;
    }
    public Integer getFkGoodsBrandId() {
    return fkGoodsBrandId;
    }
    public void setFkGoodsBrandId(Integer fkGoodsBrandId) {
    this.fkGoodsBrandId = fkGoodsBrandId;
    }
    public Integer getFkGoodsCpId() {
    return fkGoodsCpId;
    }
    public void setFkGoodsCpId(Integer fkGoodsCpId) {
    this.fkGoodsCpId = fkGoodsCpId;
    }
    public String getFkParameterValueIds() {
    return fkParameterValueIds;
    }
    public void setFkParameterValueIds(String fkParameterValueIds) {
    this.fkParameterValueIds = fkParameterValueIds;
    }
    public Integer getLowestPrice() {
    return lowestPrice;
    }
    public void setLowestPrice(Integer lowestPrice) {
    this.lowestPrice = lowestPrice;
    }
    public Integer getHighestPrice() {
    return highestPrice;
    }
    public void setHighestPrice(Integer highestPrice) {
    this.highestPrice = highestPrice;
    }
    public Integer getFkStaffId() {
    return fkStaffId;
    }
    public void setFkStaffId(Integer fkStaffId) {
    this.fkStaffId = fkStaffId;
    }
    public Integer getTotalStore() {
    return totalStore;
    }
    public void setTotalStore(Integer totalStore) {
    this.totalStore = totalStore;
    }
    public Integer getMonthlySales() {
    return monthlySales;
    }
    public void setMonthlySales(Integer monthlySales) {
    this.monthlySales = monthlySales;
    }



    /**
    * 添加的参数
    */
    @ApiModel(value="TblGoodsSpuPoAddPa对象", description="添加的参数")
    public static class TblGoodsSpuPoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识",hidden = true )
        private Integer id;

        @ApiModelProperty(value = "商品名称")
        private String name;

        @ApiModelProperty(value = "发布时间",hidden = true)
        private Long addTime;

        @ApiModelProperty(value = "修改时间",hidden = true)
        private Long upTime;

        @ApiModelProperty(value = "商品轮播图")
        private String carouselImage;

        @ApiModelProperty(value = "图文详情，放html")
        private String details;

        @ApiModelProperty(value = "商品状态（-1 已删除，0 下架，1 上架）")
        private Integer status;

        @ApiModelProperty(value = "品牌id")
        private Integer fkGoodsBrandId;

        @ApiModelProperty(value = "平台分类id",hidden = true)
        private Integer fkGoodsCpId;

        @ApiModelProperty(value = "参数值的id组合(“参数名称id”:[参数值id])",hidden = true)
        private String fkParameterValueIds;

        @ApiModelProperty(value = "商品的最低价",hidden = true)
        private Integer lowestPrice;

        @ApiModelProperty(value = "商品的最高价",hidden = true)
        private Integer highestPrice;

        @ApiModelProperty(value = "录入员工的id",hidden = true)
        private Integer fkStaffId;

        @ApiModelProperty(value = "总库存",hidden = true)
        private Integer totalStore;

        @ApiModelProperty(value = "月销量",hidden = true)
        private Integer monthlySales;

        @ApiModelProperty(value = "门店分类id")
        private Integer fkGoodsCsId;

        @ApiModelProperty(value = "门店id",hidden = true)
        private Integer fkShopId;

        @ApiModelProperty(value = "要入库的仓库")
        private List<TblWarehouseGoodsPo.TblWarehouseGoodsPoAddPa> warehouseList;

        @ApiModelProperty(value = "单位集合")
        private List<TblGoodsSpuUnitPo.TblGoodsSpuUnitPoAddPa> unitList;

        @ApiModelProperty(value = "sku集合")
        private List<TblGoodsSkuPo.TblGoodsSkuPoAddPa> goodsSkuList;



        public Integer getFkShopId() {
            return fkShopId;
        }

        public void setFkShopId(Integer fkShopId) {
            this.fkShopId = fkShopId;
        }

        public Integer getFkGoodsCsId() {
            return fkGoodsCsId;
        }

        public void setFkGoodsCsId(Integer fkGoodsCsId) {
            this.fkGoodsCsId = fkGoodsCsId;
        }

        public List<TblWarehouseGoodsPo.TblWarehouseGoodsPoAddPa> getWarehouseList() {
            return warehouseList;
        }

        public void setWarehouseList(List<TblWarehouseGoodsPo.TblWarehouseGoodsPoAddPa> warehouseList) {
            this.warehouseList = warehouseList;
        }

        public List<TblGoodsSpuUnitPo.TblGoodsSpuUnitPoAddPa> getUnitList() {
            return unitList;
        }

        public void setUnitList(List<TblGoodsSpuUnitPo.TblGoodsSpuUnitPoAddPa> unitList) {
            this.unitList = unitList;
        }

        public List<TblGoodsSkuPo.TblGoodsSkuPoAddPa> getGoodsSkuList() {
            return goodsSkuList;
        }

        public void setGoodsSkuList(List<TblGoodsSkuPo.TblGoodsSkuPoAddPa> goodsSkuList) {
            this.goodsSkuList = goodsSkuList;
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
        public Long getAddTime() {
        return addTime;
        }
        public void setAddTime(Long addTime) {
        this.addTime = addTime;
        }
        public Long getUpTime() {
        return upTime;
        }
        public void setUpTime(Long upTime) {
        this.upTime = upTime;
        }
        public String getCarouselImage() {
        return carouselImage;
        }
        public void setCarouselImage(String carouselImage) {
        this.carouselImage = carouselImage;
        }
        public String getDetails() {
        return details;
        }
        public void setDetails(String details) {
        this.details = details;
        }
        public Integer getStatus() {
        return status;
        }
        public void setStatus(Integer status) {
        this.status = status;
        }
        public Integer getFkGoodsBrandId() {
        return fkGoodsBrandId;
        }
        public void setFkGoodsBrandId(Integer fkGoodsBrandId) {
        this.fkGoodsBrandId = fkGoodsBrandId;
        }
        public Integer getFkGoodsCpId() {
        return fkGoodsCpId;
        }
        public void setFkGoodsCpId(Integer fkGoodsCpId) {
        this.fkGoodsCpId = fkGoodsCpId;
        }
        public String getFkParameterValueIds() {
        return fkParameterValueIds;
        }
        public void setFkParameterValueIds(String fkParameterValueIds) {
        this.fkParameterValueIds = fkParameterValueIds;
        }
        public Integer getLowestPrice() {
        return lowestPrice;
        }
        public void setLowestPrice(Integer lowestPrice) {
        this.lowestPrice = lowestPrice;
        }
        public Integer getHighestPrice() {
        return highestPrice;
        }
        public void setHighestPrice(Integer highestPrice) {
        this.highestPrice = highestPrice;
        }
        public Integer getFkStaffId() {
        return fkStaffId;
        }
        public void setFkStaffId(Integer fkStaffId) {
        this.fkStaffId = fkStaffId;
        }
        public Integer getTotalStore() {
        return totalStore;
        }
        public void setTotalStore(Integer totalStore) {
        this.totalStore = totalStore;
        }
        public Integer getMonthlySales() {
        return monthlySales;
        }
        public void setMonthlySales(Integer monthlySales) {
        this.monthlySales = monthlySales;
        }

    }


    /**
    * 修改的参数
    */
    @ApiModel(value="TblGoodsSpuPoUpPa对象", description="修改的参数")
    public static class TblGoodsSpuPoUpPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "商品名称")
        private String name;
        @ApiModelProperty(value = "发布时间")
        private Long addTime;
        @ApiModelProperty(value = "修改时间")
        private Long upTime;
        @ApiModelProperty(value = "商品轮播图")
        private String carouselImage;
        @ApiModelProperty(value = "图文详情，放html")
        private String details;
        @ApiModelProperty(value = "商品状态（-1 已删除，0 下架，1 上架）")
        private Integer status;
        @ApiModelProperty(value = "平台品牌id")
        private Integer fkGoodsBrandId;
        @ApiModelProperty(value = "平台分类id")
        private Integer fkGoodsCpId;
        @ApiModelProperty(value = "参数值的id组合(“参数名称id”:[参数值id])")
        private String fkParameterValueIds;
        @ApiModelProperty(value = "商品的最低价")
        private Integer lowestPrice;
        @ApiModelProperty(value = "商品的最高价")
        private Integer highestPrice;
        @ApiModelProperty(value = "录入员工的id")
        private Integer fkStaffId;
        @ApiModelProperty(value = "总库存")
        private Integer totalStore;
        @ApiModelProperty(value = "月销量")
        private Integer monthlySales;

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

        public Long getAddTime() {
        return addTime;
        }
        public void setAddTime(Long addTime) {
        this.addTime = addTime;
        }

        public Long getUpTime() {
        return upTime;
        }
        public void setUpTime(Long upTime) {
        this.upTime = upTime;
        }

        public String getCarouselImage() {
        return carouselImage;
        }
        public void setCarouselImage(String carouselImage) {
        this.carouselImage = carouselImage;
        }

        public String getDetails() {
        return details;
        }
        public void setDetails(String details) {
        this.details = details;
        }

        public Integer getStatus() {
        return status;
        }
        public void setStatus(Integer status) {
        this.status = status;
        }

        public Integer getFkGoodsBrandId() {
        return fkGoodsBrandId;
        }
        public void setFkGoodsBrandId(Integer fkGoodsBrandId) {
        this.fkGoodsBrandId = fkGoodsBrandId;
        }

        public Integer getFkGoodsCpId() {
        return fkGoodsCpId;
        }
        public void setFkGoodsCpId(Integer fkGoodsCpId) {
        this.fkGoodsCpId = fkGoodsCpId;
        }

        public String getFkParameterValueIds() {
        return fkParameterValueIds;
        }
        public void setFkParameterValueIds(String fkParameterValueIds) {
        this.fkParameterValueIds = fkParameterValueIds;
        }

        public Integer getLowestPrice() {
        return lowestPrice;
        }
        public void setLowestPrice(Integer lowestPrice) {
        this.lowestPrice = lowestPrice;
        }

        public Integer getHighestPrice() {
        return highestPrice;
        }
        public void setHighestPrice(Integer highestPrice) {
        this.highestPrice = highestPrice;
        }

        public Integer getFkStaffId() {
        return fkStaffId;
        }
        public void setFkStaffId(Integer fkStaffId) {
        this.fkStaffId = fkStaffId;
        }

        public Integer getTotalStore() {
        return totalStore;
        }
        public void setTotalStore(Integer totalStore) {
        this.totalStore = totalStore;
        }

        public Integer getMonthlySales() {
        return monthlySales;
        }
        public void setMonthlySales(Integer monthlySales) {
        this.monthlySales = monthlySales;
        }

    }

    /**
    * 删除的参数
    */
    @ApiModel(value="TblGoodsSpuPoDelPa对象", description="删除的参数")
    public static class TblGoodsSpuPoDelPa implements Serializable {
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
    @ApiModel(value="TblGoodsSpuPoGetPa对象", description="查询单个的参数")
    public static class TblGoodsSpuPoGetPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "商品的id" )
        private Integer fkGoodsSpuId;
        @ApiModelProperty(value = "会员价格类型")
        private Integer fkMemberPriceShopId;

        public Integer getFkGoodsSpuId() {
            return fkGoodsSpuId;
        }

        public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
            this.fkGoodsSpuId = fkGoodsSpuId;
        }

        public Integer getFkMemberPriceShopId() {
            return fkMemberPriceShopId;
        }

        public void setFkMemberPriceShopId(Integer fkMemberPriceShopId) {
            this.fkMemberPriceShopId = fkMemberPriceShopId;
        }

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
    @ApiModel(value="TblGoodsSpuPoGetListPa对象", description="查询集合的参数")
    public static class TblGoodsSpuPoGetListPa extends CommonGetListPa  implements Serializable {
        @ApiModelProperty(value = "门店分类")
        private Integer fkGoodsCsId;

        @ApiModelProperty(value = "品牌")
        private Integer fkGoodsBrandId;

        @ApiModelProperty(value = "会员价格类型")
        private Integer fkMemberPriceShopId;

        public Integer getFkMemberPriceShopId() {
            return fkMemberPriceShopId;
        }

        public void setFkMemberPriceShopId(Integer fkMemberPriceShopId) {
            this.fkMemberPriceShopId = fkMemberPriceShopId;
        }

        public Integer getFkGoodsCsId() {
            return fkGoodsCsId;
        }

        public void setFkGoodsCsId(Integer fkGoodsCsId) {
            this.fkGoodsCsId = fkGoodsCsId;
        }

        public Integer getFkGoodsBrandId() {
            return fkGoodsBrandId;
        }

        public void setFkGoodsBrandId(Integer fkGoodsBrandId) {
            this.fkGoodsBrandId = fkGoodsBrandId;
        }
    }



}


