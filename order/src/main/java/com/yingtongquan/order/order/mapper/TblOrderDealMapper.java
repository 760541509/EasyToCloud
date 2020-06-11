package com.yingtongquan.order.order.mapper;

import com.yingtongquan.order.order.entity.TblOrderDealPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface TblOrderDealMapper extends BaseMapper<TblOrderDealPo> {

    /**
     * @Date 2020/6/10 13:46
     * @Author 胖
     * 根据订单号查询已支付的金额
     **/
    TblOrderDealPo queryHaveToPay(String orderNo);
}
