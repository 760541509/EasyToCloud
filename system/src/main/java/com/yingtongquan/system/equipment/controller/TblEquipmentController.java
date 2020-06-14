package com.yingtongquan.system.equipment.controller;

import com.yingtongquan.startcommon.base.ResultVo;
import com.yingtongquan.system.equipment.pojo.ShopEquipment;
import com.yingtongquan.system.equipment.service.TblEquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/system/equipment")
@Api(tags = "设备管理")
public class TblEquipmentController {

    @Resource
    private TblEquipmentService equipmentService;

    @ApiOperation(value = "添加设备")
    @PostMapping("/addShopEquipment")
    public ResultVo addShopEquipment(@RequestBody ShopEquipment shopEquipment){
        return ResultVo.successResult(equipmentService.addShopEquipment(shopEquipment));
    }

}

