package com.yingtongquan.employees.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.shop.entity.TblShopDeliveryAddressPo;
import com.yingtongquan.employees.shop.mapper.TblShopDeliveryAddressMapper;
import com.yingtongquan.employees.shop.mapper.TblShopMapper;
import com.yingtongquan.employees.shop.pojo.ShopShippingAddress;
import com.yingtongquan.employees.shop.service.TblShopDeliveryAddressService;
import com.yingtongquan.startcommon.address.pojo.Address;
import com.yingtongquan.startcommon.address.pojo.Coordinate;
import com.yingtongquan.startcommon.util.AddressUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@Service
public class TblShopDeliveryAddressServiceImpl extends ServiceImpl<TblShopDeliveryAddressMapper, TblShopDeliveryAddressPo> implements TblShopDeliveryAddressService {

    @Resource
    private TblShopMapper shopMapper;
    @Resource
    private TblShopDeliveryAddressMapper shopDeliveryAddressMapper;

    @Override
    public List<ShopShippingAddress> queryShopAllShippingAddress(Integer shopId) {
        return shopDeliveryAddressMapper.queryShopAllShippingAddress(shopId);
    }

    @Override
    public Boolean addShopShippingAddress(ShopShippingAddress shopShippingAddress) {
        Address address = shopMapper.queryCityAndProvincial(shopShippingAddress.getAreaId());
        String str = address.getProvince() + address.getCity() + address.getArea() + shopShippingAddress.getAddress();
        Coordinate coordinate = AddressUtil.coordinate(str);
        TblShopDeliveryAddressPo shopDeliveryAddressPo = new TblShopDeliveryAddressPo();
        shopDeliveryAddressPo.setAddress(shopShippingAddress.getAddress());
        shopDeliveryAddressPo.setAddTime(System.currentTimeMillis());
        shopDeliveryAddressPo.setAreaId(shopShippingAddress.getAreaId());
        shopDeliveryAddressPo.setIsDefault(shopShippingAddress.getIsDefault());
        shopDeliveryAddressPo.setLatitude(coordinate.getLatitude());
        shopDeliveryAddressPo.setLongitude(coordinate.getLongitude());
        shopDeliveryAddressPo.setName(shopShippingAddress.getName());
        shopDeliveryAddressPo.setPhone(shopShippingAddress.getPhone());
        shopDeliveryAddressPo.setShopId(shopShippingAddress.getShopId());
        return shopDeliveryAddressMapper.addShopShippingAddress(shopDeliveryAddressPo);
    }

    @Override
    public ShopShippingAddress queryAddress(Integer id) {
        return shopDeliveryAddressMapper.queryShopShippingAddress(id);
    }

    @Override
    public Boolean updateShopShippingAddress(ShopShippingAddress shopShippingAddress) {
        return shopDeliveryAddressMapper.updateShopShippingAddress(shopShippingAddress);
    }

    @Override
    public Boolean deleteShopShippingAddress(Integer id, Integer shopId) {
        return shopDeliveryAddressMapper.deleteShopShippingAddress(id, shopId);
    }

    @Override
    public Boolean setTheAddressToTheDefaultShippingAddress(Integer id, Integer shopId) {
        shopDeliveryAddressMapper.deleteTheOriginalDefaultAddress(shopId);
        return shopDeliveryAddressMapper.setTheAddressToTheDefaultShippingAddress(id, shopId);
    }
}
