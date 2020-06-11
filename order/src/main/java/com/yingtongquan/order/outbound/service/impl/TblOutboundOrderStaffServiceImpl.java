package com.yingtongquan.order.outbound.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.order.outbound.entity.TblOutboundOrderStaffPo;
import com.yingtongquan.order.outbound.mapper.TblOutboundOrderStaffMapper;
import com.yingtongquan.order.outbound.service.TblOutboundOrderStaffService;
import com.yingtongquan.startcommon.util.HttpUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
@Service
public class TblOutboundOrderStaffServiceImpl extends ServiceImpl<TblOutboundOrderStaffMapper, TblOutboundOrderStaffPo> implements TblOutboundOrderStaffService {

    @Resource
    private HttpServletRequest request;
    @Resource
    private TblOutboundOrderStaffMapper outboundOrderStaffMapper;

    @Override
    public void addOutboundOrderStaff(Integer outboundOrderId) {

        Integer curUserId = HttpUtil.getCurUserId(request.getHeader("token"));

        TblOutboundOrderStaffPo outboundOrderStaffPo = new TblOutboundOrderStaffPo();
        outboundOrderStaffPo.setAddTime(System.currentTimeMillis());
        outboundOrderStaffPo.setCommissionAmount(0);
        outboundOrderStaffPo.setOutboundOrderId(outboundOrderId);
        outboundOrderStaffPo.setStaffId(curUserId);
        outboundOrderStaffMapper.addOutboundOrderStaff(outboundOrderStaffPo);
    }
}
