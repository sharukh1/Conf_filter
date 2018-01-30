/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb_json;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.Subject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Inspiron
 */
public class Writer {

    public static void main(String[] args) {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(Student.class);

            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Student s = new Student();
            List<Subjects> l = new ArrayList<>();
            Subjects s1 = new Subjects();
            Subjects s2 = new Subjects();

            s1.setMaths("miss1 maths");
            s1.setEnglish("miss1 english");

            s2.setMaths("miss2 maths");
            s2.setEnglish("miss2 english");

            l.add(s1);
            l.add(s2);

            s.setName("sharukh");
            s.setMark(50);
            s.setSub(l);

            marshallerObj.marshal(s, new FileOutputStream("C:/Users/Inspiron/Documents/Student.xml"));
        } catch (JAXBException | FileNotFoundException ex) {
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
