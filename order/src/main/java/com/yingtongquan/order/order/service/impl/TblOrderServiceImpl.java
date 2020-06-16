package com.yingtongquan.order.order.service.impl;


import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.yingtongquan.checkstand.payment.WXPayment;
import com.yingtongquan.checkstand.pojo.UnifiedOrderParam;
import com.yingtongquan.order.order.entity.TblOrderDealPo;
import com.yingtongquan.order.order.entity.TblOrderGoodsPo;
import com.yingtongquan.order.order.entity.TblOrderPo;
import com.yingtongquan.order.order.mapper.TblOrderGoodsMapper;
import com.yingtongquan.order.order.mapper.TblOrderMapper;
import com.yingtongquan.order.order.pojo.*;
import com.yingtongquan.order.order.service.*;
import com.yingtongquan.startcommon.base.ResultVo;
import com.yingtongquan.startcommon.util.HttpUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
@Service
public class TblOrderServiceImpl extends ServiceImpl<TblOrderMapper, TblOrderPo> implements TblOrderService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private HttpServletRequest request;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private TblOrderMapper orderMapper;
    @Resource
    private TblOrderGoodsService orderGoodsService;
    @Resource
    private TblOrderDeliveryAddressService orderDeliveryAddressService;
    @Resource
    private TblOrderGoodsMapper orderGoodsMapper;
    @Resource
    private TblOrderDealService orderDealService;
    @Resource
    private TblOrderStaffService orderStaffService;


    @Override
    public ResultVo addOrderInformation(UserOrderAndMemberInformation orderAndMemberInformation) {
        if (orderAndMemberInformation.getOrderChannel() == 0) {
            return staffPlaceOrder(orderAndMemberInformation);    //员工开单
        } else if (orderAndMemberInformation.getOrderChannel() == 1) {
            return WeChatPlaceOrder(orderAndMemberInformation);   //小程序下单
        }
        return ResultVo.errorResult();
    }

    @Override
    public List<OrderInformation> queryUserAllOrderInformation() {
        //token中获取的userID
        Integer curUserId = HttpUtil.getCurUserId(request.getHeader("token"));
        Boolean hasKey = redisTemplate.hasKey(curUserId + "OrderInformation");
        if (hasKey) {
            return redisTemplate.opsForList().range(curUserId + "OrderInformation", 0, -1);
        } else {
            //查询所有的订单信息
            List<OrderInformation> orderInformations = orderMapper.queryUserAllOrderInformation(curUserId);
            if (orderInformations.size() > 0) {
                //添加订单商品具体信息
                for (OrderInformation orderInformation : orderInformations) {
                    List<OrderGoods> orderGoods = orderMapper.queryOrderAllGoods(orderInformation.getOrderNo());
                    orderInformation.setOrderGoods(orderGoods);
                }
                redisTemplate.opsForList().rightPushAll(curUserId + "OrderInformation", orderInformations);
            }
            return orderInformations;
        }
    }

    @Override
    public OrderInformation queryOrderInformation(String orderNo) {
        OrderInformation orderInformation = orderMapper.queryOrderBasicInformation(orderNo);
        Address address = orderMapper.queryAddressInfo(orderInformation.getAreaId());
        orderInformation.setProvinces(address.getProvince());
        orderInformation.setCity(address.getCity());
        orderInformation.setArea(address.getArea());
        List<OrderGoods> orderGoods = orderMapper.queryOrderAllGoods(orderInformation.getOrderNo());
        for (OrderGoods orderGood : orderGoods) {
            orderGood.setGoodsSkuName(orderMapper.querygoodsSkuName(orderGood.getGoodsSkuId()));
        }
        orderInformation.setOrderGoods(orderGoods);
        TblOrderPo tblOrderPo = orderMapper.queryOrderInfo(orderInformation.getOrderNo());
        if (tblOrderPo.getUserId() == 0) {
            orderInformation.setMemberId(0);
        } else {
            MemberInformation memberInformation = orderMapper.queryMemberInfo(tblOrderPo.getShopId(), tblOrderPo.getUserId());
            if (memberInformation.getId() == null || memberInformation.getId() == 0) {
                orderInformation.setMemberId(0);
            }
            orderInformation.setMemberId(memberInformation.getId());
            orderInformation.setMemberName(memberInformation.getMemberName());
            orderInformation.setHeadPortrait(memberInformation.getHeadPortrail());
        }
        TblOrderDealPo orderDealPo = orderDealService.queryHaveToPay(orderInformation.getOrderNo());
        if (orderDealPo != null) {
            orderInformation.setHaveToPay(orderDealPo.getPayAmount());
        }
        return orderInformation;
    }

    @Override
    public Boolean updateOrderGoodsInformation(List<OrderGoodsInformation> orderGoodsInformation, String orderNo) {
        //商品的数量
        int goodsNumber = 0;
        //实际付款金额
        int goodsMoney = 0;
        //商品的总金额
        int goodsTotalAmount = 0;
        //订单基本信息
        TblOrderPo tblOrderPo = orderMapper.queryOrderInformation(orderNo);
        //删除订单商品信息
        orderGoodsService.reOrderGoods(tblOrderPo.getId());
        //查询会员信息
        MemberInformation memberInformation = orderMapper.queryShopMemberInfromation(tblOrderPo.getUserId(), tblOrderPo.getShopId());
        for (OrderGoodsInformation goodsInformation : orderGoodsInformation) {
            //商品信息
            GoodsInfromation goods = orderGoodsService.queryGoodsInformation(goodsInformation.getShopGoodsId());
            //商品的价格
            GoodsShopPrice shopPrice = orderMapper.queryGoodsMemberPrice(goodsInformation.getGoodsSkuUnitId(), memberInformation.getMemberId(), goodsInformation.getGoodsSkuId());
            //商品图片
            List<String> imageList = Lists.newArrayList(goods.getCarouselImage().split(";"));
            TblOrderGoodsPo orderGoodsPo = new TblOrderGoodsPo();
            orderGoodsPo.setStaffCommissionRate(goods.getStaffCommissionRate());
            orderGoodsPo.setShopGoodsId(goodsInformation.getShopGoodsId());
            orderGoodsPo.setShareCouponsPrice(0);
            orderGoodsPo.setPrice(goodsInformation.getPrice());
            orderGoodsPo.setOriginalPrice(shopPrice.getPrice());
            orderGoodsPo.setOrderId(tblOrderPo.getId());
            orderGoodsPo.setOrderGoodsName(goods.getName());
            for (int i = 0; i < imageList.size(); i++) {
                orderGoodsPo.setImage(imageList.get(0));
            }
            orderGoodsPo.setGoodsSkuUnitId(goodsInformation.getGoodsSkuUnitId());
            orderGoodsPo.setGoodsSkuId(goodsInformation.getGoodsSkuId());
            orderGoodsPo.setDistributorCommissionRate(goods.getDistributorCommissionRate());
            orderGoodsPo.setAmount(goodsInformation.getAmount());
            orderGoodsMapper.addOrderGoodsInformation(orderGoodsPo);
            goodsNumber = goodsInformation.getAmount() + goodsNumber;    //商品的数量
            goodsTotalAmount = shopPrice.getPrice() * goodsInformation.getAmount() + goodsTotalAmount;  //实际需要支付的金额
            goodsMoney = goodsInformation.getPrice() * goodsInformation.getAmount() + goodsMoney;  //商品需要支付的金额
        }

        UpdateOrderInformation orderInformation = new UpdateOrderInformation();
        orderInformation.setGoodsAmountTotal(goodsTotalAmount);
        orderInformation.setGoodsCount(goodsNumber);
        orderInformation.setOrderAmountTotal(goodsMoney);
        orderInformation.setOrderNo(orderNo);
        orderMapper.modifyThePriceAndQuantityInTheOrder(orderInformation);
        return true;
    }

    @Override
    public Boolean updateOrderStatus(OrderDeal orderDeal) {

        Integer orderId = orderMapper.queryOrderId(orderDeal.getOrderNo());

        TblOrderDealPo orderDealPo = new TblOrderDealPo();
        orderDealPo.setAddTime(System.currentTimeMillis());
        orderDealPo.setOrderId(orderId);
        orderDealPo.setPayAmount(orderDeal.getPayAmount());
        orderDealPo.setPayWay(orderDeal.getPayWay());
        orderDealPo.setSerialNo(RandomStringUtils.randomAlphanumeric(12).toUpperCase());


        return null;
    }

    /***************************************自我定义的方法***************************************/

    /**
     * @Date 2020/6/1 16:10
     * @Author 胖
     * 微信用户下单
     **/
    private ResultVo WeChatPlaceOrder(UserOrderAndMemberInformation orderAndMemberInformation) {
//        //订单实体类
//        TblOrderPo orderPo = new TblOrderPo();
//        //订单号
//        String orderNumber = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 15);
//        //查询生成出来的订单号是否已存在
//        TblOrderPo tblOrderPo = orderMapper.queryOrderInformation(orderNumber);
//        //赋值订单号
//        if (tblOrderPo == null) {
//            orderPo.setOrderNo(orderNumber);
//        } else {
//            orderNumber = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 15);
//            orderPo.setOrderNo(orderNumber);
//        }
//        //获取UserId
//        Integer userId = getUserId(request.getHeader("token"));
//        //查询门店会员信息
//        MemberInformation memberInformation = orderMapper.queryShopMemberInfromation(userId, orderAndMemberInformation.getShopId());
//        //如果存在则记录会员ID，如果不存在则添加后再记录
//        if (memberInformation != null) {
//            orderPo.setMemberShopId(memberInformation.getId());
//        } else {
//            Integer integer = addShopMemberInformation(userId, orderAndMemberInformation.getShopId());
//            orderPo.setMemberShopId(integer);
//        }
//        orderPo.setOrderStatus(0);                                  //订单状态
//        orderPo.setOrderStatusVice(0);                              //订单副状态
//        orderPo.setAddTime(System.currentTimeMillis());      //订单创建时间
//        orderPo.setShopId(orderAndMemberInformation.getShopId());   //店铺ID
//        orderPo.setUserId(userId);                                  //用户ID
//        //查询用户会员信息
//        MemberInformation member = orderMapper.queryShopMemberInfromation(userId, orderAndMemberInformation.getShopId());
//        GoodsStatistical goodsStatistical = statisticsOfTheNumber(orderAndMemberInformation.getOrderGoodsInformations(), member.getMemberId());
//        //订单的商品总数量
//        orderPo.setGoodsCount(goodsStatistical.getGoodsNumber());
//        //实际需要支付的金额
//        Integer totalAmount = goodsStatistical.getGoodsMoney();
//        //是否使用优惠卷
//        if (orderAndMemberInformation.getCouponsId() != null) {
//            //用户的优惠卷ID
//            Coupons coupons = couponsService.queryCouponInformation(orderAndMemberInformation.getCouponsId());
//            if ("未过期".equals(coupons.getIsLate())) {
//                if (coupons.getMeet() != null) {                    //折扣多少钱
//                    if (totalAmount >= coupons.getMeet()) {
//                        totalAmount = goodsStatistical.getGoodsMoney() - coupons.getReduce();
//                        orderMapper.bindCouponsAndOrder(orderAndMemberInformation.getCouponsId(), orderNumber);
//                    }
//                } else if (coupons.getDiscount() != null) {         //打多少折
//                    totalAmount = goodsStatistical.getGoodsMoney() * coupons.getDiscount();
//                }
//            }
//        }
//        //实际付款金额
//        orderPo.setOrderAmountTotal(totalAmount);
//        //订单的总金额
//        orderPo.setGoodsAmountTotal(goodsStatistical.getGoodsTotalAmount());
//        //运费
//        orderPo.setLogisticsFee(0);
//        //订单类型
//        orderPo.setOrderType(orderAndMemberInformation.getOrderType());
//        //订单的来源
//        orderPo.setOrderChannel(orderAndMemberInformation.getOrderChannel());
//        orderMapper.addOrderInformation(orderPo);
//        //订单商品详细
//        for (OrderGoodsInformation orderGoodsInformation : orderAndMemberInformation.getOrderGoodsInformations()) {
//            orderGoodsService.addOrderGoodsInformation(orderGoodsInformation, userId, orderNumber, orderAndMemberInformation.getShopId());
//        }
//        //收货地址
//        orderDeliveryAddressService.addOrderShippingAddress(orderAndMemberInformation.getUserAddressId(), orderNumber, userId, orderAndMemberInformation.getShopId());
//
//        try {
//            return ResultVo.successResult(creatWxOrder(orderPo, request.getRemoteAddr()));
//        } catch (Exception e) {
        return ResultVo.errorResult();
//        }
    }

    /**
     * @Date 2020/6/2 9:31
     * @Author 胖
     * 员工下单
     **/
    private ResultVo staffPlaceOrder(UserOrderAndMemberInformation orderAndMemberInformation) {
        //shopId
        Integer shopId = HttpUtil.getShopId(request.getHeader("token"));
        //订单号
        String orderNumber = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 16);
        //查询生成出来的订单号是否已存在
        TblOrderPo tblOrderPo = orderMapper.queryOrderInformation(orderNumber);
        //查询用户ID
        Integer userId = orderMapper.queryUser(orderAndMemberInformation.getMemberId());
        //统计订单中商品的数量,价格等
        GoodsStatistical goodsStatistical = statisticsOfTheNumber(orderAndMemberInformation.getOrderGoods(), orderAndMemberInformation.getMemberShopPriceId(), orderAndMemberInformation.getMemberId());
        //订单实体类
        TblOrderPo orderPo = new TblOrderPo();
        if (tblOrderPo == null) {
            orderNumber = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 16);
            orderPo.setOrderNo(orderNumber);
        }
        //订单号
        orderPo.setOrderNo(orderNumber);
        //店铺ID
        orderPo.setShopId(shopId);
        //订单状态
        orderPo.setOrderType(orderAndMemberInformation.getOrderType());
        //订单副状态
        orderPo.setOrderStatusVice(0);
        //订单状态
        orderPo.setOrderStatus(0);
        //实际付款金额
        orderPo.setOrderAmountTotal(goodsStatistical.getGoodsMoney());
        //运费金额
        orderPo.setLogisticsFee(0);
        //商品的总数量
        orderPo.setGoodsCount(goodsStatistical.getGoodsNumber());
        //商品总金额
        orderPo.setGoodsAmountTotal(goodsStatistical.getGoodsTotalAmount());
        //添加的时间
        orderPo.setAddTime(System.currentTimeMillis());
        //订单渠道
        orderPo.setOrderChannel(0);
        //门店会员id
        orderPo.setMemberShopId(orderAndMemberInformation.getMemberId());
        if (orderAndMemberInformation.getMemberId() == 0) {
            orderPo.setUserId(0);
        } else {
            orderPo.setUserId(userId);
        }
        orderMapper.addOrderInformation(orderPo);
        //订单中的商品信息
        for (OrderGoods orderGood : orderAndMemberInformation.getOrderGoods()) {
            orderGoodsService.addIndividualTravelerOrderGoodsInformation(orderGood, orderNumber, shopId, orderAndMemberInformation.getMemberShopPriceId(), orderAndMemberInformation.getMemberId());
        }
        //收货地址
        if (orderAndMemberInformation.getMemberId() != 0) {
            if (orderAndMemberInformation.getIsSince() == 1) {
                orderDeliveryAddressService.addIndividualShippingAddress(orderAndMemberInformation.getMemberShopAddressId(), orderPo.getId());
            }
        }
        //订单员工表
        orderStaffService.addStaffAndOrder(orderNumber);
        addOutboundOrder(orderNumber);
        return ResultVo.successResult(orderNumber);
    }

    /**
     * @Date 2020/6/10 10:48
     * @Author 胖
     * 创建出库单
     **/
    private void addOutboundOrder(String orderNo) {
        OutboundOrderPo outboundOrderPo = new OutboundOrderPo();
        outboundOrderPo.setAddTime(System.currentTimeMillis());
        outboundOrderPo.setGoodsCount(0);
        outboundOrderPo.setOrderNo(orderNo);
        outboundOrderPo.setOutboundOrderChannel(0);
        outboundOrderPo.setOutboundOrderNo(UUID.randomUUID().toString().replace("-", "").substring(0, 12));
        outboundOrderPo.setOutboundOrderStatus(0);
        outboundOrderPo.setOutboundOrderType(0);
        orderMapper.addOutboundOrder(outboundOrderPo);
    }

    /**
     * @Date 2020/6/2 14:33
     * @Author 胖
     * 统计出订单中商品的总数量，总金额，实际付款的金额
     **/
    private GoodsStatistical statisticsOfTheNumber(List<OrderGoods> orderGoods, Integer memberPriceId, Integer memberId) {
        //商品的数量
        int goodsNumber = 0;
        //实际付款金额
        int goodsMoney = 0;
        //商品的总金额
        int goodsTotalAmount = 0;

        for (OrderGoods orderGood : orderGoods) {
            goodsNumber = orderGood.getAmount() + goodsNumber;
            goodsMoney = orderGood.getPrice() * orderGood.getAmount() + goodsMoney;
            GoodsShopPrice shopPrice = orderMapper.queryGoodsIndividualTravelerPrice(orderGood.getGoodsSkuUnitId(), memberPriceId, orderGood.getGoodsSkuId());
            Integer goodsPrice = shopPrice.getPrice();
            goodsTotalAmount = goodsPrice * orderGood.getAmount() + goodsTotalAmount;
        }
        GoodsStatistical goodsStatistical = new GoodsStatistical();
        goodsStatistical.setGoodsMoney(goodsMoney);
        goodsStatistical.setGoodsNumber(goodsNumber);
        goodsStatistical.setGoodsTotalAmount(goodsTotalAmount);
        return goodsStatistical;
    }

    /**
     * @Date 2020/5/13 15:20
     * @Author 胖虎
     * 添加用户会员信息
     **/
    public Integer addShopMemberInformation(Integer curUserId, Integer shopId) {

        //查询用户信息
        UserPojo userPojo = orderMapper.queryUserInformation(curUserId);
        //查询店铺的零售价信息
        ShopMemberPrice memberPrice = orderMapper.queryShopMemberPrice(shopId);
        MemberPojo memberPo = new MemberPojo();
        memberPo.setAddTime(System.currentTimeMillis());        //添加时间
        memberPo.setHeadPortrait(userPojo.getHeadPortrait());          //添加会员头像
        memberPo.setMemberName(userPojo.getUsername());                //添加会员名字
        memberPo.setPhone(userPojo.getPhone());                        //添加会员电话
        memberPo.setShopId(shopId);   //添加店铺ID
        memberPo.setUserId(curUserId);                               //添加用户ID
        memberPo.setMemberId(memberPrice.getId());
        //添加会员信息
        orderMapper.addShopMemberInfromation(memberPo);
        return memberPo.getId();
    }

    /**
     * @Date 2020/6/4 10:55
     * @Author 胖
     * 获取UserId
     **/
    private Integer getUserId(String token) {
        //创建UserId用户全局
        Integer userId = 0;
        //Token中的UserId
        //得到token中的辨识
        String wx = HttpUtil.getWX(token);
        if ("".equals(wx)) {
            userId = HttpUtil.getCurUserId(token);
        } else if ("WX".equals(wx)) {
            userId = orderMapper.queryUserId(HttpUtil.getWXUserId(token));
        }
        return userId;
    }


    /**
     * @Date 2020/5/15 14:15
     * @Author 胖虎
     * 创建微信支付订单
     **/
    public String creatWxOrder(TblOrderPo orderPo, String ip) throws Exception {
        UnifiedOrderParam orderParam = WeChatTransactionParameters(orderPo, ip);
        Map<String, String> result = WXPayment.creatWxOrder(orderParam);
        logger.info(JSONUtil.parseObj(result).toString());
        Integer userId = getUserId(request.getHeader("token"));
        //添加抽奖次数
        orderMapper.addUserLotteryNumber(userId);
        //todo 得到了prepayID (微信生成的预支付会话标识，用于后续前端接口调用中使用，该值有效期为2小时)
        String prepayId = result.get("prepay_id");
        return prepayId;
    }

    public UnifiedOrderParam WeChatTransactionParameters(TblOrderPo orderPo, String ip) {
        String token = request.getHeader("token");
        String wx = HttpUtil.getWX(token);
        WXUserInformation userInformation = null;
        if ("".equals(wx)) {
            userInformation = orderMapper.theUserIDIsQueriedByTheMobilePhoneNumber(null, HttpUtil.getCurUserId(token));
        } else {
            userInformation = orderMapper.theUserIDIsQueriedByTheMobilePhoneNumber(HttpUtil.getWXUserId(token), null);
        }
        UnifiedOrderParam orderParam = new UnifiedOrderParam();
        orderParam.setBody(userInformation.getName() + "购买" + orderPo.getGoodsCount() + "件商品");
        orderParam.setOutTradeNo(orderPo.getOrderNo());
        orderParam.setSpbillCreateIp(ip);
        if (!"".equals(HttpUtil.getWX(token))) {
            orderParam.setTradeType("JSAPI");
        } else {
            orderParam.setTradeType("APP");
        }
        //todo   记得修改通知地址(必须为外网可以访问的)
        orderParam.setNotifyUrl("https://ryy.yingtongquan.com:8088/system/wxPaid");
        orderParam.setSubOpenid(userInformation.getOpenId());
        orderParam.setSubMchId("1565585691");
        orderParam.setTotalFee(orderPo.getOrderAmountTotal());    //单位为分
        return orderParam;
    }
}
