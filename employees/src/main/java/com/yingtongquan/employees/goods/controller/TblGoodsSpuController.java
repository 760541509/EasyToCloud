package com.yingtongquan.employees.goods.controller;


import com.yingtongquan.employees.goods.entity.TblGoodsSpuPo.*;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo;
import com.yingtongquan.employees.goods.service.TblGoodsSpuService;
import com.yingtongquan.startcommon.base.ResultVo;
import com.yingtongquan.startcommon.util.ServiceUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author ML
* @since 2020-05-29
*/
@RestController
@RequestMapping("/employees/goods/tblGoodsSpuPo")
@Api(tags = "商品信息相关")
public class TblGoodsSpuController {
    @Resource
    private TblGoodsSpuService mService;

    @ApiOperation(value = "添加")
    @PostMapping("/addInfo")
    public ResultVo addInfo(@RequestBody TblGoodsSpuPoAddPa info){

        return new ServiceUtil().execute(() -> {
            mService.addInfo(info);
            if(info.getId()==null||info.getId()==0){
                return false;
            }
            else{
                return info.getId();
            }
        });
    }


    @ApiOperation(value = "修改")
    @PostMapping("/updateInfo")
    public ResultVo updateInfo(@RequestBody TblGoodsSpuPoUpPa info){

        return new ServiceUtil().execute(() -> mService.updateInfo(info));
    }


    @ApiOperation(value = "删除")
    @PostMapping("/deleteByInfo")
    public ResultVo deleteByInfo(@RequestBody TblGoodsSpuPoDelPa info){

        return new ServiceUtil().execute(() -> mService.deleteByInfo(info));
    }


    @ApiOperation(value = "条件获取单条数据")
    @PostMapping("/getByInfo")
    public ResultVo getByInfo(@RequestBody TblGoodsSpuPoGetPa info){

        return new ServiceUtil().execute(() -> mService.getByInfo(info));
    }


    @ApiOperation(value = "条件获取集合数据")
    @PostMapping("/getListByInfo")
    public ResultVo getListByInfo(@RequestBody TblGoodsSpuPoGetListPa info){

        return new ServiceUtil().execute(() -> mService.getListByInfo(info));
    }

    @ApiOperation(value = "条件商品的sku信息数据")
    @PostMapping("/getSkuListByGoodsId")
    public ResultVo getSkuListByGoodsId(@RequestBody TblGoodsSpuPoGetPa info){

        return new ServiceUtil().execute(() -> mService.getSkuListByGoodsId(info));
    }


    @ApiOperation(value = "入库到门店")
    @PostMapping("/addShopGoodsSkuStore")
    public ResultVo addShopGoodsSkuStore(@RequestBody List<TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa> info){

        return new ServiceUtil().execute(() -> mService.addShopGoodsSkuStore(info));
    }

    @ApiOperation(value = "入库到仓库")
    @PostMapping("/addWarehouseGoodsSkuStore")
    public ResultVo addWarehouseGoodsSkuStore(@RequestBody List<TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa> info){

        return new ServiceUtil().execute(() -> mService.addWarehouseGoodsSkuStore(info));
    }

}
