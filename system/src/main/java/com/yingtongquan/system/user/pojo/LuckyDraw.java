package com.yingtongquan.system.user.pojo;

import java.io.Serializable;

public class LuckyDraw implements Serializable {

    private Integer id;

    /**
     * @Date 2020/6/3 11:20
     * @Author 胖
     * 优惠卷ID
     **/
    private Integer couponId;

    /**
     * @Date 2020/6/3 11:20
     * @Author 胖
     * 中奖率
     **/
    private Double chance;

    /**
     * @Date 2020/6/3 16:06
     * @Author 胖
     * 抽奖中的商品ID
     **/
    private Integer productId;

    public LuckyDraw() {}

    public LuckyDraw(Integer id, Integer couponId, Double chance, Integer productId) {
        this.id = id;
        this.couponId = couponId;
        this.chance = chance;
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Double getChance() {
        return chance;
    }

    public void setChance(Double chance) {
        this.chance = chance;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "LuckyDraw{" +
                "id=" + id +
                ", couponId=" + couponId +
                ", chance=" + chance +
                ", productId=" + productId +
                '}';
    }
}
