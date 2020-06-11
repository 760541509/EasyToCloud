package com.yingtongquan.order;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class MyTest {

    @Test
    public void test() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0,10)+ DateUtil.today().replace("-", "");
        int num = 0;
        for (int i = 0; i < 999999999; i++) {
            String str = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0,10)+ DateUtil.today().replace("-", "");
            num ++;
            if(str.equals(uuid)){
                System.out.println(num);
                break;
            }
        }
        System.out.println("当前循环已结束");
    }
}
