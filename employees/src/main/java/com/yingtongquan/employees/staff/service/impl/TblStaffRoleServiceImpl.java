package com.yingtongquan.employees.staff.service.impl;

import cn.hutool.core.codec.Base64;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.staff.entity.TblStaffPo;
import com.yingtongquan.employees.staff.entity.TblStaffRolePo;
import com.yingtongquan.employees.staff.mapper.TblStaffRoleMapper;
import com.yingtongquan.employees.staff.pojo.StaffInforamtion;
import com.yingtongquan.employees.staff.pojo.UserInformation;
import com.yingtongquan.employees.staff.service.TblStaffRoleService;
import com.yingtongquan.startcommon.base.ResultVo;
import com.yingtongquan.startcommon.util.HttpUtil;
import com.yingtongquan.startcommon.util.MD5;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@Service
public class TblStaffRoleServiceImpl extends ServiceImpl<TblStaffRoleMapper, TblStaffRolePo> implements TblStaffRoleService {

    @Resource
    private TblStaffRoleMapper staffRoleMapper;
    @Resource
    private HttpServletRequest request;

    @Override
    public Boolean addDefaultRoles(Integer shopId) {

        TblStaffRolePo staffRolePoOne = new TblStaffRolePo();
        staffRolePoOne.setResources("[0]");
        staffRolePoOne.setRoleName("老板");
        staffRolePoOne.setShopId(shopId);
        staffRolePoOne.setStaffCommissionRate(0);
        staffRoleMapper.addRoleInformation(staffRolePoOne);

        TblStaffRolePo staffRolePoOneTwo = new TblStaffRolePo();
        staffRolePoOneTwo.setResources("[1]");
        staffRolePoOneTwo.setRoleName("店长");
        staffRolePoOneTwo.setShopId(shopId);
        staffRolePoOneTwo.setStaffCommissionRate(0);
        staffRoleMapper.addRoleInformation(staffRolePoOneTwo);


        TblStaffRolePo staffRolePoOneThree = new TblStaffRolePo();
        staffRolePoOneThree.setResources("[2,3]");
        staffRolePoOneThree.setRoleName("营业员");
        staffRolePoOneThree.setShopId(shopId);
        staffRolePoOneThree.setStaffCommissionRate(0);
        staffRoleMapper.addRoleInformation(staffRolePoOneThree);

        return true;
    }

    @Override
    public ResultVo addStaffInformation(StaffInforamtion staffInforamtion) {
        Integer shopId = HttpUtil.getShopId(request.getHeader("token"));
        TblStaffPo staffPo = new TblStaffPo();
        staffPo.setAddress(staffInforamtion.getAddress());
        staffPo.setAreaId(staffInforamtion.getAreaId());
        staffPo.setShopId(shopId);
        staffPo.setStaffName(staffInforamtion.getName());
        staffPo.setStaffPhone(staffInforamtion.getPhone());
        staffPo.setStaffRoleId(staffInforamtion.getStaffRoleId());

        UserInformation userInformation = staffRoleMapper.queryUserInformation(staffInforamtion.getPhone());
        if (userInformation == null) {
            //盐值
            String toUpperCase = Base64.encode(RandomStringUtils.randomAlphanumeric(20)).toUpperCase();
            //随机密码
            String password = UUID.randomUUID().toString().replace("-", "").substring(0, 6);
            //加密后的密码
            String encryption = MD5.encryption(staffInforamtion.getPhone(), password, toUpperCase);
            UserInformation user = new UserInformation();
            user.setAccount(staffInforamtion.getPhone());
            user.setAddress(staffInforamtion.getAddress());
            user.setAddTime(System.currentTimeMillis());
            user.setAreaId(staffInforamtion.getAreaId());
            user.setDateBirth(Long.valueOf(0));
            user.setEmail("");
            user.setHeadPortrait("");
            user.setMac("");
            user.setPassword(encryption);
            user.setPhone(staffInforamtion.getPhone());
            user.setSaltValue(toUpperCase);
            user.setSex("");
            user.setUsername(RandomStringUtils.randomAlphanumeric(6));
            Boolean inforamtion = staffRoleMapper.addUserInforamtion(user);
            if (inforamtion) {
                staffPo.setUserId(user.getId());
                staffRoleMapper.addStaffInformation(staffPo);
                Map<Object, Object> map = new HashMap<>();
                map.put("account", staffInforamtion.getPhone());
                map.put("password", password);
                return ResultVo.successResult("员工添加成功,您员工的账号密码是" + map);
            }
        }
        staffPo.setUserId(userInformation.getId());
        staffRoleMapper.addStaffInformation(staffPo);
        return ResultVo.successResult("员工添加成功");
    }

    @Override
    public List<TblStaffPo> queryAllStaffInformation() {
        Integer shopId = HttpUtil.getShopId(request.getHeader("token"));
        return staffRoleMapper.queryAllStaffInformation(shopId);
    }

    @Override
    public Boolean deleteStaffInformation(Integer staffId) {
        return staffRoleMapper.deleteStaff(staffId);
    }

    @Override
    public void addStaffRole(TblStaffRolePo staffRolePo) {
        staffRoleMapper.addRoleInformation(staffRolePo);
    }

    @Override
    public Boolean updateStaffRole(TblStaffRolePo staffRolePo) {
        return staffRoleMapper.updateStaffRole(staffRolePo);
    }

    @Override
    public Boolean deleteStaffRole(Integer roleId) {
        return staffRoleMapper.deleteStaff(roleId);
    }

    @Override
    public List<TblStaffRolePo> queryShopAllStaffRole() {
        Integer shopId = HttpUtil.getShopId(request.getHeader("token"));
        return staffRoleMapper.queryShopAllStaffRole(shopId);
    }

    @Override
    public Integer queryBossId(Integer shopId) {
        return staffRoleMapper.queryBossId(shopId);
    }
}
