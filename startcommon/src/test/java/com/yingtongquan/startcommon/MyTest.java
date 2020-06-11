package com.yingtongquan.startcommon;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yingtongquan.startcommon.pojo.LatAndLon;
import com.yingtongquan.startcommon.util.AddressUtil;
import org.junit.jupiter.api.Test;

public class MyTest {

    private static final String BAIDU_API_AK = "bxWzssoK9GjmBYmiQvn97OoIDpyoZom5";


   @Test
    public void test(){
       float lat = (float) 30.69046;
       float lon = (float) 104.077327;
       String url = "http://api.map.baidu.com/reverse_geocoding/v3/?ak="+BAIDU_API_AK+"&output=json&coordtype=wgs84ll&location="+lat+","+lon;
       String body = HttpRequest.get(url)
               .timeout(20000)//超时，毫秒
               .execute().body();
       JSONObject result = JSONUtil.parseObj(body);
       JSONObject result1 = JSONUtil.parseObj(result.get("result").toString());
       JSONObject component = JSONUtil.parseObj(result1.get("addressComponent").toString());
       String province = component.get("province").toString();
       String city = component.get("city").toString();
       String district = component.get("district").toString();
       System.out.println(province+city+district);
   }

   @Test
   public void test1(){
      LatAndLon andLon = new LatAndLon();
      andLon.setLat((float) 30.69046);
      andLon.setLon((float) 104.077327);
      LatAndLon anAddressBasedOnLatitudeAndLongitude = AddressUtil.getAnAddressBasedOnLatitudeAndLongitude(andLon);
      System.out.println(anAddressBasedOnLatitudeAndLongitude);
   }



}
