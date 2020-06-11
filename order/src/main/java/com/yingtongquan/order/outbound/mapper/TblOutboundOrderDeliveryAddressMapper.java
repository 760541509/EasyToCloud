package com.yingtongquan.order.outbound.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.order.outbound.entity.TblOutboundOrderDeliveryAddressPo;
import com.yingtongquan.order.outbound.entity.TblOutboundOrderPo;
import com.yingtongquan.order.outbound.pojo.OutboundOrderAddress;
import com.yingtongquan.order.outbound.pojo.ShopMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author Pang
* @since 2020-05-12
*/
@Mapper
@Repository
public interface TblOutboundOrderDeliveryAddressMapper extends BaseMapper<TblOutboundOrderDeliveryAddressPo> {

    /**
     * @Date 2020/5/17 17:19
     * @Author 胖
     * 根据出库单号查询相对应的信息
     **/
    TblOutboundOrderPo queryOutboundOrderInformation(String outboundOrderNo);

    /**
     * @Date 2020/5/17 17:41
     * @Author 胖
     *查询订单号中的收货地址
     **/
    OutboundOrderAddress queryOutboundOrderShippingAddress(String orderNo);

    /**
     * @Date 2020/5/18 11:22
     * @Author 胖
     *查询门店会员编号
     **/
    ShopMember queryShopMemberInformation(Integer userId,Integer shopId);

    /**
     * @Date 2020/5/18 11:43
     * @Author 胖
     *添加订单收货地址
     **/
    void addOutboundOrderAddress(TblOutboundOrderDeliveryAddressPo outboundOrderDeliveryAddressPo);



}
