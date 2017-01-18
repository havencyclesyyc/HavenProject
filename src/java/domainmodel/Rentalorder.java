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
@Table(name = "rentalorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RentalOrder.findAll", query = "SELECT r FROM RentalOrder r"),
    @NamedQuery(name = "RentalOrder.findByRentalOrderId", query = "SELECT r FROM RentalOrder r WHERE r.rentalOrderId = :rentalOrderId"),
    @NamedQuery(name = "RentalOrder.findByUserid", query = "SELECT r FROM RentalOrder r WHERE r.userid = :userid"),
    @NamedQuery(name = "RentalOrder.findByEndDate", query = "SELECT r FROM RentalOrder r WHERE r.endDate = :endDate"),
    @NamedQuery(name = "RentalOrder.findByStartDate", query = "SELECT r FROM RentalOrder r WHERE r.startDate = :startDate"),
    @NamedQuery(name = "RentalOrder.findByStatus", query = "SELECT r FROM RentalOrder r WHERE r.status = :status")})
public class RentalOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rentalOrderId")
    private Integer rentalOrderId;
    @Column(name = "userid")
    private Integer userid;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "status")
    private Character status;
    @JoinColumn(name = "rentalBikeId", referencedColumnName = "rentalBikeId")
    @ManyToOne
    private RentalBike rentalBikeId;
    @JoinColumn(name = "typeId", referencedColumnName = "rentalTypeId")
    @ManyToOne
    private RentalType typeId;

    public RentalOrder() {
    }

    public RentalOrder(Integer rentalOrderId) {
        this.rentalOrderId = rentalOrderId;
    }

    public Integer getRentalOrderId() {
        return rentalOrderId;
    }

    public void setRentalOrderId(Integer rentalOrderId) {
        this.rentalOrderId = rentalOrderId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public RentalBike getRentalBikeId() {
        return rentalBikeId;
    }

    public void setRentalBikeId(RentalBike rentalBikeId) {
        this.rentalBikeId = rentalBikeId;
    }

    public RentalType getTypeId() {
        return typeId;
    }

    public void setTypeId(RentalType typeId) {
        this.typeId = typeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rentalOrderId != null ? rentalOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RentalOrder)) {
            return false;
        }
        RentalOrder other = (RentalOrder) object;
        if ((this.rentalOrderId == null && other.rentalOrderId != null) || (this.rentalOrderId != null && !this.rentalOrderId.equals(other.rentalOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.RentalOrder[ rentalOrderId=" + rentalOrderId + " ]";
    }
    
}
