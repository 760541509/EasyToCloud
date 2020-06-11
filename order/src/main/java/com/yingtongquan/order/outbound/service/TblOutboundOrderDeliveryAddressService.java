package com.yingtongquan.order.outbound.service;

import com.yingtongquan.order.outbound.entity.TblOutboundOrderDeliveryAddressPo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
public interface TblOutboundOrderDeliveryAddressService extends IService<TblOutboundOrderDeliveryAddressPo> {

    /**
     * @Date 2020/5/18 10:00
     * @Author 胖
     *添加收货地址
     **/
    void addOutboundOrderShippingAddress(String outboundOrderNo);

}
