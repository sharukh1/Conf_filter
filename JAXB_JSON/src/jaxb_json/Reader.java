/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb_json;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Inspiron
 */
public class Reader {
    public static void main(String[] args) {
        try {
            File file = new File("C:/Users/Inspiron/Documents/Student.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();    
            Student s=(Student) jaxbUnmarshaller.unmarshal(file);
           
            System.out.println(s.getName()+"  "+s.getMark());
             for (Subjects sub : s.getSub()) {
                System.out.println("sub-"+sub.getEnglish()+""+sub.getMaths());
            }
        } catch (JAXBException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
