package com.huihex.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy          //开启网关功能
@EnableDiscoveryClient    //开启eureka客户端 测试
public class ZuulServer10010 {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServer10010.class, args);
    }

}
