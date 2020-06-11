package com.yingtongquan.order.coupons.service.impl;

import com.yingtongquan.order.coupons.entity.TblCouponsPo;
import com.yingtongquan.order.coupons.mapper.TblCouponsMapper;
import com.yingtongquan.order.coupons.pojo.Coupons;
import com.yingtongquan.order.coupons.service.TblCouponsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-06-02
 */
@Service
public class TblCouponsServiceImpl extends ServiceImpl<TblCouponsMapper, TblCouponsPo> implements TblCouponsService {

    @Resource
    private TblCouponsMapper couponsMapper;

    @Override
    public Coupons queryCouponInformation(Integer couponId) {
        return couponsMapper.queryCouponInformation(couponId);
    }
}
