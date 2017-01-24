/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 693663
 */
@Entity
@Table(name = "purchaseorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrder.findAll", query = "SELECT p FROM PurchaseOrder p"),
    @NamedQuery(name = "PurchaseOrder.findByPurchaseOrderId", query = "SELECT p FROM PurchaseOrder p WHERE p.purchaseOrderId = :purchaseOrderId"),
    @NamedQuery(name = "PurchaseOrder.findByCart", query = "SELECT p FROM PurchaseOrder p WHERE p.cart = :cart"),
    @NamedQuery(name = "PurchaseOrder.findByShippingAddress", query = "SELECT p FROM PurchaseOrder p WHERE p.shippingAddress = :shippingAddress"),
    @NamedQuery(name = "PurchaseOrder.findByBillingAddress", query = "SELECT p FROM PurchaseOrder p WHERE p.billingAddress = :billingAddress"),
    @NamedQuery(name = "PurchaseOrder.findByDatePlaced", query = "SELECT p FROM PurchaseOrder p WHERE p.datePlaced = :datePlaced"),
    @NamedQuery(name = "PurchaseOrder.findByEstimatedDelivery", query = "SELECT p FROM PurchaseOrder p WHERE p.estimatedDelivery = :estimatedDelivery"),
    @NamedQuery(name = "PurchaseOrder.findByStatus", query = "SELECT p FROM PurchaseOrder p WHERE p.status = :status"),
    @NamedQuery(name = "PurchaseOrder.findByShipAndHandleCost", query = "SELECT p FROM PurchaseOrder p WHERE p.shipAndHandleCost = :shipAndHandleCost"),
    @NamedQuery(name = "PurchaseOrder.findByEstimatedTaxes", query = "SELECT p FROM PurchaseOrder p WHERE p.estimatedTaxes = :estimatedTaxes")})
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchaseOrderId")
    private Integer purchaseOrderId;
    @Column(name = "cart")
    private Integer cart;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "shipAndHandleCost")
    private BigDecimal shipAndHandleCost;
    @Column(name = "estimatedTaxes")
    private BigDecimal estimatedTaxes;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne
    private User userId;
    @OneToMany(mappedBy = "purchaseOrderId")
    private List<CartProduct> cartProductList;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Integer getCart() {
        return cart;
    }

    public void setCart(Integer cart) {
        this.cart = cart;
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

    public BigDecimal getShipAndHandleCost() {
        return shipAndHandleCost;
    }

    public void setShipAndHandleCost(BigDecimal shipAndHandleCost) {
        this.shipAndHandleCost = shipAndHandleCost;
    }

    public BigDecimal getEstimatedTaxes() {
        return estimatedTaxes;
    }

    public void setEstimatedTaxes(BigDecimal estimatedTaxes) {
        this.estimatedTaxes = estimatedTaxes;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<CartProduct> getCartProductList() {
        return cartProductList;
    }

    public void setCartProductList(List<CartProduct> cartProductList) {
        this.cartProductList = cartProductList;
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
        if (!(object instanceof PurchaseOrder)) {
            return false;
        }
        PurchaseOrder other = (PurchaseOrder) object;
        if ((this.purchaseOrderId == null && other.purchaseOrderId != null) || (this.purchaseOrderId != null && !this.purchaseOrderId.equals(other.purchaseOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.PurchaseOrder[ purchaseOrderId=" + purchaseOrderId + " ]";
    }
    
}
