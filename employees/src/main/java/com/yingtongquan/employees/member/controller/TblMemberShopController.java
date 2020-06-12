package com.yingtongquan.employees.member.controller;


import com.yingtongquan.employees.member.entity.TblMemberPriceShopPo;
import com.yingtongquan.employees.member.pojo.*;
import com.yingtongquan.employees.member.service.TblMemberDeliveryAddressShopService;
import com.yingtongquan.employees.member.service.TblMemberPriceShopService;
import com.yingtongquan.employees.member.service.TblMemberShopService;
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
@Api(tags = "门店会员")
@RestController
@RequestMapping("/member/tblMemberShopPo")
public class TblMemberShopController {
    @Resource
    private TblMemberShopService memberShopService;
    @Resource
    private TblMemberPriceShopService memberPriceShopService;
    @Resource
    private TblMemberDeliveryAddressShopService memberDeliveryAddressShopService;

    @ApiOperation("查询所有的会员")
    @PostMapping("/queryAllShopMember")
    public ResultVo queryAllShopMember(@RequestBody UseTheQuery useTheQuery) {
        return ResultVo.successResult(memberShopService.queryAllShopMember(useTheQuery));
    }

    @ApiOperation("店铺添加会员")
    @PostMapping("/addShopMember")
    public ResultVo addShopMember(@RequestBody AddShopMember addShopMember) {
        return ResultVo.successResult(memberShopService.addShopMember(addShopMember));
    }

    @ApiOperation("添加会员收货地址")
    @PostMapping("/addMemberShippingAddress")
    public ResultVo addMemberShippingAddress(@RequestBody MemberAddress memberAddress) {
        return ResultVo.successResult(memberDeliveryAddressShopService.addMemberAddress(memberAddress));
    }

    @ApiOperation("查询会员详细")
    @PostMapping("/queryMemberInfromation")
    public ResultVo queryMemberInfromation(@RequestBody QueryMemberInformation memberInformation) {
        return ResultVo.successResult(memberShopService.queryMemberInformation(memberInformation));
    }

    @ApiOperation("修改门店会员价格表")
    @PostMapping("/updateStoreMemberPrice")
    public ResultVo updateStoreMemberPrice(@RequestBody TblMemberPriceShopPo memberPriceShopPo) {
        return ResultVo.successResult(memberPriceShopService.updateShopMemberPrice(memberPriceShopPo));
    }

    @ApiOperation("查询门店所有以开启的会员价格表")
    @PostMapping("/queryStoreOpenAllMember")
    public ResultVo queryStoreOpenAllMember() {
        return ResultVo.successResult(memberPriceShopService.queryShopAllMemberprice());
    }

    @ApiOperation("查询门店所有的会员价格表")
    @PostMapping("/queryShopAllMember")
    public ResultVo queryShopAllMember() {
        return ResultVo.successResult(memberPriceShopService.queryShopAllMember());
    }

    @ApiOperation("关闭门店会员价格表")
    @PostMapping("/shutShopMember")
    public ResultVo shutShopMember(@RequestBody UserInformation userInformation) {
        return ResultVo.successResult(memberPriceShopService.updateShopAllMemberprice(userInformation.getId()));
    }

}