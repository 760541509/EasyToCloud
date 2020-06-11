package com.yingtongquan.system.user.pojo;

import java.io.Serializable;

public class Product implements Serializable {

    private Integer id;

    private String goodsName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }
}
