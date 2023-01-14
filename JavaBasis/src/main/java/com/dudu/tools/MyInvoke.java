package com.dudu.tools;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyInvoke {
    public static void setValue(Object dto, String name, Object value) {
        //将字符串进行首字母大写
        name=name.substring(0, 1).toUpperCase() + name.substring(1);
        try {
            //反射调用set+输入name值的方法，这里因为只是为了做Demo，不考虑复用问题
            Method m = (Method) dto.getClass().getMethod("set" + name,int.class);
            //方法调用
            m.invoke(dto, value);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Object getValue(Object dto, String name) {
        //将字符串进行首字母大写
        name=name.substring(0, 1).toUpperCase() + name.substring(1);
        try {
            //反射调用get+输入name值的方法，这里因为只是为了做Demo，不考虑复用问题
            Method m = (Method) dto.getClass().getMethod(("get" + name));
            // 调用getter方法获取属性值
            return m.invoke(dto);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
