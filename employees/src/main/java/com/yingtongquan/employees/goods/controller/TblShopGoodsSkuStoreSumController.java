//package com.yingtongquan.employees.goods.controller;
//
//
//import com.wly.commons.entity.ResultVo;
//import com.wly.commons.util.ServiceUtil;
//import com.wly.goods.goods.entity.TblShopGoodsSkuStoreSumPo.*;
//import com.wly.goods.goods.service.TblShopGoodsSkuStoreSumService;
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
//* @since 2020-06-10
//*/
//@RestController
//@RequestMapping("/goods/tblShopGoodsSkuStoreSumPo")
//public class TblShopGoodsSkuStoreSumController {
//    @Resource
//    private TblShopGoodsSkuStoreSumService mService;
//    private ServiceUtil serviceUtil = new ServiceUtil();
//
//    @ApiOperation(value = "添加")
//    @PostMapping("/addInfo")
//    public ResultVo addInfo(@RequestBody TblShopGoodsSkuStoreSumPoAddPa info){
//        return serviceUtil.execute(() -> mService.addInfo(info));
//    }
//
//
//    @ApiOperation(value = "修改")
//    @PostMapping("/updateInfo")
//    public ResultVo updateInfo(@RequestBody TblShopGoodsSkuStoreSumPoUpPa info){
//
//        return serviceUtil.execute(() -> mService.updateInfo(info));
//    }
//
//
//    @ApiOperation(value = "删除")
//    @PostMapping("/deleteByInfo")
//    public ResultVo deleteByInfo(@RequestBody TblShopGoodsSkuStoreSumPoDelPa info){
//
//        return serviceUtil.execute(() -> mService.deleteByInfo(info));
//    }
//
//
//    @ApiOperation(value = "条件获取单条数据")
//    @PostMapping("/getByInfo")
//    public ResultVo getByInfo(@RequestBody TblShopGoodsSkuStoreSumPoGetPa info){
//
//        return serviceUtil.execute(() -> mService.getByInfo(info));
//    }
//
//
//    @ApiOperation(value = "条件获取集合数据")
//    @PostMapping("/getListByInfo")
//    public ResultVo getListByInfo(@RequestBody TblShopGoodsSkuStoreSumPoGetListPa info){
//
//        return serviceUtil.execute(() -> mService.getListByInfo(info));
//    }
//
//
//}
