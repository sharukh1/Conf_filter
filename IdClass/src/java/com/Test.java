/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Inspiron
 */
public class Test {
    public static void main(String[] args) {
        Configuration config=new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sf=config.buildSessionFactory();
        Session s=sf.openSession();
        Transaction t=s.beginTransaction();
        MyEntity e=new MyEntity();
        e.setId(1);
        e.setRid(2);
       // e.setSid(3);
        s.save(e);
        t.commit();
        s.close();
    }
}
