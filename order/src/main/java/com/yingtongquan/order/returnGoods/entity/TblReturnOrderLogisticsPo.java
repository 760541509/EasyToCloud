package com.yingtongquan.order.returnGoods.entity;

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
@TableName("tbl_return_order_logistics")
@ApiModel(value = "TblReturnOrderLogisticsPo对象", description = "")
public class TblReturnOrderLogisticsPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "退货单号")
    private String returnOrderNo;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty(value = "物流公司名称")
    private String name;

    @ApiModelProperty(value = "物流单号")
    private String logisticsNo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReturnOrderNo() {
        return returnOrderNo;
    }

    public void setReturnOrderNo(String returnOrderNo) {
        this.returnOrderNo = returnOrderNo;
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
        return "TblReturnOrderLogisticsPo{" +
                "id=" + id +
                ", returnOrderNo='" + returnOrderNo + '\'' +
                ", addTime=" + addTime +
                ", name='" + name + '\'' +
                ", logisticsNo='" + logisticsNo + '\'' +
                '}';
    }
}
