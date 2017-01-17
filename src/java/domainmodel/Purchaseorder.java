/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 545410
 */
@Entity
@Table(name = "purchaseorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchaseorder.findAll", query = "SELECT p FROM Purchaseorder p"),
    @NamedQuery(name = "Purchaseorder.findByPurchaseOrderId", query = "SELECT p FROM Purchaseorder p WHERE p.purchaseOrderId = :purchaseOrderId"),
    @NamedQuery(name = "Purchaseorder.findByShippingAddress", query = "SELECT p FROM Purchaseorder p WHERE p.shippingAddress = :shippingAddress"),
    @NamedQuery(name = "Purchaseorder.findByBillingAddress", query = "SELECT p FROM Purchaseorder p WHERE p.billingAddress = :billingAddress"),
    @NamedQuery(name = "Purchaseorder.findByDatePlaced", query = "SELECT p FROM Purchaseorder p WHERE p.datePlaced = :datePlaced"),
    @NamedQuery(name = "Purchaseorder.findByEstimatedDelivery", query = "SELECT p FROM Purchaseorder p WHERE p.estimatedDelivery = :estimatedDelivery"),
    @NamedQuery(name = "Purchaseorder.findByStatus", query = "SELECT p FROM Purchaseorder p WHERE p.status = :status")})
public class Purchaseorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchaseOrderId")
    private Integer purchaseOrderId;
    @Column(name = "shippingAddress")
    private Integer shippingAddress;
    @Column(name = "billingAddress")
    private Integer billingAddress;
    @Column(name = "datePlaced")
    @Temporal(TemporalType.DATE)
    private Date datePlaced;
    @Column(name = "estimatedDelivery")
    @Temporal(TemporalType.DATE)
    private Date estimatedDelivery;
    @Column(name = "status")
    private Character status;
    @JoinColumn(name = "cart", referencedColumnName = "cartid")
    @ManyToOne
    private Cart cart;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private User userid;

    public Purchaseorder() {
    }

    public Purchaseorder(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Integer getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Integer shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Integer getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Integer billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Date getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(Date datePlaced) {
        this.datePlaced = datePlaced;
    }

    public Date getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(Date estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseOrderId != null ? purchaseOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchaseorder)) {
            return false;
        }
        Purchaseorder other = (Purchaseorder) object;
        if ((this.purchaseOrderId == null && other.purchaseOrderId != null) || (this.purchaseOrderId != null && !this.purchaseOrderId.equals(other.purchaseOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Purchaseorder[ purchaseOrderId=" + purchaseOrderId + " ]";
    }
    
}
