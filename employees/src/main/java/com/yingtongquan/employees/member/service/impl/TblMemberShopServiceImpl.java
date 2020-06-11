package com.yingtongquan.employees.member.service.impl;

import cn.hutool.core.codec.Base64;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.member.entity.TblMemberShopPo;
import com.yingtongquan.employees.member.mapper.TblMemberShopMapper;
import com.yingtongquan.employees.member.pojo.AddShopMember;
import com.yingtongquan.employees.member.pojo.MemberInformation;
import com.yingtongquan.employees.member.pojo.UseTheQuery;
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
    public List<TblMemberShopPo> queryAllShopMember() {
        Integer shopId = HttpUtil.getShopId(request.getHeader("token"));
        return memberShopMapper.queryAllShopMember(shopId);
    }

    @Override
    public Boolean addShopMember(AddShopMember addShopMember) {
        String member = memberShopMapper.queryMember(addShopMember.getMemberPriceId());
        UserInformation userInformation = memberShopMapper.queryUserInfromation(addShopMember.getAccount());
        TblMemberShopPo memberShopPo = new TblMemberShopPo();
        memberShopPo.setAddTime(System.currentTimeMillis());
        memberShopPo.setMemberId(addShopMember.getMemberPriceId());
        memberShopPo.setMemberName(member);
        memberShopPo.setPhone(addShopMember.getAccount());
        memberShopPo.setShopId(addShopMember.getShopId());
        if (userInformation != null) {
            memberShopPo.setUserId(userInformation.getId());
            memberShopPo.setHeadPortrait(userInformation.getHeadPortrait());
        } else {
            UserInformation user = new UserInformation();
            user.setAccount(addShopMember.getAccount());
            user.setAddTime(System.currentTimeMillis());
            user.setHeadPortrait("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F%E5%9B%BE%E7%89%87&step_word=&hs=2&pn=1&spn=0&di=43120&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=-1&cs=1618065806%2C14298536&os=2605524294%2C2363748290&simid=3179791506%2C2868578070&adpicid=0&lpn=0&ln=1029&fr=&fmq=1590475748938_R&fm=rs1&ic=undefined&s=undefined&hd=1&latest=0&copyright=0&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F%20%E5%8E%9F%E5%9B%BE&objurl=http%3A%2F%2Fwww.yozrun.com%2FUploadFiles%2Fimg_3_2774380917_512880114_26.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3By5z67g_z%26e3Bv54AzdH3FrtvAzdH3F%25El%25BB%25lb%25Eb%25AE%25A9%25Ec%25b8%25lA%25E0%25BE%25A9%25Ec%25A9%25B9%25Ec%25bn%25bF%25E0%25lA%25b9%25Ec%25lB%25BE%25E0%25bl%25b0%25E0%25B9%25Aa%25Em%25lD%25laAzdH3F&gsm=2&rpstart=0&rpnum=0&islist=&querylist=&force=undefined");
            user.setMac("");
            user.setSaltValue(Base64.encode(RandomStringUtils.randomAlphanumeric(20)).toUpperCase());
            user.setPassword(MD5.encryption(addShopMember.getAccount(), RandomStringUtils.randomAlphanumeric(6), user.getSaltValue()));
            user.setPhone(addShopMember.getAccount());
            user.setUsername(RandomStringUtils.randomAlphanumeric(6));
            memberShopMapper.addUserInformation(user);
            memberShopPo.setUserId(user.getId());
        }
        return memberShopMapper.addShopMember(memberShopPo);
    }

    @Override
    public Boolean updateShopMember(MemberInformation memberInformation) {
        return memberShopMapper.updateShopMember(memberInformation);
    }

    @Override
    public Boolean deleteShopMember(String account) {
        return memberShopMapper.deleteShopMember(account);
    }

    @Override
    public List<TblMemberShopPo> queryByConditionMember(UseTheQuery useTheQuery) {
        Integer shopId = HttpUtil.getShopId(request.getHeader("token"));
        useTheQuery.setShopId(shopId);
        return memberShopMapper.queryByCondition(useTheQuery);

    }
}
