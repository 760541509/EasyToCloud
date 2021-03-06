package com.yingtongquan.employees.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.member.entity.TblMemberDeliveryAddressShopPo;
import com.yingtongquan.employees.member.mapper.TblMemberDeliveryAddressShopMapper;
import com.yingtongquan.employees.member.mapper.TblMemberShopMapper;
import com.yingtongquan.employees.member.pojo.MemberAddress;
import com.yingtongquan.employees.member.service.TblMemberDeliveryAddressShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@Service
public class TblMemberDeliveryAddressShopServiceImpl extends ServiceImpl<TblMemberDeliveryAddressShopMapper, TblMemberDeliveryAddressShopPo> implements TblMemberDeliveryAddressShopService {

    @Resource
    private TblMemberShopMapper memberShopMapper;

    @Override
    public Integer addMemberAddress(MemberAddress memberAddress) {
        TblMemberDeliveryAddressShopPo memberDeliveryAddress = new TblMemberDeliveryAddressShopPo();
        memberDeliveryAddress.setAddress(memberAddress.getAddress());
        memberDeliveryAddress.setLatitude(memberAddress.getLatitude());
        memberDeliveryAddress.setAreaId(memberAddress.getAreaId());
        memberDeliveryAddress.setLongitude(memberAddress.getLongitude());
        memberDeliveryAddress.setMemberShopId(memberAddress.getMemberId());
        memberDeliveryAddress.setPhone(memberAddress.getPhone());
        memberDeliveryAddress.setName(memberAddress.getConsignee());
        memberShopMapper.addMemberAddress(memberDeliveryAddress);
        return memberDeliveryAddress.getId();
    }
}
