package com.dudu.demo;

import com.dudu.cls.Person;

public class PersonDemo {
    public static void main(String[] args) {
        Person person=new Person();
        person.setName("Do");
        person.setAge(20);
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
