package com.pers.test;

import com.pers.dao.OrderItemDao;
import com.pers.dao.impl.OrderItemDaoImpl;
import com.pers.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null, "python实战", 1,
                new BigDecimal(68), new BigDecimal(68), "20210531001"));
        orderItemDao.saveOrderItem(new OrderItem(null, "设计模式", 2,
                new BigDecimal(50), new BigDecimal(100), "20210531001"));
    }
}