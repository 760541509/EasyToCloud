package com.yingtongquan.order.outbound.entity;

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
 * @author Pang
 * @since 2020-05-12
 */
@TableName("tbl_outbound_order_goods")
@ApiModel(value="TblOutboundOrderGoodsPo对象", description="")
public class TblOutboundOrderGoodsPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单商品id")
    private Integer orderGoodsId;

    @ApiModelProperty(value = "出库的数量（需大于0并且小于或等于购买数量）")
    private Integer amount;

    @ApiModelProperty(value = "出库单id")
    private Integer outboundOrderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Integer getOutboundOrderId() {
        return outboundOrderId;
    }

    public void setOutboundOrderId(Integer outboundOrderId) {
        this.outboundOrderId = outboundOrderId;
    }

    @Override
    public String toString() {
        return "TblOutboundOrderGoodsPo{" +
        "id=" + id +
        ", orderGoodsId=" + orderGoodsId +
        ", amount=" + amount +
        ", outboundOrderId=" + outboundOrderId +
        "}";
    }
}
