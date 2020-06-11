package com.yingtongquan.checkstand.payment;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import com.yingtongquan.checkstand.dao.CheckstandDao;
import com.yingtongquan.checkstand.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class WXPaid {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private CheckstandDao checkstandDao;

    public String wxPaid(Map<String, String> param) throws Exception {
        String outTradeNo = param.get("out_trade_no");
        OrderInformation orderInformation = checkstandDao.queryOrder(outTradeNo);
        //员工的总提成
        Integer moneyEmployeesGet = 0;
        List<OrderGoodsInformation> orderGoodsInformations = checkstandDao.queryOrderAllGoodsInformation(orderInformation.getId());
        String mchKey = "967c2d9020274c93989d78498a103824";
        // 验证消息准确性
        if (WXPayUtil.isSignatureValid(param, mchKey)) {
            StaticLog.info(JSONUtil.parseObj(param).toString());
            String resultCode = param.get("result_code");
            if (WXPayConstants.SUCCESS.equals(resultCode)) {
                //计算员工的提成和减少对应商品的数量
                for (OrderGoodsInformation orderGoodsInformation : orderGoodsInformations) {
                    moneyEmployeesGet = (orderGoodsInformation.getPrice() * orderGoodsInformation.getAmount()) * (orderGoodsInformation.getStaffCommissionRate() / 100) + moneyEmployeesGet;
                    reduceTheQuantityOfGoods(orderGoodsInformation.getShopGoodsId(), orderGoodsInformation.getGoodsSkuId(), orderGoodsInformation.getGoodsSkuUnitId(), orderGoodsInformation.getAmount(), orderGoodsInformation.getId());
                }
                String totalFee = param.get("total_fee");            //支付的金额
                String timeEnd = param.get("time_end");              //支付完成的时间
                String transactionId = param.get("transaction_id"); //微信支付订单号
                OrderStaff orderStaff = new OrderStaff();
                orderStaff.setAddTime(System.currentTimeMillis() / 1000);
                orderStaff.setCommissionAmount(moneyEmployeesGet);
                orderStaff.setOrderId(orderInformation.getId());
                orderStaff.setStaffId(orderInformation.getOrderChannel());
                checkstandDao.addOrderThoseResponsible(orderStaff);
                checkstandDao.updateOrderPaymentStatus(orderInformation.getOrderNo());
                addOrderDeal(orderInformation.getId(), timeEnd, Integer.valueOf(totalFee), 1, transactionId);
                logger.info("订单号" + orderInformation.getOrderNo() + "支付成功了。。。。");
            }
            return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml> ";
        }
        return "";
    }

    public void addOrderDeal(Integer orderId, String timeEnd, Integer totalFee, Integer payWay, String serialNo) {
        OrderDeal orderDeal = new OrderDeal();
        orderDeal.setAddTime(Long.valueOf(timeEnd));
        orderDeal.setOrderId(orderId);
        orderDeal.setPayAmount(totalFee);
        orderDeal.setPayWay(payWay);
        orderDeal.setSerialNo(serialNo);
        checkstandDao.addOrderDeal(orderDeal);
    }

    public void reduceTheQuantityOfGoods(Integer shopGoodsId, Integer goodsSkuId, Integer goodsSkuUnitId, Integer goodsQuantity, Integer id) {

        //查询商品与仓库的关联关系
        OrderGoodsQuantity orderGoodsQuantity = checkstandDao.queryGoodsInventory(shopGoodsId);
        //通过上一步查询出来的关系ID和商品ID查询商品的库存
        WarehouseGoodsInventory warehouseGoodsInventory = checkstandDao.inquireTheRemainingInventoryOfTheGoods(goodsSkuId, orderGoodsQuantity.getId());
        //查询出商品的单位具体是多少个基本单位
        GoodsSpuUnit goodsSpuUnit = checkstandDao.queryNumber(goodsSkuUnitId);
        //计算出订单中商品需要的具体数量
        int quantity = goodsSpuUnit.getAmount() * goodsQuantity;
        //库存的减少(剩余的库存)
        Integer surplusStock = warehouseGoodsInventory.getStore() - quantity;
        if (surplusStock >= 0) {
            checkstandDao.updateGoodsInventory(surplusStock, goodsSkuId, orderGoodsQuantity.getId());
        } else {

            checkstandDao.updateOrderGoodsStatus(warehouseGoodsInventory.getStore() - quantity, id);
        }
    }


}
