package com.yingtongquan.order.outbound.service.impl;

import com.yingtongquan.order.outbound.entity.TblOutboundOrderGoodsPo;
import com.yingtongquan.order.outbound.mapper.TblOutboundOrderGoodsMapper;
import com.yingtongquan.order.outbound.pojo.OutboundOrderGoods;
import com.yingtongquan.order.outbound.service.TblOutboundOrderGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
@Service
public class TblOutboundOrderGoodsServiceImpl extends ServiceImpl<TblOutboundOrderGoodsMapper, TblOutboundOrderGoodsPo> implements TblOutboundOrderGoodsService {

    @Resource
    private TblOutboundOrderGoodsMapper outboundOrderGoodsMapper;

    @Override
    public void addOutboundOrderGoods(Integer outboundOrderId, String orderNo, List<OutboundOrderGoods> outboundOrderGoods) {
        //发货的总数量
        int goodsNumber = 0;
        for (OutboundOrderGoods outboundOrderGood : outboundOrderGoods) {
            goodsNumber = goodsNumber + outboundOrderGood.getAmount();
            TblOutboundOrderGoodsPo outboundOrderGoodsPo = new TblOutboundOrderGoodsPo();
            outboundOrderGoodsPo.setAmount(outboundOrderGood.getAmount());
            outboundOrderGoodsPo.setOrderGoodsId(outboundOrderGood.getOrderGoodsId());
            outboundOrderGoodsPo.setOutboundOrderId(outboundOrderId);
            outboundOrderGoodsMapper.addOutboundOrderGoods(outboundOrderGoodsPo);
        }
        outboundOrderGoodsMapper.outboundTheTotalQuantityOfGoods(orderNo, goodsNumber);
    }
}
