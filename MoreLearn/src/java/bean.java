

import com.Student;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Inspiron
 */
public class bean {
    public String insert(String name,String gender,String lang,String place){
        
     SessionFactory sf=   NewHibernateUtil.getSessionFactory();
        Session s=sf.openSession();
//     String hql = "FROM Student E WHERE E.name = :name";
//Query q = s.createQuery(hql);
//q.setParameter("name",name);
////List results = query.list();
//       List<Student> l=q.list();
//       int size=l.size();
//       if(size<1){
//String c = String.join(",", lang);
//StringBuffer sb=new StringBuffer();
//for(String ss:lang){
//    sb.append(ss);
//}


           Transaction t=s.beginTransaction();
           Student st=new Student();
           st.setId(1);
           st.setName(name);
           st.setGender(gender);
           st.setLanguage(lang);
           st.setPlace(place);
           s.save(st);
           t.commit();
           return "ok";
           
//       }else{
//           return "error";
//       }
//        
        
        
        
    }
    
    public List<Student> retrive(){
        SessionFactory sf=   NewHibernateUtil.getSessionFactory();
        Session s=sf.openSession();
         String hql = "select e FROM  Student e";
Query q = s.createQuery(hql);
List<Student> list=q.list();
        
    return list;    
    }
}
