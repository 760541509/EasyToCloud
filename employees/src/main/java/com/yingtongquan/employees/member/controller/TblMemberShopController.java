package com.yingtongquan.employees.member.controller;


import com.yingtongquan.employees.member.entity.TblMemberPriceShopPo;
import com.yingtongquan.employees.member.pojo.AddShopMember;
import com.yingtongquan.employees.member.pojo.UserInformation;
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

    @ApiOperation("查询所有的会员")
    @PostMapping("/queryAllShopMember")
    public ResultVo queryAllShopMember() {
        return ResultVo.successResult(memberShopService.queryAllShopMember());
    }

    @ApiOperation("店铺添加会员")
    @PostMapping("/addShopMember")
    public ResultVo addShopMember(@RequestBody AddShopMember addShopMember) {
        return ResultVo.successResult(memberShopService.addShopMember(addShopMember));
    }

//    @ApiOperation("修改会员")
//    @PostMapping("/updateShopMember")
//    public ResultVo updateShopMember(@RequestBody UseTheQuery useTheQuery) {
//        return ResultVo.successResult(memberShopService.queryAllShopMember(useTheQuery.getShopId()));
//    }
//
//    @ApiOperation("删除会员")
//    @PostMapping("/deleteShopMember")
//    public ResultVo deleteShopMember(@RequestBody UseTheQuery useTheQuery) {
//        return ResultVo.successResult(memberShopService.queryAllShopMember(useTheQuery.getShopId()));
//    }

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