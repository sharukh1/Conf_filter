/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author Inspiron
 */
@MappedSuperclass
public class MyBase {
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
