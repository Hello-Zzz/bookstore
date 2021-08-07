package com.pers.threadLocal;

import com.alibaba.druid.sql.dialect.odps.ast.OdpsAddStatisticStatement;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class ThreadLocalTest {
//    public static Map<String, Object> map = new Hashtable<>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    private static Random random = new Random();

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            Integer i = random.nextInt(100);
            String name = Thread.currentThread().getName();
            System.out.println("线程[" + name + "]生成的随机数是" + i);

            // map.put(name, i);
            threadLocal.set(i);
            try {
                Thread.sleep(1000*3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            (new OrderService()).createOrder();

            // Object o = map.get(name);
            Object o = threadLocal.get();
            System.out.println("线程[" + name + "]即将结束时，生成的随机数是" + o);

        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            new Thread(new MyThread()).start();
        }
    }
}
