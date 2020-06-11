package com.yingtongquan.employees.staff.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.staff.entity.TblStaffPo;
import com.yingtongquan.employees.staff.entity.TblStaffRolePo;
import com.yingtongquan.employees.staff.pojo.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-05-21
*/
@Mapper
@Repository
public interface TblStaffRoleMapper extends BaseMapper<TblStaffRolePo> {

    /**
     * @Date 2020/5/21 17:37
     * @Author 胖
     * 添加角色表信息
     **/
    void addRoleInformation(TblStaffRolePo staffRolePo);

    /**
     * 2020/5/25  17:49
     * @Author 胖
     * 查询该手机号是否被注册
     **/
    UserInformation queryUserInformation(String phone);

    /**
     * 2020/5/25  18:10
     * @Author 胖
     * 添加用户信息
     **/
    Boolean addUserInforamtion(UserInformation userInformation);

    /**
     * 2020/5/25  18:16
     * @Author 胖
     * 添加员工表
     **/
    Boolean addStaffInformation(TblStaffPo staffPo);

    /**
     * 2020/5/25  18:26
     * @Author 胖
     * 查询所有的员工
     **/
    List<TblStaffPo> queryAllStaffInformation(Integer shopId);

    /**
     * 2020/5/25  18:28
     * @Author 胖
     * 删除员工
     **/
    Boolean deleteStaff(Integer staffId);

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
    List<TblStaffRolePo> queryShopAllStaffRole(Integer shopId);

    /**
     * @Date 2020/6/5 17:21
     * @Author 胖
     * 查询店铺老板的ID
     **/
    Integer queryBossId(Integer shopId);
}
