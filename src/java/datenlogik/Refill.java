/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datenlogik;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kadim
 */
@Entity
@Table(name = "refill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Refill.findAll", query = "SELECT r FROM Refill r"),
    @NamedQuery(name = "Refill.findByRefillID", query = "SELECT r FROM Refill r WHERE r.refillID = :refillID"),
    @NamedQuery(name = "Refill.findBySuplier", query = "SELECT r FROM Refill r WHERE r.suplier = :suplier"),
    @NamedQuery(name = "Refill.findByStationID", query = "SELECT r FROM Refill r WHERE r.stationID = :stationID"),
    @NamedQuery(name = "Refill.findByProductID", query = "SELECT r FROM Refill r WHERE r.productID = :productID"),
    @NamedQuery(name = "Refill.findByAmount", query = "SELECT r FROM Refill r WHERE r.amount = :amount"),
    @NamedQuery(name = "Refill.findByTimestamp", query = "SELECT r FROM Refill r WHERE r.timestamp = :timestamp")})
public class Refill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "refillID")
    private Integer refillID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suplier")
    private int suplier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stationID")
    private int stationID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "productID")
    private int productID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public Refill() {
    }

    public Refill(Integer refillID) {
        this.refillID = refillID;
    }

    public Refill(Integer refillID, int suplier, int stationID, int productID, int amount, Date timestamp) {
        this.refillID = refillID;
        this.suplier = suplier;
        this.stationID = stationID;
        this.productID = productID;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Integer getRefillID() {
        return refillID;
    }

    public void setRefillID(Integer refillID) {
        this.refillID = refillID;
    }

    public int getSuplier() {
        return suplier;
    }

    public void setSuplier(int suplier) {
        this.suplier = suplier;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (refillID != null ? refillID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Refill)) {
            return false;
        }
        Refill other = (Refill) object;
        if ((this.refillID == null && other.refillID != null) || (this.refillID != null && !this.refillID.equals(other.refillID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datenlogik.Refill[ refillID=" + refillID + " ]";
    }
    
}
