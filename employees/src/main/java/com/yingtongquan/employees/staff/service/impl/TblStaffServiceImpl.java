package com.yingtongquan.employees.staff.service.impl;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.staff.entity.TblStaffPo;
import com.yingtongquan.employees.staff.mapper.TblStaffMapper;
import com.yingtongquan.employees.staff.pojo.*;
import com.yingtongquan.employees.staff.service.TblStaffRoleService;
import com.yingtongquan.employees.staff.service.TblStaffService;
import com.yingtongquan.startcommon.util.HttpUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@Service
public class TblStaffServiceImpl extends ServiceImpl<TblStaffMapper, TblStaffPo> implements TblStaffService {

    @Resource
    private TblStaffMapper staffMapper;
    @Resource
    private TblStaffRoleService staffRoleService;
    @Resource
    private HttpServletRequest request;

    @Override
    public Boolean addShopStaff(Integer shopId, Integer userId) {
        UserInformation userInformation = staffMapper.queryUser(userId);
        Integer bossId = staffRoleService.queryBossId(shopId);
        TblStaffPo staffPo = new TblStaffPo();
        staffPo.setAddress("");
        staffPo.setAreaId(0);
        staffPo.setShopId(shopId);
        staffPo.setStaffName(userInformation.getUsername());
        staffPo.setStaffPhone(userInformation.getPhone());
        staffPo.setStaffRoleId(bossId);
        staffPo.setUserId(userId);
        return staffMapper.addShopStaff(staffPo);
    }

    @Override
    public List<OrderInfromation> theEmployeeQueriesTheOrderByStatus(InquireOrderInfor inquireOrderInfor) {
        String token = request.getHeader("token");
        Integer shopId = HttpUtil.getShopId(token);
        inquireOrderInfor.setShopId(shopId);
        inquireOrderInfor.setPageStart((inquireOrderInfor.getPage() - 1) * inquireOrderInfor.getPageEnd());
        List<OrderInfromation> orderInfromations = staffMapper.theEmployeeQueriesTheOrderByStatus(inquireOrderInfor);
        for (int i = 0; i < orderInfromations.size(); i++) {
            String name = null;
            List<String> goodsName = staffMapper.queryOrderGoodsName(orderInfromations.get(i).getOrderNo());
            orderInfromations.get(i).setHaveToPay(staffMapper.queryOrderPayAmount(orderInfromations.get(i).getOrderNo()));
            for (int j = 0; j < goodsName.size(); j++) {
                name = goodsName.get(0);
            }
            orderInfromations.get(i).setGoodsName(name + " 等" + orderInfromations.get(i).getGoodsCount() + "件商品");
        }
        return orderInfromations;
    }

    @Override
    public StaffOrderInformation queryStaffOrderInformation(Order order) {
        //已支付金额
        Integer price = 0;
        //查询订单信息的一部分
        StaffOrderInformation staffOrderInformation = staffMapper.queryOrderInformation(order.getOrderNo());
        //统计已支付的金额
        List<Integer> moneys = staffMapper.countMoney(order.getOrderNo());
        for (Integer money : moneys) {
            price = money + price;
        }
        staffOrderInformation.setAmountPaid(price);
        //查询订单中的会员并赋值
        MemberInformation memberInformation = staffMapper.queryMemberInformation(order.getOrderNo());
        staffOrderInformation.setMemberId(memberInformation.getId());
        staffOrderInformation.setMemberName(memberInformation.getMemberName());
        staffOrderInformation.setHeadPortrait(memberInformation.getHeadPortrait());
        //查询订单中的商品信息
        List<StaffOrderGoods> staffOrderGoods = staffMapper.queryGoods(order.getOrderNo());
        //查询出货数量
        List<Goods> goods = staffMapper.queryOutboundGoodsNumber(order.getOrderNo());
        for (StaffOrderGoods staffOrderGood : staffOrderGoods) {
            //单位名字
            staffOrderGood.setSkuName(staffMapper.querySkuName(staffOrderGood.getGoodsSkuId()));
            for (Goods good : goods) {
                //如果出货商品不为空则复制
                if (good != null) {
                    //商品ID相同则添加出库数量
                    if (good.getOrderGoodsId().equals(staffOrderGood.getId())) {
                        staffOrderGood.setQuantityShipped(good.getAmount());
                    }
                }
            }
        }
        staffOrderInformation.setStaffOrderGoods(staffOrderGoods);
        //查询支付明细
        staffOrderInformation.setStaffOrderPayments(staffMapper.queryPaymentInformation(order.getOrderNo()));
        //出库单信息
        staffOrderInformation.setStaffOutboundOrders(staffMapper.queryOutboundInformation(order.getOrderNo()));
        System.out.println(new JSONObject(staffOrderInformation));
        return staffOrderInformation;
    }

