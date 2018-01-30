/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.Map;

/**
 *
 * @author Inspiron
 */
public class B {
private int id;
private Map<State,District> loc; 

    public Map<State, District> getLoc() {
        return loc;
    }

    public void setLoc(Map<State, District> loc) {
        this.loc = loc;
    }


    public B() {
        System.out.println("B default const");
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public void display(){
        System.out.println("B display"+id);
        System.out.println(">>"+loc);
    }
}
