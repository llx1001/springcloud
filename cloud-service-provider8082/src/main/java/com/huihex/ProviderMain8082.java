package com.huihex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
public class ProviderMain8082 {

    public static void main(String[] args) {

        SpringApplication.run(ProviderMain8082.class,args);
    }

}
