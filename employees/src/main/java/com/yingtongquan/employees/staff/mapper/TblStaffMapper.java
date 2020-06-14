package com.yingtongquan.employees.staff.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.member.entity.TblMemberDeliveryAddressShopPo;
import com.yingtongquan.employees.staff.entity.TblStaffPo;
import com.yingtongquan.employees.staff.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@Mapper
@Repository
public interface TblStaffMapper extends BaseMapper<TblStaffPo> {

    /**
     * @Date 2020/6/5 16:54
     * @Author 胖
     * 添加店铺员工角色表
     **/
    Boolean addShopStaff(TblStaffPo staffPo);

    /**
     * @Date 2020/6/5 17:11
     * @Author 胖
     * 通过用户ID查询信息
     **/
    UserInformation queryUser(Integer userId);

    /**
     * @Date 2020/6/9 15:36
     * @Author 胖
     * 员工按照状态查询订单
     **/
    List<OrderInfromation> theEmployeeQueriesTheOrderByStatus(InquireOrderInfor inquireOrderInfor);

    /**
     * @Date 2020/6/9 17:22
     * @Author 胖
     * 返回商品名字
     **/
    List<String> queryOrderGoodsName(String orderNo);

    /**
     * @Date 2020/6/10 16:05
     * @Author 胖
     * 查询已支付金额
     **/
    Integer queryOrderPayAmount(String orderNo);

    /**
     * @Date 2020/6/12 15:09
     * @Author 胖
     * 查询订单详细的一部分
     **/
    StaffOrderInformation queryOrderInformation(String orderNo);

    /**
     * @Date 2020/6/14 10:26
     * @Author 胖
     * 查询订单收货地址
     **/
    StaffOrderInformation queryOrderShipping(String orderNo);

    /**
     * @Date 2020/6/12 16:43
     * @Author 胖
     * 统计已支付的金额
     **/
    List<Integer> countMoney(String orderNo);

    /**
     * @Date 2020/6/12 15:26
     * @Author 胖
     * 查询订单会员信息
     **/
    MemberInformation queryMemberInformation(String orderNo);

    /**
     * @Date 2020/6/12 15:50
     * @Author 胖
     * 查询商品信息
     **/
    List<StaffOrderGoods> queryGoods(String orderNo);

    /**
     * @Date 2020/6/12 15:55
     * @Author 胖
     * 查询规格描述
     **/
    String querySkuName(Integer skuId);

    /**
     * @Date 2020/6/12 16:06
     * @Author 胖
     * 查询商品出货数量
     **/
    List<Goods> queryOutboundGoodsNumber(String orderNo);

    /**
     * @Date 2020/6/12 16:28
     * @Author 胖
     * 查询支付明细
     **/
    List<StaffOrderPayment> queryPaymentInformation(String orderNo);

    /**
     * @Date 2020/6/12 16:38
     * @Author 胖
     * 查询出库单信息
     **/
    List<StaffOutboundOrder> queryOutboundInformation(String orderNo);

    /**
     * @Date 2020/6/12 17:34
     * @Author 胖
     * 查询订单ID
     **/
    Integer queryOrderId(String orderNo);

    /**
     * @Date 2020/6/12 17:41
     * @Author 胖
     * 通过UserId查询员工ID
     **/
    Integer queryStaffId(Integer userId);

    /**
     * @Date 2020/6/12 17:37
     * @Author 胖
     * 添加收款单
     **/
    Boolean addOrderDeal(OrderDeal orderDeal);

    /**
     * 2020/6/12  20:23
     * @Author 胖
     * 添加出库单
     **/
    Boolean addOutboundOrder(OutboundOrder outboundOrder);

    /**
     * @Date 2020/6/13 10:23
     * @Author 胖
     * 添加商品的出库
     **/
    Boolean addOutboundGoods(DistributeOrderGoods distributeOrderGoods);

    /**
     * @Date 2020/6/13 11:35
     * @Author 胖
     * 添加出库员工单
     **/
    Boolean addOutboundStaff(OutboundStaff outboundStaff);

    /**
     * @Date 2020/6/13 14:03
     * @Author 胖
     * 根据出库单号查询收货地址
     **/
    ShippingAddress queryOrderShippingAddress(Integer outboundId);

    /**
     * @Date 2020/6/14 11:59
     * @Author 胖
     * 查询收货地址
     **/
    TblMemberDeliveryAddressShopPo queryShippingAddress(Integer id);

    /**
     * @Date 2020/6/13 14:20
     * @Author 胖
     * 添加出库收货地址
     **/
    Boolean addOutboundShippingAddress(OutboundShippingAddress outboundShippingAddress);

    /**
     * @Date 2020/6/13 15:24
     * @Author 胖
     * 查询出库单号
     **/
    String queryOutboundNo(Integer outboundId);

    /**
     * @Date 2020/6/13 16:01
     * @Author 胖
     * 商品基本单位
     **/
    Integer queryGoodsSpuUnit(Integer id);

    /**
     * @Date 2020/6/13 16:38
     * @Author 胖
     * 查询出库单状态
     **/
    List<Outbound> queryOutboundOrderStatus(String orderNo);

    /**
     * @Date 2020/6/13 16:51
     * @Author 胖
     * 修改订单状态
     **/
    Boolean updateOrderStatus(String orderNo);

    /**
     * @Date 2020/6/13 17:13
     * @Author 胖
     * 查询出库商品单的信息
     **/
    List<IncomingGoods> queryGoodsInfo(String outboundNo);

    /**
     * @Date 2020/6/13 17:39
     * @Author 胖
     * 查询出库单
     **/
    List<OutboundInformation> queryOutboundInfo(Parment parment);

    /**
     * @Date 2020/6/13 17:46
     * @Author 胖
     * 查询出库商品名称
     **/
    List<String> queryOutboundGoods(String outboundNo);

    /**
     * 2020/6/13  20:14
     * @Author 胖
     * 查询出库单的一部分信息
     **/
    StaffOrderInformation queryStaffOutboundInformation(String outboundNo);

    /**
     * @Date 2020/6/14 9:53
     * @Author 胖
     * 出库单商品信息
     **/
    List<StaffOrderGoods> queryOutbounGoodsInformation(String outboundNo);

    /**
     * 2020/6/13  20:14
     * @Author 胖
     * 查询出库单的收货地址
     **/
    StaffOrderInformation queryStaffOutboundShippingAddress(String outboundNo);

    /**
     * @Date 2020/6/14 10:33
     * @Author 胖
     * 查询出库单信息
     **/
    OutboundOrderPo queryOutboundOrderInformation(String outboundNo);

    /**
     * @Date 2020/6/14 10:37
     * @Author 胖
     * 修改出库单状态
     **/
    Boolean updateOutboundStatus(String outboundNo);

    /**
     * @Date 2020/6/14 13:59
     * @Author 胖
     * 添加出库物流单
     **/
    Boolean addOutboundLogistics(OutboundOrderLogistics outboundOrderLogistics);
}
