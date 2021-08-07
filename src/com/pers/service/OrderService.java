package com.pers.service;

import com.pers.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
