package com.pers.dao;

import com.pers.pojo.User;

public interface UserDao {

    /**
     * 注册请求，根据用户名查询用户是否存在
     * @param username 用户名
     * @return 如果返回null  没有查询到该用户
     */
    public User queryUserByName(String username);

    /**
     * 登录请求，根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 如果返回null  没有查询到该用户
     */
    public User queryByNameAndPwd(String username, String password);

    public int saveUser(User user);
}
