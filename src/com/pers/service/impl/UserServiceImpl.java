package com.pers.service.impl;

import com.pers.dao.UserDao;
import com.pers.dao.impl.UserDaoImpl;
import com.pers.pojo.User;
import com.pers.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryByNameAndPwd(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userDao.queryUserByName(username) == null)
            return false;
        else
            return true;
    }
}
