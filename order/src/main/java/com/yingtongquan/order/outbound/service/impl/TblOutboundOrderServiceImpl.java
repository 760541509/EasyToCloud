package com.yingtongquan.order.outbound.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.yingtongquan.order.order.entity.TblOrderPo;
import com.yingtongquan.order.outbound.entity.TblOutboundOrderPo;
import com.yingtongquan.order.outbound.mapper.TblOutboundOrderMapper;
import com.yingtongquan.order.outbound.pojo.OutboundOrderGoods;
import com.yingtongquan.order.outbound.pojo.OutboundOrderInformation;
import com.yingtongquan.order.outbound.pojo.UserInformation;
import com.yingtongquan.order.outbound.service.TblOutboundOrderDeliveryAddressService;
import com.yingtongquan.order.outbound.service.TblOutboundOrderGoodsService;
import com.yingtongquan.order.outbound.service.TblOutboundOrderService;
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
 * @author Pang
 * @since 2020-05-12
 */
@Service
public class TblOutboundOrderServiceImpl extends ServiceImpl<TblOutboundOrderMapper, TblOutboundOrderPo> implements TblOutboundOrderService {

    @Resource
    private HttpServletRequest request;
    @Resource
    private TblOutboundOrderMapper outboundOrderMapper;
    @Resource
    private TblOutboundOrderGoodsService outboundOrderGoodsService;
    @Resource
    private TblOutboundOrderDeliveryAddressService outboundOrderDeliveryAddressService;

    @Override
    public List<TblOrderPo> inquireWhichOrdersNeedToBeShippedOut(Integer shopId, Integer goodsCount) {
        List<TblOrderPo> tblOrderPos = outboundOrderMapper.queryShopAllOutgoingOrdersAreRequired(shopId);
        for (TblOrderPo tblOrderPo : tblOrderPos) {
            TblOutboundOrderPo outboundOrderPo = new TblOutboundOrderPo();
            outboundOrderPo.setAddTime(System.currentTimeMillis());
            outboundOrderPo.setGoodsCount(goodsCount);
            outboundOrderPo.setOutboundOrderChannel(HttpUtil.getCurUserId(request.getHeader("token")));
            outboundOrderPo.setOutboundOrderNo(UUID.randomUUID().toString().replace("-", "").substring(16).toUpperCase());
            outboundOrderPo.setOutboundOrderStatus(0);
            outboundOrderPo.setOutboundOrderType(0);
            outboundOrderPo.setOrderNo(tblOrderPo.getOrderNo());
            outboundOrderMapper.addOutboundOrder(outboundOrderPo);
        }
        return tblOrderPos;
    }

    @Override
    public Boolean selectOrderOutbound(String outboundOrderNo, List<OutboundOrderGoods> outboundOrderGoods) {
        //查询出库信息
        TblOutboundOrderPo outboundOrderPo = outboundOrderMapper.queryOutboundOrderInformation(outboundOrderNo);
        //填写出库商品信息
        outboundOrderGoodsService.addOutboundOrderGoods(outboundOrderPo.getId(), outboundOrderPo.getOrderNo(), outboundOrderGoods);
        //修改出库订单状态
        outboundOrderMapper.modifyTheOutboundSingleState(outboundOrderPo.getOrderNo());
        //修改订单状态
        return outboundOrderMapper.modifyOrderStatus(outboundOrderPo.getOrderNo());
    }

    @Override
    public Boolean fillInTheShippingAddress(String outboundOrderNo) {
        outboundOrderDeliveryAddressService.addOutboundOrderShippingAddress(outboundOrderNo);
        return true;
    }

    @Override
    public OutboundOrderInformation queryTheoutboundinformation(String orderNo) {
        OutboundOrderInformation outboundOrderInformation = outboundOrderMapper.queryTheOutboundInformation(orderNo);
        List<OutboundOrderGoods> outboundOrderGoods = outboundOrderMapper.queryTheCommodityInformationInTheOutboundList(outboundOrderInformation.getId());
        outboundOrderInformation.setOutboundOrderGoods(outboundOrderGoods);
        return outboundOrderInformation;
    }

    @Override
    public List<OutboundOrderInformation> viewAllOfTheUserOrders() {
        String token = request.getHeader("token");
        String wx = HttpUtil.getWX(token);
        List<OutboundOrderInformation> outboundOrderInformations = Lists.newArrayList();
        if ("".equals(wx)) {
            List<TblOrderPo> tblOrderPos = outboundOrderMapper.queryUserAllOrder(HttpUtil.getCurUserId(token));
            for (TblOrderPo tblOrderPo : tblOrderPos) {
                OutboundOrderInformation outboundOrderInformation = outboundOrderMapper.queryTheOutboundInformation(tblOrderPo.getOrderNo());
                List<OutboundOrderGoods> outboundOrderGoods = outboundOrderMapper.queryTheCommodityInformationInTheOutboundList(outboundOrderInformation.getId());
                outboundOrderInformation.setOutboundOrderGoods(outboundOrderGoods);
                outboundOrderInformations.add(outboundOrderInformation);
            }
        } else if ("WX".equals(wx)) {
            UserInformation userInformation = outboundOrderMapper.queryWithWeChatUserID(HttpUtil.getWXUserId(token));
            List<TblOrderPo> tblOrderPos = outboundOrderMapper.queryUserAllOrder(userInformation.getId());
            for (TblOrderPo tblOrderPo : tblOrderPos) {
                OutboundOrderInformation outboundOrderInformation = outboundOrderMapper.queryTheOutboundInformation(tblOrderPo.getOrderNo());
                List<OutboundOrderGoods> outboundOrderGoods = outboundOrderMapper.queryTheCommodityInformationInTheOutboundList(outboundOrderInformation.getId());
                outboundOrderInformation.setOutboundOrderGoods(outboundOrderGoods);
                outboundOrderInformations.add(outboundOrderInformation);
            }
        }
        return outboundOrderInformations;
    }
}
