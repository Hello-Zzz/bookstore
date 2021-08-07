package com.pers.dao.impl;

import com.pers.dao.UserDao;
import com.pers.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByName(String username) {
        String sql = "select `id`, `username`, `email` from t_user where username = ?";
        return queryForOne(sql, User.class, username);
    }

    @Override
    public User queryByNameAndPwd(String username, String password) {
        String sql = "select `id`, `username`, `email` from t_user where username = ? and password = ?";
        return queryForOne(sql, User.class, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO t_user(username,`password`,email) VALUES(?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
