package com.yingtongquan.employees.goodsClassify.controller;


import com.yingtongquan.employees.goodsClassify.entity.TblGoodsClassifyPo;
import com.yingtongquan.employees.goodsClassify.entity.TblGoodsClassifyPo.*;
import com.yingtongquan.employees.goodsClassify.service.TblGoodsClassifyService;
import com.yingtongquan.startcommon.base.ResultVo;
import com.yingtongquan.startcommon.util.ServiceUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author ML
* @since 2020-05-27
*/
@RestController
@RequestMapping("/employees/goodsClassify/tblGoodsClassifyPo")
@Api(tags = "商品共用分类相关")
public class TblGoodsClassifyController {
    @Resource
    private TblGoodsClassifyService mService;

    @ApiOperation(value = "添加")
    @PostMapping("/addInfo")
    public ResultVo addInfo(@RequestBody TblGoodsClassifyPoAddPa info){
        return new ServiceUtil().execute(() -> mService.addInfo(info));
    }


    @ApiOperation(value = "修改")
    @PostMapping("/updateInfo")
    public ResultVo updateInfo(@RequestBody TblGoodsClassifyPoUpPa info){

        return new ServiceUtil().execute(() -> mService.updateInfo(info));
    }


    @ApiOperation(value = "删除")
    @PostMapping("/deleteByInfo")
    public ResultVo deleteByInfo(@RequestBody TblGoodsClassifyPoDelPa info){

        return new ServiceUtil().execute(() -> mService.deleteByInfo(info));
    }


    @ApiOperation(value = "条件获取单条数据")
    @PostMapping("/getByInfo")
    public ResultVo getByInfo(@RequestBody TblGoodsClassifyPoGetPa info){

        return new ServiceUtil().execute(() -> mService.getByInfo(info));
    }


    @ApiOperation(value = "条件获取集合数据")
    @PostMapping("/getListByInfo")
    public ResultVo getListByInfo(@RequestBody TblGoodsClassifyPoGetListPa info){

        return new ServiceUtil().execute(() -> mService.getListByInfo(info));
    }

    @ApiOperation(value = "获取共用商品一级分类")
    @PostMapping("/getListPrimaryClassification")
    public ResultVo getListPrimaryClassification() {
        return new ServiceUtil().execute(() -> mService.getListPrimaryClassification());
    }

    @ApiOperation(value = "获取共用商品二级和三级分类")
    @PostMapping("/getListSecondAndThreeClassification")
    public ResultVo getListSecondAndThreeClassification(@RequestBody TblGoodsClassifyPoGetListPa info) {
        return new ServiceUtil().execute(() -> {
            List<TblGoodsClassifyPo> secondClassificationList = mService.getListSecondClassification(info.getPrimaryId());
            //组装id
            List<Integer> secondClassificationIdList = new ArrayList<>();
            secondClassificationList.forEach(tblGoodsClassifyPo -> {
                secondClassificationIdList.add(tblGoodsClassifyPo.getId());
            });
            List<TblGoodsClassifyPo> threeClassificationList= mService.getListThreeClassification(secondClassificationIdList);
            //根据 sup_id 分组map
            Map<Integer,List<TblGoodsClassifyPo>> threeClassificationMapList = new HashMap<>();
            threeClassificationList.forEach(tblGoodsClassifyPo -> {
                threeClassificationMapList.computeIfAbsent(tblGoodsClassifyPo.getSupId(), k -> new ArrayList<>());
                threeClassificationMapList.get(tblGoodsClassifyPo.getSupId()).add(tblGoodsClassifyPo);
            });
            //填充二级分类的三级分类集合
            secondClassificationList.forEach(tblGoodsClassifyPo -> tblGoodsClassifyPo.setThirdList(threeClassificationMapList.get(tblGoodsClassifyPo.getId())));
            return secondClassificationList;
        });
    }

}
