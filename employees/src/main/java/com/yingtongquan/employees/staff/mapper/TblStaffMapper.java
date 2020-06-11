package com.yingtongquan.employees.staff.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.outbound.entity.OutboundOrderGoodsPo;
import com.yingtongquan.employees.outbound.entity.OutboundOrderPo;
import com.yingtongquan.employees.staff.entity.TblStaffPo;
import com.yingtongquan.employees.staff.pojo.OrderInfromation;
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
public interface TblStaffMapper extends BaseMapper<TblStaffPo> {

    /**
     * @Date 2020/6/5 16:54
     * @Author 胖
     * 添加店铺员工角色表
     **/
    Boolean addShopStaff(TblStaffPo staffPo);

    /**
     * @Date 2020/6/5 17:11
     * @Author 胖
     * 通过用户ID查询信息
     **/
    UserInformation queryUser(Integer userId);

    /**
     * @Date 2020/6/9 15:36
     * @Author 胖
     * 员工按照状态查询订单
     **/
    List<OrderInfromation> theEmployeeQueriesTheOrderByStatus(Integer status,Integer shopId);

    /**
     * @Date 2020/6/9 17:22
     * @Author 胖
     * 返回商品名字
     **/
    List<String> queryOrderGoodsName(String orderNo);

    /**
     * @Date 2020/6/10 10:57
     * @Author 胖
     * 根据订单号查询商品
     **/
    List<OutboundOrderGoodsPo> queryGoodsInfo(String orderNo);

    /**
     * @Date 2020/6/10 11:05
     * @Author 胖
     * 根据出库单号查询信息
     **/
    OutboundOrderPo queryOutboundInfo(String outboundNo);

    /**
     * @Date 2020/6/10 11:20
     * @Author 胖
     * 添加商品出库单
     **/
    Boolean addOutboundGoods(OutboundOrderGoodsPo outboundOrderGoodsPo);

    /**
     * @Date 2020/6/10 16:05
     * @Author 胖
     * 查询已支付金额
     **/
    Integer queryOrderPayAmount(String orderNo);

}
