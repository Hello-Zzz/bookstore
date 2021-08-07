package com.pers.web;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.google.gson.Gson;
import com.pers.pojo.User;
import com.pers.service.UserService;
import com.pers.service.impl.UserServiceImpl;
import com.pers.test.UserServletTest;
import com.pers.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();


    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("登录");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User login = userService.login(new User(null, username, password, null));
        if(login != null) {

            req.getSession().setAttribute("user", login);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }else{
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("注册");
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamsToBean(req.getParameterMap(), new User());

        if( token != null && token.equalsIgnoreCase(code)){
            if(userService.existUsername(username)){
                req.setAttribute("msg", "用户名已存在");
                req.setAttribute("username", username);
                req.setAttribute("password", password);
                req.setAttribute("email", email);
                try {
                    req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                userService.registerUser(new User(null, username, password, email));
                try {
                    req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }else{
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("email", email);


            System.out.println("验证码[" + code + "]错误");
            try {
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        boolean exists = userService.existUsername(username);

        Map<String, Boolean> existsMap = new HashMap<>();
        existsMap.put("exists", exists);

        Gson gson = new Gson();
        String toJson = gson.toJson(existsMap);

        resp.getWriter().write(toJson);
    }

}
