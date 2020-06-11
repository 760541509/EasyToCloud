//package com.yingtongquan.employees.goods.controller;
//
//
//import com.yingtongquan.employees.goods.entity.TblShopGoodsPo.*;
//import com.yingtongquan.employees.goods.service.TblShopGoodsService;
//import com.yingtongquan.startcommon.base.ResultVo;
//import com.yingtongquan.startcommon.util.ServiceUtil;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
//* <p>
//    *  前端控制器
//    * </p>
//*
//* @author ML
//* @since 2020-05-29
//*/
//@RestController
//@RequestMapping("/goods/tblShopGoodsPo")
//public class TblShopGoodsController {
//    @Resource
//    private TblShopGoodsService mService;
//
//    @ApiOperation(value = "添加")
//    @PostMapping("/addInfo")
//    public ResultVo addInfo(@RequestBody TblShopGoodsPoAddPa info){
//        return new ServiceUtil().execute(() -> mService.addInfo(info));
//    }
//
//
//    @ApiOperation(value = "修改")
//    @PostMapping("/updateInfo")
//    public ResultVo updateInfo(@RequestBody TblShopGoodsPoUpPa info){
//
//        return new ServiceUtil().execute(() -> mService.updateInfo(info));
//    }
//
//
//    @ApiOperation(value = "删除")
//    @PostMapping("/deleteByInfo")
//    public ResultVo deleteByInfo(@RequestBody TblShopGoodsPoDelPa info){
//
//        return new ServiceUtil().execute(() -> mService.deleteByInfo(info));
//    }
//
//
//    @ApiOperation(value = "条件获取单条数据")
//    @PostMapping("/getByInfo")
//    public ResultVo getByInfo(@RequestBody TblShopGoodsPoGetPa info){
//
//        return new ServiceUtil().execute(() -> mService.getByInfo(info));
//    }
//
//
//    @ApiOperation(value = "条件获取集合数据")
//    @PostMapping("/getListByInfo")
//    public ResultVo getListByInfo(@RequestBody TblShopGoodsPoGetListPa info){
//
//        return new ServiceUtil().execute(() -> mService.getListByInfo(info));
//    }
//
//
//}
