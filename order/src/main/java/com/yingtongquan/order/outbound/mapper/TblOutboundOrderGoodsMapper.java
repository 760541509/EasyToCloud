package com.yingtongquan.order.outbound.mapper;

import com.yingtongquan.order.outbound.entity.TblOutboundOrderGoodsPo;
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
public interface TblOutboundOrderGoodsMapper extends BaseMapper<TblOutboundOrderGoodsPo> {

    /**
     * @Date 2020/5/17 16:47
     * @Author 胖
     *添加出库单商品
     **/
    void addOutboundOrderGoods(TblOutboundOrderGoodsPo outboundOrderGoodsPo);

    /**
     * @Date 2020/5/17 16:56
     * @Author 胖
     * 修改发货商品的总数量
     **/
    void outboundTheTotalQuantityOfGoods(String orderNo,Integer goodsNumber);
}
