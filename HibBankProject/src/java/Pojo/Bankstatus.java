/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "bankstatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bankstatus.findAll", query = "SELECT b FROM Bankstatus b")
    , @NamedQuery(name = "Bankstatus.findByIdbankstatus", query = "SELECT b FROM Bankstatus b WHERE b.idbankstatus = :idbankstatus")
    , @NamedQuery(name = "Bankstatus.findByBankUsername", query = "SELECT b FROM Bankstatus b WHERE b.bankUsername = :bankUsername")
    , @NamedQuery(name = "Bankstatus.findByStatus", query = "SELECT b FROM Bankstatus b WHERE b.status = :status")})
public class Bankstatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbankstatus")
    private Integer idbankstatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bank_username")
    private String bankUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "idbank", referencedColumnName = "idbankreg")
    @OneToOne(optional = false)
    private Bankregister idbank;

    public Bankstatus() {
    }

    public Bankstatus(Integer idbankstatus) {
        this.idbankstatus = idbankstatus;
    }

    public Bankstatus(Integer idbankstatus, String bankUsername, String status) {
        this.idbankstatus = idbankstatus;
        this.bankUsername = bankUsername;
        this.status = status;
    }

    public Integer getIdbankstatus() {
        return idbankstatus;
    }

    public void setIdbankstatus(Integer idbankstatus) {
        this.idbankstatus = idbankstatus;
    }

    public String getBankUsername() {
        return bankUsername;
    }

    public void setBankUsername(String bankUsername) {
        this.bankUsername = bankUsername;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bankregister getIdbank() {
        return idbank;
    }

    public void setIdbank(Bankregister idbank) {
        this.idbank = idbank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbankstatus != null ? idbankstatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bankstatus)) {
            return false;
        }
        Bankstatus other = (Bankstatus) object;
        if ((this.idbankstatus == null && other.idbankstatus != null) || (this.idbankstatus != null && !this.idbankstatus.equals(other.idbankstatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pojo.Bankstatus[ idbankstatus=" + idbankstatus + " ]";
    }
    
}
