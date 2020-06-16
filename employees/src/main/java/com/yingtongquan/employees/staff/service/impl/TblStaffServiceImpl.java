package com.yingtongquan.employees.staff.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo;
import com.yingtongquan.employees.goods.service.TblGoodsSpuService;
import com.yingtongquan.employees.member.entity.TblMemberDeliveryAddressShopPo;
import com.yingtongquan.employees.staff.entity.TblStaffPo;
import com.yingtongquan.employees.staff.mapper.TblStaffMapper;
import com.yingtongquan.employees.staff.pojo.*;
import com.yingtongquan.employees.staff.service.TblStaffRoleService;
import com.yingtongquan.employees.staff.service.TblStaffService;
import com.yingtongquan.startcommon.base.ResultVo;
import com.yingtongquan.startcommon.exception.AssertException;
import com.yingtongquan.startcommon.util.HttpUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
    private TblGoodsSpuService goodsSpuService;
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
        //todo 记得释放注释
//        String token = request.getHeader("token");
//        Integer shopId = HttpUtil.getShopId(token);
        inquireOrderInfor.setShopId(10003);
        inquireOrderInfor.setPageStart((inquireOrderInfor.getPage() - 1) * inquireOrderInfor.getPageEnd());
        List<OrderInfromation> orderInfromations = staffMapper.theEmployeeQueriesTheOrderByStatus(inquireOrderInfor);
        for (int i = 0; i < orderInfromations.size(); i++) {
            String name = null;
            if (orderInfromations.get(i).getMemberId() != 0) {
                MemberInformation memberInformation = staffMapper.queryOrderMemberInfor(orderInfromations.get(i).getOrderNo());
                OrderShippingAddress orderShippingAddress = staffMapper.shippingAddress(orderInfromations.get(i).getOrderNo());
                orderInfromations.get(i).setMemberName(memberInformation.getMemberName());
                orderInfromations.get(i).setHeadPortrait(memberInformation.getHeadPortrait());
                orderInfromations.get(i).setMemberId(memberInformation.getId());
                if (orderShippingAddress != null) {
                    orderInfromations.get(i).setAddress(orderShippingAddress.getAddress());
                    orderInfromations.get(i).setArea(orderShippingAddress.getArea());
                    orderInfromations.get(i).setCity(orderShippingAddress.getCity());
                    orderInfromations.get(i).setProvince(orderShippingAddress.getProvince());
                }
            }
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
        StaffOrderInformation shippingAddress = staffMapper.queryOrderShipping(order.getOrderNo());
        if (shippingAddress != null) {
            staffOrderInformation.setAddress(shippingAddress.getAddress());
            staffOrderInformation.setIsSince(shippingAddress.getIsSince());
            staffOrderInformation.setPhone(shippingAddress.getPhone());
            staffOrderInformation.setConsignee(shippingAddress.getConsignee());
            staffOrderInformation.setProvince(shippingAddress.getProvince());
            staffOrderInformation.setCity(shippingAddress.getCity());
            staffOrderInformation.setArea(shippingAddress.getArea());
        }
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
        Boolean collection = staffMapper.orderCollection(staffCollection.getOrderNo());
        if (collection) {
            OrderDeal orderDeal = new OrderDeal();
            orderDeal.setAddTime(System.currentTimeMillis());
            orderDeal.setOrderId(staffMapper.queryOrderId(staffCollection.getOrderNo()));
            orderDeal.setPayAmount(staffCollection.getMoeny());
            orderDeal.setPayWay(staffCollection.getPayType());
            orderDeal.setSerialNo(UUID.randomUUID().toString().replace("-", "").substring(0, 14).toUpperCase());
            orderDeal.setStaffId(staffId);
            return staffMapper.addOrderDeal(orderDeal);
        }
        return false;
    }

    @Override
    public List<StaffOrderGoods> queryGoodsInformation(Order order) {
        List<StaffOrderGoods> staffOrderGoods = staffMapper.queryGoods(order.getOrderNo());
        for (StaffOrderGoods staffOrderGood : staffOrderGoods) {
            staffOrderGood.setSkuName(staffMapper.querySkuName(staffOrderGood.getGoodsSkuId()));
            staffOrderGood.setWarehouseInformations(staffMapper.queryWarehouseInformation(staffOrderGood.getGoodsSkuId()));
            staffOrderGood.setStoresInformations(staffMapper.queryStoresInformation(staffOrderGood.getGoodsSkuId()));
        }
        return staffOrderGoods;
    }

    @Override
    public Boolean distributingOrder(DistributeOrder distributeOrder) {

        //todo 还有BUG

        Map<Integer, Integer> orderMap = new HashMap<>();
        Map<Integer, Integer> outboundMap = new HashMap<>();
        //获取request中的token
        Integer curUserId = HttpUtil.getCurUserId(request.getHeader("token"));
        //通过token中的用户ID获取到员工ID
        Integer staffId = staffMapper.queryStaffId(curUserId);
        //发货的总数量
        Integer goodsCount = 0;
        Integer outboundID = 0;
        //仓库出货或者店铺出货的对象
        List<TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa> shopGoodsSkuStore = new ArrayList<>();
        List<TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa> warehouseGoodsSkuStore = new ArrayList<>();
        TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa goodsSkuStore = new TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa();
        TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa warehouseGoods = new TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa();
        //订单中需要出库的商品集合
        List<DistributeOrderGoods> distributeOrderGoods = distributeOrder.getDistributeOrderGoods();
        //商品基本信息
        List<StaffOrderGoods> staffOrderGoods = staffMapper.queryGoods(distributeOrder.getOrderNo());
        //计算出出货的数量和统计总出货数量
        for (DistributeOrderGoods distributeOrderGood : distributeOrderGoods) {
            //基本单位数量
            Integer unit = staffMapper.queryGoodsSpuUnit(distributeOrderGood.getGoodsSkuUnitId());
            //发货的基本数量（需要发送的数量 * 基本单位）
            distributeOrderGood.setStoreAmount(distributeOrderGood.getStoreAmount() * unit);
            goodsCount = goodsCount + distributeOrderGood.getStoreAmount();
            orderMap.computeIfAbsent(distributeOrderGood.getId(), k -> 0);
            orderMap.put(distributeOrderGood.getId(), orderMap.get(distributeOrderGood.getId()) + distributeOrderGood.getStoreAmount());
        }
        List<IncomingGoods> incomingGoods = staffMapper.queryGoodsInfo(null, distributeOrder.getOrderNo());
        for (IncomingGoods incomingGood : incomingGoods) {
            outboundMap.computeIfAbsent(incomingGood.getOrderGoodsId(), k -> 0);
            outboundMap.put(incomingGood.getOrderGoodsId(), outboundMap.get(incomingGood.getOrderGoodsId()) + incomingGood.getAmount());
        }
        Set keySet = orderMap.keySet();
        Iterator it1 = keySet.iterator();
        while (it1.hasNext()) {
            Integer id = (Integer) it1.next();
            Integer goodsAmount = orderMap.get(id);
            for (DistributeOrderGoods distributeOrderGood : distributeOrderGoods) {
                for (StaffOrderGoods staffOrderGood : staffOrderGoods) {
                    if (staffOrderGood.getId().equals(id)) {
                        Integer outboundNumber = outboundMap.get(id);
                        if (outboundNumber == null) {
                            outboundNumber = 0;
                        }
                        Integer amount = (staffOrderGood.getAmount() * staffOrderGood.getUnitAmount()) - outboundNumber;
                        if (goodsAmount <= amount) {
                            if (distributeOrder.getAutomaticLedSingle() == 0) {
                                //出库单号
                                outboundID = addOutboundOrder(distributeOrder.getAutomaticLedSingle(), goodsCount, distributeOrder.getOrderNo());
                                addOutboundGoods(distributeOrderGood, outboundID);
                            } else {
                                outboundID = addOutboundOrder(distributeOrder.getAutomaticLedSingle(), goodsCount, distributeOrder.getOrderNo());
                                String outboundNo = staffMapper.queryOutboundNo(outboundID);
                                //查询基本单位
                                Integer unit = staffMapper.queryGoodsSpuUnit(distributeOrderGood.getGoodsSkuUnitId());
                                //计算基本单位
                                distributeOrderGood.setStoreAmount(distributeOrderGood.getStoreAmount() * unit);
                                //添加出库商品
                                addOutboundGoods(distributeOrderGood, outboundID);
                                //出库
                                if (distributeOrderGood.getStoreId() != null) {                                  //店铺出货
                                    goodsSkuStore.setOutboundOrderNo(outboundNo);
                                    goodsSkuStore.setFkIdStaff(staffId);
                                    goodsSkuStore.setFkGoodsSkuId(distributeOrderGood.getGoodsSkuId());
                                    goodsSkuStore.setFkShopId(distributeOrderGood.getStoreId());
                                    goodsSkuStore.setType(1);
                                    goodsSkuStore.setStore(distributeOrderGood.getStoreAmount() * -1);
                                    shopGoodsSkuStore.add(goodsSkuStore);
                                } else if (distributeOrderGood.getWarehouseId() != null) {                      //仓库出货
                                    warehouseGoods.setOutboundOrderNo(outboundNo);
                                    warehouseGoods.setFkIdStaff(staffId);
                                    warehouseGoods.setFkGoodsSkuId(distributeOrderGood.getGoodsSkuId());
                                    warehouseGoods.setFkWarehouseId(distributeOrderGood.getWarehouseId());
                                    warehouseGoods.setType(1);
                                    warehouseGoods.setStore(distributeOrderGood.getStoreAmount() * -1);
                                    warehouseGoodsSkuStore.add(warehouseGoods);
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("发货的数量超出实际订单所需要的数量");
                        }

                        if (outboundID != 0) {
                            //填写员工出库单
                            addOutboundStaff(outboundID);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public ResultVo cancelTheOrder(Order order) {
        List<Outbound> outbounds = staffMapper.queryOutboundOrderStatus(order.getOrderNo());
        for (Outbound outbound : outbounds) {
            if (outbound.getOutboundOrderStatus() != 4) {
                return ResultVo.errorResult("还有出库单尚未取消，出库单号是:" + outbound.getOutboundOrderNO());
            }
        }
        return ResultVo.successResult(staffMapper.updateOrderStatus(order.getOrderNo()));
    }

    @Override
    public void cancelTheDelivery(Outbound outbound) {
        Integer curUserId = HttpUtil.getCurUserId(request.getHeader("token"));
        Integer staffId = staffMapper.queryStaffId(curUserId);
        List<IncomingGoods> incomingGoods = staffMapper.queryGoodsInfo(outbound.getOutboundOrderNO(), null);
        List<TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa> shopGoodsSkuStore = new ArrayList<>();
        List<TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa> warehouseGoodsSkuStore = new ArrayList<>();
        TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa goodsSkuStore = new TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa();
        TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa warehouseGoods = new TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa();
        for (IncomingGoods incomingGood : incomingGoods) {
            if (incomingGood.getShopId() != null) {
                goodsSkuStore.setOutboundOrderNo(incomingGood.getOutboundOrderNo());
                goodsSkuStore.setFkIdStaff(staffId);
                goodsSkuStore.setFkGoodsSkuId(incomingGood.getGoodsSkuId());
                goodsSkuStore.setFkShopId(incomingGood.getShopId());
                goodsSkuStore.setType(1);
                goodsSkuStore.setStore(incomingGood.getAmount());
                shopGoodsSkuStore.add(goodsSkuStore);
            } else {
                warehouseGoods.setOutboundOrderNo(incomingGood.getOutboundOrderNo());
                warehouseGoods.setFkIdStaff(staffId);
                warehouseGoods.setFkGoodsSkuId(incomingGood.getGoodsSkuId());
                warehouseGoods.setFkWarehouseId(incomingGood.getShopId());
                warehouseGoods.setType(1);
                warehouseGoods.setStore(incomingGood.getAmount());
                warehouseGoodsSkuStore.add(warehouseGoods);
            }
        }
        if (shopGoodsSkuStore.size() > 0) {
            goodsSpuService.addShopGoodsSkuStore(shopGoodsSkuStore);
        } else if (warehouseGoodsSkuStore.size() > 0) {
            goodsSpuService.addWarehouseGoodsSkuStore(warehouseGoodsSkuStore);
        }
    }

    @Override
    public List<OutboundInformation> queryOutbound(Parment parment) {
        String goodsName = null;
        parment.setPageStart((parment.getPage() - 1) * parment.getPageEnd());
        List<OutboundInformation> outboundInformations = staffMapper.queryOutboundInfo(parment);
        for (OutboundInformation outboundInformation : outboundInformations) {
            List<String> goods = staffMapper.queryOutboundGoods(outboundInformation.getOutboundOrderNo());
            for (int i = 0; i < goods.size(); i++) {
                goodsName = goods.get(0);
            }
            outboundInformation.setGoodsName(goodsName);
        }
        return outboundInformations;
    }

    @Override
    public StaffOrderInformation queryOutboundInformation(Outbound outbound) {
        StaffOrderInformation staffOrderInformation = staffMapper.queryStaffOutboundInformation(outbound.getOutboundOrderNO());
        StaffOrderInformation shippingAddress = staffMapper.queryStaffOutboundShippingAddress(outbound.getOutboundOrderNO());
        if (shippingAddress != null) {
            staffOrderInformation.setArea(shippingAddress.getArea());
            staffOrderInformation.setCity(shippingAddress.getCity());
            staffOrderInformation.setProvince(shippingAddress.getProvince());
            staffOrderInformation.setConsignee(shippingAddress.getConsignee());
            staffOrderInformation.setPhone(shippingAddress.getPhone());
            staffOrderInformation.setIsSince(shippingAddress.getIsSince());
            staffOrderInformation.setAddress(shippingAddress.getAddress());
        }
        List<StaffOrderGoods> staffOrderGoods = staffMapper.queryOutbounGoodsInformation(outbound.getOutboundOrderNO());
        for (StaffOrderGoods staffOrderGood : staffOrderGoods) {
            staffOrderGood.setSkuName(staffMapper.querySkuName(staffOrderGood.getGoodsSkuId()));
        }
        staffOrderInformation.setStaffOrderGoods(staffOrderGoods);
        return staffOrderInformation;
    }

    @Override
    public Boolean staffGetASingle(Outbound outbound) {
        OutboundOrderPo outboundOrderPo = staffMapper.queryOutboundOrderInformation(outbound.getOutboundOrderNO());
        addOutboundStaff(outboundOrderPo.getId());
        return staffMapper.updateOutboundStatus(outbound.getOutboundOrderNO());
    }

    @Override
    public Boolean staffDeliverGoods(DeliveryInformation deliveryInformation) {
        OutboundOrderPo outboundOrderPo = staffMapper.queryOutboundOrderInformation(deliveryInformation.getOutboundNo());
        addShipingAddress(outboundOrderPo.getId(), deliveryInformation.getAddressId());
        OutboundOrderLogistics outboundOrderLogistics = new OutboundOrderLogistics();
        outboundOrderLogistics.setAddTime(System.currentTimeMillis());
        outboundOrderLogistics.setLogisticsNo(deliveryInformation.getLogisticsNo());
        outboundOrderLogistics.setName(deliveryInformation.getName());
        outboundOrderLogistics.setOutboundOrderId(outboundOrderPo.getId());
        return staffMapper.addOutboundLogistics(outboundOrderLogistics);
    }

    /**
     * @Date 2020/6/13 9:18
     * @Author 胖
     * 创建出库单
     **/
    private Integer addOutboundOrder(Integer automaticLedSingle, Integer goodsCount, String orderNo) {
        String outboundNo = UUID.randomUUID().toString().replace("-", "").substring(0, 14);
        OutboundOrder outboundOrder = new OutboundOrder();
        outboundOrder.setAddTime(System.currentTimeMillis());
        outboundOrder.setGoodsCount(goodsCount);
        outboundOrder.setOrderNo(orderNo);
        outboundOrder.setOutboundOrderChannel(automaticLedSingle);
        outboundOrder.setOutboundOrderNo(outboundNo);
        outboundOrder.setOutboundOrderStatus(0);
        outboundOrder.setOutboundOrderType(0);
        staffMapper.addOutboundOrder(outboundOrder);
        return outboundOrder.getId();
    }

    /**
     * @Date 2020/6/13 10:12
     * @Author 胖
     * 添加出库商品
     **/
    private Boolean addOutboundGoods(DistributeOrderGoods distributeOrderGoods, Integer outboundId) {
        distributeOrderGoods.setOutboundId(outboundId);
        return staffMapper.addOutboundGoods(distributeOrderGoods);
    }

    /**
     * @Date 2020/6/13 10:59
     * @Author 胖
     * 填写员工出库单
     **/
    private Boolean addOutboundStaff(Integer outboundId) {
        Integer userId = HttpUtil.getCurUserId(request.getHeader("token"));
        Integer staffId = staffMapper.queryStaffId(userId);
        OutboundStaff outboundStaff = new OutboundStaff();
        outboundStaff.setAddTime(System.currentTimeMillis());
        outboundStaff.setCommissionAmount(0);
        outboundStaff.setOutboundOrderId(outboundId);
        outboundStaff.setStaffId(staffId);
        return staffMapper.addOutboundStaff(outboundStaff);
    }

    /**
     * @Date 2020/6/13 11:50
     * @Author 胖
     * 出库单收货地址
     **/
    private Boolean addShipingAddress(Integer outboundId, Integer addressId) {
        TblMemberDeliveryAddressShopPo memberDeliveryAddress = staffMapper.queryShippingAddress(addressId);
        ShippingAddress shippingAddress = staffMapper.queryOrderShippingAddress(outboundId);
        OutboundShippingAddress outboundShippingAddress = new OutboundShippingAddress();
        outboundShippingAddress.setAddress(memberDeliveryAddress.getAddress());
        outboundShippingAddress.setAddTime(System.currentTimeMillis());
        outboundShippingAddress.setAreaId(memberDeliveryAddress.getAreaId());
        outboundShippingAddress.setIsSince(shippingAddress.getIsSince());
        outboundShippingAddress.setMemberShopId(shippingAddress.getMemberId());
        outboundShippingAddress.setName(memberDeliveryAddress.getName());
        outboundShippingAddress.setOutboundOrderId(outboundId);
        outboundShippingAddress.setPhone(memberDeliveryAddress.getPhone());
        return staffMapper.addOutboundShippingAddress(outboundShippingAddress);
    }

}
