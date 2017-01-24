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
 * @author 693663
 */
@Entity
@Table(name = "rentaltype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RentalType.findAll", query = "SELECT r FROM RentalType r"),
    @NamedQuery(name = "RentalType.findByRentalTypeId", query = "SELECT r FROM RentalType r WHERE r.rentalTypeId = :rentalTypeId"),
    @NamedQuery(name = "RentalType.findByRatePerDay", query = "SELECT r FROM RentalType r WHERE r.ratePerDay = :ratePerDay")})
public class RentalType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rentalTypeId")
    private Integer rentalTypeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ratePerDay")
    private BigDecimal ratePerDay;
    @OneToMany(mappedBy = "typeId")
    private List<RentalOrder> rentalOrderList;

    public RentalType() {
    }

    public RentalType(Integer rentalTypeId) {
        this.rentalTypeId = rentalTypeId;
    }

    public Integer getRentalTypeId() {
        return rentalTypeId;
    }

    public void setRentalTypeId(Integer rentalTypeId) {
        this.rentalTypeId = rentalTypeId;
    }

    public BigDecimal getRatePerDay() {
        return ratePerDay;
    }

    public void setRatePerDay(BigDecimal ratePerDay) {
        this.ratePerDay = ratePerDay;
    }

    @XmlTransient
    public List<RentalOrder> getRentalOrderList() {
        return rentalOrderList;
    }

    public void setRentalOrderList(List<RentalOrder> rentalOrderList) {
        this.rentalOrderList = rentalOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rentalTypeId != null ? rentalTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RentalType)) {
            return false;
        }
        RentalType other = (RentalType) object;
        if ((this.rentalTypeId == null && other.rentalTypeId != null) || (this.rentalTypeId != null && !this.rentalTypeId.equals(other.rentalTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.RentalType[ rentalTypeId=" + rentalTypeId + " ]";
    }
    
}
