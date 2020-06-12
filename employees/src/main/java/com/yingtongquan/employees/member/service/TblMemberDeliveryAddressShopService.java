package com.yingtongquan.employees.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.member.entity.TblMemberDeliveryAddressShopPo;
import com.yingtongquan.employees.member.pojo.MemberAddress;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
public interface TblMemberDeliveryAddressShopService extends IService<TblMemberDeliveryAddressShopPo> {

    /**
     * @Date 2020/6/11 14:23
     * @Author 胖
     * 添加会员地址
     **/
    Integer addMemberAddress(MemberAddress memberAddress);

}
