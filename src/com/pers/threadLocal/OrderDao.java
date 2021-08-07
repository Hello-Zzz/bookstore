package com.pers.threadLocal;

public class OrderDao {
    public void saveDao(){
        String name = Thread.currentThread().getName();
        System.out.println("saveDao当前线程[" + name + "]保存的数是" + ThreadLocalTest.threadLocal.get());
    }
}
