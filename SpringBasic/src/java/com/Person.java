/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.List;

/**
 *
 * @author Inspiron
 */
public class Person {
    String name;
    List<Integer> phno;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(List<Integer> phno) {
        this.phno = phno;
    }

    
    
    public Person(String name, List<Integer> phno) {
        this.name = name;
        this.phno = phno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPhno() {
        return phno;
    }

    public void setPhno(List<Integer> phno) {
        this.phno = phno;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", phno=" + phno + '}';
    }

   
}
