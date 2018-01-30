/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Address;
import entity.Location;
import entity.Place;
import entity.Zip;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Inspiron
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    @PersistenceContext(unitName = "EjbEmb-ejbPU")
    private EntityManager em;

    @Override
    public void insert() {
        
//        Address add=new Address();
//        add.setPlace("ernakulam");
//        
//        Zip zip=new Zip();
//        zip.setPin(1010);
//        
//        add.setPin(zip);
//        
//        em.persist(add);
//        
//        

Location l=new Location();
l.setName("sharukh");

Place p=new Place();
p.setCity("kochi");
p.setTown("ernakulam");

l.setPlace(p);

        persist(l);
        
    }

    public void persist(Object object) {
        em.persist(object);
    }

    
    
    
    
}
