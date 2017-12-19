/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb_json;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inspiron
 */
@XmlRootElement
public class Student {
    String name;
    int mark;
    List<Subjects> sub;

    public List<Subjects> getSub() {
        return sub;
    }

    public void setSub(List<Subjects> sub) {
        this.sub = sub;
    }
@XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@XmlElement
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    
}
