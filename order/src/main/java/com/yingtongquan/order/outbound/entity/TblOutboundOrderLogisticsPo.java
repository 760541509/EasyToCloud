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
@TableName("tbl_outbound_order_logistics")
@ApiModel(value="TblOutboundOrderLogisticsPo对象", description="")
public class TblOutboundOrderLogisticsPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "出库单的id")
    private Integer outboundOrderId;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty(value = "物流公司名称")
    private String name;

    @ApiModelProperty(value = "物流单号")
    private String logisticsNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getOutboundOrderId() {
        return outboundOrderId;
    }

    public void setOutboundOrderId(Integer outboundOrderId) {
        this.outboundOrderId = outboundOrderId;
    }
    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }

    @Override
    public String toString() {
        return "TblOutboundOrderLogisticsPo{" +
        "id=" + id +
        ", outboundOrderId=" + outboundOrderId +
        ", addTime=" + addTime +
        ", name=" + name +
        ", logisticsNo=" + logisticsNo +
        "}";
    }
}
