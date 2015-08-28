/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.products.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author garciniegas
 */

@Entity
@Cacheable
@Table(name = "product")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Product.findById",
                query = "SELECT p FROM Product p WHERE p.id = :ID",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "Product.findAll",
                query = "SELECT NEW co.com.touresbalon.foundation.products.entity.Product(p.id, p.name, p.description," +
                        "p.code, p.spectacleDate, p.arrivalDate, p.departureDate) FROM Product p ",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "Product.findAllByCriteria",
                query = "SELECT NEW co.com.touresbalon.foundation.products.entity.Product(p.id, p.name, p.description," +
                        "p.code, p.spectacleDate, p.arrivalDate, p.departureDate) FROM Product p WHERE " +
                        "TRIM(p.code) = TRIM(:CODE) OR LOWER(p.name) LIKE TRIM(LOWER(:NAME)) OR " +
                        "LOWER(p.description) LIKE TRIM(LOWER(:DESCRIPTION))",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "Product.findAllCount",
                query = "SELECT count(p) FROM Product p ",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "Product.findAllByCriteriaCount",
                query = "SELECT count(p) FROM Product p WHERE " +
                        "TRIM(p.code) = TRIM(:CODE) OR LOWER(p.name) LIKE TRIM(LOWER(:NAME)) OR " +
                        "LOWER(p.description) LIKE TRIM(LOWER(:DESCRIPTION))",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private String code;

    @Column(name = "spectacle_date")
    @Temporal(TemporalType.DATE)
    private Date spectacleDate;

    @Column(name = "arrival_date")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;

    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    private Date departureDate;

    @JoinColumn(name = "transport_type", referencedColumnName = "Id")
    @ManyToOne
    private Transport transportType;

    @JoinColumn(name = "spectacle_type", referencedColumnName = "Id")
    @ManyToOne
    private Spectacle spectacleType;

    @JoinColumn(name = "lodging_type", referencedColumnName = "Id")
    @ManyToOne
    private Lodging lodgingType;

    @JoinColumn(name = "spectacle_city", referencedColumnName = "Id")
    @ManyToOne
    private City spectacleCity;

    @Lob
    @Column(name = "image_ref")
    private byte[] imageRef;

    public Product() {
    }

    public Product(Long id, String name, String description, String code, Date spectacleDate, Date arrivalDate, Date departureDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.code = code;
        this.spectacleDate = spectacleDate;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    public Product(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSpectacleDate() {
        return spectacleDate;
    }

    public void setSpectacleDate(Date spectacleDate) {
        this.spectacleDate = spectacleDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Transport getTransportType() {
        return transportType;
    }

    public void setTransportType(Transport transportType) {
        this.transportType = transportType;
    }

    public Spectacle getSpectacleType() {
        return spectacleType;
    }

    public void setSpectacleType(Spectacle spectacleType) {
        this.spectacleType = spectacleType;
    }

    public Lodging getLodgingType() {
        return lodgingType;
    }

    public void setLodgingType(Lodging lodgingType) {
        this.lodgingType = lodgingType;
    }

    public City getSpectacleCity() {
        return spectacleCity;
    }

    public void setSpectacleCity(City spectacleCity) {
        this.spectacleCity = spectacleCity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImageRef() {
        return imageRef;
    }

    public void setImageRef(byte[] imageRef) {
        this.imageRef = imageRef;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.cache.foundation.pruebassql.Product[ id=" + id + " ]";
    }

}
