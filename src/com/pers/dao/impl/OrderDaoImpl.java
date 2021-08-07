package com.pers.dao.impl;

import com.pers.dao.OrderDao;
import com.pers.pojo.Order;

import java.util.Date;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO t_order(`order_id`,`create_time`,`price`,`status`, `user_id`) VALUES(?, ?, ?, ?, ?)";
        update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());

        return 0;
    }
}
