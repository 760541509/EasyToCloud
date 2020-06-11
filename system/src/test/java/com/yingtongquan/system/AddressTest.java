package com.yingtongquan.system;

import cn.hutool.http.HttpRequest;

class AddressTest implements Runnable {

    String url = "http://api.map.baidu.com/reverse_geocoding/v3/?ak=bxWzssoK9GjmBYmiQvn97OoIDpyoZom5&output=json&coordtype=wgs84ll&location=30.69046,104.077324";

    private String name;       // 表示线程的名称

    public AddressTest(String name) {
        this.name = name;      // 通过构造方法配置name属性
    }

    public void run() {  // 覆写run()方法，作为线程 的操作主体
        for (int i = 0; i < 500; i++) {
            String body = HttpRequest.get(url)
                    .timeout(20000)//超时，毫秒
                    .execute().body();
            System.out.println(name + "运行请求= " + body);
        }
    }
};

class RunnableDemo {
    public static void main(String[] args) {
        AddressTest addressTest1 = new AddressTest("A");
        AddressTest addressTest2 = new AddressTest("B");
        Thread t1 = new Thread(addressTest1);       // 实例化Thread类对象
        Thread t2 = new Thread(addressTest2);       // 实例化Thread类对象
        t1.start();    // 启动多线程
        t2.start();    // 启动多线程
    }
}
