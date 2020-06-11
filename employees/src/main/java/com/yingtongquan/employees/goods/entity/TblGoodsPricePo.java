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
* @since 2020-05-30
*/

@TableName("tbl_goods_price")
public class TblGoodsPricePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一标识",hidden = true )
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品spu单位的id")
    private Integer fkGoodsSpuUnitId;

    @ApiModelProperty(value = "商品单位的价格")
    private Integer price;

    @ApiModelProperty(value = "会员价格表id")
    private Integer fkMemberPriceShopId;

    @ApiModelProperty(value = "商品sku的id")
    private Integer fkGoodsSkuId;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "单位父id")
    private Integer unitSupId;

    @ApiModelProperty(value = "单位对应基础单位的数量")
    private Integer unitAmount;

    @ApiModelProperty(value = "价格对应的类型名称")
    private String priceName;




    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getUnitSupId() {
        return unitSupId;
    }

    public void setUnitSupId(Integer unitSupId) {
        this.unitSupId = unitSupId;
    }

    public Integer getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(Integer unitAmount) {
        this.unitAmount = unitAmount;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public Integer getId() {
    return id;
    }
    public void setId(Integer id) {
    this.id = id;
    }
    public Integer getFkGoodsSpuUnitId() {
    return fkGoodsSpuUnitId;
    }
    public void setFkGoodsSpuUnitId(Integer fkGoodsSpuUnitId) {
    this.fkGoodsSpuUnitId = fkGoodsSpuUnitId;
    }
    public Integer getPrice() {
    return price;
    }
    public void setPrice(Integer price) {
    this.price = price;
    }
    public Integer getFkMemberPriceShopId() {
    return fkMemberPriceShopId;
    }
    public void setFkMemberPriceShopId(Integer fkMemberPriceShopId) {
    this.fkMemberPriceShopId = fkMemberPriceShopId;
    }
    public Integer getFkGoodsSkuId() {
    return fkGoodsSkuId;
    }
    public void setFkGoodsSkuId(Integer fkGoodsSkuId) {
    this.fkGoodsSkuId = fkGoodsSkuId;
    }


    /**
    * 添加的参数
    */
    @ApiModel(value="TblGoodsPricePoAddPa对象", description="添加的参数")
    public static class TblGoodsPricePoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识",hidden = true )
        private Integer id;

        @ApiModelProperty(value = "商品spu单位的id")
        private Integer fkGoodsSpuUnitId;

        @ApiModelProperty(value = "商品单位的价格")
        private Integer price;

        @ApiModelProperty(value = "会员价格表id")
        private Integer fkMemberPriceShopId;

        @ApiModelProperty(value = "商品sku的id")
        private Integer fkGoodsSkuId;

        @ApiModelProperty(value = "商品spu的id")
        private Integer fkGoodsSpuId;


        public Integer getId() {
        return id;
        }
        public void setId(Integer id) {
        this.id = id;
        }
        public Integer getFkGoodsSpuUnitId() {
        return fkGoodsSpuUnitId;
        }
        public void setFkGoodsSpuUnitId(Integer fkGoodsSpuUnitId) {
        this.fkGoodsSpuUnitId = fkGoodsSpuUnitId;
        }
        public Integer getPrice() {
        return price;
        }
        public void setPrice(Integer price) {
        this.price = price;
        }
        public Integer getFkMemberPriceShopId() {
        return fkMemberPriceShopId;
        }
        public void setFkMemberPriceShopId(Integer fkMemberPriceShopId) {
        this.fkMemberPriceShopId = fkMemberPriceShopId;
        }
        public Integer getFkGoodsSkuId() {
        return fkGoodsSkuId;
        }
        public void setFkGoodsSkuId(Integer fkGoodsSkuId) {
        this.fkGoodsSkuId = fkGoodsSkuId;
        }

        public Integer getFkGoodsSpuId() {
            return fkGoodsSpuId;
        }

        public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
            this.fkGoodsSpuId = fkGoodsSpuId;
        }
    }


    /**
    * 修改的参数
    */
    @ApiModel(value="TblGoodsPricePoUpPa对象", description="修改的参数")
    public static class TblGoodsPricePoUpPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "商品spu单位的id")
        private Integer fkGoodsSpuUnitId;
        @ApiModelProperty(value = "商品单位的价格")
        private Integer price;
        @ApiModelProperty(value = "会员价格表id")
        private Integer fkMemberPriceShopId;
        @ApiModelProperty(value = "商品sku的id")
        private Integer fkGoodsSkuId;

        public Integer getId() {
        return id;
        }
        public void setId(Integer id) {
        this.id = id;
        }

        public Integer getFkGoodsSpuUnitId() {
        return fkGoodsSpuUnitId;
        }
        public void setFkGoodsSpuUnitId(Integer fkGoodsSpuUnitId) {
        this.fkGoodsSpuUnitId = fkGoodsSpuUnitId;
        }

        public Integer getPrice() {
        return price;
        }
        public void setPrice(Integer price) {
        this.price = price;
        }

        public Integer getFkMemberPriceShopId() {
        return fkMemberPriceShopId;
        }
        public void setFkMemberPriceShopId(Integer fkMemberPriceShopId) {
        this.fkMemberPriceShopId = fkMemberPriceShopId;
        }

        public Integer getFkGoodsSkuId() {
        return fkGoodsSkuId;
        }
        public void setFkGoodsSkuId(Integer fkGoodsSkuId) {
        this.fkGoodsSkuId = fkGoodsSkuId;
        }

    }

    /**
    * 删除的参数
    */
    @ApiModel(value="TblGoodsPricePoDelPa对象", description="删除的参数")
    public static class TblGoodsPricePoDelPa implements Serializable {
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
    @ApiModel(value="TblGoodsPricePoGetPa对象", description="查询单个的参数")
    public static class TblGoodsPricePoGetPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "商品spu单位的id")
        private Integer fkGoodsSpuUnitId;
        @ApiModelProperty(value = "会员价格表id")
        private Integer fkMemberPriceShopId;
        @ApiModelProperty(value = "商品sku的id")
        private Integer fkGoodsSkuId;
        @ApiModelProperty(value = "商品spu的id")
        private Integer fkGoodsSpuId;

        public Integer getId() {
        return id;
        }
        public void setId(Integer id) {
        this.id = id;
        }

        public Integer getFkGoodsSpuUnitId() {
            return fkGoodsSpuUnitId;
        }

        public void setFkGoodsSpuUnitId(Integer fkGoodsSpuUnitId) {
            this.fkGoodsSpuUnitId = fkGoodsSpuUnitId;
        }

        public Integer getFkMemberPriceShopId() {
            return fkMemberPriceShopId;
        }

        public void setFkMemberPriceShopId(Integer fkMemberPriceShopId) {
            this.fkMemberPriceShopId = fkMemberPriceShopId;
        }

        public Integer getFkGoodsSkuId() {
            return fkGoodsSkuId;
        }

        public void setFkGoodsSkuId(Integer fkGoodsSkuId) {
            this.fkGoodsSkuId = fkGoodsSkuId;
        }

        public Integer getFkGoodsSpuId() {
            return fkGoodsSpuId;
        }

        public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
            this.fkGoodsSpuId = fkGoodsSpuId;
        }
    }


    /**
    * 查询集合的参数
    */
    @ApiModel(value="TblGoodsPricePoGetListPa对象", description="查询集合的参数")
    public static class TblGoodsPricePoGetListPa extends CommonGetListPa  implements Serializable {
        @ApiModelProperty(value = "商品spu单位的id")
        private Integer fkGoodsSpuUnitId;
        @ApiModelProperty(value = "会员价格表id")
        private Integer fkMemberPriceShopId;
        @ApiModelProperty(value = "商品sku的id")
        private Integer fkGoodsSkuId;

        @ApiModelProperty(value = "商品spu的id")
        private Integer fkGoodsSpuId;

        public Integer getFkGoodsSpuId() {
            return fkGoodsSpuId;
        }

        public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
            this.fkGoodsSpuId = fkGoodsSpuId;
        }

        public Integer getFkGoodsSpuUnitId() {
            return fkGoodsSpuUnitId;
        }

        public void setFkGoodsSpuUnitId(Integer fkGoodsSpuUnitId) {
            this.fkGoodsSpuUnitId = fkGoodsSpuUnitId;
        }

        public Integer getFkMemberPriceShopId() {
            return fkMemberPriceShopId;
        }

        public void setFkMemberPriceShopId(Integer fkMemberPriceShopId) {
            this.fkMemberPriceShopId = fkMemberPriceShopId;
        }

        public Integer getFkGoodsSkuId() {
            return fkGoodsSkuId;
        }

        public void setFkGoodsSkuId(Integer fkGoodsSkuId) {
            this.fkGoodsSkuId = fkGoodsSkuId;
        }
    }



}


