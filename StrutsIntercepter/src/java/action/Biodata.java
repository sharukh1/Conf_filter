/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Inspiron
 */
public class Biodata extends ActionSupport{
    private String name;
    private int  age;
    private int mark;

    public Biodata(String name, int age, int mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public Biodata() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarks() {
        return mark;
    }

    public void setMarks(int mark) {
        this.mark = mark;
    }

    @Override
    public String execute() throws Exception {
  
        if(name.equals("java")){
           return SUCCESS;
        }else{
            return ERROR;
        }
    }

    
    


    
    
    
}
