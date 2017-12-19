/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflectionproject;

import Model.Student;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inspiron
 */
public class ReflectionProject {

    public ReflectionProject(Object obj) {
        Class c=obj.getClass();
        System.out.println("with getclass method: "+c);
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Student s=new Student();
            ReflectionProject rp=new ReflectionProject(s);
            try {
                Class c= Class.forName("Model.Student");
                System.out.println("with forName method: "+c.getName());
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReflectionProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Class c=Student.class;
            //  System.out.println("with class: "+c);
           Object obj= c.newInstance();
            Method m=c.getDeclaredMethod("study",int.class);
            m.setAccessible(true);
            m.invoke(obj,500);
            
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ReflectionProject.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }
    
}
