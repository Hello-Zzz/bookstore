package com.pers.web;

import com.pers.pojo.User;
import com.pers.service.UserService;
import com.pers.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User login = userService.login(new User(null, username, password, null));
        if(login != null) {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }else{
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }
}
