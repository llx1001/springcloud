package com.huihex.controller;

import com.huihex.com.huihex.client.UserClient;
import com.huihex.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author llx
 * @date 2021/03/27 17:56
 */
@RestController
@RequestMapping("/consumer/user")
//@DefaultProperties(defaultFallback = "fallBackMethod") // 指定一个类的全局熔断方法
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

   /*  方式1



    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {

        User user = this.restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);
        return user;
    }*/

    // eureka客户端，可以获取到eureka中服务的信息
   /* @Autowired
    private DiscoveryClient discoveryClient; // 注入discoveryClient，通过该客户端获取服务列表

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {

        // 根据服务名称，获取服务实例。有可能是集群，所以是service实例集合
        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        // 因为只有一个Service-provider。所以获取第一个实例
        ServiceInstance instance = instances.get(0);
        // 获取ip和端口信息，拼接成服务地址
        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;
        User user = this.restTemplate.getForObject(baseUrl, User.class);
        return user;
    }*/

    /*
    @PathVariable  /id/1
    @RequestParam /id=1
     */

    @GetMapping("{id}")
    @ResponseBody
    @HystrixCommand(fallbackMethod="queryByIdFallBack")
    public String queryById(@PathVariable("id") Long id) {
        // 通过client获取服务提供方的服务列表，这里我们只有一个
        // ServiceInstance instance = discoveryClient.getInstances("service-provider").get(0);
        String baseUrl = "http://service-provider/user/" + id;
        User user = this.restTemplate.getForObject(baseUrl, User.class);
        return user.toString();
    }
    /**
     * 熔断方法
     * 返回值要和被熔断的方法的返回值一致
     * 熔断方法不需要参数
     * @return
     */
    public String queryByIdFallBack(Long id){
        return "请求繁忙，请稍后再试！";
    }

    @Autowired
    private UserClient userClient;

    @GetMapping("feign/{id}")
    public User queryUserById(@PathVariable("id") Long id){
        User user = this.userClient.queryById(id);
        return user;
    }
}