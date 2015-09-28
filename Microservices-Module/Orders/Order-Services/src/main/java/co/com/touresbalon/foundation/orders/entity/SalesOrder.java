/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.orders.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Jenny Rodriguez
 */
@Entity
@Table(name = "SALES_ORDER")
@XmlRootElement
@NamedQueries(value = {
        @NamedQuery(name = "SalesOrder.findAll", query = "SELECT s FROM SalesOrder s"),
        @NamedQuery(name = "SalesOrder.ByCustomer",
                query = "SELECT NEW co.com.touresbalon.foundation.orders.entity.SalesOrder (s.id, s.orderDate,s.price, s.status, " +
                        "s.comments) FROM SalesOrder s " +
                        "WHERE s.custDocumentType =:TYPE_DOCUMENT AND s.custDocumentNumber =:NUMBER_DOCUMENT AND s.status = :STATUS",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "SalesOrder.getDetail",
                query = "SELECT NEW co.com.touresbalon.foundation.orders.entity.SalesOrder (s.id, s.orderDate,s.price, s.status, " +
                        "s.comments, s.custDocumentNumber ,s.custDocumentType) FROM SalesOrder s " +
                        "WHERE s.id=:ID_SALES_ORDER",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})

})
public class SalesOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "PRICE")
    private Long price;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "COMMENTS")
    private String comments;
    @Basic(optional = false)
    @Column(name = "CUST_DOCUMENT_NUMBER")
    private String custDocumentNumber;
    @Basic(optional = false)
    @Column(name = "CUST_DOCUMENT_TYPE")
    private String custDocumentType;
    @OneToMany(mappedBy = "orderId")
    private List<OrderItem> orderItemList;

    public SalesOrder() {
    }

    public SalesOrder(Long id) {
        this.id = id;
    }

    public SalesOrder(Long id, String custDocumentNumber, String custDocumentType) {
        this.id = id;
        this.custDocumentNumber = custDocumentNumber;
        this.custDocumentType = custDocumentType;
    }

    public SalesOrder(Long id, Date orderDate, Long price, String status, String comments) {
        this.id = id;
        this.orderDate = orderDate;
        this.price = price;
        this.status = status;
        this.comments = comments;
    }

    public SalesOrder(Long id, Date orderDate, Long price, String status, String comments, String custDocumentNumber, String custDocumentType) {
        this.id = id;
        this.orderDate = orderDate;
        this.price = price;
        this.status = status;
        this.comments = comments;
        this.custDocumentNumber = custDocumentNumber;
        this.custDocumentType = custDocumentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getStatus() {
        return SalesOrderStatus.valueOf( status ).getLabel();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCustDocumentNumber() {
        return custDocumentNumber;
    }

    public void setCustDocumentNumber(String custDocumentNumber) {
        this.custDocumentNumber = custDocumentNumber;
    }

    public String getCustDocumentType() {
        return custDocumentType;
    }

    public void setCustDocumentType(String custDocumentType) {
        this.custDocumentType = custDocumentType;
    }

    @XmlTransient
    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
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
        if (!(object instanceof SalesOrder)) {
            return false;
        }
        SalesOrder other = (SalesOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.foundation.orders.entity.SalesOrder[ id=" + id + " ]";
    }

}
