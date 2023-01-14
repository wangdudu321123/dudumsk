package com.dudu.demo;

import com.dudu.cls.Person;
import com.dudu.tools.MyInvoke;

public class MyInvokeDemo {
    public static void main(String[] args) {
        Person person=new Person();
        MyInvoke.setValue(person,"age",123);
        System.out.println(MyInvoke.getValue(person,"age"));
    }
}
