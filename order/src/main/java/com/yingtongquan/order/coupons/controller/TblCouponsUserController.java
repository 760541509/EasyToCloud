package com.yingtongquan.order.coupons.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.order.coupons.service.TblCouponsUserService;
import com.yingtongquan.order.coupons.entity.TblCouponsUserPo;
    import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
/**
*  前端控制器
* @author ML
* @since 2020-06-02
*/
@Api(value="TblCouponsUserController",tags="")
    @RestController
@RequestMapping("/coupons/tblCouponsUserPo")
public class TblCouponsUserController {

    @Resource
    private TblCouponsUserService TblCouponsUserService;


    }
