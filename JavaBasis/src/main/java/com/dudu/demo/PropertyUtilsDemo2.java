package com.dudu.demo;

import com.dudu.cls.Person2;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

public class PropertyUtilsDemo2 {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Person2 person=new Person2();
        System.out.println(PropertyUtils.getProperty(person,"other"));
    }
}
