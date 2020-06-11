package com.yingtongquan.order.returnGoods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.order.returnGoods.entity.TblReturnOrderDeliveryAddressPo;
import com.yingtongquan.order.returnGoods.entity.TblReturnOrderGoodsPo;
import com.yingtongquan.order.returnGoods.entity.TblReturnOrderLogisticsPo;
import com.yingtongquan.order.returnGoods.entity.TblReturnOrderPo;
import com.yingtongquan.order.returnGoods.pojo.MemberInformation;
import com.yingtongquan.order.returnGoods.pojo.OrderGoodsInformation;
import com.yingtongquan.order.returnGoods.pojo.OrderInformation;
import com.yingtongquan.order.returnGoods.pojo.ShopDeliveryAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface TblReturnOrderMapper extends BaseMapper<TblReturnOrderPo> {

    /**
     * @Date 2020/5/19 17:45
     * @Author 胖
     * 通过订单号查询对应的信息
     **/
    OrderInformation queryOrderInformation(String orderNo);

    /**
     * @Date 2020/5/20 11:27
     * @Author 胖
     * 通过订单编号查询相对应的商品信息
     **/
    OrderGoodsInformation queryOrderAllGoodsInformation(String orderNo, Integer shopGoodsId);

    /**
     * @Date 2020/5/20 12:02
     * @Author 胖
     * 根据用户ID查询出会员编号
     **/
    MemberInformation queryShopMemberInformation(Integer userId, Integer shopId);

    /**
     * @Date 2020/5/20 16:14
     * @Author 胖
     * 根据微信用户ID查询出会员编号
     **/
    MemberInformation queryTheMembershipNumberAccordingToTheWeChatUserID(Integer WXUserId, Integer shopId);

    /**
     * @Date 2020/5/20 12:16
     * @Author 胖
     * 根据退货单号查询信息
     **/
    TblReturnOrderPo queryReturnOrderInformation(String returnOrderNo);

    /**
     * @Date 2020/5/20 15:29
     * @Author 胖
     * 添加退款单
     **/
    Boolean addReturnOrderInformation(TblReturnOrderPo returnOrderPo);

    /**
     * @Date 2020/5/20 16:43
     * @Author 胖
     * 添加物流信息
     **/
    Boolean addLogisticsInformation(TblReturnOrderLogisticsPo returnOrderLogisticsPo);

    /**
     * @Date 2020/5/20 17:09
     * @Author 胖
     * 查询门店收货地址
     **/
    ShopDeliveryAddress queryShopShippingAddress(Integer id);

    /**
     * @Date 2020/5/20 17:17
     * @Author 胖
     * 添加退货单收货地址
     **/
    Boolean addReturnAddress(TblReturnOrderDeliveryAddressPo returnOrderDeliveryAddressPo);

    /**
     * @Date 2020/5/20 17:49
     * @Author 胖
     * 添加退货单商品信息
     **/
    Boolean addItemsInTheReturnForm(TblReturnOrderGoodsPo returnOrderGoodsPo);

    /**
     * @Date 2020/5/21 9:33
     * @Author 胖
     * 修改退货单状态
     **/
    Boolean modifyTheReturnStatus(String returnOrderNo);

    /**
     * @Date 2020/5/21 10:07
     * @Author 胖
     * 完成退货单，并修改相对应的属性
     **/
    void completeTheReturnForm(String outOrderNo,String refundId);

    /**
     * @Date 2020/5/29 11:31
     * @Author 胖
     * 查询所有的退货信息
     **/
    List<TblReturnOrderPo> queryAllShopReturnToApplyFor(Integer shopId);
}
