package com.yingtongquan.order.order.service.impl;

import com.yingtongquan.order.order.entity.TblOrderDealPo;
import com.yingtongquan.order.order.mapper.TblOrderDealMapper;
import com.yingtongquan.order.order.service.TblOrderDealService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
@Service
public class TblOrderDealServiceImpl extends ServiceImpl<TblOrderDealMapper, TblOrderDealPo> implements TblOrderDealService {

    @Resource
    private TblOrderDealMapper orderDealMapper;

    @Override
    public TblOrderDealPo queryHaveToPay(String orderNo) {
        return orderDealMapper.queryHaveToPay(orderNo);
    }
}
