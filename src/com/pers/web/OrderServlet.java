package com.pers.web;

import com.pers.pojo.Cart;
import com.pers.pojo.User;
import com.pers.service.OrderService;
import com.pers.service.impl.OrderServiceImpl;
import com.pers.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");

        if(user == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }

        String orderId = orderService.createOrder(cart, user.getId());



        System.out.println("orderId:" + orderId);
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
