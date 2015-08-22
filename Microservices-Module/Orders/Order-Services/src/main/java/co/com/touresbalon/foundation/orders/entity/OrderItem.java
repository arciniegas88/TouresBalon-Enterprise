/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.orders.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author garciniegas
 */

@Entity
@Table(name = "ORDER_ITEM")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "OrderItem.findAll", query = "SELECT o FROM OrderItem o"),
        @NamedQuery(name = "OrderItem.OrderItemByOrderId",
                query = "SELECT NEW co.com.touresbalon.foundation.orders.entity.OrderItem( o.id ) " +
                        "FROM OrderItem o WHERE o.orderId.id = :ID_ORDEN ",
        hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
})

public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PARTNUM")
    private String partnum;
    @Column(name = "PRICE")
    private Long price;
    @Column(name = "QUANTITY")
    private Short quantity;
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
    @ManyToOne
    private SalesOrder orderId;

    public OrderItem() {
    }

    public OrderItem(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPartnum() {
        return partnum;
    }

    public void setPartnum(String partnum) {
        this.partnum = partnum;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public SalesOrder getOrderId() {
        return orderId;
    }

    public void setOrderId(SalesOrder orderId) {
        this.orderId = orderId;
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
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.foundation.orders.entity.OrderItem[ id=" + id + " ]";
    }
    
}
