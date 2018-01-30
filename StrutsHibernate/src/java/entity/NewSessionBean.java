/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Inspiron
 */
public class NewSessionBean {
    
    public String insert(Registration r) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
//  Query q =  session.createQuery("select l from Login l where l.username=:username");
//  List<Login> list = q.setParameter("username", r.getLogin().getUsername()).list();
//  if(list.size()>0){
//      return "user already present";
//  }else{

        Transaction transaction = session.beginTransaction();
         
        System.out.println("--------------------------------"+r.getIdReg());
 
//        add.setRegister(r);
//       
//        Login log = r.getLogin();
//        log.setRegister(r);
//        System.out.println(r.getName());
//        System.out.println(r.getAge());
//        System.out.println(r.getAddress().getPin());
//       
//        System.out.println(r.getAddress().getPlace());
//        System.out.println(r.getAddress().getStreet());
//        System.out.println(r.getLogin().getUsername());
//        System.out.println(r.getLogin().getPassword());
       

//        
//        
//        System.out.println("----------------");
// 
    session.save(r);
        session.close();
        return "success";
        //}
        
    }
}
