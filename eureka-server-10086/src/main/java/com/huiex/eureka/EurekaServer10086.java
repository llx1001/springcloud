package com.huiex.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// 声明当前springboot应用是一个eureka服务中心
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer10086 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer10086.class, args);
    }

}
