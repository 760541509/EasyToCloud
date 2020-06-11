package com.yingtongquan.order.returnGoods.service.impl;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.checkstand.payment.WXRefund;
import com.yingtongquan.checkstand.pojo.Refund;
import com.yingtongquan.order.returnGoods.entity.TblReturnOrderDeliveryAddressPo;
import com.yingtongquan.order.returnGoods.entity.TblReturnOrderGoodsPo;
import com.yingtongquan.order.returnGoods.entity.TblReturnOrderLogisticsPo;
import com.yingtongquan.order.returnGoods.entity.TblReturnOrderPo;
import com.yingtongquan.order.returnGoods.mapper.TblReturnOrderMapper;
import com.yingtongquan.order.returnGoods.pojo.*;
import com.yingtongquan.order.returnGoods.service.TblReturnOrderService;
import com.yingtongquan.startcommon.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class TblReturnOrderServiceImpl extends ServiceImpl<TblReturnOrderMapper, TblReturnOrderPo> implements TblReturnOrderService {

    private final static Logger log = LoggerFactory.getLogger(TblReturnOrderServiceImpl.class);

    @Resource
    private HttpServletRequest request;
    @Resource
    private TblReturnOrderMapper returnOrderMapper;

    @Override
    public Boolean returnOfTheGoods(ReturnGoods returnGoods) {

        //退货的总数量
        Integer amount = 0;
        //退货的总价钱
        Integer goodsTotalAmount = 0;

        OrderInformation orderInformation = returnOrderMapper.queryOrderInformation(returnGoods.getOrderNo());
        for (ReturnGoodsInformation returnGoodsInformation : returnGoods.getReturnGoodsInformations()) {
            OrderGoodsInformation orderGoodsInformation = returnOrderMapper.queryOrderAllGoodsInformation(returnGoods.getOrderNo(), returnGoodsInformation.getGoodsId());
            //退货的总数量
            amount = returnGoodsInformation.getGoodsAmount() + amount;
            //退货的总价钱（订单中实际付款的价格乘退款的数量）
            goodsTotalAmount = (orderGoodsInformation.getPrice() * returnGoodsInformation.getGoodsAmount()) + goodsTotalAmount;
        }
        MemberInformation memberInformation = returnOrderMapper.queryShopMemberInformation(orderInformation.getUserId(), orderInformation.getShopId());

        String returnOrderNo = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 16);
        TblReturnOrderPo returnOrder = returnOrderMapper.queryReturnOrderInformation(returnOrderNo);

        TblReturnOrderPo returnOrderPo = new TblReturnOrderPo();
        returnOrderPo.setAddTime(System.currentTimeMillis() );
        returnOrderPo.setGoodsAmountTotal(goodsTotalAmount);
        returnOrderPo.setGoodsCount(amount);
        returnOrderPo.setMemberShopId(memberInformation.getId());
        returnOrderPo.setReturnOrderAmountTotal(returnGoods.getRefundAmount());
        returnOrderPo.setReturnOrderChannel(0);
        if (returnOrder == null) {
            returnOrderPo.setReturnOrderNo(returnOrderNo);
        } else {
            returnOrderNo = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 16);
            returnOrderPo.setReturnOrderNo(returnOrderNo);
        }
        returnOrderPo.setReturnOrderStatus(0);
        returnOrderPo.setReturnOrderType(0);
        returnOrderPo.setShopId(returnGoods.getShopId());
        returnOrderPo.setOrderNo(returnGoods.getOrderNo());

