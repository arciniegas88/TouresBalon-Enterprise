/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.products.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author garciniegas
 */

@Entity
@Table(name = "transport")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Transport.findAll",
                    query = "SELECT NEW co.com.touresbalon.foundation.products.entity.Transport(" +
                            "t.id, t.name, t.cost, t.travelDate, t.travelOutTime, t.businessProvider) " +
                            "FROM Transport t",
                    hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "Transport.updateRate", query = "UPDATE Transport t SET t.cost = :COST WHERE t.id = :ID"),
        @NamedQuery(name = "Transport.findById", query = "SELECT t FROM Transport t WHERE t.id = :id"),
        @NamedQuery(name = "Transport.findByName", query = "SELECT t FROM Transport t WHERE t.name = :name"),
        @NamedQuery(name = "Transport.findByCost", query = "SELECT t FROM Transport t WHERE t.cost = :cost")})
public class Transport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Long cost;

    @Column(name = "travel_date")
    @Temporal(TemporalType.DATE)
    private Date travelDate;

    @Column(name = "travel_out_time")
    private String travelOutTime;

    @Column(name = "business_provider")
    private String businessProvider;

    public Transport() {
    }

    public Transport(Integer id, String name, Long cost, Date travelDate,
                     String travelOutTime, String businessProvider) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.travelDate = travelDate;
        this.travelOutTime = travelOutTime;
        this.businessProvider = businessProvider;
    }

    public Transport(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getBusinessProvider() {
        return businessProvider;
    }

    public void setBusinessProvider(String businessProvider) {
        this.businessProvider = businessProvider;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public String getTravelOutTime() {
        return travelOutTime;
    }

    public void setTravelOutTime(String travelOutTime) {
        this.travelOutTime = travelOutTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
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
        if (!(object instanceof Transport)) {
            return false;
        }
        Transport other = (Transport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.cache.foundation.pruebassql.Transport[ id=" + id + " ]";
    }

}
