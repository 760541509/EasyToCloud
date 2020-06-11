package com.yingtongquan.employees.goods.pojo;

    import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* <p>
    * 
    * </p>
*
* @author ML
* @since 2020-05-30
*/

@TableName("tbl_goods_price")
public class GoodsPricePoCallClient implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "最高价")
    private Integer highestPrice;

    @ApiModelProperty(value = "最低价")
    private Integer lowestPrice;

    @ApiModelProperty(value = "会员价格名称")
    private String priceName;


    public Integer getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(Integer highestPrice) {
        this.highestPrice = highestPrice;
    }

    public Integer getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Integer lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }
}


