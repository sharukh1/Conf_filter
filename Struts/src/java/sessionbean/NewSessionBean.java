/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import bean.Register;
import javax.ejb.Stateless;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Inspiron
 */

public class NewSessionBean implements NewSessionBeanLocal {

    @Override
    public String register(Register r) {

        System.out.println("inside register");
        
        System.out.println(r.getId());
        System.out.println(r.getName());
        System.out.println(r.getPassword());
        //SessionFactory sf = NewHibernateUtil.NewHibernateUtil.getSessionFactory();
        Configuration c=new Configuration();
        c.configure("xml/hibernate.cfg.xml");
        SessionFactory sf=c.buildSessionFactory();
        Session s = sf.openSession();
//        Register reg = (Register) s.load(Register.class, 1);
//        String un = reg.getUsername();
//        if(reg != null) {
//            return "user exist";
//        } else {
            Transaction t = s.beginTransaction();
            s.save(r);
    
            t.commit();
            s.close();
            System.out.println("data saved");
            return "success";

//        }

    }

}
