/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import bean.Register;
import javax.ejb.Local;

/**
 *
 * @author Inspiron
 */

public interface NewSessionBeanLocal {

    String register(Register r);
    
}
