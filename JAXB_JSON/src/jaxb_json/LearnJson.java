/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb_json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

/**
 *
 * @author Inspiron
 */
public class LearnJson {
    public static void main(String[] args) {
        try {
            String s="C:/Users/Inspiron/Documents/NetBeansProjects/JAXB_JSON/src/jaxb_json/LearnJson.json";
            Object obj=JSONValue.parse(new FileReader(s));
            JSONObject jobjt=(JSONObject)obj;
            
            long i=(long)jobjt.get("model");
            System.out.println(i);
            String n=(String)jobjt.get("name");
            System.out.println(n);
            JSONObject jobjt1=(JSONObject) jobjt.get("features");
JSONArray jarr1=(JSONArray) jobjt1.get("dellmusic");
for (int j = 0; j < jarr1.size(); j++) {
                System.out.println(jarr1.get(j));
            }
JSONArray jarr2=(JSONArray) jobjt1.get("dellaudio");
 for (int j = 0; j < jarr2.size(); j++) {
                System.out.println(jarr2.get(j));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LearnJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
