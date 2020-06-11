//package com.yingtongquan.employees.goods.controller;
//
//
//import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo.*;
//import com.yingtongquan.employees.goods.service.TblGoodsSkuSpecValueService;
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
//* @since 2020-05-30
//*/
//@RestController
//@RequestMapping("/goods/tblGoodsSkuSpecValuePo")
//public class TblGoodsSkuSpecValueController {
//    @Resource
//    private TblGoodsSkuSpecValueService mService;
//
//    @ApiOperation(value = "添加")
//    @PostMapping("/addInfo")
//    public ResultVo addInfo(@RequestBody TblGoodsSkuSpecValuePoAddPa info){
//        return new ServiceUtil().execute(() -> mService.addInfo(info));
//    }
//
//
//    @ApiOperation(value = "修改")
//    @PostMapping("/updateInfo")
//    public ResultVo updateInfo(@RequestBody TblGoodsSkuSpecValuePoUpPa info){
//
//        return new ServiceUtil().execute(() -> mService.updateInfo(info));
//    }
//
//
//    @ApiOperation(value = "删除")
//    @PostMapping("/deleteByInfo")
//    public ResultVo deleteByInfo(@RequestBody TblGoodsSkuSpecValuePoDelPa info){
//
//        return new ServiceUtil().execute(() -> mService.deleteByInfo(info));
//    }
//
//
//    @ApiOperation(value = "条件获取单条数据")
//    @PostMapping("/getByInfo")
//    public ResultVo getByInfo(@RequestBody TblGoodsSkuSpecValuePoGetPa info){
//
//        return new ServiceUtil().execute(() -> mService.getByInfo(info));
//    }
//
//
//    @ApiOperation(value = "条件获取集合数据")
//    @PostMapping("/getListByInfo")
//    public ResultVo getListByInfo(@RequestBody TblGoodsSkuSpecValuePoGetListPa info){
//
//        return new ServiceUtil().execute(() -> mService.getListByInfo(info));
//    }
//
//
//}
