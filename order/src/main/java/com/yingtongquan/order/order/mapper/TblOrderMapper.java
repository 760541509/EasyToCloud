package com.yingtongquan.order.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.order.order.entity.TblOrderPo;
import com.yingtongquan.order.order.pojo.*;
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
public interface TblOrderMapper extends BaseMapper<TblOrderPo> {

    /**
     * @Date 2020/5/12 14:31
     * @Author 胖虎
     * 查询订单号是否存在
     **/
    TblOrderPo queryOrderInformation(String orderNo);

    /**
     * @Date 2020/5/12 14:32
     * @Author 胖虎
     * 查询用户会员信息
     **/
    MemberInformation queryShopMemberInfromation(Integer userId, Integer shopId);

    /**
     * @Date 2020/5/12 14:32
     * @Author 胖虎
     * 添加会员信息
     **/
    Boolean addShopMemberInfromation(MemberPojo memberPojo);

    /**
     * @Date 2020/5/12 13:57
     * @Author 胖虎
     * 查询某用户的信息
     **/
    UserPojo queryUserInformation(Integer userId);

    /**
     * @Date 2020/5/12 15:22
     * @Author 胖虎
     * 查询店铺的会员信息
     **/
    ShopMemberPrice queryShopMemberPrice(Integer shopId);

    /**
     * @Date 2020/5/12 15:44
     * @Author 胖虎
     * 查询价格(散客)
     **/
    GoodsShopPrice queryGoodsIndividualTravelerPrice(Integer goodsSkuUnitId, Integer memberPriceShopId, Integer goodsSkuId);

    /**
     * @Date 2020/6/9 11:37
     * @Author 胖
     * 查询价格(会员)
     **/
    GoodsShopPrice queryGoodsMemberPrice(Integer goodsSkuUnitId, Integer memberId, Integer goodsSkuId);

    /**
     * @Date 2020/5/12 16:11
     * @Author 胖虎
     * 添加订单基本信息
     **/
    Boolean addOrderInfromation(TblOrderPo orderPo);

    /**
     * @Date 2020/5/14 10:35
     * @Author 胖虎
     * 查询用户下面所有订单
     **/
    List<OrderInformation> queryUserAllOrderInformation(Integer userId);

    /**
     * @Date 2020/5/14 10:35
     * @Author 胖虎
     * 查询店铺所有订单
     **/
    List<OrderInformation> queryShopAllOrder(Integer shopId);

    /**
     * @Date 2020/5/14 10:42
     * @Author 胖虎
     * 查询订单中的所有商品
     **/
    List<OrderGoods> queryOrderAllGoods(String orderNo);

    /**
     * @Date 2020/6/10 13:15
     * @Author 胖
     * 查询共用商品单位名称
     **/
    String querygoodsSkuName(Integer goodsSkuId);

    /**
     * @Date 2020/5/14 11:18
     * @Author 胖虎
     * 获取某一个订单的基本信息
     **/
    OrderInformation queryOrderBasicInformation(String orderNo);

    /**
     * @Date 2020/5/14 15:33
     * @Author 胖虎
     * 修改订单中的价格和数量
     **/
    void modifyThePriceAndQuantityInTheOrder(UpdateOrderInformation orderInformation);

    /**
     * @Date 2020/5/15 14:44
     * @Author 胖虎
     * 按照微信用户ID查询相用户信息（指连表查询）
     **/
    WXUserInformation theUserIDIsQueriedByTheMobilePhoneNumber(Integer WXUserId, Integer UserId);

    /**
     * @Date 2020/6/1 16:16
     * @Author 胖
     * 通过微信ID查询出用户表中存在的ID
     **/
    Integer queryUserId(Integer WXId);

    /**
     * @Date 2020/6/2 15:10
     * @Author 胖
     * 添加订单信息
     **/
    Boolean addOrderInformation(TblOrderPo orderPo);

    /**
     * @Date 2020/6/4 11:11
     * @Author 胖
     * 添加抽奖次数
     **/
    Boolean addUserLotteryNumber(Integer userId);

    /**
     * @Date 2020/6/8 15:08
     * @Author 胖
     * 订单与优惠卷绑定
     **/
    Boolean bindCouponsAndOrder(Integer couponsId,String orderNo);

    /**
     * @Date 2020/6/8 17:56
     * @Author 胖
     * 通过会员ID查询userId
     **/
    Integer queryUser(Integer memberId);

    /**
     * @Date 2020/6/9 9:43
     * @Author 胖
     * 添加用户
     **/
    Boolean addUserInformation(UserPojo user);

    /**
     * @Date 2020/6/9 14:51
     * @Author 胖
     * 根据订单号查询订单ID
     **/
    Integer queryOrderId(String orderNo);

    /**
     * @Date 2020/6/10 10:52
     * @Author 胖
     * 添加出库单
     **/
    Boolean addOutboundOrder(OutboundOrderPo outboundOrderPo);

    /**
     * @Date 2020/6/10 11:12
     * @Author 胖
     * 订单号查询详细信息
     **/
    TblOrderPo queryOrderInfo(String orderNo);

    /**
     * @Date 2020/6/10 11:14
     * @Author 胖
     * 查询会员
     **/
    MemberInformation queryMemberInfo(Integer shopId,Integer userId);

    /**
     * @Date 2020/6/10 13:28
     * @Author 胖
     * 查询省市区
     **/
    Address queryAddressInfo(Integer areaId);
}
