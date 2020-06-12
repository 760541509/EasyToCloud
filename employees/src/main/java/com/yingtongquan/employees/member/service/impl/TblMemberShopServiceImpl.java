package com.yingtongquan.employees.member.service.impl;

import cn.hutool.core.codec.Base64;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.member.entity.TblMemberDeliveryAddressShopPo;
import com.yingtongquan.employees.member.entity.TblMemberShopPo;
import com.yingtongquan.employees.member.mapper.TblMemberShopMapper;
import com.yingtongquan.employees.member.pojo.*;
import com.yingtongquan.employees.member.service.TblMemberShopService;
import com.yingtongquan.employees.staff.pojo.UserInformation;
import com.yingtongquan.startcommon.util.HttpUtil;
import com.yingtongquan.startcommon.util.MD5;
import org.apache.commons.lang.RandomStringUtils;
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
public class TblMemberShopServiceImpl extends ServiceImpl<TblMemberShopMapper, TblMemberShopPo> implements TblMemberShopService {

    @Resource
    private TblMemberShopMapper memberShopMapper;
    @Resource
    private HttpServletRequest request;

    @Override
    public List<MemberInformation> queryAllShopMember(UseTheQuery useTheQuery) {
//        Integer shopId = HttpUtil.getShopId(request.getHeader("token"));
        useTheQuery.setShopId(10003);
        useTheQuery.setPageStart((useTheQuery.getPage() - 1) * useTheQuery.getPageEnd());
        List<MemberInformation> memberInformations = memberShopMapper.queryAllShopMember(useTheQuery);
        for (MemberInformation memberInformation : memberInformations) {
            List<Long> time = memberShopMapper.checkLastOrderTime(memberInformation.getUserId());
            for (int i = 0; i < time.size(); i++) {
                memberInformation.setAddTime(time.get(0));
            }
            Integer weChat = memberShopMapper.bindWeChat(memberInformation.getUserId());
            if (weChat == null) {
                memberInformation.setBindWeChat(false);
            } else {
                memberInformation.setBindWeChat(true);
            }
        }
        return memberInformations;
    }

//    @Override
//    public List<MemberInformation> queryByConditionMember(UseTheQuery useTheQuery) {
//        Integer shopId = HttpUtil.getShopId(request.getHeader("token"));
//        useTheQuery.setShopId(shopId);
//        useTheQuery.setPageStart((useTheQuery.getPage() - 1) * useTheQuery.getPageEnd());
//        List<MemberInformation> memberInformations = memberShopMapper.queryByCondition(useTheQuery);
//        for (MemberInformation memberInformation : memberInformations) {
//            List<Long> time = memberShopMapper.checkLastOrderTime(memberInformation.getUserId());
//            for (int i = 0; i < time.size(); i++) {
//                memberInformation.setAddTime(time.get(0));
//            }
//            Integer weChat = memberShopMapper.bindWeChat(memberInformation.getUserId());
//            if (weChat == 0 || weChat == null) {
//                memberInformation.setBindWeChat(false);
//            } else {
//                memberInformation.setBindWeChat(true);
//            }
//        }
//        return memberInformations;
//    }

    @Override
    public ShopMemberInfo queryMemberInformation(QueryMemberInformation memberInformation) {
        ShopMemberInfo shopMemberInfo = memberShopMapper.queryMemberInformation(memberInformation.getId());
        shopMemberInfo.setMemberAddresses(memberShopMapper.queryMemberShippingAddress(shopMemberInfo.getId()));
        return shopMemberInfo;
    }

