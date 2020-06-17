package com.yingtongquan.employees.staff.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.staff.entity.TblStaffPo;
import com.yingtongquan.employees.staff.entity.TblStaffRolePo;
import com.yingtongquan.employees.staff.pojo.StaffInforamtion;
import com.yingtongquan.startcommon.base.ResultVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
public interface TblStaffRoleService extends IService<TblStaffRolePo> {

    /**
     * @Date 2020/5/21 17:13
     * @Author 胖
     * 添加默认角色
     **/
    Boolean addDefaultRoles(Integer shopId);

    /**
     * 2020/5/25  17:37
     * @Autho 胖
     * 添加员工角色
     **/
    ResultVo addStaffInformation(StaffInforamtion staffInforamtion);

    /**
     * 2020/5/25  17:39
     * @Autho 胖
     * 查询员工信息
     **/
    List<TblStaffPo> queryAllStaffInformation();

    /**
     * 2020/5/25  17:41
     * @Autho 胖
     * 删除员工信息
     **/
    Boolean deleteStaffInformation(Integer staffId);

    /**
     * 2020/5/25  18:29
     * @Author 胖
     * 添加角色权限表
     **/
    void addStaffRole(TblStaffRolePo staffRolePo);

    /**
     * 2020/5/25  18:30
     * @Author 胖
     * 修改员工权限表
     **/
    Boolean updateStaffRole(TblStaffRolePo staffRolePo);

    /**
     * 2020/5/25  18:30
     * @Author 胖
     * 删除员工权限表
     **/
    Boolean deleteStaffRole(Integer roleId);

    /**
     * 2020/5/25  18:31
     * @Author 胖
     * 查询员工权限表
     **/
    List<TblStaffRolePo> queryShopAllStaffRole();

    /**
     * @Date 2020/6/5 17:21
     * @Author 胖
     * 查询店铺老板的ID
     **/
    Integer queryBossId(Integer shopId);
}
