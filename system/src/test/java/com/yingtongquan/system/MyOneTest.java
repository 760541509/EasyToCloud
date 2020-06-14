package com.yingtongquan.system;

import com.yingtongquan.startcommon.pojo.LatAndLon;
import com.yingtongquan.startcommon.util.AddressUtil;
import com.yingtongquan.startcommon.util.TimeUtil;
import com.yingtongquan.system.user.mapper.UserAndShopMapper;
import com.yingtongquan.system.user.pojo.AddressInformation;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

public class MyOneTest {
    @Resource
    private UserAndShopMapper userAndShopMapper;

    @Test
    public void test1() {
//       String url = "https://ytq.oss-cn-beijing.aliyuncs.com/shop_app/qrcode?shopId=10036";
        String url = "http://fq385zgl.xiaomy.net/system/system/tblUserPo/Test";
        String imgPath = "D:/timg.jpg";
        String destPath = "D:/code";
        boolean needCompress = true;
        try {
            QRCodeUtils.encode(url, imgPath, destPath, needCompress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        LatAndLon latAndLon = new LatAndLon();
        latAndLon.setLat((float) 30.69046);
        latAndLon.setLon((float) 104.077327);

        LatAndLon andLon = AddressUtil.getAnAddressBasedOnLatitudeAndLongitude(latAndLon);
        System.out.println(andLon);

        AddressInformation addressInformation = userAndShopMapper.queryAreaId(andLon.getDistrict());
        System.out.println(addressInformation);
    }

    @Test
    public void test2() {
        System.out.println(TimeUtil.timeConversionMilliseconds("2020-06-01 17:51:37"));
    }

}
