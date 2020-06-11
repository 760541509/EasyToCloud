package com.yingtongquan.employees.brand.controller;


import com.yingtongquan.employees.brand.entity.TblGoodsBrandPo.*;
import com.yingtongquan.employees.brand.service.TblGoodsBrandService;
import com.yingtongquan.startcommon.base.ResultVo;
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
* @since 2020-05-23
*/
@RestController
@RequestMapping("/employees/brand/tblGoodsBrandPo")
@Api(tags = "商品品牌相关")
public class TblGoodsBrandController {
    @Resource
    private TblGoodsBrandService mService;
    private ServiceUtil serviceUtil = new ServiceUtil();

    @ApiOperation(value = "添加")
    @PostMapping("/addInfo")
    public ResultVo addInfo(@RequestBody TblGoodsBrandPoAddPa info){
        return serviceUtil.execute(() -> mService.addInfo(info));
    }


    @ApiOperation(value = "修改")
    @PostMapping("/updateInfo")
    public ResultVo updateInfo(@RequestBody TblGoodsBrandPoUpPa info){

        return serviceUtil.execute(() -> mService.updateInfo(info));
    }


    @ApiOperation(value = "删除")
    @PostMapping("/deleteByInfo")
    public ResultVo deleteByInfo(@RequestBody TblGoodsBrandPoDelPa info){

        return serviceUtil.execute(() -> mService.deleteByInfo(info));
    }


    @ApiOperation(value = "条件获取单条数据")
    @PostMapping("/getByInfo")
    public ResultVo getByInfo(@RequestBody TblGoodsBrandPoGetPa info){

        return serviceUtil.execute(() -> mService.getByInfo(info));
    }


    @ApiOperation(value = "条件获取集合数据")
    @PostMapping("/getListByInfo")
    public ResultVo getListByInfo(@RequestBody TblGoodsBrandPoGetListPa info){

        return serviceUtil.execute(() -> mService.getListByInfo(info));
    }


}
