package com.yingtongquan.order.outbound.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.order.outbound.entity.TblOutboundOrderLogisticsPo;
import com.yingtongquan.order.outbound.entity.TblOutboundOrderPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
@Mapper
@Repository
public interface TblOutboundOrderLogisticsMapper extends BaseMapper<TblOutboundOrderLogisticsPo> {

    /**
     * @Date 2020/5/18 14:39
     * @Author 胖
     * 传入出库单号查询相对应的信息
     **/
    TblOutboundOrderPo queryOutboundOrderInformation(String outboundOrderNo);

    /**
     * @Date 2020/5/18 14:44
     * @Author 胖
     * 添加出库单物流信息
     **/
    Boolean addOutboundOrderShippingAddress(TblOutboundOrderLogisticsPo tblOutboundOrderLogisticsPo);
}
