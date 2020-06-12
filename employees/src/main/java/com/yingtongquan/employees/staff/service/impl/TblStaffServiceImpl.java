package com.yingtongquan.employees.staff.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.staff.entity.TblStaffPo;
import com.yingtongquan.employees.staff.mapper.TblStaffMapper;
import com.yingtongquan.employees.staff.pojo.*;
import com.yingtongquan.employees.staff.service.TblStaffRoleService;
import com.yingtongquan.employees.staff.service.TblStaffService;
import com.yingtongquan.startcommon.util.HttpUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@Service
public class TblStaffServiceImpl extends ServiceImpl<TblStaffMapper, TblStaffPo> implements TblStaffService {

    @Resource
    private TblStaffMapper staffMapper;
    @Resource
    private TblStaffRoleService staffRoleService;
    @Resource
    private HttpServletRequest request;

    @Override
    public Boolean addShopStaff(Integer shopId, Integer userId) {
        UserInformation userInformation = staffMapper.queryUser(userId);
        Integer bossId = staffRoleService.queryBossId(shopId);
        TblStaffPo staffPo = new TblStaffPo();
        staffPo.setAddress("");
        staffPo.setAreaId(0);
        staffPo.setShopId(shopId);
        staffPo.setStaffName(userInformation.getUsername());
        staffPo.setStaffPhone(userInformation.getPhone());
        staffPo.setStaffRoleId(bossId);
        staffPo.setUserId(userId);
        return staffMapper.addShopStaff(staffPo);
    }

    @Override
    public List<OrderInfromation> theEmployeeQueriesTheOrderByStatus(InquireOrderInfor inquireOrderInfor) {
        String token = request.getHeader("token");
        Integer shopId = HttpUtil.getShopId(token);
        inquireOrderInfor.setShopId(shopId);
        inquireOrderInfor.setPageStart((inquireOrderInfor.getPage() - 1) * inquireOrderInfor.getPageEnd());
        List<OrderInfromation> orderInfromations = staffMapper.theEmployeeQueriesTheOrderByStatus(inquireOrderInfor);
        for (int i = 0; i < orderInfromations.size(); i++) {
            String name = null;
            List<String> goodsName = staffMapper.queryOrderGoodsName(orderInfromations.get(i).getOrderNo());
            orderInfromations.get(i).setHaveToPay(staffMapper.queryOrderPayAmount(orderInfromations.get(i).getOrderNo()));
            for (int j = 0; j < goodsName.size(); j++) {
                name = goodsName.get(0);
            }
            orderInfromations.get(i).setGoodsName(name + " 等" + orderInfromations.get(i).getGoodsCount() + "件商品");
        }
        return orderInfromations;
    }

    @Override
    public StaffOrderInformation queryStaffOrderInformation(Order order) {





































        return null;
    }
}
