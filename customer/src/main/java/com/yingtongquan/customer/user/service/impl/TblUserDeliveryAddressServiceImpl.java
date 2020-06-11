package com.yingtongquan.customer.user.service.impl;

import com.yingtongquan.customer.user.entity.TblUserDeliveryAddressPo;
import com.yingtongquan.customer.user.mapper.TblUserDeliveryAddressMapper;
import com.yingtongquan.customer.user.service.TblUserDeliveryAddressService;
import com.yingtongquan.startcommon.address.pojo.Address;
import com.yingtongquan.startcommon.address.pojo.Coordinate;
import com.yingtongquan.startcommon.util.AddressUtil;
import com.yingtongquan.startcommon.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class TblUserDeliveryAddressServiceImpl implements TblUserDeliveryAddressService {
    @Resource
    private TblUserDeliveryAddressMapper userDeliveryAddressMapper;

    @Autowired
    public HttpServletRequest request;

    @Override
    public Boolean addUserShippingAddress(TblUserDeliveryAddressPo userDeliveryAddressPo) {
        Integer curUserId = HttpUtil.getCurUserId(request.getHeader("token"));
        //逆向查询省市区（县）
        Address address = userDeliveryAddressMapper.queryCityAndProvincial(userDeliveryAddressPo.getAreaId());
        //详细地址（省市区（县）详细地址）
        String UserAddress = address.getProvince()+address.getCity()+address.getCity()+userDeliveryAddressPo.getAddress();
        Coordinate coordinate = AddressUtil.coordinate(UserAddress);
        userDeliveryAddressPo.setLatitude(coordinate.getLatitude());
        userDeliveryAddressPo.setLongitude(coordinate.getLongitude());
        userDeliveryAddressPo.setUserId(curUserId);
        return userDeliveryAddressMapper.addUserShippingAddress(userDeliveryAddressPo);
    }

    @Override
    public Boolean updateUserShippingAddress(TblUserDeliveryAddressPo userDeliveryAddressPo) {
        return userDeliveryAddressMapper.updateUserShippingAddress(userDeliveryAddressPo);
    }

    @Override
    public List<TblUserDeliveryAddressPo> queryAllUserShippingAddress(Integer userId) {
        return userDeliveryAddressMapper.queryAllUserShippingAddress(userId);
    }

    @Override
    public Boolean rmUserShippingAddress(Integer addressId) {
        return userDeliveryAddressMapper.rmUserShippingAddress(addressId);
    }
}