    @Override
    public Boolean employeesCollection(StaffCollection staffCollection) {
        Integer staffId = staffMapper.queryStaffId(HttpUtil.getCurUserId(request.getHeader("token")));
        OrderDeal orderDeal = new OrderDeal();
        orderDeal.setAddTime(System.currentTimeMillis());
        orderDeal.setOrderId(staffMapper.queryOrderId(staffCollection.getOrderNo()));
        orderDeal.setPayAmount(staffCollection.getMoeny());
        orderDeal.setPayWay(staffCollection.getPayType());
        orderDeal.setSerialNo(UUID.randomUUID().toString().replace("-", "").substring(0, 14).toUpperCase());
        orderDeal.setStaffId(staffId);
        return staffMapper.addOrderDeal(orderDeal);
    }

    @Override
    public List<StaffOrderGoods> queryGoodsInformation(Order order) {
        List<StaffOrderGoods> staffOrderGoods = staffMapper.queryGoods(order.getOrderNo());
        for (StaffOrderGoods staffOrderGood : staffOrderGoods) {
            staffOrderGood.setSkuName(staffMapper.querySkuName(staffOrderGood.getGoodsSkuId()));
        }
        return staffOrderGoods;
    }

    @Override
    public Boolean distributingOrder(DistributeOrder distributeOrder) {
        //todo 明天继续
        Integer goodsCount = 0;
        for (DistributeOrderGoods distributeOrderGood : distributeOrder.getDistributeOrderGoods()) {
            goodsCount = goodsCount + distributeOrderGood.getStoreAmount();
        }
        if (distributeOrder.getAutomaticLedSingle() == 0) {
            addOutboundOrder(distributeOrder.getAutomaticLedSingle(),goodsCount,distributeOrder.getOrderNo());
        } else {
            addOutboundOrder(distributeOrder.getAutomaticLedSingle(),goodsCount,distributeOrder.getOrderNo());

















        }


        return null;
    }

    /**
     * @Date 2020/6/13 9:18
     * @Author 胖
     * 创建出库单
     **/
    private Boolean addOutboundOrder(Integer automaticLedSingle, Integer goodsCount, String orderNo) {
        String outboundNo = UUID.randomUUID().toString().replace("-", "").substring(0, 14);
        OutboundOrder outboundOrder = new OutboundOrder();
        outboundOrder.setAddTime(System.currentTimeMillis());
        outboundOrder.setGoodsCount(goodsCount);
        outboundOrder.setOrderNo(orderNo);
        outboundOrder.setOutboundOrderChannel(automaticLedSingle);
        outboundOrder.setOutboundOrderNo(outboundNo);
        outboundOrder.setOutboundOrderStatus(0);
        outboundOrder.setOutboundOrderType(0);
        return staffMapper.addOutboundOrder(outboundOrder);
    }

    /**
     * @Date 2020/6/13 10:12
     * @Author 胖
     * 添加出库商品
     **/
    private Boolean addOutboundGoods(DistributeOrderGoods distributeOrderGoods){














        return null;
    }

}
