/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Inspiron
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //with constructor-arg
//        Student stud= (Student)context.getBean("s");
//        System.out.println(stud.toString());
//        System.out.println("*************************");
//        //with property tag
//        Student studProp= (Student)context.getBean("p");
//        System.out.println(studProp.toString());
        
        System.out.println("********collection***********");
        Person p=(Person) context.getBean("per");
        System.out.println(p.toString());
        
        Person ss=(Person) context.getBean("perpro");
        System.out.println(ss.getName());
        System.out.println(ss.getPhno());
        
          System.out.println("********collection user defined type for list***********");
          Employee e=(Employee) context.getBean("emp1");
        System.out.println(e);
        
        
        Employee emp=(Employee) context.getBean("emp2");
        System.out.println(emp);
        
        A a=(A)context.getBean("a");
        a.display();
        
        
    }
}
