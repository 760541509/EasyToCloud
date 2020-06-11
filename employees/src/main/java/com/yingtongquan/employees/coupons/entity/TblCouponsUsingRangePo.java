package com.yingtongquan.employees.coupons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ML
 * @since 2020-06-05
 */
@TableName("tbl_coupons_using_range")
@ApiModel(value="TblCouponsUsingRangePo对象", description="")
public class TblCouponsUsingRangePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "所有商品")
    private Integer shopAllGoods;

    @ApiModelProperty(value = "某商品")
    private String specifyTheCommodity;

    @ApiModelProperty(value = "某品类")
    private String certainCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getShopAllGoods() {
        return shopAllGoods;
    }

    public void setShopAllGoods(Integer shopAllGoods) {
        this.shopAllGoods = shopAllGoods;
    }
    public String getSpecifyTheCommodity() {
        return specifyTheCommodity;
    }

    public void setSpecifyTheCommodity(String specifyTheCommodity) {
        this.specifyTheCommodity = specifyTheCommodity;
    }
    public String getCertainCategory() {
        return certainCategory;
    }

    public void setCertainCategory(String certainCategory) {
        this.certainCategory = certainCategory;
    }

    @Override
    public String toString() {
        return "TblCouponsUsingRangePo{" +
        "id=" + id +
        ", shopAllGoods=" + shopAllGoods +
        ", specifyTheCommodity=" + specifyTheCommodity +
        ", certainCategory=" + certainCategory +
        "}";
    }
}
