//package com.yingtongquan.employees.spec.controller;
//
//import com.yingtongquan.employees.spec.service.TblGoodsSpecValueService;
//import com.yingtongquan.startcommon.base.ResultVo;
//import com.yingtongquan.startcommon.util.MyAssert;
//import com.yingtongquan.startcommon.util.ServiceUtil;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.Map;
//
///**
//* <p>
//    *  前端控制器
//    * </p>
//*
//* @author ML
//* @since 2020-05-14
//*/
//@RestController
//@RequestMapping("/employees/spec/tblGoodsSpecValuePo")
//@Api(tags = "商品规格值相关")
//public class TblGoodsSpecValueController {
//    @Resource
//    private TblGoodsSpecValueService mService;
//    private ServiceUtil serviceUtil = new ServiceUtil();
//
//    @ApiOperation(value = "添加")
//    @PostMapping("/add")
//    public ResultVo add(@RequestBody Map<String ,Object> info){
//
//        return serviceUtil.execute(() -> {
//            MyAssert.notEmpty(info.get("fkGoodsSpecNameId"), "请选择规格名称");
//            MyAssert.notEmpty(info.get("name"), "请输入规格值");
//            return mService.add(info);
//        });
//    }
//
//
//    @ApiOperation(value = "修改")
//    @PostMapping("/update")
//    public ResultVo update(@RequestBody Map<String ,Object> info){
//
//        return serviceUtil.execute(() -> mService.update(info));
//    }
//
//
//    @ApiOperation(value = "删除")
//    @PostMapping("/deleteByInfo")
//    public ResultVo deleteByInfo(@RequestBody Map<String ,Object> info){
//
//        return serviceUtil.execute(() -> mService.deleteByInfo(info));
//    }
//
//
//    @ApiOperation(value = "条件获取一条数据")
//    @PostMapping("/getByInfo")
//    public ResultVo getByInfo(@RequestBody Map<String ,Object> info){
//
//        return serviceUtil.execute(() -> mService.getByInfo(info));
//    }
//
//
//    @ApiOperation(value = "条件获取多条数据")
//    @PostMapping("/getListByInfo")
//    public ResultVo getListByInfo(@RequestBody Map<String ,Object> info){
//
//        return serviceUtil.execute(() -> mService.getListByInfo(info));
//    }
//
//
//}
