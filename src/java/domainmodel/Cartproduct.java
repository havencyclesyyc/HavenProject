/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 545410
 */
@Entity
@Table(name = "cartproduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartProduct.findAll", query = "SELECT c FROM CartProduct c"),
    @NamedQuery(name = "CartProduct.findByCartProductId", query = "SELECT c FROM CartProduct c WHERE c.cartProductId = :cartProductId"),
    @NamedQuery(name = "CartProduct.findByProductId", query = "SELECT c FROM CartProduct c WHERE c.productId = :productId"),
    @NamedQuery(name = "CartProduct.findByQuantity", query = "SELECT c FROM CartProduct c WHERE c.quantity = :quantity"),
    @NamedQuery(name = "CartProduct.findByPrice", query = "SELECT c FROM CartProduct c WHERE c.price = :price")})
public class CartProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cartProductId")
    private Integer cartProductId;
    @Column(name = "productId")
    private Integer productId;
    @Column(name = "quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @JoinColumn(name = "cart", referencedColumnName = "cartid")
    @ManyToOne
    private Cart cart;

    public CartProduct() {
    }

    public CartProduct(Integer cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Integer getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(Integer cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartProductId != null ? cartProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartProduct)) {
            return false;
        }
        CartProduct other = (CartProduct) object;
        if ((this.cartProductId == null && other.cartProductId != null) || (this.cartProductId != null && !this.cartProductId.equals(other.cartProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.CartProduct[ cartProductId=" + cartProductId + " ]";
    }
    
}
