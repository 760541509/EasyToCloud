package com.yingtongquan.order.outbound.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.order.outbound.entity.TblOutboundOrderLogisticsPo;
import com.yingtongquan.order.outbound.entity.TblOutboundOrderPo;
import com.yingtongquan.order.outbound.mapper.TblOutboundOrderLogisticsMapper;
import com.yingtongquan.order.outbound.pojo.OutboundOrderShippingAddress;
import com.yingtongquan.order.outbound.service.TblOutboundOrderLogisticsService;
import com.yingtongquan.order.outbound.service.TblOutboundOrderStaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 *
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
@Service
public class TblOutboundOrderLogisticsServiceImpl extends ServiceImpl<TblOutboundOrderLogisticsMapper, TblOutboundOrderLogisticsPo> implements TblOutboundOrderLogisticsService {

    @Resource
    private TblOutboundOrderLogisticsMapper outboundOrderLogisticsMapper;
    @Resource
    private TblOutboundOrderStaffService outboundOrderStaffService;

    @Override
    public Boolean fillInTheOutboundLogisticsForm(OutboundOrderShippingAddress outboundOrderShippingAddress) {
        //查询出库单信息
        TblOutboundOrderPo outboundOrderPo = outboundOrderLogisticsMapper.queryOutboundOrderInformation(outboundOrderShippingAddress.getOrderNo());
        //录入出库单物流信息
        TblOutboundOrderLogisticsPo outboundOrderLogisticsPo = new TblOutboundOrderLogisticsPo();
        outboundOrderLogisticsPo.setAddTime(System.currentTimeMillis());
        outboundOrderLogisticsPo.setLogisticsNo(outboundOrderShippingAddress.getLogisticsNo());
        outboundOrderLogisticsPo.setName(outboundOrderShippingAddress.getLogisticsName());
        outboundOrderLogisticsPo.setOutboundOrderId(outboundOrderPo.getId());
        //员工出库单录入
        outboundOrderStaffService.addOutboundOrderStaff(outboundOrderPo.getId());
        return outboundOrderLogisticsMapper.addOutboundOrderShippingAddress(outboundOrderLogisticsPo);
    }
}
