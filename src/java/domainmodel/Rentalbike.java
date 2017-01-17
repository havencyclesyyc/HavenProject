/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
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
 * @author 545410
 */
@Entity
@Table(name = "rentalbike")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rentalbike.findAll", query = "SELECT r FROM Rentalbike r"),
    @NamedQuery(name = "Rentalbike.findByRentalBikeId", query = "SELECT r FROM Rentalbike r WHERE r.rentalBikeId = :rentalBikeId"),
    @NamedQuery(name = "Rentalbike.findByAvailable", query = "SELECT r FROM Rentalbike r WHERE r.available = :available"),
    @NamedQuery(name = "Rentalbike.findByYear", query = "SELECT r FROM Rentalbike r WHERE r.year = :year"),
    @NamedQuery(name = "Rentalbike.findByBrand", query = "SELECT r FROM Rentalbike r WHERE r.brand = :brand"),
    @NamedQuery(name = "Rentalbike.findByModel", query = "SELECT r FROM Rentalbike r WHERE r.model = :model"),
    @NamedQuery(name = "Rentalbike.findBySize", query = "SELECT r FROM Rentalbike r WHERE r.size = :size"),
    @NamedQuery(name = "Rentalbike.findByColor", query = "SELECT r FROM Rentalbike r WHERE r.color = :color"),
    @NamedQuery(name = "Rentalbike.findByDescription", query = "SELECT r FROM Rentalbike r WHERE r.description = :description")})
public class Rentalbike implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rentalBikeId")
    private Integer rentalBikeId;
    @Column(name = "available")
    private Character available;
    @Column(name = "year")
    private Integer year;
    @Size(max = 25)
    @Column(name = "brand")
    private String brand;
    @Size(max = 20)
    @Column(name = "model")
    private String model;
    @Size(max = 2)
    @Column(name = "size")
    private String size;
    @Size(max = 20)
    @Column(name = "color")
    private String color;
    @Size(max = 2000)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "rentalBikeId")
    private List<Rentalorder> rentalorderList;

    public Rentalbike() {
    }

    public Rentalbike(Integer rentalBikeId) {
        this.rentalBikeId = rentalBikeId;
    }

    public Integer getRentalBikeId() {
        return rentalBikeId;
    }

    public void setRentalBikeId(Integer rentalBikeId) {
        this.rentalBikeId = rentalBikeId;
    }

    public Character getAvailable() {
        return available;
    }

    public void setAvailable(Character available) {
        this.available = available;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (rentalBikeId != null ? rentalBikeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rentalbike)) {
            return false;
        }
        Rentalbike other = (Rentalbike) object;
        if ((this.rentalBikeId == null && other.rentalBikeId != null) || (this.rentalBikeId != null && !this.rentalBikeId.equals(other.rentalBikeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Rentalbike[ rentalBikeId=" + rentalBikeId + " ]";
    }
    
}
