package com.yingtongquan.order.returnGoods.controller;


import com.yingtongquan.order.returnGoods.pojo.*;
import com.yingtongquan.order.returnGoods.service.TblReturnOrderService;
import com.yingtongquan.startcommon.base.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
@RestController
@RequestMapping("/returnGoods/tblReturnOrderPo")
@Api(tags = "退货操作")
public class TblReturnOrderController {

    @Resource
    private TblReturnOrderService returnOrderService;

    @ApiOperation(value = "顾客退货")
    @PostMapping("/customerReturns")
    public ResultVo customerReturns(@RequestBody CustomerReturns customerReturns) {
        return ResultVo.successResult(returnOrderService.customerReturns(customerReturns));
    }

    @ApiOperation(value = "员工处理退货申请")
    @PostMapping("/employeesHandleReturnRequests")
    public ResultVo employeesHandleReturnRequests(@RequestBody ReturnOrderDeliveryAddressInformation returnOrderDeliveryAddressInformation) {
        return ResultVo.successResult(returnOrderService.employeesHandleReturnRequests(returnOrderDeliveryAddressInformation));
    }

    @ApiOperation(value = "顾客填写退货地址")
    @PostMapping("/customerFilledOutTheReturnAddress")
    public ResultVo customerFilledOutTheReturnAddress(@RequestBody LogisticsInformation logisticsInformation) {
        return ResultVo.successResult(returnOrderService.addReturnOrderInformation(logisticsInformation));
    }

    @ApiOperation(value = "员工收到货物")
    @PostMapping("/employeeReceivesGoods")
    public ResultVo employeeReceivesGoods(@RequestBody EmployessReturn employessReturn) {
        return ResultVo.successResult(returnOrderService.employeeReceivesGoods(employessReturn));
    }

    @ApiOperation(value = "查询店铺下所有的退款申请")
    @PostMapping("/queryShopAllReturn")
    public ResultVo queryShopAllReturn(@RequestBody ReturnGoods returnGoods) {
        //后面的人如果在这里需要维护，不要疑惑为啥要传这个对象，因为我难得去再去写一个对象了，将就用的
        Integer shopId = returnGoods.getShopId();
        return ResultVo.successResult(returnOrderService.queryAllReturnToApplyFor(shopId));
    }

}
