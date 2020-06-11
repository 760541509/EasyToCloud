package com.yingtongquan.order.order.mapper;

import com.yingtongquan.order.order.entity.TblOrderStaffPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface TblOrderStaffMapper extends BaseMapper<TblOrderStaffPo> {

    /**
     * @Date 2020/6/2 17:14
     * @Author 胖
     * 查询订单中开单员工的提成
     **/
    List<Integer> queryStaffCommission(String orderNo);

    /**
     * @Date 2020/6/2 17:19
     * @Author 胖
     * 添加员工和订单关系表
     **/
    Boolean addStaffAndOrder(TblOrderStaffPo orderStaffPo);

}
