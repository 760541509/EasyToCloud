package com.yingtongquan.order.order.pojo;

import java.io.Serializable;

public class Infromation implements Serializable {

    private String order;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Infromation{" +
                "order='" + order + '\'' +
                '}';
    }
}
