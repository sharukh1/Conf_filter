/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import HibSession.SessionConnection;
import entity.Biodata;

import javax.ejb.Stateless;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Inspiron
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    @Override
    public String show(String name, int age, long phno) {
        
       Session s=new SessionConnection().connection();
       Transaction t=s.beginTransaction();
       
       Biodata b=new Biodata();
       b.setName(name);
       b.setAge(age);
       b.setPhno(phno);
       s.save(b);
       t.commit();
       s.close();
        return name+ " "+ age +" "+ phno+ "from bean class";
    }
    

   
}
