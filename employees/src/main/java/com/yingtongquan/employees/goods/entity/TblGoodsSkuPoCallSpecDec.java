package com.yingtongquan.employees.goods.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* <p>
    * 
    * </p>
*
* @author ML
* @since 2020-05-29
*/

@ApiModel(value="sku规格描述", description="sku规格描述")
public class TblGoodsSkuPoCallSpecDec implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一标识")
    private Integer fkGoodsSkuId;
    @ApiModelProperty(value = "规格的名称描述")
    private String specName;
    @ApiModelProperty(value = "规格的值描述")
    private String specValue;


    public Integer getFkGoodsSkuId() {
        return fkGoodsSkuId;
    }

    public void setFkGoodsSkuId(Integer fkGoodsSkuId) {
        this.fkGoodsSkuId = fkGoodsSkuId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue;
    }
}


