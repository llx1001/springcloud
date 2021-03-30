package com.huihex.com.huihex.client;

import com.huihex.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author llx
 * @date 2021/03/30 02:49
 */
@FeignClient(value = "service-provider") // 标注该类是一个feign接口
public interface UserClient {
    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Long id);
    /**
     * - 首先这是一个接口，Feign会通过动态代理，帮我们生成实现类。这点跟mybatis的mapper很像
     * - @FeignClient，声明这是一个Feign客户端，类似@Mapper注解。同时通过value属性指定服务名称
     * - 接口中的定义方法，完全采用SpringMVC的注解，Feign会根据注解帮我们生成URL，并访问获取结果
     */
}
