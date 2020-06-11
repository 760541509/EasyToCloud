package com.yingtongquan.order.outbound.mapper;

import com.yingtongquan.order.outbound.entity.TblOutboundOrderStaffPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author Pang
* @since 2020-05-12
*/
@Mapper
@Repository
public interface TblOutboundOrderStaffMapper extends BaseMapper<TblOutboundOrderStaffPo> {

    /**
     * @Date 2020/5/18 15:25
     * @Author 胖
     *添加员工出库单
     **/
    void addOutboundOrderStaff(TblOutboundOrderStaffPo outboundOrderStaffPo);

}
