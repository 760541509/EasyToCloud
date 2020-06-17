package com.yingtongquan.employees.staff.controller;


import com.yingtongquan.employees.staff.entity.TblStaffRolePo;
import com.yingtongquan.employees.staff.pojo.*;
import com.yingtongquan.employees.staff.service.TblStaffRoleService;
import com.yingtongquan.employees.staff.service.TblStaffService;
import com.yingtongquan.startcommon.base.ResultVo;
import com.yingtongquan.startcommon.util.ServiceIn;
import com.yingtongquan.startcommon.util.ServiceUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 前端控制器
 *
 * @author ML
 * @since 2020-05-21
 */
@Api(value = "TblStaffController", tags = "员工/角色相关操作")
@RestController
@RequestMapping("/staff/tblStaffPo")
public class TblStaffController {

    @Resource
    private TblStaffRoleService staffRoleService;
    @Resource
    private TblStaffService staffService;

    @ApiOperation(value = "添加员工")
    @PostMapping("/addStaff")
    public ResultVo addStaff(@RequestBody StaffInforamtion staffInforamtion) {
        return ResultVo.successResult(staffRoleService.addStaffInformation(staffInforamtion));
    }

    @ApiOperation(value = "查询员工信息")
    @PostMapping("queryEmployeeInformation")
    public ResultVo queryEmployeeInformation() {
        return ResultVo.successResult(staffRoleService.queryAllStaffInformation());
    }

    @ApiOperation(value = "删除员工信息")
    @PostMapping("/deleteEmployeeInformation")
    public ResultVo deleteEmployeeInformation(@RequestBody Order order) {
        return ResultVo.successResult(staffRoleService.deleteStaffInformation(order.getStaffId()));
    }

    @ApiOperation(value = "添加角色权限表")
    @PostMapping("/addRolePermissionTable")
    public ResultVo addRolePermissionTable(@RequestBody TblStaffRolePo staffRolePo) {
        staffRoleService.addStaffRole(staffRolePo);
        return ResultVo.successResult();
    }

    @ApiOperation(value = "修改员工权限表")
    @PostMapping("/modifyEmployeePermissionTable")
    public ResultVo modifyEmployeePermissionTable(@RequestBody TblStaffRolePo staffRolePo) {
        return ResultVo.successResult(staffRoleService.updateStaffRole(staffRolePo));
    }

    @ApiOperation(value = "删除员工权限表")
    @PostMapping("/deleteEmployeePermissionTable")
    public ResultVo deleteEmployeePermissionTable(@RequestBody Order order) {
        return ResultVo.successResult(staffRoleService.deleteStaffRole(order.getRoleId()));
    }

    @ApiOperation(value = "查询员工权限表")
    @PostMapping("/queryEmployeePermissionTable")
    public ResultVo queryEmployeePermissionTable() {
        return ResultVo.successResult(staffRoleService.queryShopAllStaffRole());
    }

    @ApiOperation(value = "员工按照状态查询订单")
    @PostMapping("/theEmployeeQueriesTheOrderByStatus")
    public ResultVo theEmployeeQueriesTheOrderByStatus(@RequestBody InquireOrderInfor inquireOrderInfor) {
        return ResultVo.successResult(staffService.theEmployeeQueriesTheOrderByStatus(inquireOrderInfor));
    }

    @ApiOperation(value = "员工查询订单详细")
    @PostMapping("/queryStaffOrderInformation")
    public ResultVo queryStaffOrderInformation(@RequestBody Order order) {
        return ResultVo.successResult(staffService.queryStaffOrderInformation(order));
    }

    @ApiOperation(value = "员工收款")
    @PostMapping("/employeesCollection")
    public ResultVo employeesCollection(@RequestBody StaffCollection staffCollection) {
        return ResultVo.successResult(staffService.employeesCollection(staffCollection));
    }

    @ApiOperation(value = "员工查询需要发货的商品")
    @PostMapping("/queryGoodsInformation")
    public ResultVo queryGoodsInformation(@RequestBody Order order) {
        return ResultVo.successResult(staffService.queryGoodsInformation(order));
    }

    @ApiOperation(value = "派发订单")
    @PostMapping("/distributingOrder")
    public ResultVo distributingOrder(@RequestBody DistributeOrder distributeOrder) {
        return new ServiceUtil().execute(new ServiceIn() {
            @Override
            public Object dataOp() throws Exception {
                return staffService.distributingOrder(distributeOrder);
            }
        });
    }

    @ApiOperation(value = "订单取消")
    @PostMapping("/cancelTheOrder")
    public ResultVo cancelTheOrder(@RequestBody Order order) {
        return ResultVo.successResult(staffService.cancelTheOrder(order));
    }

    @ApiOperation(value = "取消出库")
    @PostMapping("/cancelTheDelivery")
    public ResultVo cancelTheDelivery(@RequestBody Outbound outbound) {
        staffService.cancelTheDelivery(outbound);
        return ResultVo.successResult();
    }

    @ApiOperation(value = "查询出库单")
    @PostMapping("/queryOutbound")
    public ResultVo queryOutbound(@RequestBody Parment parment) {
        return ResultVo.successResult(staffService.queryOutbound(parment));
    }

    @ApiOperation(value = "出库单详情")
    @PostMapping("/queryOutboundInformation")
    public ResultVo queryOutboundInformation(@RequestBody Outbound outbound) {
        return ResultVo.successResult(staffService.queryOutboundInformation(outbound));
    }

    @ApiOperation(value = "员工领单")
    @PostMapping("/staffGetASingle")
    public ResultVo staffGetASingle(@RequestBody Outbound outbound) {
        return ResultVo.successResult(staffService.staffGetASingle(outbound));
    }

    @ApiOperation(value = "员工发货(填写物流信息)")
    @PostMapping("/staffDeliverGoods")
    public ResultVo staffDeliverGoods(@RequestBody DeliveryInformation deliveryInformation) {
        return ResultVo.successResult(staffService.staffDeliverGoods(deliveryInformation));
    }
}
