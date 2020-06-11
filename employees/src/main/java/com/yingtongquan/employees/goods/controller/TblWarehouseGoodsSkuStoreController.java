//package com.yingtongquan.employees.goods.controller;
//
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import javax.annotation.Resource;
//import com.yingtongquan.startcommon.base.ResultVo;
//import com.yingtongquan.startcommon.util.JwtUtil;
//import com.yingtongquan.startcommon.util.ServiceUtil;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import io.swagger.annotations.ApiOperation;
//import java.util.Map;
//import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa;
//import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoUpPa;
//import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoDelPa;
//import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoGetPa;
//import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoGetListPa;
//import com.yingtongquan.employees.goods.service.TblWarehouseGoodsSkuStoreService;
//import org.springframework.web.bind.annotation.RestController;
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
//@RequestMapping("/goods/tblWarehouseGoodsSkuStorePo")
//public class TblWarehouseGoodsSkuStoreController {
//    @Resource
//    private TblWarehouseGoodsSkuStoreService mService;
//
//    @ApiOperation(value = "添加")
//    @PostMapping("/addInfo")
//    public ResultVo addInfo(@RequestBody TblWarehouseGoodsSkuStorePoAddPa info){
//        return new ServiceUtil().execute(() -> mService.addInfo(info));
//    }
//
//
//    @ApiOperation(value = "修改")
//    @PostMapping("/updateInfo")
//    public ResultVo updateInfo(@RequestBody TblWarehouseGoodsSkuStorePoUpPa info){
//
//        return new ServiceUtil().execute(() -> mService.updateInfo(info));
//    }
//
//
//    @ApiOperation(value = "删除")
//    @PostMapping("/deleteByInfo")
//    public ResultVo deleteByInfo(@RequestBody TblWarehouseGoodsSkuStorePoDelPa info){
//
//        return new ServiceUtil().execute(() -> mService.deleteByInfo(info));
//    }
//
//
//    @ApiOperation(value = "条件获取单条数据")
//    @PostMapping("/getByInfo")
//    public ResultVo getByInfo(@RequestBody TblWarehouseGoodsSkuStorePoGetPa info){
//
//        return new ServiceUtil().execute(() -> mService.getByInfo(info));
//    }
//
//
//    @ApiOperation(value = "条件获取集合数据")
//    @PostMapping("/getListByInfo")
//    public ResultVo getListByInfo(@RequestBody TblWarehouseGoodsSkuStorePoGetListPa info){
//
//        return new ServiceUtil().execute(() -> mService.getListByInfo(info));
//    }
//
//
//}
