package com.yingtongquan.order.order.mapper;

import com.yingtongquan.order.order.entity.TblOrderGoodsPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.order.order.pojo.GoodsInfromation;
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
public interface TblOrderGoodsMapper extends BaseMapper<TblOrderGoodsPo> {

    /**
     * @Date 2020/5/12 16:39
     * @Author 胖虎
     * 通过商品编号查询订单中商品的名字其他信息
     **/
    GoodsInfromation queryGoodsInformation(Integer goodsId);

    /**
     * @Date 2020/5/12 17:47
     * @Author 胖虎
     * 添加订单中的商品信息
     **/
    Boolean addOrderGoodsInformation(TblOrderGoodsPo orderGoodsPo);

    /**
     * @Date 2020/5/14 14:12
     * @Author 胖虎
     * 删除某个订单中的商品信息
     **/
    Boolean reOrderGoods(Integer orderId);
}
