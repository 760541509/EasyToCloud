package com.yingtongquan.order.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.order.order.entity.TblOrderPo;
import com.yingtongquan.order.order.entity.TblOrderStaffPo;
import com.yingtongquan.order.order.mapper.TblOrderMapper;
import com.yingtongquan.order.order.mapper.TblOrderStaffMapper;
import com.yingtongquan.order.order.service.TblOrderStaffService;
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
 * @author Pang
 * @since 2020-05-12
 */
@Service
public class TblOrderStaffServiceImpl extends ServiceImpl<TblOrderStaffMapper, TblOrderStaffPo> implements TblOrderStaffService {

    @Resource
    private TblOrderStaffMapper orderStaffMapper;
    @Resource
    private TblOrderMapper orderMapper;
    @Resource
    private HttpServletRequest request;

    @Override
    public Boolean addStaffAndOrder(String orderNo) {
        //订单商品详细
        TblOrderPo orderInformation = orderMapper.queryOrderInformation(orderNo);
        //员工本单总提成
        Integer staffCommission = 0;
        //员工ID
        Integer curUserId = HttpUtil.getCurUserId(request.getHeader("token"));

        List<Integer> commission = orderStaffMapper.queryStaffCommission(orderNo);
        for (Integer integer : commission) {
            staffCommission = staffCommission + integer;
        }
        TblOrderStaffPo orderStaffPo = new TblOrderStaffPo();
        orderStaffPo.setAddTime(System.currentTimeMillis());
        orderStaffPo.setCommissionAmount(staffCommission);
        orderStaffPo.setOrderId(orderInformation.getId());
        orderStaffPo.setStaffId(curUserId);
        return orderStaffMapper.addStaffAndOrder(orderStaffPo);
    }
}
