/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Address;
import entity.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



/**
 *
 * @author Inspiron
 */
public class Logic {
    
    public String insert(String name,int age,String place,String street,int pin){
  SessionFactory sf= NewHibernateUtil.getSessionFactory();
  Session s=sf.openSession();
//  Student q=(Student)s.get(Student.class, 1);
Query q=s.getNamedQuery("Student.findByName");
Query qq=q.setParameter("name", name);
//  if(q.getName().equals("null") || q.getName().equals("")){
if(qq.equals(null)){
      Transaction t=s.beginTransaction();
  Student stud=new Student();
  Address add=new Address();
  add.setStreet(street);
  add.setPlace(place);
  add.setPin(pin);
  stud.setName(name);
  stud.setAge(age);
  stud.setAddressid(add);
   s.save(add);
  s.save(stud);
 t.commit();
 s.close();
 return "ok";
      
  }else{
      return "user exist";
  }
  
  
    }
}
