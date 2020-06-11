package com.yingtongquan.order.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.order.order.entity.TblOrderGoodsPo;
import com.yingtongquan.order.order.pojo.GoodsInfromation;
import com.yingtongquan.order.order.pojo.OrderGoods;
import com.yingtongquan.order.order.pojo.OrderGoodsInformation;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
public interface TblOrderGoodsService extends IService<TblOrderGoodsPo> {

    /**
     * @Date 2020/5/13 15:24
     * @Author 胖虎
     * 添加订单商品信息
     **/
    void addOrderGoodsInformation(OrderGoodsInformation orderGoodsInformation, Integer curUserId,String orderNumber,Integer shopId);

    /**
     * @Date 2020/5/12 16:39
     * @Author 胖虎
     * 通过商品编号查询订单中商品的名字其他信息
     **/
    GoodsInfromation queryGoodsInformation(Integer goodsId);

    /**
     * @Date 2020/5/14 14:12
     * @Author 胖虎
     * 删除某个订单中的商品信息
     **/
    Boolean reOrderGoods(Integer orderId);

    /**
     * @Date 2020/6/2 16:26
     * @Author 胖
     * 添加订单商品信息（散户专用）
     **/
    void addIndividualTravelerOrderGoodsInformation(OrderGoods orderGood, String orderNumber, Integer shopId, Integer memberPriceId, Integer memberId);

}
