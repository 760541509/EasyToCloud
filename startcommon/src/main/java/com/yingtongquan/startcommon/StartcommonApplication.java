package com.yingtongquan.startcommon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StartcommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartcommonApplication.class, args);
    }

}
