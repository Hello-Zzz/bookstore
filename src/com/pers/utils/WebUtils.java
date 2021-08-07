package com.pers.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static <T> T copyParamsToBean(Map map, T bean){
        System.out.println("注入前" + bean);
        try {
            BeanUtils.populate(bean, map);
            System.out.println("注入后" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;

    }

    public static int parseInt(String strInt, int defaultInt){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultInt;

    }
}
