package com.yingtongquan.order.coupons.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import com.yingtongquan.order.coupons.service.TblCouponsService;
    import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
/**
*  前端控制器
* @author ML
* @since 2020-06-02
*/
@Api(value="TblCouponsController",tags="")
    @RestController
@RequestMapping("/coupons/tblCouponsPo")
public class TblCouponsController {

    @Resource
    private TblCouponsService TblCouponsService;


    }
