/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxblearning;

import Model.Student;
import Model.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Inspiron
 */
public class JAXBLearning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
        
        System.out.println("****************");
       List<Subject> l=student.getSubject();
      for(Subject s: l){
          System.out.println( s.getId()+" " +s.getName());
      }
        System.out.println(student.getId()+" "+student.getName());
    
    }
    
}
