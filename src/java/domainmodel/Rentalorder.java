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
    @NamedQuery(name = "Rentalorder.findAll", query = "SELECT r FROM Rentalorder r"),
    @NamedQuery(name = "Rentalorder.findByRentalOrderId", query = "SELECT r FROM Rentalorder r WHERE r.rentalOrderId = :rentalOrderId"),
    @NamedQuery(name = "Rentalorder.findByUserid", query = "SELECT r FROM Rentalorder r WHERE r.userid = :userid"),
    @NamedQuery(name = "Rentalorder.findByEndDate", query = "SELECT r FROM Rentalorder r WHERE r.endDate = :endDate"),
    @NamedQuery(name = "Rentalorder.findByStartDate", query = "SELECT r FROM Rentalorder r WHERE r.startDate = :startDate"),
    @NamedQuery(name = "Rentalorder.findByStatus", query = "SELECT r FROM Rentalorder r WHERE r.status = :status")})
public class Rentalorder implements Serializable {

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
    private Rentalbike rentalBikeId;
    @JoinColumn(name = "typeId", referencedColumnName = "rentalTypeId")
    @ManyToOne
    private Rentaltype typeId;

    public Rentalorder() {
    }

    public Rentalorder(Integer rentalOrderId) {
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

    public Rentalbike getRentalBikeId() {
        return rentalBikeId;
    }

    public void setRentalBikeId(Rentalbike rentalBikeId) {
        this.rentalBikeId = rentalBikeId;
    }

    public Rentaltype getTypeId() {
        return typeId;
    }

    public void setTypeId(Rentaltype typeId) {
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
        if (!(object instanceof Rentalorder)) {
            return false;
        }
        Rentalorder other = (Rentalorder) object;
        if ((this.rentalOrderId == null && other.rentalOrderId != null) || (this.rentalOrderId != null && !this.rentalOrderId.equals(other.rentalOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Rentalorder[ rentalOrderId=" + rentalOrderId + " ]";
    }
    
}
