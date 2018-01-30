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
public class A {
private B b;


   

   
    public A() {
        System.out.println("A default const");
    }
    
    public void setB(B b){
        this.b=b;
        
    }
    
    

    public B getB() {
        return b;
    }
    
    public void display(){
        System.out.println("A display");
        
        b.display();
        
    }

    @Override
    public String toString() {
        return "A{" + "b=" + b + '}';
    }

   
    
}
