/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datenlogik;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kadim
 */
@Entity
@Table(name = "seller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seller.findAll", query = "SELECT s FROM Seller s"),
    @NamedQuery(name = "Seller.findBySellerID", query = "SELECT s FROM Seller s WHERE s.sellerID = :sellerID"),
    @NamedQuery(name = "Seller.findByType", query = "SELECT s FROM Seller s WHERE s.type = :type"),
    @NamedQuery(name = "Seller.findByHumanmachineID", query = "SELECT s FROM Seller s WHERE s.humanmachineID = :humanmachineID")})
public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sellerID")
    private Integer sellerID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private int type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "humanmachineID")
    private int humanmachineID;

    public Seller() {
    }

    public Seller(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public Seller(Integer sellerID, int type, int humanmachineID) {
        this.sellerID = sellerID;
        this.type = type;
        this.humanmachineID = humanmachineID;
    }

    public Integer getSellerID() {
        return sellerID;
    }

    public void setSellerID(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getHumanmachineID() {
        return humanmachineID;
    }

    public void setHumanmachineID(int humanmachineID) {
        this.humanmachineID = humanmachineID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sellerID != null ? sellerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seller)) {
            return false;
        }
        Seller other = (Seller) object;
        if ((this.sellerID == null && other.sellerID != null) || (this.sellerID != null && !this.sellerID.equals(other.sellerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datenlogik.Seller[ sellerID=" + sellerID + " ]";
    }
    
}
