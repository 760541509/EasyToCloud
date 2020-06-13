package com.yingtongquan.employees.staff.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.staff.entity.TblStaffPo;
import com.yingtongquan.employees.staff.pojo.*;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
public interface TblStaffService extends IService<TblStaffPo> {

    /**
     * @Date 2020/6/5 16:54
     * @Author 胖
     * 添加店铺员工角色表
     **/
    Boolean addShopStaff(Integer shopId,Integer userId);

    /**
     * @Date 2020/6/9 15:36
     * @Author 胖
     * 员工按照状态查询订单
     **/
    List<OrderInfromation> theEmployeeQueriesTheOrderByStatus(InquireOrderInfor inquireOrderInfor);

    /**
     * @Date 2020/6/12 11:37
     * @Author 胖
     * 员工查询订单详细
     **/
    StaffOrderInformation queryStaffOrderInformation(Order order);

    /**
     * @Date 2020/6/12 17:27
     * @Author 胖
     * 员工收款
     **/
    Boolean employeesCollection(StaffCollection staffCollection);

    /**
     * @Date 2020/6/12 17:46
     * @Author 胖
     * 员工查询需要发货的商品
     **/
    List<StaffOrderGoods> queryGoodsInformation(Order orderNo);

    /**
     * @Date 2020/6/12 17:52
     * @Author 胖
     * 派发订单
     **/
    Boolean distributingOrder(DistributeOrder distributeOrder);
}
