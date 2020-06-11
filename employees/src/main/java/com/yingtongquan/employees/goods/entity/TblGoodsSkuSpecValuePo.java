package com.yingtongquan.employees.goods.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.yingtongquan.startcommon.pojo.CommonGetListPa;

/**
* <p>
    * 
    * </p>
*
* @author ML
* @since 2020-05-30
*/

@TableName("tbl_goods_sku_spec_value")
public class TblGoodsSkuSpecValuePo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "商品sku的id")
    private Integer fkGoodsSkuId;

    @ApiModelProperty(value = "规格值的id")
    private Integer fkSpecValueId;

    public Integer getId() {
    return id;
    }
    public void setId(Integer id) {
    this.id = id;
    }
    public Integer getFkGoodsSkuId() {
    return fkGoodsSkuId;
    }
    public void setFkGoodsSkuId(Integer fkGoodsSkuId) {
    this.fkGoodsSkuId = fkGoodsSkuId;
    }
    public Integer getFkSpecValueId() {
    return fkSpecValueId;
    }
    public void setFkSpecValueId(Integer fkSpecValueId) {
    this.fkSpecValueId = fkSpecValueId;
    }



    /**
    * 添加的参数
    */
    @ApiModel(value="TblGoodsSkuSpecValuePoAddPa对象", description="添加的参数")
    public static class TblGoodsSkuSpecValuePoAddPa implements Serializable {
        private Integer id;

        @ApiModelProperty(value = "商品sku的id")
        private Integer fkGoodsSkuId;

        @ApiModelProperty(value = "规格值的id")
        private Integer fkSpecValueId;

        public Integer getId() {
        return id;
        }
        public void setId(Integer id) {
        this.id = id;
        }
        public Integer getFkGoodsSkuId() {
        return fkGoodsSkuId;
        }
        public void setFkGoodsSkuId(Integer fkGoodsSkuId) {
        this.fkGoodsSkuId = fkGoodsSkuId;
        }
        public Integer getFkSpecValueId() {
        return fkSpecValueId;
        }
        public void setFkSpecValueId(Integer fkSpecValueId) {
        this.fkSpecValueId = fkSpecValueId;
        }

    }


    /**
    * 修改的参数
    */
    @ApiModel(value="TblGoodsSkuSpecValuePoUpPa对象", description="修改的参数")
    public static class TblGoodsSkuSpecValuePoUpPa implements Serializable {
        private Integer id;
        @ApiModelProperty(value = "商品sku的id")
        private Integer fkGoodsSkuId;
        @ApiModelProperty(value = "规格值的id")
        private Integer fkSpecValueId;

        public Integer getId() {
        return id;
        }
        public void setId(Integer id) {
        this.id = id;
        }

        public Integer getFkGoodsSkuId() {
        return fkGoodsSkuId;
        }
        public void setFkGoodsSkuId(Integer fkGoodsSkuId) {
        this.fkGoodsSkuId = fkGoodsSkuId;
        }

        public Integer getFkSpecValueId() {
        return fkSpecValueId;
        }
        public void setFkSpecValueId(Integer fkSpecValueId) {
        this.fkSpecValueId = fkSpecValueId;
        }

    }

    /**
    * 删除的参数
    */
    @ApiModel(value="TblGoodsSkuSpecValuePoDelPa对象", description="删除的参数")
    public static class TblGoodsSkuSpecValuePoDelPa implements Serializable {

    }

    /**
    * 查询单个的参数
    */
    @ApiModel(value="TblGoodsSkuSpecValuePoGetPa对象", description="查询单个的参数")
    public static class TblGoodsSkuSpecValuePoGetPa implements Serializable {

    }


    /**
    * 查询集合的参数
    */
    @ApiModel(value="TblGoodsSkuSpecValuePoGetListPa对象", description="查询集合的参数")
    public static class TblGoodsSkuSpecValuePoGetListPa extends CommonGetListPa  implements Serializable {

    }



}


