package com.huihex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//通过添加来开启Eureka客户端功能
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderMain8081 {

    public static void main(String[] args) {

        SpringApplication.run(ProviderMain8081.class, args);
    }

}
