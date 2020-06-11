package com.yingtongquan.startcommon.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value="共用的获取单条数据，参数对象", description="")
public class CommonGetPa implements Serializable {
    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字")
    private String keyword;

    /**
     * 门店id
     */
    @ApiModelProperty(value = "门店id")
    private Integer fkShopId;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id",hidden = true)
    private Integer fkUserId;



    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getFkShopId() {
        return fkShopId;
    }

    public void setFkShopId(Integer fkShopId) {
        this.fkShopId = fkShopId;
    }

    public Integer getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Integer fkUserId) {
        this.fkUserId = fkUserId;
    }
}
