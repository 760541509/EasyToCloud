package com.yingtongquan.customer.user.pojo;

import java.io.Serializable;

public class Infromation implements Serializable {

    private Integer userId;

    private Integer addressId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Infromation{" +
                "userId=" + userId +
                ", addressId=" + addressId +
                '}';
    }
}
