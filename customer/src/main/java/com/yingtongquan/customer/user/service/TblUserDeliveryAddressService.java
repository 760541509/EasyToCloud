package com.yingtongquan.customer.user.service;

import com.yingtongquan.customer.user.entity.TblUserDeliveryAddressPo;

import java.util.List;

public interface TblUserDeliveryAddressService {

    /**
     * @Date 2020/5/11 11:18
     * @Author 胖虎
     * 添加用户收货地址
     **/
    Boolean addUserShippingAddress(TblUserDeliveryAddressPo userDeliveryAddressPo);

    /**
     * @Date 2020/5/11 11:21
     * @Author 胖虎
     * 修改用户收货地址
     **/
    Boolean updateUserShippingAddress(TblUserDeliveryAddressPo userDeliveryAddressPo);

    /**
     * @Date 2020/5/11 11:24
     * @Author 胖虎
     * 查询用户所有的收货地址
     **/
    List<TblUserDeliveryAddressPo> queryAllUserShippingAddress(Integer userId);

    /**
     * @Date 2020/5/11 11:32
     * @Author 胖虎
     * 删除用户收货地址
     **/
    Boolean rmUserShippingAddress(Integer addressId);
}
