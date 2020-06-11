package com.yingtongquan.order.order.controller;


import com.yingtongquan.order.order.pojo.Infromation;
import com.yingtongquan.order.order.pojo.OrderGoodsInformation;
import com.yingtongquan.order.order.pojo.UserOrderAndMemberInformation;
import com.yingtongquan.order.order.service.TblOrderService;
import com.yingtongquan.startcommon.base.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
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
@RequestMapping("/order/tblOrderPo")
@Api(tags = "订单相关操作")
public class TblOrderController {

    @Resource
    private TblOrderService orderService;
    @Resource
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "添加订单")
    @PostMapping("/addOrder")
    public ResultVo addOrder(@RequestBody UserOrderAndMemberInformation orderAndMemberInformation) {
        return ResultVo.successResult(orderService.addOrderInformation(orderAndMemberInformation));
    }

    @ApiOperation(value = "查询用户所有的订单")
    @PostMapping("/queryUserAllOrder")
    public ResultVo queryUserAllOrder() {
        return ResultVo.successResult(orderService.queryUserAllOrderInformation());
    }

    @ApiOperation(value = "查询某一个订单的详细信息")
    @PostMapping("/queryTheDetailsOfAnOrder")
    public ResultVo queryTheDetailsOfAnOrder(@RequestBody Infromation infromation) {
        return ResultVo.successResult(orderService.queryOrderInformation(infromation.getOrder()));
    }

    @ApiOperation(value = "修改订单信息（注：只能是员工才能使用，顾客是不能使用的）")
    @PostMapping("/modifyOrderInformation")
    public ResultVo modifyOrderInformation(@RequestBody List<OrderGoodsInformation> orderGoodsInformation, String orderNo) {
        return ResultVo.successResult(orderService.updateOrderGoodsInformation(orderGoodsInformation, orderNo));
    }


}
