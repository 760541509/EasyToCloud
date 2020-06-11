package com.yingtongquan.order.order.mapper;

import com.yingtongquan.order.order.entity.TblOrderDeliveryAddressPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.order.order.pojo.UserAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
@Mapper
@Repository
public interface TblOrderDeliveryAddressMapper extends BaseMapper<TblOrderDeliveryAddressPo> {

    /**
     * @Date 2020/5/13 9:34
     * @Author 胖虎
     * 查询用户收货地址
     **/
    UserAddress queryUserShippingAddress(Integer addressId);

    /**
     * @Date 2020/5/13 10:02
     * @Author 胖虎
     * 添加订单收货地址
     **/
    Boolean addUserShippingAddress(TblOrderDeliveryAddressPo orderDeliveryAddressPo);

    /**
     * @Date 2020/6/2 16:48
     * @Author 胖
     * 查询地址编号
     **/
    Integer queryAreaId(String province, String city, String area);

}
