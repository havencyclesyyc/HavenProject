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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 693663
 */
@Entity
@Table(name = "repairbike")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepairBike.findAll", query = "SELECT r FROM RepairBike r"),
    @NamedQuery(name = "RepairBike.findByRepairBikeId", query = "SELECT r FROM RepairBike r WHERE r.repairBikeId = :repairBikeId"),
    @NamedQuery(name = "RepairBike.findByYear", query = "SELECT r FROM RepairBike r WHERE r.year = :year"),
    @NamedQuery(name = "RepairBike.findByBrand", query = "SELECT r FROM RepairBike r WHERE r.brand = :brand"),
    @NamedQuery(name = "RepairBike.findByModel", query = "SELECT r FROM RepairBike r WHERE r.model = :model"),
    @NamedQuery(name = "RepairBike.findByType", query = "SELECT r FROM RepairBike r WHERE r.type = :type"),
    @NamedQuery(name = "RepairBike.findBySize", query = "SELECT r FROM RepairBike r WHERE r.size = :size"),
    @NamedQuery(name = "RepairBike.findByColor", query = "SELECT r FROM RepairBike r WHERE r.color = :color"),
    @NamedQuery(name = "RepairBike.findBySeatHeight", query = "SELECT r FROM RepairBike r WHERE r.seatHeight = :seatHeight")})
public class RepairBike implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "repairBikeId")
    private Integer repairBikeId;
    @Column(name = "year")
    private Integer year;
    @Size(max = 25)
    @Column(name = "brand")
    private String brand;
    @Size(max = 25)
    @Column(name = "model")
    private String model;
    @Size(max = 25)
    @Column(name = "type")
    private String type;
    @Size(max = 2)
    @Column(name = "size")
    private String size;
    @Size(max = 20)
    @Column(name = "color")
    private String color;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "seatHeight")
    private BigDecimal seatHeight;
    @OneToMany(mappedBy = "repairBikeId")
    private List<RepairOrder> repairOrderList;

    public RepairBike() {
    }

    public RepairBike(Integer repairBikeId) {
        this.repairBikeId = repairBikeId;
    }

    public Integer getRepairBikeId() {
        return repairBikeId;
    }

    public void setRepairBikeId(Integer repairBikeId) {
        this.repairBikeId = repairBikeId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(BigDecimal seatHeight) {
        this.seatHeight = seatHeight;
    }

    @XmlTransient
    public List<RepairOrder> getRepairOrderList() {
        return repairOrderList;
    }

    public void setRepairOrderList(List<RepairOrder> repairOrderList) {
        this.repairOrderList = repairOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repairBikeId != null ? repairBikeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepairBike)) {
            return false;
        }
        RepairBike other = (RepairBike) object;
        if ((this.repairBikeId == null && other.repairBikeId != null) || (this.repairBikeId != null && !this.repairBikeId.equals(other.repairBikeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.RepairBike[ repairBikeId=" + repairBikeId + " ]";
    }
    
}
