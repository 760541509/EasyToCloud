package com.yingtongquan.startcommon.address.controller;


import com.yingtongquan.startcommon.address.entity.TblAreaPo;
import com.yingtongquan.startcommon.address.service.TblAreaService;
import com.yingtongquan.startcommon.base.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 地区码表 前端控制器
 * </p>
 *
 * @author Pang
 * @since 2020-05-11
 */
@RestController
@RequestMapping("/address/tblAreaPo")
@Api(tags = "地址查询")
public class TblAreaController {


    @Resource
    private TblAreaService areaService;
    @Resource
    private RedisTemplate redisTemplate;


    @ApiOperation(value = "查询所有的省级单位")
    @PostMapping("/queryAllProvincial")
    public ResultVo queryAllProvincial() {
        Boolean hasKey = redisTemplate.hasKey("Provincial");
        if (hasKey) {
            return ResultVo.successResult(redisTemplate.opsForList().range("Provincial", 0, -1));
        } else {
            List<TblAreaPo> tblAreaPos = areaService.queryAllProvincial();
            redisTemplate.opsForList().rightPushAll("Provincial", tblAreaPos);
            return ResultVo.successResult(tblAreaPos);
        }
    }

    @ApiOperation(value = "查询省级下面所有的市级单位")
    @PostMapping("/queryAllMunicipalUnitsBelowTheProvincialLevel")
    public ResultVo queryAllMunicipalUnitsBelowTheProvincialLevel(@RequestBody TblAreaPo tblAreaPo) {
//        Boolean hasKey = redisTemplate.hasKey("City");
//        if(hasKey){
//            return ResultVo.successResult(redisTemplate.opsForList().range("City",0,-1));
//        }else {
            List<TblAreaPo> tblAreaPos = areaService.queryAllCitiesBelowTheProvincialLevel(tblAreaPo.getParentId());
//            redisTemplate.opsForList().rightPushAll("City",tblAreaPos);
            return ResultVo.successResult(tblAreaPos);
//        }
    }

    @ApiOperation(value = "查询市级下面所有的区/县")
    @PostMapping("/querAllDistrictsOrCountiesBelowTheCityLevel")
    public ResultVo querAllDistrictsOrCountiesBelowTheCityLevel(@RequestBody TblAreaPo tblAreaPo) {
        return ResultVo.successResult(areaService.queryAllDistrictsBelowCityLevel(tblAreaPo.getParentId()));
    }

}
