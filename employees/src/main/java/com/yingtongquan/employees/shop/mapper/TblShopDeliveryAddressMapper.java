package com.yingtongquan.employees.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.shop.entity.TblShopDeliveryAddressPo;
import com.yingtongquan.employees.shop.pojo.ShopShippingAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-05-21
*/
@Mapper
@Repository
public interface TblShopDeliveryAddressMapper extends BaseMapper<TblShopDeliveryAddressPo> {

    /**
     * @Date 2020/5/22 14:49
     * @Author 胖
     * 查询店铺下所有的收货地址
     **/
    List<ShopShippingAddress> queryShopAllShippingAddress(Integer shopId);

    /**
     * @Date 2020/5/22 16:55
     * @Author 胖
     * 添加收货地址
     **/
    Boolean addShopShippingAddress(TblShopDeliveryAddressPo shopDeliveryAddressPo);

    /**
     * @Date 2020/5/22 17:01
     * @Author 胖
     * 查询某一个地址
     **/
    ShopShippingAddress queryShopShippingAddress(Integer id);

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
    Boolean deleteTheOriginalDefaultAddress(Integer shopId);
    Boolean setTheAddressToTheDefaultShippingAddress(Integer id, Integer shopId);
}
