package com.pers.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServletTest {
    public void login(){
        System.out.println("login");
    }

    public void regist(){
        System.out.println("regist");
    }

    public static void main(String[] args) {

        String action = "login";
        try {
            Method declaredMethod = UserServletTest.class.getDeclaredMethod(action);

            System.out.println(declaredMethod);

            declaredMethod.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
