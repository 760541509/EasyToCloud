package com.yingtongquan.checkstand.pojo;

public class GoodsSpuUnit {

    private Integer id;

    //商品spu的id
    private Integer fkGoodsSpuId;

    //单位名称
    private String name;

    //上级单位id
    private Integer supId;

    //对应上级单位的数量
    private Integer amount;

    //推荐售卖的价格
    private Integer price;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
