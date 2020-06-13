package com.yingtongquan.employees.staff.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
}
