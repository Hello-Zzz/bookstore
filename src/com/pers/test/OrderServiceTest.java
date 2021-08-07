package com.pers.test;

import com.pers.pojo.Cart;
import com.pers.pojo.CartItem;
import com.pers.service.OrderService;
import com.pers.service.impl.OrderServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(01, "乱世求生", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(01, "乱世求生", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(2, "水浒传", 1, new BigDecimal(56), new BigDecimal(56)));

        OrderService orderService = new OrderServiceImpl();
        orderService.createOrder(cart, 1);
    }
}