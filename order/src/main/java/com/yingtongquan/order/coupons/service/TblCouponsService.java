package com.yingtongquan.order.coupons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.order.coupons.entity.TblCouponsPo;
import com.yingtongquan.order.coupons.pojo.Coupons;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-06-02
 */
public interface TblCouponsService extends IService<TblCouponsPo> {
    /**
     * @Date 2020/6/2 10:11
     * @Author 胖
     * 根据优惠卷编号查询优惠卷详细
     **/
    Coupons queryCouponInformation(Integer couponId);
}
