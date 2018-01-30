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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Inspiron
 */
public class ReaderJson {

    public static void main(String[] args) {
        try {
            String s = "C:/Users/Inspiron/Documents/NetBeansProjects/JAXB_JSON/src/jaxb_json/Student.json";
            Object obj = JSONValue.parse(new FileReader(s));

            JSONObject jobjct = (JSONObject) obj;
            JSONArray jarr = (JSONArray) jobjct.get("subject");
            for (int i = 0; i < jarr.size(); i++) {
                System.out.println(jarr.get(i));
            }
            String n = (String) jobjct.get("name");
            long m = (long) jobjct.get("mark");
            System.out.println(n + " " + m);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
