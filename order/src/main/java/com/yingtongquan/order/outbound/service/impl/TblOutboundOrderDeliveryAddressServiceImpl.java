package com.yingtongquan.order.outbound.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.order.outbound.entity.TblOutboundOrderDeliveryAddressPo;
import com.yingtongquan.order.outbound.entity.TblOutboundOrderPo;
import com.yingtongquan.order.outbound.mapper.TblOutboundOrderDeliveryAddressMapper;
import com.yingtongquan.order.outbound.pojo.OutboundOrderAddress;
import com.yingtongquan.order.outbound.pojo.ShopMember;
import com.yingtongquan.order.outbound.service.TblOutboundOrderDeliveryAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
@Service
public class TblOutboundOrderDeliveryAddressServiceImpl extends ServiceImpl<TblOutboundOrderDeliveryAddressMapper, TblOutboundOrderDeliveryAddressPo> implements TblOutboundOrderDeliveryAddressService {

    @Resource
    private TblOutboundOrderDeliveryAddressMapper outboundOrderDeliveryAddressMapper;

    @Override
    public void addOutboundOrderShippingAddress(String outboundOrderNo) {
        //查询出库单详细
        TblOutboundOrderPo outboundOrderPo = outboundOrderDeliveryAddressMapper.queryOutboundOrderInformation(outboundOrderNo);
        //查询订单中的收货地址
        OutboundOrderAddress outboundOrderAddress = outboundOrderDeliveryAddressMapper.queryOutboundOrderShippingAddress(outboundOrderPo.getOrderNo());
        //通过订单中的userID查询门店会员编号
        ShopMember shopMember = outboundOrderDeliveryAddressMapper.queryShopMemberInformation(outboundOrderAddress.getUserId(), outboundOrderAddress.getShopId());

        TblOutboundOrderDeliveryAddressPo outboundOrderDeliveryAddressPo = new TblOutboundOrderDeliveryAddressPo();
        outboundOrderDeliveryAddressPo.setAddress(outboundOrderAddress.getAddress());
        outboundOrderDeliveryAddressPo.setAddTime(System.currentTimeMillis());
        outboundOrderDeliveryAddressPo.setAreaId(outboundOrderAddress.getAreaId());
        outboundOrderDeliveryAddressPo.setIsSince(1);
        outboundOrderDeliveryAddressPo.setMemberShopId(shopMember.getId());
        outboundOrderDeliveryAddressPo.setName(outboundOrderAddress.getName());
        outboundOrderDeliveryAddressPo.setOutboundOrderId(outboundOrderPo.getId());
        outboundOrderDeliveryAddressPo.setPhone(outboundOrderAddress.getPhone());
        outboundOrderDeliveryAddressMapper.addOutboundOrderAddress(outboundOrderDeliveryAddressPo);

    }
}
