/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 545410
 */
@Entity
@Table(name = "cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findByCartid", query = "SELECT c FROM Cart c WHERE c.cartid = :cartid"),
    @NamedQuery(name = "Cart.findByShipAndHandleCost", query = "SELECT c FROM Cart c WHERE c.shipAndHandleCost = :shipAndHandleCost"),
    @NamedQuery(name = "Cart.findByEstimatedTaxes", query = "SELECT c FROM Cart c WHERE c.estimatedTaxes = :estimatedTaxes")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cartid")
    private Integer cartid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "shipAndHandleCost")
    private BigDecimal shipAndHandleCost;
    @Column(name = "estimatedTaxes")
    private BigDecimal estimatedTaxes;
    @OneToMany(mappedBy = "cart")
    private List<Purchaseorder> purchaseorderList;
    @OneToMany(mappedBy = "cart")
    private List<Cartproduct> cartproductList;

    public Cart() {
    }

    public Cart(Integer cartid) {
        this.cartid = cartid;
    }

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
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

    @XmlTransient
    public List<Purchaseorder> getPurchaseorderList() {
        return purchaseorderList;
    }

    public void setPurchaseorderList(List<Purchaseorder> purchaseorderList) {
        this.purchaseorderList = purchaseorderList;
    }

    @XmlTransient
    public List<Cartproduct> getCartproductList() {
        return cartproductList;
    }

    public void setCartproductList(List<Cartproduct> cartproductList) {
        this.cartproductList = cartproductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartid != null ? cartid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.cartid == null && other.cartid != null) || (this.cartid != null && !this.cartid.equals(other.cartid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Cart[ cartid=" + cartid + " ]";
    }
    
}