    @Override
    public Integer addShopMember(AddShopMember addShopMember) {
        Integer shopId = HttpUtil.getShopId(request.getHeader("token"));
        UserInformation userInformation = memberShopMapper.queryUserInfromation(addShopMember.getAccount());
        TblMemberShopPo memberShopPo = new TblMemberShopPo();
        memberShopPo.setAddTime(System.currentTimeMillis());
        memberShopPo.setMemberId(addShopMember.getMemberPriceId());
        memberShopPo.setMemberName(addShopMember.getName());
        memberShopPo.setPhone(addShopMember.getAccount());
        memberShopPo.setShopId(shopId);
        if (userInformation != null) {
            memberShopPo.setUserId(userInformation.getId());
            memberShopPo.setHeadPortrait(userInformation.getHeadPortrait());
        } else {
            Integer userId = addUserInfromation(addShopMember.getAccount());
            memberShopPo.setUserId(userId);
        }
        memberShopMapper.addShopMember(memberShopPo);
        for (MemberAddress memberAddress : addShopMember.getMemberAddresses()) {
            TblMemberDeliveryAddressShopPo memberDeliveryAddress = new TblMemberDeliveryAddressShopPo();
            memberDeliveryAddress.setAddress(memberAddress.getAddress());
            memberDeliveryAddress.setLatitude(memberAddress.getLatitude());
            memberDeliveryAddress.setAreaId(memberAddress.getAreaId());
            memberDeliveryAddress.setLongitude(memberAddress.getLongitude());
            memberDeliveryAddress.setMemberShopId(memberShopPo.getId());
            memberDeliveryAddress.setPhone(memberAddress.getPhone());
            memberDeliveryAddress.setName(memberAddress.getConsignee());
            memberShopMapper.addMemberAddress(memberDeliveryAddress);
        }
        return memberShopPo.getId();
    }

    @Override
    public Boolean updateShopMember(UpdateMemberInformation memberInformation) {
        return memberShopMapper.updateShopMember(memberInformation);
    }

    @Override
    public Boolean updateMemberAddress(MemberAddress memberAddress) {
        TblMemberDeliveryAddressShopPo memberDelivery = new TblMemberDeliveryAddressShopPo();
        memberDelivery.setId(memberAddress.getId());
        memberDelivery.setAreaId(memberAddress.getAreaId());
        memberDelivery.setAddress(memberAddress.getAddress());
        memberDelivery.setName(memberAddress.getConsignee());
        memberDelivery.setPhone(memberAddress.getPhone());
        memberDelivery.setLatitude(memberAddress.getLatitude());
        memberDelivery.setLongitude(memberAddress.getLatitude());
        return memberShopMapper.updateMemberShippingAddress(memberDelivery);
    }

    @Override
    public Boolean deleteShopMember(String account) {
        return memberShopMapper.deleteShopMember(account);
    }

    /**
     * @Date 2020/6/11 11:56
     * @Author 胖
     * 添加账号
     **/
    private Integer addUserInfromation(String account) {
        UserInformation user = new UserInformation();
        user.setAccount(account);
        user.setAddTime(System.currentTimeMillis());
        user.setHeadPortrait("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F%E5%9B%BE%E7%89%87&step_word=&hs=2&pn=1&spn=0&di=43120&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=-1&cs=1618065806%2C14298536&os=2605524294%2C2363748290&simid=3179791506%2C2868578070&adpicid=0&lpn=0&ln=1029&fr=&fmq=1590475748938_R&fm=rs1&ic=undefined&s=undefined&hd=1&latest=0&copyright=0&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F%20%E5%8E%9F%E5%9B%BE&objurl=http%3A%2F%2Fwww.yozrun.com%2FUploadFiles%2Fimg_3_2774380917_512880114_26.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3By5z67g_z%26e3Bv54AzdH3FrtvAzdH3F%25El%25BB%25lb%25Eb%25AE%25A9%25Ec%25b8%25lA%25E0%25BE%25A9%25Ec%25A9%25B9%25Ec%25bn%25bF%25E0%25lA%25b9%25Ec%25lB%25BE%25E0%25bl%25b0%25E0%25B9%25Aa%25Em%25lD%25laAzdH3F&gsm=2&rpstart=0&rpnum=0&islist=&querylist=&force=undefined");
        user.setMac("");
        user.setSaltValue(Base64.encode(RandomStringUtils.randomAlphanumeric(20)).toUpperCase());
        user.setPassword(MD5.encryption(account, RandomStringUtils.randomAlphanumeric(6), user.getSaltValue()));
        user.setPhone(account);
        user.setUsername(RandomStringUtils.randomAlphanumeric(6));
        memberShopMapper.addUserInformation(user);
        return user.getId();
    }


}
