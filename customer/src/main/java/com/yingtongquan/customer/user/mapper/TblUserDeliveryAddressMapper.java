package com.yingtongquan.customer.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.customer.user.entity.TblUserDeliveryAddressPo;
import com.yingtongquan.startcommon.address.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Pang
 * @since 2020-05-11
 */
@Mapper
@Repository
public interface TblUserDeliveryAddressMapper extends BaseMapper<TblUserDeliveryAddressPo> {

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

    /**
     * @Date 2020/5/11 11:57
     * @Author 胖虎
     * 逆向查询市和省
     **/
    Address queryCityAndProvincial(Integer areaId);

}
