package com.yingtongquan.order.outbound.service;

import com.yingtongquan.order.outbound.entity.TblOutboundOrderStaffPo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
public interface TblOutboundOrderStaffService extends IService<TblOutboundOrderStaffPo> {

    /**
     * @Date 2020/5/18 15:21
     * @Author 胖
     *添加员工出库单信息
     **/
    void addOutboundOrderStaff(Integer outboundOrderId);

}
