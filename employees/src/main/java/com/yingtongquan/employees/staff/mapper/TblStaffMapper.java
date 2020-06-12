package com.yingtongquan.employees.staff.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.staff.entity.TblStaffPo;
import com.yingtongquan.employees.staff.pojo.InquireOrderInfor;
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
    List<OrderInfromation> theEmployeeQueriesTheOrderByStatus(InquireOrderInfor inquireOrderInfor);

    /**
     * @Date 2020/6/9 17:22
     * @Author 胖
     * 返回商品名字
     **/
    List<String> queryOrderGoodsName(String orderNo);

    /**
     * @Date 2020/6/10 16:05
     * @Author 胖
     * 查询已支付金额
     **/
    Integer queryOrderPayAmount(String orderNo);

}
