package com.yingtongquan.employees.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
* @since 2020-06-10
*/

@TableName("tbl_shop_goods_sku_store_sum")
public class TblShopGoodsSkuStoreSumPo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *
     **/
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     *商品sku的id
     **/
    private Integer fkGoodsSkuId;
    /**
     *库存
     **/
    private Integer store;
    /**
     *门店id
     **/
    private Integer fkShopId;

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
    public Integer getFkShopId() {
    return fkShopId;
    }
    public void setFkShopId(Integer fkShopId) {
    this.fkShopId = fkShopId;
    }



    /**
    * 添加的参数
    */
    @ApiModel(value="TblShopGoodsSkuStoreSumPoAddPa对象", description="添加的参数")
    public static class TblShopGoodsSkuStoreSumPoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识",hidden = true )
        private Integer id;

        @ApiModelProperty(value = "商品sku的id")
        private Integer fkGoodsSkuId;

        @ApiModelProperty(value = "库存")
        private Integer store;

        @ApiModelProperty(value = "门店id")
        private Integer fkShopId;

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
        public Integer getFkShopId() {
        return fkShopId;
        }
        public void setFkShopId(Integer fkShopId) {
        this.fkShopId = fkShopId;
        }

    }


    /**
    * 修改的参数
    */
    @ApiModel(value="TblShopGoodsSkuStoreSumPoUpPa对象", description="修改的参数")
    public static class TblShopGoodsSkuStoreSumPoUpPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "商品sku的id")
        private Integer fkGoodsSkuId;
        @ApiModelProperty(value = "库存")
        private Integer store;
        @ApiModelProperty(value = "门店id")
        private Integer fkShopId;

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
    @ApiModel(value="TblShopGoodsSkuStoreSumPoDelPa对象", description="删除的参数")
    public static class TblShopGoodsSkuStoreSumPoDelPa implements Serializable {
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
    @ApiModel(value="TblShopGoodsSkuStoreSumPoGetPa对象", description="查询单个的参数")
    public static class TblShopGoodsSkuStoreSumPoGetPa implements Serializable {
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
    @ApiModel(value="TblShopGoodsSkuStoreSumPoGetListPa对象", description="查询集合的参数")
    public static class TblShopGoodsSkuStoreSumPoGetListPa  implements Serializable {

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

        @ApiModelProperty(value = "sku的id集合")
        private List<Integer> skuIds;

        @ApiModelProperty(value = "门店id")
        private Integer fkShopId;

        public List<Integer> getSkuIds() {
            return skuIds;
        }

        public void setSkuIds(List<Integer> skuIds) {
            this.skuIds = skuIds;
        }

        public Integer getFkShopId() {
            return fkShopId;
        }

        public void setFkShopId(Integer fkShopId) {
            this.fkShopId = fkShopId;
        }

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


