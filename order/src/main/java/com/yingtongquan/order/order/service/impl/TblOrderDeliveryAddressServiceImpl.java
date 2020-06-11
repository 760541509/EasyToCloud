package com.yingtongquan.order.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.order.order.entity.TblOrderDeliveryAddressPo;
import com.yingtongquan.order.order.entity.TblOrderPo;
import com.yingtongquan.order.order.mapper.TblOrderDeliveryAddressMapper;
import com.yingtongquan.order.order.mapper.TblOrderMapper;
import com.yingtongquan.order.order.pojo.UserAddress;
import com.yingtongquan.order.order.service.TblOrderDeliveryAddressService;
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
public class TblOrderDeliveryAddressServiceImpl extends ServiceImpl<TblOrderDeliveryAddressMapper, TblOrderDeliveryAddressPo> implements TblOrderDeliveryAddressService {

    @Resource
    private TblOrderMapper orderMapper;
    @Resource
    private TblOrderDeliveryAddressMapper orderDeliveryAddressMapper;

    @Override
    public Boolean addOrderShippingAddress(Integer addressId, String orderNumber, Integer curUserId, Integer shopId) {
        //订单商品详细
        TblOrderPo orderInformation = orderMapper.queryOrderInformation(orderNumber);

        UserAddress userAddress = orderDeliveryAddressMapper.queryUserShippingAddress(addressId);
        TblOrderDeliveryAddressPo orderDeliveryAddressPo = new TblOrderDeliveryAddressPo();
        orderDeliveryAddressPo.setOrderId(orderInformation.getId());                                          //订单ID
        orderDeliveryAddressPo.setAddTime(System.currentTimeMillis());                                 //添加时间
        orderDeliveryAddressPo.setMemberShopId(orderMapper.queryShopMemberInfromation(curUserId, shopId).getId());    //门店会员ID
        orderDeliveryAddressPo.setPhone(userAddress.getPhone());                                              //收货人手机号
        orderDeliveryAddressPo.setName(userAddress.getMemberName());                                       //收货人名字
        orderDeliveryAddressPo.setAreaId(userAddress.getAreaId());                                            //收货人省市区ID
        orderDeliveryAddressPo.setAddress(userAddress.getAddress());                                          //收货人地址详情
        orderDeliveryAddressPo.setIsSince(0);
        return orderDeliveryAddressMapper.addUserShippingAddress(orderDeliveryAddressPo);
    }

    @Override
    public Boolean addIndividualShippingAddress(Integer orderId,Integer addressId,Integer memberId) {

        UserAddress userAddress = orderDeliveryAddressMapper.queryUserShippingAddress(addressId);

        TblOrderDeliveryAddressPo orderDeliveryAddressPo = new TblOrderDeliveryAddressPo();
        orderDeliveryAddressPo.setPhone(userAddress.getPhone());
        orderDeliveryAddressPo.setOrderId(orderId);
        orderDeliveryAddressPo.setName(userAddress.getMemberName());
        orderDeliveryAddressPo.setMemberShopId(memberId);
        orderDeliveryAddressPo.setIsSince(1);
        orderDeliveryAddressPo.setAreaId(userAddress.getAreaId());
        orderDeliveryAddressPo.setAddTime(System.currentTimeMillis());
        orderDeliveryAddressPo.setAddress(userAddress.getAddress());
        return orderDeliveryAddressMapper.addUserShippingAddress(orderDeliveryAddressPo);
    }
}
