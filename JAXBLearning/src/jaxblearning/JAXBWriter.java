/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxblearning;

import Model.Student;
import Model.Subject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Inspiron
 */
public class JAXBWriter {
    public static void main(String[] args) {
         Subject subject1=new Subject();
        subject1.setId(1);
        subject1.setName("English");
         Subject subject2=new Subject();
          subject2.setId(2);
        subject2.setName("Malayalam");
        List<Subject> list=new ArrayList<>();
        list.add(subject1);
        list.add(subject2);
        
        Student student=new Student();
        student.setId(1);
        student.setName("sharukh");
        student.setSubject(list);
        try {
            JAXBContext jaxbcontect=JAXBContext.newInstance(Student.class);
            Marshaller marshaller=jaxbcontect.createMarshaller();
            marshaller.marshal(student, new FileOutputStream("C:/Users/Inspiron/Documents/Student.xml"));
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JAXBWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
