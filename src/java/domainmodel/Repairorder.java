/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 545410
 */
@Entity
@Table(name = "repairorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepairOrder.findAll", query = "SELECT r FROM RepairOrder r"),
    @NamedQuery(name = "RepairOrder.findByRepairOrderId", query = "SELECT r FROM RepairOrder r WHERE r.repairOrderId = :repairOrderId"),
    @NamedQuery(name = "RepairOrder.findByEndDate", query = "SELECT r FROM RepairOrder r WHERE r.endDate = :endDate"),
    @NamedQuery(name = "RepairOrder.findByStartDate", query = "SELECT r FROM RepairOrder r WHERE r.startDate = :startDate"),
    @NamedQuery(name = "RepairOrder.findByCost", query = "SELECT r FROM RepairOrder r WHERE r.cost = :cost"),
    @NamedQuery(name = "RepairOrder.findByNotes", query = "SELECT r FROM RepairOrder r WHERE r.notes = :notes"),
    @NamedQuery(name = "RepairOrder.findByStatus", query = "SELECT r FROM RepairOrder r WHERE r.status = :status")})
public class RepairOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "repairOrderId")
    private Integer repairOrderId;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private BigDecimal cost;
    @Size(max = 5000)
    @Column(name = "notes")
    private String notes;
    @Column(name = "status")
    private Character status;
    @JoinColumn(name = "repairBikeId", referencedColumnName = "repairBikeId")
    @ManyToOne
    private RepairBike repairBikeId;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private User userid;

    public RepairOrder() {
    }

    public RepairOrder(Integer repairOrderId) {
        this.repairOrderId = repairOrderId;
    }

    public Integer getRepairOrderId() {
        return repairOrderId;
    }

    public void setRepairOrderId(Integer repairOrderId) {
        this.repairOrderId = repairOrderId;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public RepairBike getRepairBikeId() {
        return repairBikeId;
    }

    public void setRepairBikeId(RepairBike repairBikeId) {
        this.repairBikeId = repairBikeId;
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
        hash += (repairOrderId != null ? repairOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepairOrder)) {
            return false;
        }
        RepairOrder other = (RepairOrder) object;
        if ((this.repairOrderId == null && other.repairOrderId != null) || (this.repairOrderId != null && !this.repairOrderId.equals(other.repairOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.RepairOrder[ repairOrderId=" + repairOrderId + " ]";
    }
    
}
