/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.products.entity;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author garciniegas
 */
@Entity
@Table(name = "lodging")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lodging.findAll", query = "SELECT l FROM Lodging l"),
    @NamedQuery(name = "Lodging.findById", query = "SELECT l FROM Lodging l WHERE l.id = :id"),
    @NamedQuery(name = "Lodging.findByName", query = "SELECT l FROM Lodging l WHERE l.name = :name"),
    @NamedQuery(name = "Lodging.findByCost", query = "SELECT l FROM Lodging l WHERE l.cost = :cost")})
public class Lodging implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private Long cost;
    @OneToMany(mappedBy = "lodgingType")
    private List<Product> productList;

    public Lodging() {
    }

    public Lodging(Integer id) {
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

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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
        if (!(object instanceof Lodging)) {
            return false;
        }
        Lodging other = (Lodging) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.cache.foundation.pruebassql.Lodging[ id=" + id + " ]";
    }
    
}
