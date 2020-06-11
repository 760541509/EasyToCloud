package com.yingtongquan.order.returnGoods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.order.returnGoods.entity.TblReturnOrderPo;
import com.yingtongquan.order.returnGoods.pojo.*;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
public interface TblReturnOrderService extends IService<TblReturnOrderPo> {

    /**
     * @Date 2020/5/19 10:46
     * @Author 胖
     * 申请退货
     **/
    Boolean returnOfTheGoods(ReturnGoods returnGoods);

    /**
     * @Date 2020/5/20 15:52
     * @Author 胖
     * 顾客申请退款
     **/
    Boolean customerReturns(CustomerReturns customerReturns);

    /**
     * @Date 2020/5/20 16:30
     * @Author 胖
     * 员工处理退货申请
     **/
    Boolean employeesHandleReturnRequests(ReturnOrderDeliveryAddressInformation returnOrderDeliveryAddressInformation);

    /**
     * @Date 2020/5/20 17:29
     * @Author 胖
     * 添加退货单物流信息
     **/
    Boolean addReturnOrderInformation(LogisticsInformation logisticsInformation);

    /**
     * @Date 2020/5/20 17:56
     * @Author 胖
     * 员工确认收到货物
     **/
    Boolean employeeReceivesGoods(EmployessReturn employessReturn);

    /**
     * @Date 2020/5/29 11:29
     * @Author 胖
     * 查询店铺下所有的退货申请
     **/
    List<TblReturnOrderPo> queryAllReturnToApplyFor(Integer shopId);
}
