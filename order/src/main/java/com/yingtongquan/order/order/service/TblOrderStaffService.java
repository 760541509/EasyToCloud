package com.yingtongquan.order.order.service;

import com.yingtongquan.order.order.entity.TblOrderStaffPo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
public interface TblOrderStaffService extends IService<TblOrderStaffPo> {

    /**
     * @Date 2020/6/2 17:08
     * @Author 胖
     * 添加订单与开单员工之间的关系
     **/
    Boolean addStaffAndOrder(String orderNo);

}
