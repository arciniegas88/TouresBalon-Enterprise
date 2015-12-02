/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.orders.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jenny Rodriguez
 */
@Entity
@Table(name = "SALES_ORDER")
@XmlRootElement
@NamedQueries(value = {
        @NamedQuery(name = "SalesOrder.changeStatus",
                query = "UPDATE SalesOrder s SET s.status = :STATUS," +
                        "s.comments = :COMMENTS " +
                        "WHERE s.id = :ID"),
        //@NamedQuery(name = "SalesOrder.findAll", query = "SELECT s FROM SalesOrder s"),
        @NamedQuery(name = "SalesOrder.findAll",
                query = "SELECT NEW co.com.touresbalon.foundation.orders.entity.SalesOrder(s.id, s.orderDate, s.price," +
                        "s.status, s.comments, s.custDocumentNumber ,s.custDocumentType) FROM SalesOrder s ",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "SalesOrder.ByCustomer",
                query = "SELECT  NEW co.com.touresbalon.foundation.orders.entity.SalesOrder (s.id, s.orderDate,s.price, s.status, " +
                        "s.comments) FROM SalesOrder s " +
                        "WHERE s.custDocumentType =:TYPE_DOCUMENT AND s.custDocumentNumber =:NUMBER_DOCUMENT AND s.status = :STATUS",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "SalesOrder.getDetail",
                query = "SELECT NEW co.com.touresbalon.foundation.orders.entity.SalesOrder (s.id, s.orderDate,s.price, s.status, " +
                        "s.comments, s.custDocumentNumber ,s.custDocumentType) FROM SalesOrder s " +
                        "WHERE s.id=:ID_SALES_ORDER",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "SalesOrder.findAllByCriteria",
                query = "SELECT NEW co.com.touresbalon.foundation.orders.entity.SalesOrder(s.id, s.orderDate, s.price," +
                        "s.status, s.comments, s.custDocumentNumber, s.custDocumentType) FROM SalesOrder s WHERE " +
                        "TRIM(s.id) = TRIM(:ID)",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),

        @NamedQuery(name = "SalesOrder.findAllByStatus",
                query = "SELECT NEW co.com.touresbalon.foundation.orders.entity.SalesOrder(s.id, s.orderDate, s.price," +
                        "s.status, s.comments, s.custDocumentNumber, s.custDocumentType) FROM SalesOrder s WHERE " +
                        "LOWER(s.status) LIKE TRIM(LOWER(:STATUS))",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "SalesOrder.findAllByStatusCount",
                query = "SELECT count(s) FROM SalesOrder s WHERE " +
                        "LOWER(s.status) LIKE TRIM(LOWER(:STATUS))",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "SalesOrder.findAllByIdAndProduct",
                query = "SELECT NEW co.com.touresbalon.foundation.orders.entity.SalesOrder(s.id, s.orderDate, s.price," +
                        "s.status, s.comments, s.custDocumentNumber, s.custDocumentType) FROM SalesOrder s,OrderItem o WHERE " +
                        "s.id = o.orderId.id AND TRIM(s.id) = TRIM(:ID) AND TRIM(o.productId) = TRIM(:PRODUCTID)",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "SalesOrder.findAllByProduct",
                query = "SELECT NEW co.com.touresbalon.foundation.orders.entity.SalesOrder(s.id, s.orderDate, s.price," +
                        "s.status, s.comments, s.custDocumentNumber, s.custDocumentType) FROM SalesOrder s,OrderItem o WHERE " +
                        "s.id = o.orderId.id AND TRIM(o.productId) = TRIM(:PRODUCTID)",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),

        @NamedQuery(name = "SalesOrder.findAllCount",
                query = "SELECT count(s) FROM SalesOrder s ",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "SalesOrder.findAllByCriteriaCount",
                query = "SELECT count(s) FROM SalesOrder s WHERE " +
                        "TRIM(s.id) = TRIM(:ID)",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "SalesOrder.findAllByCountIdAndProduct",
                query = "SELECT count(s) FROM SalesOrder s, OrderItem o WHERE " +
                        " s.id = o.orderId.id AND TRIM(s.id) = TRIM(:ID) AND TRIM(o.productId) = TRIM(:PRODUCTID)",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "SalesOrder.findAllByCountProduct",
                query = "SELECT count(s) FROM SalesOrder s, OrderItem o WHERE " +
                        " s.id = o.orderId.id AND TRIM(o.productId) = TRIM(:PRODUCTID)",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),

        @NamedQuery(name ="SalesOrder.ById",
                query = "SELECT NEW co.com.touresbalon.foundation.orders.entity.SalesOrder( s.id, s.orderDate, s.price, s.status," +
                        "s.comments ) FROM SalesOrder s " +
                        "WHERE s.id =:ID_SALES_ORDER ",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),

        @NamedQuery(name = "SalesOrder.countCustomersByProduct",
                query = "SELECT COUNT( DISTINCT s.custDocumentNumber ) FROM SalesOrder s LEFT JOIN s.orderItemList o " +
                        "WHERE o.productId = :PRODUCTID",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),

        @NamedQuery(name = "SalesOrder.findCustomersByProduct",
                query = "SELECT DISTINCT NEW co.com.touresbalon.foundation.orders.dto.Customer( s.custDocumentNumber, s.custDocumentType ) " +
                        "FROM SalesOrder s LEFT JOIN s.orderItemList o WHERE o.productId = :PRODUCTID",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),

        @NamedQuery(name = "SalesOrder.countAllCustomersByProduct",
                query = "SELECT COUNT( DISTINCT s.custDocumentNumber ) FROM SalesOrder s LEFT JOIN s.orderItemList o",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),

        @NamedQuery(name = "SalesOrder.findAllCustomersByProduct",
                query = "SELECT DISTINCT NEW co.com.touresbalon.foundation.orders.dto.Customer( s.custDocumentNumber, s.custDocumentType ) " +
                        "FROM SalesOrder s LEFT JOIN s.orderItemList o",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),

        @NamedQuery(name = "SalesOrder.countCustomersRanking",
                query = "SELECT COUNT(DISTINCT s.custDocumentNumber ) FROM SalesOrder s " +
                        "WHERE s.orderDate BETWEEN :STARTDATE AND :ENDDATE",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),

        @NamedQuery(name = "SalesOrder.findCustomersRanking",
                query = "SELECT NEW co.com.touresbalon.foundation.orders.dto.Customer( " +
                        "s.custDocumentNumber, s.custDocumentType, SUM( s.price ) ) " +
                        "FROM SalesOrder s WHERE s.orderDate BETWEEN :STARTDATE AND :ENDDATE GROUP BY s.custDocumentNumber, " +
                        "s.custDocumentType ORDER BY SUM(s.price) DESC",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})

})
/** @SequenceGenerator(name="SALES_ORDER_GEN", sequenceName = "SALES_ORDER_SEQ",initialValue=1, allocationSize=1 ) */
public class SalesOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    /** @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SALES_ORDER_GEN") **/
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
        this.status = status;
    }

    public SalesOrder(Long id, Date orderDate, Long price, String status, String comments, String custDocumentNumber, String custDocumentType) {
        this.id = id;
        this.orderDate = orderDate;
        this.price = price;
        this.status = status;
        this.comments = comments;
        this.custDocumentNumber = custDocumentNumber;
        this.custDocumentType = custDocumentType;
        this.status = status;
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
        return status;
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
