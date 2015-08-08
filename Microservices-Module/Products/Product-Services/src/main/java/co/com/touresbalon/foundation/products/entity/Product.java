/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.products.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author garciniegas
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findBySpectacle", query = "SELECT p FROM Product p WHERE p.spectacle = :spectacle"),
    @NamedQuery(name = "Product.findBySpectacleDate", query = "SELECT p FROM Product p WHERE p.spectacleDate = :spectacleDate"),
    @NamedQuery(name = "Product.findByArrivalDate", query = "SELECT p FROM Product p WHERE p.arrivalDate = :arrivalDate"),
    @NamedQuery(name = "Product.findByDepartureDate", query = "SELECT p FROM Product p WHERE p.departureDate = :departureDate")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Column(name = "spectacle")
    private String spectacle;
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

    public Product() {
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

    public String getSpectacle() {
        return spectacle;
    }

    public void setSpectacle(String spectacle) {
        this.spectacle = spectacle;
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
