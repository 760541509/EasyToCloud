package com.yingtongquan.order.outbound.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OutInformation implements Serializable {

    public static class OutInformationQuery implements Serializable {

        @ApiModelProperty(value = "店铺ID")
        private Integer shopId;

        @ApiModelProperty(value = "货物总数量")
        private Integer goodsCount;

        public Integer getShopId() {
            return shopId;
        }

        public void setShopId(Integer shopId) {
            this.shopId = shopId;
        }

        public Integer getGoodsCount() {
            return goodsCount;
        }

        public void setGoodsCount(Integer goodsCount) {
            this.goodsCount = goodsCount;
        }

        @Override
        public String toString() {
            return "OutInformationQuery{" +
                    "shopId=" + shopId +
                    ", goodsCount=" + goodsCount +
                    '}';
        }
    }

    public static class OutInformationOutOrder implements Serializable {

        @ApiModelProperty(value = "出库单号")
        private String outboundOrderNo;

        public String getOutboundOrderNo() {
            return outboundOrderNo;
        }

        public void setOutboundOrderNo(String outboundOrderNo) {
            this.outboundOrderNo = outboundOrderNo;
        }

        @Override
        public String toString() {
            return "OutInformationOutOrder{" +
                    "outboundOrderNo='" + outboundOrderNo + '\'' +
                    '}';
        }
    }

    public static class OutInformationOrder implements Serializable {

        private String orderNo;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public String toString() {
            return "OutInformationOrder{" +
                    "orderNo='" + orderNo + '\'' +
                    '}';
        }
    }
}
