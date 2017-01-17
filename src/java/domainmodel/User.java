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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 545410
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserid", query = "SELECT u FROM User u WHERE u.userid = :userid"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByPasswordUUID", query = "SELECT u FROM User u WHERE u.passwordUUID = :passwordUUID"),
    @NamedQuery(name = "User.findByRegisterUUID", query = "SELECT u FROM User u WHERE u.registerUUID = :registerUUID")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "userid")
    private Integer userid;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "password")
    private String password;
    @Size(max = 25)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 25)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 50)
    @Column(name = "passwordUUID")
    private String passwordUUID;
    @Size(max = 50)
    @Column(name = "registerUUID")
    private String registerUUID;
    @OneToMany(mappedBy = "userid")
    private List<Address> addressList;
    @OneToMany(mappedBy = "userid")
    private List<Purchaseorder> purchaseorderList;
    @OneToMany(mappedBy = "userid")
    private List<Repairorder> repairorderList;
    @JoinColumn(name = "roleid", referencedColumnName = "roleid")
    @ManyToOne
    private Role roleid;

    public User() {
    }

    public User(Integer userid) {
        this.userid = userid;
    }

    public User(Integer userid, String email, String password) {
        this.userid = userid;
        this.email = email;
        this.password = password;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasswordUUID() {
        return passwordUUID;
    }

    public void setPasswordUUID(String passwordUUID) {
        this.passwordUUID = passwordUUID;
    }

    public String getRegisterUUID() {
        return registerUUID;
    }

    public void setRegisterUUID(String registerUUID) {
        this.registerUUID = registerUUID;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @XmlTransient
    public List<Purchaseorder> getPurchaseorderList() {
        return purchaseorderList;
    }

    public void setPurchaseorderList(List<Purchaseorder> purchaseorderList) {
        this.purchaseorderList = purchaseorderList;
    }

    @XmlTransient
    public List<Repairorder> getRepairorderList() {
        return repairorderList;
    }

    public void setRepairorderList(List<Repairorder> repairorderList) {
        this.repairorderList = repairorderList;
    }

    public Role getRoleid() {
        return roleid;
    }

    public void setRoleid(Role roleid) {
        this.roleid = roleid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.User[ userid=" + userid + " ]";
    }
    
}
