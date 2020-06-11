package com.yingtongquan.employees.goods.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yingtongquan.startcommon.pojo.CommonGetListPa;
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

@TableName("tbl_goods_spu_unit")
public class TblGoodsSpuUnitPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一标识",hidden = true )
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品spu的id")
    private Integer fkGoodsSpuId;

    @ApiModelProperty(value = "单位名称")
    private String name;

    @ApiModelProperty(value = "上级单位id")
    private Integer supId;

    @ApiModelProperty(value = "对应上级单位的数量")
    private Integer amount;

    @ApiModelProperty(value = "推荐售卖的价格")
    private Integer price;

    public Integer getId() {
    return id;
    }
    public void setId(Integer id) {
    this.id = id;
    }
    public Integer getFkGoodsSpuId() {
    return fkGoodsSpuId;
    }
    public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
    this.fkGoodsSpuId = fkGoodsSpuId;
    }
    public String getName() {
    return name;
    }
    public void setName(String name) {
    this.name = name;
    }
    public Integer getSupId() {
    return supId;
    }
    public void setSupId(Integer supId) {
    this.supId = supId;
    }
    public Integer getAmount() {
    return amount;
    }
    public void setAmount(Integer amount) {
    this.amount = amount;
    }
    public Integer getPrice() {
    return price;
    }
    public void setPrice(Integer price) {
    this.price = price;
    }



    /**
    * 添加的参数
    */
    @ApiModel(value="TblGoodsSpuUnitPoAddPa对象", description="添加的参数")
    public static class TblGoodsSpuUnitPoAddPa implements Serializable {
        @ApiModelProperty(value = "唯一标识",hidden = true )
        private Integer id;

        @ApiModelProperty(value = "商品spu的id",hidden = true )
        private Integer fkGoodsSpuId;

        @ApiModelProperty(value = "单位名称")
        private String name;

        @ApiModelProperty(value = "上级单位id")
        private Integer supId;

        @ApiModelProperty(value = "对应上级单位的数量")
        private Integer amount;

        @ApiModelProperty(value = "推荐售卖的价格")
        private Integer price;

        public Integer getId() {
        return id;
        }
        public void setId(Integer id) {
        this.id = id;
        }
        public Integer getFkGoodsSpuId() {
        return fkGoodsSpuId;
        }
        public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
        this.fkGoodsSpuId = fkGoodsSpuId;
        }
        public String getName() {
        return name;
        }
        public void setName(String name) {
        this.name = name;
        }
        public Integer getSupId() {
        return supId;
        }
        public void setSupId(Integer supId) {
        this.supId = supId;
        }
        public Integer getAmount() {
        return amount;
        }
        public void setAmount(Integer amount) {
        this.amount = amount;
        }
        public Integer getPrice() {
        return price;
        }
        public void setPrice(Integer price) {
        this.price = price;
        }

    }


    /**
    * 修改的参数
    */
    @ApiModel(value="TblGoodsSpuUnitPoUpPa对象", description="修改的参数")
    public static class TblGoodsSpuUnitPoUpPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;
        @ApiModelProperty(value = "商品spu的id")
        private Integer fkGoodsSpuId;
        @ApiModelProperty(value = "单位名称")
        private String name;
        @ApiModelProperty(value = "上级单位id")
        private Integer supId;
        @ApiModelProperty(value = "对应上级单位的数量")
        private Integer amount;
        @ApiModelProperty(value = "推荐售卖的价格")
        private Integer price;

        public Integer getId() {
        return id;
        }
        public void setId(Integer id) {
        this.id = id;
        }

        public Integer getFkGoodsSpuId() {
        return fkGoodsSpuId;
        }
        public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
        this.fkGoodsSpuId = fkGoodsSpuId;
        }

        public String getName() {
        return name;
        }
        public void setName(String name) {
        this.name = name;
        }

        public Integer getSupId() {
        return supId;
        }
        public void setSupId(Integer supId) {
        this.supId = supId;
        }

        public Integer getAmount() {
        return amount;
        }
        public void setAmount(Integer amount) {
        this.amount = amount;
        }

        public Integer getPrice() {
        return price;
        }
        public void setPrice(Integer price) {
        this.price = price;
        }

    }

    /**
    * 删除的参数
    */
    @ApiModel(value="TblGoodsSpuUnitPoDelPa对象", description="删除的参数")
    public static class TblGoodsSpuUnitPoDelPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;

        public Integer getId() {
        return id;
        }
        public void setId(Integer id) {
        this.id = id;
        }
    }

    /**
    * 查询单个的参数
    */
    @ApiModel(value="TblGoodsSpuUnitPoGetPa对象", description="查询单个的参数")
    public static class TblGoodsSpuUnitPoGetPa implements Serializable {
        @ApiModelProperty(value = "唯一标识")
        private Integer id;

        public Integer getId() {
        return id;
        }
        public void setId(Integer id) {
        this.id = id;
        }
    }


    /**
    * 查询集合的参数
    */
    @ApiModel(value="TblGoodsSpuUnitPoGetListPa对象", description="查询集合的参数")
    public static class TblGoodsSpuUnitPoGetListPa extends CommonGetListPa  implements Serializable {
        @ApiModelProperty(value = "商品spu的id")
        private Integer fkGoodsSpuId;

        public Integer getFkGoodsSpuId() {
            return fkGoodsSpuId;
        }

        public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
            this.fkGoodsSpuId = fkGoodsSpuId;
        }
    }



}


