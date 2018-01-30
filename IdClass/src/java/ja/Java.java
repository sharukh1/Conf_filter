/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Inspiron
 */
public class Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Configuration config=new Configuration();
        config.configure("ja/hibernate.cfg.xml");
        SessionFactory sf=config.buildSessionFactory();
        Session s=sf.openSession();
        Transaction t=s.beginTransaction();
       MyJava m=new MyJava();
       m.setAge(100);
        s.save(m);
        t.commit();
        s.close();
    }
    
}
