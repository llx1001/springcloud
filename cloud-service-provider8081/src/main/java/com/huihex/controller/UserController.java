package com.huihex.controller;

import com.huihex.pojo.User;
import com.huihex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author llx
 * @date 2021/03/27 17:56
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {

       /* try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("8081执行...");

        return this.userService.queryById(id);
    }
}