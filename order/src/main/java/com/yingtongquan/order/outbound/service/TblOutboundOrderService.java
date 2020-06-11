package com.yingtongquan.order.outbound.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.order.order.entity.TblOrderPo;
import com.yingtongquan.order.outbound.entity.TblOutboundOrderPo;
import com.yingtongquan.order.outbound.pojo.OutboundOrderGoods;
import com.yingtongquan.order.outbound.pojo.OutboundOrderInformation;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
public interface TblOutboundOrderService extends IService<TblOutboundOrderPo> {

    /**
     * @Date 2020/5/17 15:29
     * @Author 胖
     * 查询有哪些订单需要出库
     **/
    List<TblOrderPo> inquireWhichOrdersNeedToBeShippedOut(Integer shopId,Integer goodsCount);

    /**
     * @Date 2020/5/17 16:11
     * @Author 胖
     * 选择订单出库
     **/
    Boolean selectOrderOutbound(String orderNo, List<OutboundOrderGoods> outboundOrderGoods);

    /**
     * @Date 2020/5/17 17:35
     * @Author 胖
     *填写出库订单的收货地址
     **/
    Boolean fillInTheShippingAddress(String outboundOrderNo);

    /**
     * @Date 2020/5/19 9:32
     * @Author 胖
     * 查询出库单信息
     **/
    OutboundOrderInformation queryTheoutboundinformation(String orderNo);

    /**
     * @Date 2020/5/19 10:04
     * @Author 胖
     *查询某个用户所有出库单的信息
     **/
    List<OutboundOrderInformation> viewAllOfTheUserOrders();

}
