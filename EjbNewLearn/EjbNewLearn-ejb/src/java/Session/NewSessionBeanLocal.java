/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import javax.ejb.Local;

/**
 *
 * @author Inspiron
 */
@Local
public interface NewSessionBeanLocal {

    String show(String name, int age, long phno);
    
}
