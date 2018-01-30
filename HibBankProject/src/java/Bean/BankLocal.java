/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.ejb.Local;

/**
 *
 * @author Inspiron
 */

public interface BankLocal {

    String register(String name, String contactno, String username, String password);
    
}
