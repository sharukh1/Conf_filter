/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.Serializable;

/**
 *
 * @author Inspiron
 */
public class MyClass implements Serializable{
    int sid;
    int rid;

   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.sid;
        hash = 79 * hash + this.rid;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyClass other = (MyClass) obj;
        return true;
    }

    @Override
    public String toString() {
        return "MyClass{" + "sid=" + sid + ", rid=" + rid + '}';
    }
    
}
