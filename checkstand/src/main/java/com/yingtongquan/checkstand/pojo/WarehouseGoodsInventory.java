package com.yingtongquan.checkstand.pojo;

import java.io.Serializable;

public class WarehouseGoodsInventory implements Serializable {

    private Integer id;

    //商品sku的id
    private Integer fk_goods_sku_id;

    //仓库商品的spu的id
    private Integer fk_warehouse_goods_spu_id;

    //库存
    private Integer store;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFk_goods_sku_id() {
        return fk_goods_sku_id;
    }

    public void setFk_goods_sku_id(Integer fk_goods_sku_id) {
        this.fk_goods_sku_id = fk_goods_sku_id;
    }

    public Integer getFk_warehouse_goods_spu_id() {
        return fk_warehouse_goods_spu_id;
    }

    public void setFk_warehouse_goods_spu_id(Integer fk_warehouse_goods_spu_id) {
        this.fk_warehouse_goods_spu_id = fk_warehouse_goods_spu_id;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }
}
