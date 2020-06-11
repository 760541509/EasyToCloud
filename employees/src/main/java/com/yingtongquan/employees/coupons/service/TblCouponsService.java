package com.yingtongquan.employees.coupons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.coupons.entity.TblCouponsPo;
import com.yingtongquan.employees.coupons.pojo.Coupons;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ML
 * @since 2020-06-05
 */
public interface TblCouponsService extends IService<TblCouponsPo> {

    /**
     * @Date 2020/6/5 10:17
     * @Author 胖
     * 添加优惠卷
     **/
    Boolean addCouponInformation(Coupons coupons);
}
