package com.dudu.demo;

import com.dudu.cls.Person;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

public class PropertyUtilsDemo {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Person person=new Person();
        PropertyUtils.setProperty(person,"age",999);
        System.out.println(PropertyUtils.getProperty(person,"age"));
    }
}
