/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibSession;

/**
 *
 * @author Inspiron
 */
import entity.Biodata;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class SessionConnection {

    public Session connection() {
        Configuration conf=new Configuration();
        conf.configure("xml/Biodata.cfg.xml");
        SessionFactory sf=conf.buildSessionFactory();
        Session s=sf.openSession();
        return s;
       
    }
    
}
