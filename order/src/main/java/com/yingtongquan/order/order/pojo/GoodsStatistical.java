package com.yingtongquan.order.order.pojo;

import java.io.Serializable;

public class GoodsStatistical implements Serializable {

    //商品的数量
    int goodsNumber = 0;
    //实际付款金额
    int goodsMoney = 0;
    //商品的总金额
    int goodsTotalAmount = 0;

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public int getGoodsMoney() {
        return goodsMoney;
    }

    public void setGoodsMoney(int goodsMoney) {
        this.goodsMoney = goodsMoney;
    }

    public int getGoodsTotalAmount() {
        return goodsTotalAmount;
    }

    public void setGoodsTotalAmount(int goodsTotalAmount) {
        this.goodsTotalAmount = goodsTotalAmount;
    }

    @Override
    public String toString() {
        return "GoodsStatistical{" +
                "goodsNumber=" + goodsNumber +
                ", goodsMoney=" + goodsMoney +
                ", goodsTotalAmount=" + goodsTotalAmount +
                '}';
    }
}
