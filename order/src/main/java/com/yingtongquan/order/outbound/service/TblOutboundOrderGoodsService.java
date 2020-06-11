package com.yingtongquan.order.outbound.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.order.outbound.entity.TblOutboundOrderGoodsPo;
import com.yingtongquan.order.outbound.pojo.OutboundOrderGoods;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
public interface TblOutboundOrderGoodsService extends IService<TblOutboundOrderGoodsPo> {

    /**
     * @Date 2020/5/17 16:44
     * @Author 胖
     * 添加出库单商品
     **/
    void addOutboundOrderGoods(Integer outboundOrderId,String orderNo, List<OutboundOrderGoods> outboundOrderGoods);
}
