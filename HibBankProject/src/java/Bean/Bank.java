/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Pojo.Bankregister;
import Pojo.Bankstatus;
import Pojo.Login;
import SessionFactory.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Inspiron
 */
public class Bank implements BankLocal {

    @Override
    public String register(String name, String contactno, String username, String password) {
        Configuration c = new Configuration();
        c.configure("hibernate.cfg.xml");

        SessionFactory sf = c.buildSessionFactory();
        Session s = sf.openSession();
        Bankregister b = (Bankregister) s.load(Bankregister.class, username);
        String un = b.getBankUsername();
        if (!un.equals(null)) {
            return "user already registered";
        } else {
            Transaction t = s.beginTransaction();

            Bankregister br = new Bankregister();
            Bankstatus bs = new Bankstatus();

            br.setBankName(name);
            br.setBankUsername(username);
            br.setBankPassword(password);
            br.setBankContactno(contactno);

            bs.setBankUsername(username);
            bs.setStatus("0");

            br.setBankstatus(bs);
            bs.setIdbank(br);

            s.save(br);
            s.save(bs);

//Login l=new Login();
//l.setUsername(username);
//l.setPasssword(password);
            t.commit();
            s.close();
            return "success";

        }

    }

}
