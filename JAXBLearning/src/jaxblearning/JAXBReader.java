/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxblearning;

import Model.Student;
import Model.Subject;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Inspiron
 */
public class JAXBReader {
    public static void main(String[] args) {
        try {
            File f=new File("C:/Users/Inspiron/Documents/Student.xml");
            JAXBContext jaxbcontext=JAXBContext.newInstance(Student.class);
            Unmarshaller unmarsheller=jaxbcontext.createUnmarshaller();
            Student s=(Student) unmarsheller.unmarshal(f);
            System.out.println("unmarshall");
            System.out.println(s.getName()+" "+s.getId());
             List<Subject> l=s.getSubject();
      for(Subject s1: l){
          System.out.println( s1.getId()+" " +s1.getName());
      }
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
