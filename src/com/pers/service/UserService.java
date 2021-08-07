package com.pers.service;

import com.pers.pojo.User;

public interface UserService {

    /**
     * 用户注册业务
     * @param user
     */
    public void registerUser(User user);

    /**
     * 用户登录业务
     * @param user
     */
    public User login(User user);

    /**
     * 查询用户名是否可用
     * @param username
     * @return true: 用户名存在，不可用<br/> false:用户名可用
     */
    public boolean existUsername(String username);
}
