package com.yingtongquan.employees.goods.entity;

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
* @since 2020-06-10
*/

@TableName("tbl_warehouse_goods_sku_store_sum")
public class TblWarehouseGoodsSkuStoreSumPo implements Serializable {

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
     *仓库id
     **/
    private Integer fkWarehouseId;

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
    public Integer getFkWarehouseId() {
    return fkWarehouseId;
    }
    public void setFkWarehouseId(Integer fkWarehouseId) {
    this.fkWarehouseId = fkWarehouseId;
    }



    /**
    * 添加的参数
    */
    @ApiModel(value="TblWarehouseGoodsSkuStoreSumPoAddPa对象", description="添加的参数")
    public static class TblWarehouseGoodsSkuStoreSumPoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识",hidden = true )
        private Integer id;

        @ApiModelProperty(value = "商品sku的id")
        private Integer fkGoodsSkuId;

        @ApiModelProperty(value = "库存")
        private Integer store;

        @ApiModelProperty(value = "仓库id")
        private Integer fkWarehouseId;

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
    @ApiModel(value="TblWarehouseGoodsSkuStoreSumPoUpPa对象", description="修改的参数")
    public static class TblWarehouseGoodsSkuStoreSumPoUpPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "商品sku的id")
        private Integer fkGoodsSkuId;
        @ApiModelProperty(value = "库存")
        private Integer store;
        @ApiModelProperty(value = "仓库id")
        private Integer fkWarehouseId;

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
    @ApiModel(value="TblWarehouseGoodsSkuStoreSumPoDelPa对象", description="删除的参数")
    public static class TblWarehouseGoodsSkuStoreSumPoDelPa implements Serializable {
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
    @ApiModel(value="TblWarehouseGoodsSkuStoreSumPoGetPa对象", description="查询单个的参数")
    public static class TblWarehouseGoodsSkuStoreSumPoGetPa implements Serializable {
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
    @ApiModel(value="TblWarehouseGoodsSkuStoreSumPoGetListPa对象", description="查询集合的参数")
    public static class TblWarehouseGoodsSkuStoreSumPoGetListPa  implements Serializable {

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


