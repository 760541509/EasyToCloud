package com.yingtongquan.employees.staff.controller;


import com.yingtongquan.employees.staff.entity.TblStaffRolePo;
import com.yingtongquan.employees.staff.pojo.InquireOrderInfor;
import com.yingtongquan.employees.staff.pojo.StaffInforamtion;
import com.yingtongquan.employees.staff.service.TblStaffRoleService;
import com.yingtongquan.employees.staff.service.TblStaffService;
import com.yingtongquan.startcommon.base.ResultVo;
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
    public ResultVo queryEmployeeInformation(Integer shopId) {
        return ResultVo.successResult(staffRoleService.queryAllStaffInformation(shopId));
    }

    @ApiOperation(value = "删除员工信息")
    @PostMapping("/deleteEmployeeInformation")
    public ResultVo deleteEmployeeInformation(Integer staffId) {
        return ResultVo.successResult(staffRoleService.deleteStaffInformation(staffId));
    }

    @ApiOperation(value = "添加角色权限表")
    @PostMapping("/addRolePermissionTable")
    public ResultVo addRolePermissionTable(TblStaffRolePo staffRolePo) {
        staffRoleService.addStaffRole(staffRolePo);
        return ResultVo.successResult();
    }

    @ApiOperation(value = "修改员工权限表")
    @PostMapping("/modifyEmployeePermissionTable")
    public ResultVo modifyEmployeePermissionTable(TblStaffRolePo staffRolePo) {
        return ResultVo.successResult(staffRoleService.updateStaffRole(staffRolePo));
    }

    @ApiOperation(value = "删除员工权限表")
    @PostMapping("/deleteEmployeePermissionTable")
    public ResultVo deleteEmployeePermissionTable(Integer roleId) {
        return ResultVo.successResult(staffRoleService.deleteStaffRole(roleId));
    }

    @ApiOperation(value = "查询员工权限表")
    @PostMapping("/queryEmployeePermissionTable")
    public ResultVo queryEmployeePermissionTable(Integer shopId) {
        return ResultVo.successResult(staffRoleService.queryShopAllStaffRole(shopId));
    }

    @ApiOperation(value = "员工按照状态查询订单")
    @PostMapping("/theEmployeeQueriesTheOrderByStatus")
    public ResultVo theEmployeeQueriesTheOrderByStatus(@RequestBody InquireOrderInfor inquireOrderInfor) {
        return ResultVo.successResult(staffService.theEmployeeQueriesTheOrderByStatus(inquireOrderInfor.getStatus()));
    }
}
