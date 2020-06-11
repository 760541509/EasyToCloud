package com.yingtongquan.employees.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.shop.entity.TblShopDeliveryAddressPo;
import com.yingtongquan.employees.shop.pojo.ShopShippingAddress;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
public interface TblShopDeliveryAddressService extends IService<TblShopDeliveryAddressPo> {

    /**
     * @Date 2020/5/22 14:49
     * @Author 胖
     * 查询店铺下所有的收货地址
     **/
    List<ShopShippingAddress> queryShopAllShippingAddress(Integer shopId);

    /**
     * @Date 2020/5/22 16:18
     * @Author 胖
     * 添加店铺收货地址
     **/
    Boolean addShopShippingAddress(ShopShippingAddress shopShippingAddress);

    /**
     * @Date 2020/5/22 16:18
     * @Author 胖
     * 查询某个收货地址
     **/
    ShopShippingAddress queryAddress(Integer id);

    /**
     * @Date 2020/5/22 16:18
     * @Author 胖
     * 修改收货地址
     **/
    Boolean updateShopShippingAddress(ShopShippingAddress shopShippingAddress);

    /**
     * @Date 2020/5/22 16:34
     * @Author 胖
     * 删除收货地址
     **/
    Boolean deleteShopShippingAddress(Integer id, Integer shopId);

    /**
     * @Date 2020/5/22 17:07
     * @Author 胖
     * 设置某一个地址为默认收货地址
     **/
    Boolean setTheAddressToTheDefaultShippingAddress(Integer id, Integer shopId);
}
