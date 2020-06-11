package com.yingtongquan.order.order.service;

import com.yingtongquan.order.order.entity.TblOrderDeliveryAddressPo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
public interface TblOrderDeliveryAddressService extends IService<TblOrderDeliveryAddressPo> {

    /**
     * @Date 2020/5/13 15:37
     * @Author 胖虎
     * 添加订单收货地址
     **/
    Boolean addOrderShippingAddress(Integer addressId, String orderNumber, Integer curUserId, Integer shopId);

    /**
     * @Date 2020/6/2 16:57
     * @Author 胖
     * 添加订单收货地址（散客类型）
     **/
    Boolean addIndividualShippingAddress(Integer orderId,Integer addressId,Integer memberId);
}
