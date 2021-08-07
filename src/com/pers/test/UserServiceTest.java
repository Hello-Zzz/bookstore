package com.pers.test;

import com.pers.pojo.User;
import com.pers.service.UserService;
import com.pers.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registerUser(new User(null, "ming", "ming", "ming@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "zjg", "123456", "hhh")));
        System.out.println(userService.login(new User(null, "hjy", "123456", "hhh")));
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("hjy2"))
            System.out.println("用户名已存在");
        else
            System.out.println("用户名不存在，用户名可用");
    }
}