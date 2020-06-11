package com.yingtongquan.checkstand.pojo;

import java.io.Serializable;

public class OrderGoodsQuantity implements Serializable {

    private Integer id;

    //仓库商品id
    private Integer fkWarehouseGoodsSpuId;

    //门店商品id
    private Integer fkShopGoodsSpuId;

    //（0 不启用，1启用）0：不查询这个仓库下该商品的信息
    private Integer state;

    //仓库区域id
    private Integer fkGoodsWarehouseAreaId;

    //共用商品的id
    private Integer fkGoodsSpuId;

    //仓库的id
    private Integer fkWarehouseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkWarehouseGoodsSpuId() {
        return fkWarehouseGoodsSpuId;
    }

    public void setFkWarehouseGoodsSpuId(Integer fkWarehouseGoodsSpuId) {
        this.fkWarehouseGoodsSpuId = fkWarehouseGoodsSpuId;
    }

    public Integer getFkShopGoodsSpuId() {
        return fkShopGoodsSpuId;
    }

    public void setFkShopGoodsSpuId(Integer fkShopGoodsSpuId) {
        this.fkShopGoodsSpuId = fkShopGoodsSpuId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getFkGoodsWarehouseAreaId() {
        return fkGoodsWarehouseAreaId;
    }

    public void setFkGoodsWarehouseAreaId(Integer fkGoodsWarehouseAreaId) {
        this.fkGoodsWarehouseAreaId = fkGoodsWarehouseAreaId;
    }

    public Integer getFkGoodsSpuId() {
        return fkGoodsSpuId;
    }

    public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
        this.fkGoodsSpuId = fkGoodsSpuId;
    }

    public Integer getFkWarehouseId() {
        return fkWarehouseId;
    }

    public void setFkWarehouseId(Integer fkWarehouseId) {
        this.fkWarehouseId = fkWarehouseId;
    }
}
