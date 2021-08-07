package com.pers.test;

import com.pers.dao.OrderDao;
import com.pers.dao.impl.OrderDaoImpl;
import com.pers.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("20210531001", new Date(), new BigDecimal(99), 0, 1));
    }
}