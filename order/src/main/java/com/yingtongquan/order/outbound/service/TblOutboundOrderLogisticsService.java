package com.yingtongquan.order.outbound.service;

import com.yingtongquan.order.outbound.entity.TblOutboundOrderLogisticsPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.order.outbound.pojo.OutboundOrderShippingAddress;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
public interface TblOutboundOrderLogisticsService extends IService<TblOutboundOrderLogisticsPo> {

    /**
     * @Date 2020/5/18 12:05
     * @Author 胖
     * 填写出库物流表
     **/
    Boolean fillInTheOutboundLogisticsForm(OutboundOrderShippingAddress outboundOrderShippingAddress);

}
