package com.pers.threadLocal;

public class OrderService {
    public void createOrder(){

        String name = Thread.currentThread().getName();
        System.out.println("OrderService线程[" + name + "]保存的数是" + ThreadLocalTest.threadLocal.get());

        (new OrderDao()).saveDao();

    }
}
