package com.yingtongquan.employees.spec.controller;


import com.yingtongquan.employees.spec.entity.TblGoodsSpecNamePo;
import com.yingtongquan.employees.spec.pojo.SpecByListInfoVo;
import com.yingtongquan.employees.spec.service.TblGoodsSpecNameService;
import com.yingtongquan.startcommon.base.ResultVo;
import com.yingtongquan.startcommon.util.MyAssert;
import com.yingtongquan.startcommon.util.ServiceUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author ML
* @since 2020-05-14
*/
@RestController
@RequestMapping("/employees/spec/tblGoodsSpecNamePo")
@Api(tags = "商品规格模板相关")
public class TblGoodsSpecNameController {
    @Resource
    private TblGoodsSpecNameService mService;
    private ServiceUtil serviceUtil = new ServiceUtil();

    @ApiOperation(value = "添加")
    @PostMapping("/addInfo")
    public ResultVo add(@RequestBody TblGoodsSpecNamePo.TblGoodsSpecNamePoAddPa info){

        return serviceUtil.execute(() -> {
            MyAssert.notEmpty(info.getName(), "请输入规格名称.");
            MyAssert.notEmpty(info.getGoodsSpecValuePoAddPaList(), "请添加规格属性.");

            return mService.addInfo(info);
        });
    }


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


    @ApiOperation(value = "条件获取一条数据")
    @PostMapping("/getByInfo")
    public ResultVo getByInfo(@RequestBody TblGoodsSpecNamePo.TblGoodsSpecNamePoGetPa info){
        return serviceUtil.execute(() -> mService.getByInfo(info));
    }


    @ApiOperation(value = "条件获取多条数据",notes = "pageValue 第一页传0，下一页传当前最小的upTime")
    @PostMapping("/getListByInfo")
    public ResultVo getListByInfo(@RequestBody SpecByListInfoVo info){

        return serviceUtil.execute(() -> mService.getListByInfo(info));
    }


}
