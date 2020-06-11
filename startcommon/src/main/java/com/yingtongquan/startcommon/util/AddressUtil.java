package com.yingtongquan.startcommon.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yingtongquan.startcommon.address.pojo.Coordinate;
import com.yingtongquan.startcommon.pojo.LatAndLon;

public class AddressUtil {

    private static final String BAIDU_API_AK = "bxWzssoK9GjmBYmiQvn97OoIDpyoZom5";

    /**
     * @Author:胖虎
     * @Date 2020/4/17 17:04
     * 获取经纬度
     **/
    public static Coordinate coordinate(String address) {
        //百度地图经纬度请求
        String url = "http://api.map.baidu.com/geocoding/v3/?address=" + address + "&output=json&ak=" + BAIDU_API_AK + "&callback=showLocation";
        //发送请求
        String body = HttpRequest.get(url)
                .timeout(20000)//超时，毫秒
                .execute().body();
        //截取返回值
        String parameter = body.substring(body.indexOf("(") + 1, body.indexOf(")"));
        //返回的值转换成JSON
        JSONObject jsonObject = new JSONObject(parameter);
        JSONObject param = new JSONObject(jsonObject.get("result"));
        JSONObject result = new JSONObject(param.get("location"));
        //获取JSON中的经纬度并赋值
        Coordinate coordinate = new Coordinate();
        coordinate.setLatitude((Double) result.get("lat"));
        coordinate.setLongitude((Double) result.get("lng"));
        return coordinate;
    }

    public static LatAndLon getAnAddressBasedOnLatitudeAndLongitude(LatAndLon latAndLon){
        String url = "http://api.map.baidu.com/reverse_geocoding/v3/?ak="+BAIDU_API_AK+"&output=json&coordtype=wgs84ll&location="+latAndLon.getLat()+","+latAndLon.getLon();
        System.out.println(url);
        String body = HttpRequest.get(url)
                .timeout(20000)//超时，毫秒
                .execute().body();
        JSONObject result = JSONUtil.parseObj(body);
        JSONObject result1 = JSONUtil.parseObj(result.get("result").toString());
        JSONObject component = JSONUtil.parseObj(result1.get("addressComponent").toString());
        latAndLon.setProvince(component.get("province").toString());
        latAndLon.setCity(component.get("city").toString());
        latAndLon.setDistrict(component.get("district").toString());
        return latAndLon;
    }
}
