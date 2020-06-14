package com.yingtongquan.order.outbound.controller;


import com.yingtongquan.order.outbound.pojo.OutInformation;
import com.yingtongquan.order.outbound.pojo.OutboundOrderGoods;
import com.yingtongquan.order.outbound.pojo.OutboundOrderShippingAddress;
import com.yingtongquan.order.outbound.service.*;
import com.yingtongquan.startcommon.base.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
@RestController
@RequestMapping("/outbound/tblOutboundOrderPo")
@Api(tags = "员工商品出库,暂时废弃,以后视情况修改启用")
public class TblOutboundOrderController {

    @Resource
    private TblOutboundOrderService outboundOrderService;
    @Resource
    private TblOutboundOrderDeliveryAddressService outboundOrderDeliveryAddressService;
    @Resource
    private TblOutboundOrderGoodsService outboundOrderGoodsService;
    @Resource
    private TblOutboundOrderLogisticsService outboundOrderLogisticsService;
    @Resource
    private TblOutboundOrderStaffService outboundOrderStaffService;

    @ApiOperation(value = "查询有哪些订单需要出库")
    @PostMapping("/inquireWhichOrdersNeedToBeShippedOut")
    public ResultVo inquireWhichOrdersNeedToBeShippedOut(@RequestBody OutInformation.OutInformationQuery outInformationQuery) {
        return ResultVo.successResult(outboundOrderService.inquireWhichOrdersNeedToBeShippedOut(outInformationQuery.getShopId(), outInformationQuery.getGoodsCount()));
    }

    @ApiOperation(value = "选择订单出库")
    @PostMapping("/selectOrderOutbound")
    public ResultVo selectOrderOutbound(@RequestBody OutInformation.OutInformationOrder outInformationOrder, @RequestBody List<OutboundOrderGoods> outboundOrderGoods) {
        return ResultVo.successResult(outboundOrderService.selectOrderOutbound(outInformationOrder.getOrderNo(), outboundOrderGoods));
    }

    @ApiOperation(value = "填写出库订单的收货地址")
    @PostMapping("/fillInTheShippingAddress")
    public ResultVo fillInTheShippingAddress(@RequestBody OutInformation.OutInformationOutOrder outInformationOutOrder) {
        return ResultVo.successResult(outboundOrderService.fillInTheShippingAddress(outInformationOutOrder.getOutboundOrderNo()));
    }

    @ApiOperation(value = "填写出库物流表")
    @PostMapping("/fillInTheOutboundLogisticsForm")
    public ResultVo fillInTheOutboundLogisticsForm(@RequestBody OutboundOrderShippingAddress outboundOrderShippingAddress) {
        return ResultVo.successResult(outboundOrderLogisticsService.fillInTheOutboundLogisticsForm(outboundOrderShippingAddress));
    }

    @ApiOperation(value = "根据订单号查询相对应的出库信息")
    @PostMapping("/queryTheCorrespondingOutboundInformationAccordingToTheOrderNumber")
    public ResultVo queryTheCorrespondingOutboundInformationAccordingToTheOrderNumber(@RequestBody OutInformation.OutInformationOrder outInformationOrder) {
        return ResultVo.successResult(outboundOrderService.queryTheoutboundinformation(outInformationOrder.getOrderNo()));
    }

    @ApiOperation(value = "查看某个用户所有出库的订单")
    @PostMapping("/viewAllOfAUserOrders")
    public ResultVo viewAllOfAUserOrders() {
        return ResultVo.successResult(outboundOrderService.viewAllOfTheUserOrders());
    }

}
