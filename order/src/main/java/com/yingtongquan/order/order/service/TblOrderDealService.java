package com.yingtongquan.order.order.service;

import com.yingtongquan.order.order.entity.TblOrderDealPo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
public interface TblOrderDealService extends IService<TblOrderDealPo> {

    /**
     * @Date 2020/6/10 13:46
     * @Author 胖
     * 根据订单号查询已支付的金额
     **/
    TblOrderDealPo queryHaveToPay(String orderNo);
}
