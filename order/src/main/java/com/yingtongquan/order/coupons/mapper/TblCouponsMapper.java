package com.yingtongquan.order.coupons.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.order.coupons.entity.TblCouponsPo;
import com.yingtongquan.order.coupons.pojo.Coupons;
import org.apache.ibatis.annotations.Mapper;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-06-02
*/
@Mapper
public interface TblCouponsMapper extends BaseMapper<TblCouponsPo> {

    /**
     * @Date 2020/6/2 10:11
     * @Author 胖
     * 根据优惠卷编号查询优惠卷详细
     **/
    Coupons queryCouponInformation(Integer couponId);

}
