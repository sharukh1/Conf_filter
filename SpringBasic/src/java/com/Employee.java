/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Inspiron
 */
public class Employee {
   private int id;
   private String name;
   private List<Department> department;
   private Map<State,District> location;

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", department=" + department + ", location=" + location + '}';
    }

    public Map<State, District> getLocation() {
        return location;
    }

    public void setLocation(Map<State, District> location) {
        this.location = location;
    }

    public Employee() {
    }

    

   
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    
   
   
}
