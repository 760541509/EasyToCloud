package com.yingtongquan.system.user.pojo;

import java.io.Serializable;

public class SystemConfig implements Serializable {

    /**
     * @Date 2020/6/3 15:11
     * @Author 胖
     * 转盘的区域有多少个
     **/
    private Integer rotaryTable;

    /**
     * @Date 2020/6/3 15:43
     * @Author 胖
     * 店铺ID
     **/
    private Integer shopId;

    public Integer getRotaryTable() {
        return rotaryTable;
    }

    public void setRotaryTable(Integer rotaryTable) {
        this.rotaryTable = rotaryTable;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "SystemConfig{" +
                "rotaryTable=" + rotaryTable +
                ", shopId=" + shopId +
                '}';
    }
}
