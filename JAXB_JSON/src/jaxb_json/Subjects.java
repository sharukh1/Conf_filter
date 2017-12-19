/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb_json;

/**
 *
 * @author Inspiron
 */
public class Subjects {
    String maths;
    String english;

    @Override
    public String toString() {
        return "maths=" + maths + ", english=" + english;
    }

    public String getMaths() {
        return maths;
    }

    public void setMaths(String maths) {
        this.maths = maths;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
