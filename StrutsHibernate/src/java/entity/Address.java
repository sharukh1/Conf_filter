/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inspiron
 */
@Entity
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByIdAdd", query = "SELECT a FROM Address a WHERE a.idAdd = :idAdd")
    , @NamedQuery(name = "Address.findByPlace", query = "SELECT a FROM Address a WHERE a.place = :place")
    , @NamedQuery(name = "Address.findByPin", query = "SELECT a FROM Address a WHERE a.pin = :pin")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAdd")
    private Integer idAdd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "place")
    private String place;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pin")
    private int pin;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Registration username;

    public Address() {
    }

    public Address(Integer idAdd) {
        this.idAdd = idAdd;
    }

    public Address(Integer idAdd, String place, int pin) {
        this.idAdd = idAdd;
        this.place = place;
        this.pin = pin;
    }

    public Integer getIdAdd() {
        return idAdd;
    }

    public void setIdAdd(Integer idAdd) {
        this.idAdd = idAdd;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Registration getUsername() {
        return username;
    }

    public void setUsername(Registration username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdd != null ? idAdd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.idAdd == null && other.idAdd != null) || (this.idAdd != null && !this.idAdd.equals(other.idAdd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Address[ idAdd=" + idAdd + " ]";
    }
    
}
