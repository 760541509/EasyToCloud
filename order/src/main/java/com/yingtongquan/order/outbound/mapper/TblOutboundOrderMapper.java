package com.yingtongquan.order.outbound.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.order.order.entity.TblOrderPo;
import com.yingtongquan.order.outbound.entity.TblOutboundOrderPo;
import com.yingtongquan.order.outbound.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface TblOutboundOrderMapper extends BaseMapper<TblOutboundOrderPo> {

    /**
     * @Date 2020/5/17 15:35
     * @Author 胖
     * 查询有哪些订单是需要出库的
     **/
    List<TblOrderPo> queryShopAllOutgoingOrdersAreRequired(Integer shopId);

    /**
     * @Date 2020/5/17 16:14
     * @Author 胖
     * 修改订单状态和出库单状态
     **/
    Boolean modifyOrderStatus(String orderNo);

    Boolean modifyTheOutboundSingleState(String orderNo);

    /**
     * @Date 2020/5/17 16:28
     * @Author 胖
     * 添加出库单单表
     **/
    Boolean addOutboundOrder(TblOutboundOrderPo outboundOrderPo);

    /**
     * @Date 2020/5/17 17:19
     * @Author 胖
     * 根据出库单号查询相对应的信息
     **/
    TblOutboundOrderPo queryOutboundOrderInformation(String outboundOrderNo);

    /**
     * @Date 2020/5/17 17:41
     * @Author 胖
     * 查询订单号中的收货地址
     **/
    OutboundOrderAddress queryOutboundOrderShippingAddress(String orderNo);

    /**
     * @Date 2020/5/17 17:58
     * @Author 胖
     * 根据地址编号查询省市区（县）
     **/
    Address queryByAreaCode(Integer addressId);

    /**
     * @Date 2020/5/19 9:47
     * @Author 胖
     * 查询出库单详细
     **/
    OutboundOrderInformation queryTheOutboundInformation(String orderNo);

    /**
     * @Date 2020/5/19 9:51
     * @Author 胖
     * 查询出库单中的商品信息
     **/
    List<OutboundOrderGoods> queryTheCommodityInformationInTheOutboundList(Integer outboundOrderId);

    /**
     * @Date 2020/5/19 10:10
     * @Author 胖
     * 查询用户有哪些订单
     **/
    List<TblOrderPo> queryUserAllOrder(Integer userId);

    /**
     * @Date 2020/5/19 10:18
     * @Author 胖
     *通过微信用户ID查询在用户表自动生成的用户ID
     **/
    UserInformation queryWithWeChatUserID(Integer WXUserId);

}
