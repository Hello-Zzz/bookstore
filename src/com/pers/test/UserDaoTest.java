package com.pers.test;

import com.pers.dao.UserDao;
import com.pers.dao.impl.UserDaoImpl;
import com.pers.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    private UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByName() {

        if(userDao.queryUserByName("admin") != null)
            System.out.println("用户名已存在！");
        else
            System.out.println("用户名可用！");
    }

    @Test
    public void queryByNameAndPwd() {
        if(userDao.queryByNameAndPwd("admin", "admin") == null)
            System.out.println("用户名或密码错误，登陆失败");
        else
            System.out.println("登陆成功");

    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "hjyzjg", "hjy369.", "hjy@163.com")));
    }
}