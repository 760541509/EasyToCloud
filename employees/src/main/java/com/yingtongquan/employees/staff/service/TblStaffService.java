package com.yingtongquan.employees.staff.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.staff.entity.TblStaffPo;
import com.yingtongquan.employees.staff.pojo.InquireOrderInfor;
import com.yingtongquan.employees.staff.pojo.OrderInfromation;
import com.yingtongquan.employees.staff.pojo.StaffOrderInformation;

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
    StaffOrderInformation queryStaffOrderInformation();
}
