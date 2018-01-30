/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bean.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author Inspiron
 */
public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student s=(Student)context.getBean("s1");
        System.out.println("with applicationcontext: "+s);
        
        Resource r=new ClassPathResource("applicationContext.xml");
        BeanFactory f=new XmlBeanFactory(r);
        Student bf=(Student)f.getBean("s2");
        System.out.println("with beanfactory: "+bf);

    }
}
