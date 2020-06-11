package com.yingtongquan.order.order.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserLotteryNumber implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "抽奖次数")
    private Integer lotteryNumberl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLotteryNumberl() {
        return lotteryNumberl;
    }

    public void setLotteryNumberl(Integer lotteryNumberl) {
        this.lotteryNumberl = lotteryNumberl;
    }

    @Override
    public String toString() {
        return "UserLotteryNumber{" +
                "id=" + id +
                ", userId=" + userId +
                ", lotteryNumberl=" + lotteryNumberl +
                '}';
    }
}
