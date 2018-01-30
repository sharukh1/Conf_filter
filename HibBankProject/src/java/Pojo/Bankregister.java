/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inspiron
 */
@Entity
@Table(name = "bankregister")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bankregister.findAll", query = "SELECT b FROM Bankregister b")
    , @NamedQuery(name = "Bankregister.findByIdbankreg", query = "SELECT b FROM Bankregister b WHERE b.idbankreg = :idbankreg")
    , @NamedQuery(name = "Bankregister.findByBankName", query = "SELECT b FROM Bankregister b WHERE b.bankName = :bankName")
    , @NamedQuery(name = "Bankregister.findByBankContactno", query = "SELECT b FROM Bankregister b WHERE b.bankContactno = :bankContactno")
    , @NamedQuery(name = "Bankregister.findByBankUsername", query = "SELECT b FROM Bankregister b WHERE b.bankUsername = :bankUsername")
    , @NamedQuery(name = "Bankregister.findByBankPassword", query = "SELECT b FROM Bankregister b WHERE b.bankPassword = :bankPassword")})
public class Bankregister implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbankreg")
    private Integer idbankreg;
    @Size(max = 50)
    @Column(name = "bank_name")
    private String bankName;
    @Size(max = 50)
    @Column(name = "bank_contactno")
    private String bankContactno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bank_username")
    private String bankUsername;
    @Size(max = 50)
    @Column(name = "bank_password")
    private String bankPassword;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idbank")
    private Bankstatus bankstatus;

    public Bankregister() {
    }

    public Bankregister(Integer idbankreg) {
        this.idbankreg = idbankreg;
    }

    public Bankregister(Integer idbankreg, String bankUsername) {
        this.idbankreg = idbankreg;
        this.bankUsername = bankUsername;
    }

    public Integer getIdbankreg() {
        return idbankreg;
    }

    public void setIdbankreg(Integer idbankreg) {
        this.idbankreg = idbankreg;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankContactno() {
        return bankContactno;
    }

    public void setBankContactno(String bankContactno) {
        this.bankContactno = bankContactno;
    }

    public String getBankUsername() {
        return bankUsername;
    }

    public void setBankUsername(String bankUsername) {
        this.bankUsername = bankUsername;
    }

    public String getBankPassword() {
        return bankPassword;
    }

    public void setBankPassword(String bankPassword) {
        this.bankPassword = bankPassword;
    }

    public Bankstatus getBankstatus() {
        return bankstatus;
    }

    public void setBankstatus(Bankstatus bankstatus) {
        this.bankstatus = bankstatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbankreg != null ? idbankreg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bankregister)) {
            return false;
        }
        Bankregister other = (Bankregister) object;
        if ((this.idbankreg == null && other.idbankreg != null) || (this.idbankreg != null && !this.idbankreg.equals(other.idbankreg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pojo.Bankregister[ idbankreg=" + idbankreg + " ]";
    }
    
}
