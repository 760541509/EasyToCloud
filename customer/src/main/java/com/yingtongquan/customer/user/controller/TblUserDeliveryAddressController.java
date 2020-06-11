package com.yingtongquan.customer.user.controller;


import com.yingtongquan.customer.user.entity.TblUserDeliveryAddressPo;
import com.yingtongquan.customer.user.pojo.Infromation;
import com.yingtongquan.customer.user.service.TblUserDeliveryAddressService;
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
 * @since 2020-05-11
 */
@RestController
@RequestMapping("/user/tblUserDeliveryAddressPo")
@Api(tags = "用户相关操作")
public class TblUserDeliveryAddressController {

    @Resource
    private TblUserDeliveryAddressService userDeliveryAddressService;

    @ApiOperation(value = "添加用户收货地址")
    @PostMapping("/addUserShippingAddress")
    public ResultVo addUserShippingAddress(@RequestBody TblUserDeliveryAddressPo userDeliveryAddressPo) {
        return ResultVo.successResult(userDeliveryAddressService.addUserShippingAddress(userDeliveryAddressPo));
    }

    @ApiOperation(value = "修改用户收货地址")
    @PostMapping("/updateUserShippingAddress")
    public ResultVo updateUserShippingAddress(@RequestBody TblUserDeliveryAddressPo userDeliveryAddressPo) {
        return ResultVo.successResult(userDeliveryAddressService.updateUserShippingAddress(userDeliveryAddressPo));
    }

    @ApiOperation(value = "查询用户所有收货地址")
    @PostMapping("/queryUserAllShippingAddress")
    public ResultVo queryUserAllShippingAddress(@RequestBody Infromation infromation) {
        return ResultVo.successResult(userDeliveryAddressService.queryAllUserShippingAddress(infromation.getUserId()));
    }

    @ApiOperation(value = "删除用户收货地址")
    @PostMapping("/rmUserShippingAddress")
    public ResultVo rmUserShippingAddress(@RequestBody Infromation infromation) {
        return ResultVo.successResult(userDeliveryAddressService.rmUserShippingAddress(infromation.getAddressId()));
    }


}
