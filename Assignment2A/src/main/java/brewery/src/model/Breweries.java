/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brewery.src.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
//import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
//import javax.validation.constraints.NotBlank;

/**
 *
 * @author k00203657
 */
@Entity
@Table(name = "breweries")
@SecondaryTable(name = "breweries_geocode", pkJoinColumns = @PrimaryKeyJoinColumn(name = "brewery_id", referencedColumnName = "id"))

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Breweries.findAll", query = "SELECT b FROM Breweries b"),
    @NamedQuery(name = "Breweries.findById", query = "SELECT b FROM Breweries b WHERE b.id = :id"),
    @NamedQuery(name = "Breweries.findByName", query = "SELECT b FROM Breweries b WHERE b.name = :name"),
    @NamedQuery(name = "Breweries.findByAddress1", query = "SELECT b FROM Breweries b WHERE b.address1 = :address1"),
    @NamedQuery(name = "Breweries.findByAddress2", query = "SELECT b FROM Breweries b WHERE b.address2 = :address2"),
    @NamedQuery(name = "Breweries.findByCity", query = "SELECT b FROM Breweries b WHERE b.city = :city"),
    @NamedQuery(name = "Breweries.findByState", query = "SELECT b FROM Breweries b WHERE b.state = :state"),
    @NamedQuery(name = "Breweries.findByCode", query = "SELECT b FROM Breweries b WHERE b.code = :code"),
    @NamedQuery(name = "Breweries.findByCountry", query = "SELECT b FROM Breweries b WHERE b.country = :country"),
    @NamedQuery(name = "Breweries.findByPhone", query = "SELECT b FROM Breweries b WHERE b.phone = :phone"),
    @NamedQuery(name = "Breweries.findByWebsite", query = "SELECT b FROM Breweries b WHERE b.website = :website"),
    @NamedQuery(name = "Breweries.findByImage", query = "SELECT b FROM Breweries b WHERE b.image = :image"),
    @NamedQuery(name = "Breweries.findByAddUser", query = "SELECT b FROM Breweries b WHERE b.addUser = :addUser"),
    @NamedQuery(name = "Breweries.findByLastMod", query = "SELECT b FROM Breweries b WHERE b.lastMod = :lastMod"),
    @NamedQuery(name = "Breweries.findByCreditLimit", query = "SELECT b FROM Breweries b WHERE b.creditLimit = :creditLimit"),
    @NamedQuery(name = "Breweries.findByEmail", query = "SELECT b FROM Breweries b WHERE b.email = :email")})
public class Breweries implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @Min(value = 0, message = "number equals positive")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "name")
    @NotBlank(message = " field cannot be empty")

    @Size(min = 1, max = 50, message = "must be 50 characters or less")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50, message = "must be 50 characters or less")
    @Column(name = "address1")
    private String address1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50, message = "must be 50 characters or less")
    @Column(name = "address2")
    private String address2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30, message = "must be 30 characters or less")
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20, message = "must be 20 characters or less")
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
     //@Size(min = 1, max = 5, message = "must be 5 digits or less")
    @NotBlank(message = " field cannot be empty")
    @Pattern(regexp="\\d{1,5}", message = "must be 5 digits or less")
    //@digit
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
     @NotNull()

    @Column(name = "country")
    @NotBlank(message = " field cannot be empty")
    private String country;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull()
    @NotBlank(message = " field cannot be empty")
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @URL( message = "must be a valid url")
    @NotBlank(message = " this field cannot be blank")
    @Column(name = "website")
    private String website;
    @Basic(optional = false)
   // @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Lob
    @NotBlank(message = " this field cannot be blank")
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    //@Positive(message = "value must be positive and 2 digits")
    @Min(value = 0, message = "number equals positive")
   @Digits(integer=2, fraction=0, message = "value must be positive and 2 digits whole number")
    @Column(name = "add_user")
    private int addUser;
    @Basic(optional = false)
//    @NotNull
    @Past()
    @Column(name = "last_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @Basic(optional = false)
    @NotNull
    @Digits(integer = 6, fraction = 2, message = "Must have a max of 6 digits before the decimal point and 2 afterwards.")
    @Column(name = "credit_limit")
    private double creditLimit;
   // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    //@Size(min = 1, max = 50)
    @NotBlank(message = " this field cannot be blank")
    @Column(name = "email")
   @Email(message= " this is not a valid email adress")
    private String email;
    @Column(table = "breweries_geocode")
    @NotNull
    //@Size(min = -90, max = 90, message = "latitide must be between -90 and 90")
    @Max(value = 90, message = "latitide must be between -90 and 90")
    @Min(value = -90, message = "latitide must be between -90 and 90")
    private float latitude;
     @NotNull
    @Column(table = "breweries_geocode")
   // @Size(min = -180, max = 180, message = "latitide must be between -180 and 180")
      @Max(value = 80, message = "latitide must be between -180 and 80")
    @Min(value = -180, message = "latitide must be between -180 and 80")
    private float longitude;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Breweries() {
    }

    public Breweries(Integer id) {
        this.id = id;
    }

    public Breweries(Integer id, String name, String address1, String address2, String city, String state, String code, String country, String phone, String website, String image, String description, int addUser, Date lastMod, double creditLimit, String email) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.code = code;
        this.country = country;
        this.phone = phone;
        this.website = website;
        this.image = image;
        this.description = description;
        this.addUser = addUser;
        this.lastMod = lastMod;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAddUser() {
        return addUser;
    }

    public void setAddUser(int addUser) {
        this.addUser = addUser;
    }

    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Breweries)) {
            return false;
        }
        Breweries other = (Breweries) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lit.sd4.model.Breweries[ id=" + id + " ]";
    }

}
