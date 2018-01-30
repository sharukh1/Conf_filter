/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb_json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Inspiron
 */
public class WriteJson {
    public static void main(String[] args) {
        
        try {
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
            
            JSONObject jobjt=new JSONObject();
            jobjt.put("name", s.getName());
            jobjt.put("mark", s.getMark());
            
       //     JSONObject jobjt1=new JSONObject();
            JSONArray jarr=new JSONArray();
            for (Subjects sub :l) {
              jarr.put(sub.toString());
                
            }
             jobjt.put("subject", jarr);
          //   jobjt.put()
            FileWriter fileWriter = new FileWriter("C:/Users/Inspiron/Documents/NetBeansProjects/JAXB_JSON/src/jaxb_json/Student.json");
            fileWriter.write(jobjt.toString());
            fileWriter.flush();
        
  
             
        } catch (JSONException | IOException ex) {
            Logger.getLogger(WriteJson.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
}
