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
@Table(name = "sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s"),
    @NamedQuery(name = "Sales.findBySalesID", query = "SELECT s FROM Sales s WHERE s.salesID = :salesID"),
    @NamedQuery(name = "Sales.findByStationID", query = "SELECT s FROM Sales s WHERE s.stationID = :stationID"),
    @NamedQuery(name = "Sales.findByProductID", query = "SELECT s FROM Sales s WHERE s.productID = :productID"),
    @NamedQuery(name = "Sales.findBySellerID", query = "SELECT s FROM Sales s WHERE s.sellerID = :sellerID"),
    @NamedQuery(name = "Sales.findByAmount", query = "SELECT s FROM Sales s WHERE s.amount = :amount"),
    @NamedQuery(name = "Sales.findByTimestamp", query = "SELECT s FROM Sales s WHERE s.timestamp = :timestamp")})
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "salesID")
    private Integer salesID;
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
    @Column(name = "sellerID")
    private int sellerID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public Sales() {
    }

    public Sales(Integer salesID) {
        this.salesID = salesID;
    }

    public Sales(Integer salesID, int stationID, int productID, int sellerID, int amount, Date timestamp) {
        this.salesID = salesID;
        this.stationID = stationID;
        this.productID = productID;
        this.sellerID = sellerID;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Integer getSalesID() {
        return salesID;
    }

    public void setSalesID(Integer salesID) {
        this.salesID = salesID;
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

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
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
        hash += (salesID != null ? salesID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.salesID == null && other.salesID != null) || (this.salesID != null && !this.salesID.equals(other.salesID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datenlogik.Sales[ salesID=" + salesID + " ]";
    }
    
}
