package com.yingtongquan.order.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.order.order.entity.TblOrderPo;
import com.yingtongquan.order.order.pojo.OrderDeal;
import com.yingtongquan.order.order.pojo.OrderGoodsInformation;
import com.yingtongquan.order.order.pojo.OrderInformation;
import com.yingtongquan.order.order.pojo.UserOrderAndMemberInformation;
import com.yingtongquan.startcommon.base.ResultVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
public interface TblOrderService extends IService<TblOrderPo> {

    /**
     * @Date 2020/5/12 11:46
     * @Author 胖虎
     * 生成订单
     **/
    ResultVo addOrderInformation(UserOrderAndMemberInformation orderAndMemberInformation);

    /**
     * @Date 2020/5/13 15:45
     * @Author 胖虎
     * 查询订单
     **/
    List<OrderInformation> queryUserAllOrderInformation();

    /**
     * @Date 2020/5/14 11:06
     * @Author 胖虎
     * 查询某一个订单的详细
     **/
    OrderInformation queryOrderInformation(String orderNo);

    /**
     * @Date 2020/5/14 12:02
     * @Author 胖虎
     * 修改订单商品信息
     **/
    Boolean updateOrderGoodsInformation(List<OrderGoodsInformation> orderGoodsInformation,String orderNo);

    /**
     * @Date 2020/6/9 14:42
     * @Author 胖
     * 填写支付方式
     **/
    Boolean updateOrderStatus(OrderDeal orderDeal);
}
