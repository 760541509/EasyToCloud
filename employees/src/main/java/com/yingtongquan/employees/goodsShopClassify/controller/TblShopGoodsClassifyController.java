package com.yingtongquan.employees.goodsShopClassify.controller;


import com.yingtongquan.employees.goodsShopClassify.entity.TblShopGoodsClassifyPo;
import com.yingtongquan.employees.goodsShopClassify.entity.TblShopGoodsClassifyPo.*;
import com.yingtongquan.employees.goodsShopClassify.service.TblShopGoodsClassifyService;
import com.yingtongquan.startcommon.base.ResultVo;
import com.yingtongquan.startcommon.pojo.CommonGetListPa;
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
@RequestMapping("/employees/goodsShopClassify/tblShopGoodsClassifyPo")
@Api(tags = "门店商品分类相关")
public class TblShopGoodsClassifyController {
    @Resource
    private TblShopGoodsClassifyService mService;

    @ApiOperation(value = "添加")
    @PostMapping("/addInfo")
    public ResultVo addInfo(@RequestBody TblShopGoodsClassifyPoAddPa info){
        info.setFkShopId(1);
        return new ServiceUtil().execute(() -> mService.addInfo(info));
    }


    @ApiOperation(value = "修改")
    @PostMapping("/updateInfo")
    public ResultVo updateInfo(@RequestBody TblShopGoodsClassifyPoUpPa info){

        return new ServiceUtil().execute(() -> mService.updateInfo(info));
    }


    @ApiOperation(value = "删除")
    @PostMapping("/deleteByInfo")
    public ResultVo deleteByInfo(@RequestBody TblShopGoodsClassifyPoDelPa info){

        return new ServiceUtil().execute(() -> mService.deleteByInfo(info));
    }


    @ApiOperation(value = "条件获取单条数据")
    @PostMapping("/getByInfo")
    public ResultVo getByInfo(@RequestBody TblShopGoodsClassifyPoGetPa info){

        return new ServiceUtil().execute(() -> mService.getByInfo(info));
    }


    @ApiOperation(value = "条件获取集合数据")
    @PostMapping("/getListByInfo")
    public ResultVo getListByInfo(@RequestBody TblShopGoodsClassifyPoGetListPa info){

        return new ServiceUtil().execute(() -> mService.getListByInfo(info));
    }

    @ApiOperation(value = "获取门店商品一级分类")
    @PostMapping("/getListPrimaryClassification")
    public ResultVo getListPrimaryClassification(@RequestBody CommonGetListPa info) {
        if(info.getFkShopId()==null){
            info.setFkShopId(1);
        }
        return new ServiceUtil().execute(() -> mService.getListPrimaryClassification(info.getFkShopId()));
    }

    @ApiOperation(value = "获取门店商品二级和三级分类")
    @PostMapping("/getListSecondAndThreeClassification")
    public ResultVo getListSecondAndThreeClassification(@RequestBody TblShopGoodsClassifyPoGetListPa info) {
        return new ServiceUtil().execute(() -> {
            List<TblShopGoodsClassifyPo> secondClassificationList = mService.getListSecondClassification(info.getPrimaryId());
            //组装id
            List<Integer> secondClassificationIdList = new ArrayList<>();
            secondClassificationList.forEach(tblGoodsClassifyPo -> {
                secondClassificationIdList.add(tblGoodsClassifyPo.getId());
            });
            List<TblShopGoodsClassifyPo> threeClassificationList = new ArrayList<>();
            if(secondClassificationIdList.size()>0){
                threeClassificationList = mService.getListThreeClassification(secondClassificationIdList);

                //根据 sup_id 分组map
                Map<Integer,List<TblShopGoodsClassifyPo>> threeClassificationMapList = new HashMap<>();
                threeClassificationList.forEach(tblGoodsClassifyPo -> {
                    threeClassificationMapList.computeIfAbsent(tblGoodsClassifyPo.getSupId(), k -> new ArrayList<>());
                    threeClassificationMapList.get(tblGoodsClassifyPo.getSupId()).add(tblGoodsClassifyPo);
                });
                //填充二级分类的三级分类集合
                secondClassificationList.forEach(tblGoodsClassifyPo -> tblGoodsClassifyPo.setThirdList(threeClassificationMapList.get(tblGoodsClassifyPo.getId())));
            }

            return secondClassificationList;
        });
    }

}
