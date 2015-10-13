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
 *
 * @author garciniegas
 */
@Entity
@Table(name = "spectacle")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Spectacle.findAll",
                    query = "SELECT NEW co.com.touresbalon.foundation.products.entity.Spectacle(" +
                            "s.id, s.name, s.cost, s.spectacleDate) " +
                            "FROM Spectacle s",
                    hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "Spectacle.findById", query = "SELECT s FROM Spectacle s WHERE s.id = :id"),
        @NamedQuery(name = "Spectacle.findByName", query = "SELECT s FROM Spectacle s WHERE s.name = :name"),
        @NamedQuery(name = "Spectacle.findByCost", query = "SELECT s FROM Spectacle s WHERE s.cost = :cost")})
public class Spectacle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private Long cost;
    @Column(name = "spectacle_date")
    @Temporal(TemporalType.DATE)
    private Date spectacleDate;

    public Spectacle() {
    }

    public Spectacle(Integer id, String name, Long cost, Date spectacleDate) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.spectacleDate = spectacleDate;
    }

    public Date getSpectacleDate() {
        return spectacleDate;
    }

    public void setSpectacleDate(Date spectacleDate) {
        this.spectacleDate = spectacleDate;
    }

    public Spectacle(Integer id) {
        this.id = id;
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
        if (!(object instanceof Spectacle)) {
            return false;
        }
        Spectacle other = (Spectacle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.cache.foundation.pruebassql.Spectacle[ id=" + id + " ]";
    }

}
