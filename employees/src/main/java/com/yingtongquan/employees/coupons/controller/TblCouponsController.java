package com.yingtongquan.employees.coupons.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.coupons.service.TblCouponsService;
import com.yingtongquan.employees.coupons.entity.TblCouponsPo;
    import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
/**
*  前端控制器
* @author ML
* @since 2020-06-05
*/
@Api(value="TblCouponsController",tags="")
    @RestController
@RequestMapping("/coupons/tblCouponsPo")
public class TblCouponsController {

    @Resource
    private TblCouponsService TblCouponsService;


    }
