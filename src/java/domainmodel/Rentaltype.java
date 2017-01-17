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
@Table(name = "rentaltype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rentaltype.findAll", query = "SELECT r FROM Rentaltype r"),
    @NamedQuery(name = "Rentaltype.findByRentalTypeId", query = "SELECT r FROM Rentaltype r WHERE r.rentalTypeId = :rentalTypeId"),
    @NamedQuery(name = "Rentaltype.findByRatePerDay", query = "SELECT r FROM Rentaltype r WHERE r.ratePerDay = :ratePerDay")})
public class Rentaltype implements Serializable {

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
    private List<Rentalorder> rentalorderList;

    public Rentaltype() {
    }

    public Rentaltype(Integer rentalTypeId) {
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
    public List<Rentalorder> getRentalorderList() {
        return rentalorderList;
    }

    public void setRentalorderList(List<Rentalorder> rentalorderList) {
        this.rentalorderList = rentalorderList;
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
        if (!(object instanceof Rentaltype)) {
            return false;
        }
        Rentaltype other = (Rentaltype) object;
        if ((this.rentalTypeId == null && other.rentalTypeId != null) || (this.rentalTypeId != null && !this.rentalTypeId.equals(other.rentalTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Rentaltype[ rentalTypeId=" + rentalTypeId + " ]";
    }
    
}
