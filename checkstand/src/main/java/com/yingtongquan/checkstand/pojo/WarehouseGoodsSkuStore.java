package com.yingtongquan.checkstand.pojo;

import java.io.Serializable;

public class WarehouseGoodsSkuStore implements Serializable {

    private Integer id;

    private Integer fk_warehouse_goods_sku_id;

    private Integer store;

    private Long add_time;

    private Long production_time;

    private Long expiration_date;

    private Integer cost_price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFk_warehouse_goods_sku_id() {
        return fk_warehouse_goods_sku_id;
    }

    public void setFk_warehouse_goods_sku_id(Integer fk_warehouse_goods_sku_id) {
        this.fk_warehouse_goods_sku_id = fk_warehouse_goods_sku_id;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Long add_time) {
        this.add_time = add_time;
    }

    public Long getProduction_time() {
        return production_time;
    }

    public void setProduction_time(Long production_time) {
        this.production_time = production_time;
    }

    public Long getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Long expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Integer getCost_price() {
        return cost_price;
    }

    public void setCost_price(Integer cost_price) {
        this.cost_price = cost_price;
    }
}