//        WXRefund(returnOrderPo, returnGoods.getRefundReason(), returnOrderNo, returnGoods.getOrderNo(), returnGoods.getRefundAmount(), goodsTotalAmount);


        return null;
    }

    @Override
    public Boolean customerReturns(CustomerReturns customerReturns) {
        //退货的总数量
        Integer amount = 0;
        //退货的总价钱
        Integer goodsTotalAmount = 0;
        //退款订单号
        String returnOrderNo = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 16);
        //查询订单号是否存在
        TblReturnOrderPo returnOrder = returnOrderMapper.queryReturnOrderInformation(returnOrderNo);
        //根据订单号查询相对应的信息
        OrderInformation orderInformation = returnOrderMapper.queryOrderInformation(customerReturns.getOrderNo());
        //查询门店会员ID
        MemberInformation memberInformation = null;
        String token = request.getHeader("token");
        String wx = HttpUtil.getWX(token);
        if ("".equals(wx)) {
            memberInformation = returnOrderMapper.queryShopMemberInformation(HttpUtil.getCurUserId(token), orderInformation.getShopId());
        } else {
            memberInformation = returnOrderMapper.queryTheMembershipNumberAccordingToTheWeChatUserID(HttpUtil.getWXUserId(token), orderInformation.getShopId());
        }
        //退货商品的总金额和数量
        for (ReturnGoodsInformation returnGoodsInformation : customerReturns.getReturnGoodsInformations()) {
            OrderGoodsInformation orderGoodsInformation = returnOrderMapper.queryOrderAllGoodsInformation(customerReturns.getOrderNo(), returnGoodsInformation.getGoodsId());
            //退货的总数量
            amount = returnGoodsInformation.getGoodsAmount() + amount;
            //退货的总价钱（订单中实际付款的价格乘退款的数量）
            goodsTotalAmount = (orderGoodsInformation.getPrice() * returnGoodsInformation.getGoodsAmount()) + goodsTotalAmount;
            //记录商品信息
            addItemsInTheReturnForm(returnGoodsInformation, customerReturns.getOrderNo());
        }

        TblReturnOrderPo returnOrderPo = new TblReturnOrderPo();
        returnOrderPo.setOrderNo(customerReturns.getOrderNo());
        if (returnOrder == null) {
            returnOrderPo.setReturnOrderNo(returnOrderNo);
        } else {
            returnOrderNo = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 16);
            returnOrderPo.setReturnOrderNo(returnOrderNo);
        }
        returnOrderPo.setReturnOrderChannel(1);
        returnOrderPo.setAddTime(System.currentTimeMillis() );
        returnOrderPo.setReturnOrderType(0);
        returnOrderPo.setReturnOrderStatus(0);
        returnOrderPo.setShopId(orderInformation.getShopId());
        returnOrderPo.setMemberShopId(memberInformation.getId());
        returnOrderPo.setGoodsCount(amount);
        returnOrderPo.setGoodsAmountTotal(goodsTotalAmount);
        returnOrderPo.setReturnOrderAmountTotal(0);
        return returnOrderMapper.addReturnOrderInformation(returnOrderPo);
    }

    @Override
    public Boolean addReturnOrderInformation(LogisticsInformation logisticsInformation) {
        TblReturnOrderLogisticsPo returnOrderLogisticsPo = new TblReturnOrderLogisticsPo();
        returnOrderLogisticsPo.setAddTime(System.currentTimeMillis() );
        returnOrderLogisticsPo.setLogisticsNo(logisticsInformation.getLogisticsNo());
        returnOrderLogisticsPo.setName(logisticsInformation.getLogisticsName());
        returnOrderLogisticsPo.setReturnOrderNo(logisticsInformation.getReturnOrderNo());
        return returnOrderMapper.addLogisticsInformation(returnOrderLogisticsPo);
    }

    @Override
    public Boolean employeesHandleReturnRequests(ReturnOrderDeliveryAddressInformation returnOrderDeliveryAddressInformation) {

        //退货单号查询信息
        TblReturnOrderPo returnOrderPo = returnOrderMapper.queryReturnOrderInformation(returnOrderDeliveryAddressInformation.getReturnOrderNo());
        //查询门店收货地址
        ShopDeliveryAddress shopDeliveryAddress = returnOrderMapper.queryShopShippingAddress(returnOrderDeliveryAddressInformation.getShopDeliveryAddressId());

        TblReturnOrderDeliveryAddressPo returnOrderDeliveryAddressPo = new TblReturnOrderDeliveryAddressPo();
        returnOrderDeliveryAddressPo.setAddress(shopDeliveryAddress.getAddress());
        returnOrderDeliveryAddressPo.setAddTime(System.currentTimeMillis() );
        returnOrderDeliveryAddressPo.setAreaId(shopDeliveryAddress.getAreaId());
        returnOrderDeliveryAddressPo.setIsSince(1);
        returnOrderDeliveryAddressPo.setName(shopDeliveryAddress.getName());
        returnOrderDeliveryAddressPo.setPhone(shopDeliveryAddress.getPhone());
        returnOrderDeliveryAddressPo.setReturnOrderId(returnOrderPo.getId());
        returnOrderDeliveryAddressPo.setShopDeliveryAddressId(returnOrderDeliveryAddressInformation.getShopDeliveryAddressId());
        returnOrderMapper.addReturnAddress(returnOrderDeliveryAddressPo);
        return returnOrderMapper.modifyTheReturnStatus(returnOrderDeliveryAddressInformation.getReturnOrderNo());
    }

    @Override
    public Boolean employeeReceivesGoods(EmployessReturn employessReturn) {

        if (employessReturn.getRefundReason() == null) {
            employessReturn.setRefundReason("商品退款");
        }
        OrderInformation orderInformation = returnOrderMapper.queryOrderInformation(employessReturn.getOrderNo());

        return WXRefund(employessReturn.getRefundReason(),
                employessReturn.getReturnOrderNo(),
                employessReturn.getOrderNo(),
                employessReturn.getRefundAmount(),
                orderInformation.getOrderAmountTotal());
    }

    @Override
    public List<TblReturnOrderPo> queryAllReturnToApplyFor(Integer shopId) {
        return returnOrderMapper.queryAllShopReturnToApplyFor(shopId);
    }

    /**
     * @Date 2020/5/20 17:34
     * @Author 胖
     * 添加退货单中的商品
     **/
    public Boolean addItemsInTheReturnForm(ReturnGoodsInformation returnGoodsInformation, String returnOrderNo) {

        OrderGoodsInformation orderGoodsInformation = returnOrderMapper.queryOrderAllGoodsInformation(returnOrderNo, returnGoodsInformation.getGoodsId());

        TblReturnOrderGoodsPo returnOrderGoodsPo = new TblReturnOrderGoodsPo();
        Assert.isTrue(returnGoodsInformation.getGoodsAmount() > 0, "退货数量不能为零");
        Assert.isTrue(returnGoodsInformation.getGoodsAmount() <= orderGoodsInformation.getAmount(), "退货数量大于购买数量,请检查是否填写退货数量正确");
        returnOrderGoodsPo.setAmount(returnGoodsInformation.getGoodsAmount());
        returnOrderGoodsPo.setBuyPrice(orderGoodsInformation.getPrice());
        returnOrderGoodsPo.setGoodsSkuUnitId(returnGoodsInformation.getGoodsSkuUnitId());
        returnOrderGoodsPo.setOrderGoodsId(returnGoodsInformation.getGoodsId());
        returnOrderGoodsPo.setPrice(orderGoodsInformation.getPrice());
        returnOrderGoodsPo.setReturnOrderId(orderGoodsInformation.getPrice());
        return returnOrderMapper.addItemsInTheReturnForm(returnOrderGoodsPo);
    }

    /**
     * @Date 2020/5/20 16:01
     * @Author 胖
     * 退款
     **/
    private Boolean WXRefund(String refundDesc, String returnOrderNo, String orderNo, Integer refundFee, Integer totalFee) {
        Refund refund = WeChatRefundParameters(refundDesc, returnOrderNo, orderNo, refundFee, totalFee);
        Map<String, String> result = WXRefund.WXRefund(refund);
        String returnCode = result.get("return_code");
        log.info("微信返回的结果为:" + result);
        if ("SUCCESS".equals(returnCode)) {
            Integer refund_fee = Integer.valueOf(result.get("refund_fee"));
            String refundId = result.get("refund_id");
            String outRefundNo = result.get("out_refund_no");
            returnOrderMapper.completeTheReturnForm(outRefundNo, refundId);
            String rmb = refund_fee / 100 + "." + refund_fee % 100 / 10 + refund_fee % 100 % 10;
            log.info("订单:" + orderNo + "退款" + rmb + "元");
        } else {
            System.out.println("订单:" + orderNo + "退款失败,其原因是:" + result.get("return_msg"));
            log.error("订单:" + orderNo + "退款失败,其原因是:" + result.get("return_msg"));
        }

        return null;
    }

    /**
     * @Date 2020/5/20 16:01
     * @Author 胖
     * 退款参数填写
     **/
    private Refund WeChatRefundParameters(String refundDesc, String returnOrderNo, String orderNo, Integer refundFee, Integer totalFee) {
        Refund refund = new Refund();
        refund.setOutRefundNo(returnOrderNo);
        refund.setOutTradeNo(orderNo);
        refund.setRefundDesc(refundDesc);
        refund.setRefundFee(refundFee);
        refund.setTotalFee(totalFee);
        return refund;
    }

}
