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

@TableName("tbl_goods_sku")
public class TblGoodsSkuPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一标识",hidden = true )
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品spu的id")
    private Integer fkGoodsSpuId;

    @ApiModelProperty(value = "条码")
    private String barCode;

    @ApiModelProperty(value = "货号")
    private String artNo;

    @ApiModelProperty(value = "图片")
    private String image;

    @ApiModelProperty(value = "规格值的id组合[白色,上衣,S]")
    private String fkSpecValueIds;

    @ApiModelProperty(value = "库存")
    private Integer store;

    @ApiModelProperty(value = "规格名称")
    private String specName;

    @ApiModelProperty(value = "规格名称的值")
    private String specValue;

    @ApiModelProperty(value = "单位价格信息")
    private List<TblGoodsPricePo> goodsPricePoList;

    public List<TblGoodsPricePo> getGoodsPricePoList() {
        return goodsPricePoList;
    }

    public void setGoodsPricePoList(List<TblGoodsPricePo> goodsPricePoList) {
        this.goodsPricePoList = goodsPricePoList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue;
    }

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
    public String getBarCode() {
    return barCode;
    }
    public void setBarCode(String barCode) {
    this.barCode = barCode;
    }
    public String getArtNo() {
    return artNo;
    }
    public void setArtNo(String artNo) {
    this.artNo = artNo;
    }
    public String getImage() {
    return image;
    }
    public void setImage(String image) {
    this.image = image;
    }
    public String getFkSpecValueIds() {
    return fkSpecValueIds;
    }
    public void setFkSpecValueIds(String fkSpecValueIds) {
    this.fkSpecValueIds = fkSpecValueIds;
    }
    public Integer getStore() {
    return store;
    }
    public void setStore(Integer store) {
    this.store = store;
    }



    /**
    * 添加的参数
    */
    @ApiModel(value="TblGoodsSkuPoAddPa对象", description="添加的参数")
    public static class TblGoodsSkuPoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识",hidden = true )
        private Integer id;

        @ApiModelProperty(value = "商品spu的id",hidden = true)
        private Integer fkGoodsSpuId;

        @ApiModelProperty(value = "条码")
        private String barCode;

        @ApiModelProperty(value = "货号")
        private String artNo;

        @ApiModelProperty(value = "图片")
        private String image;

        @ApiModelProperty(value = "规格值的id组合[白色,上衣,S]")
        private String fkSpecValueIds;

        @ApiModelProperty(value = "库存",hidden = true)
        private Integer store;

        @ApiModelProperty(value = "价格集合")
        private List<TblGoodsPricePo.TblGoodsPricePoAddPa> unitPriceList;

        @ApiModelProperty(value = "仓库库存集合")
        private List<TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa> warehouseGoodsstoreList;

        @ApiModelProperty(value = "门店库存")
        private TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa shopGoodsstore;


        public List<TblGoodsPricePo.TblGoodsPricePoAddPa> getUnitPriceList() {
            return unitPriceList;
        }

        public void setUnitPriceList(List<TblGoodsPricePo.TblGoodsPricePoAddPa> unitPriceList) {
            this.unitPriceList = unitPriceList;
        }

        public List<TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa> getWarehouseGoodsstoreList() {
            return warehouseGoodsstoreList;
        }

        public void setWarehouseGoodsstoreList(List<TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa> warehouseGoodsstoreList) {
            this.warehouseGoodsstoreList = warehouseGoodsstoreList;
        }

        public TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa getShopGoodsstore() {
            return shopGoodsstore;
        }

        public void setShopGoodsstore(TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa shopGoodsstore) {
            this.shopGoodsstore = shopGoodsstore;
        }

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
        public String getBarCode() {
        return barCode;
        }
        public void setBarCode(String barCode) {
        this.barCode = barCode;
        }
        public String getArtNo() {
        return artNo;
        }
        public void setArtNo(String artNo) {
        this.artNo = artNo;
        }
        public String getImage() {
        return image;
        }
        public void setImage(String image) {
        this.image = image;
        }
        public String getFkSpecValueIds() {
        return fkSpecValueIds;
        }
        public void setFkSpecValueIds(String fkSpecValueIds) {
        this.fkSpecValueIds = fkSpecValueIds;
        }
        public Integer getStore() {
        return store;
        }
        public void setStore(Integer store) {
        this.store = store;
        }

    }





    /**
    * 修改的参数
    */
    @ApiModel(value="TblGoodsSkuPoUpPa对象", description="修改的参数")
    public static class TblGoodsSkuPoUpPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "商品spu的id")
        private Integer fkGoodsSpuId;
        @ApiModelProperty(value = "条码")
        private String barCode;
        @ApiModelProperty(value = "货号")
        private String artNo;
        @ApiModelProperty(value = "图片")
        private String image;
        @ApiModelProperty(value = "规格值的id组合[白色,上衣,S]")
        private String fkSpecValueIds;
        @ApiModelProperty(value = "库存")
        private Integer store;

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

        public String getBarCode() {
        return barCode;
        }
        public void setBarCode(String barCode) {
        this.barCode = barCode;
        }

        public String getArtNo() {
        return artNo;
        }
        public void setArtNo(String artNo) {
        this.artNo = artNo;
        }

        public String getImage() {
        return image;
        }
        public void setImage(String image) {
        this.image = image;
        }

        public String getFkSpecValueIds() {
        return fkSpecValueIds;
        }
        public void setFkSpecValueIds(String fkSpecValueIds) {
        this.fkSpecValueIds = fkSpecValueIds;
        }

        public Integer getStore() {
        return store;
        }
        public void setStore(Integer store) {
        this.store = store;
        }

    }

    /**
    * 删除的参数
    */
    @ApiModel(value="TblGoodsSkuPoDelPa对象", description="删除的参数")
    public static class TblGoodsSkuPoDelPa implements Serializable {
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
    @ApiModel(value="TblGoodsSkuPoGetPa对象", description="查询单个的参数")
    public static class TblGoodsSkuPoGetPa implements Serializable {
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
    @ApiModel(value="TblGoodsSkuPoGetListPa对象", description="查询集合的参数")
    public static class TblGoodsSkuPoGetListPa extends CommonGetListPa  implements Serializable {

        @ApiModelProperty(value = "商品id")
        private Integer fkGoodsSpuId;

        public Integer getFkGoodsSpuId() {
            return fkGoodsSpuId;
        }

        public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
            this.fkGoodsSpuId = fkGoodsSpuId;
        }
    }



}


