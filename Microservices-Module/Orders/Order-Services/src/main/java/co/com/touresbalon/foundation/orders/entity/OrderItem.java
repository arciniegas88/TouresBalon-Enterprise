/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.orders.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Jenny Rodriguez
 */

@Entity
@Table(name = "ORDER_ITEM")
@XmlRootElement
@NamedQueries({

        @NamedQuery(name = "OrderItem.getProductTotalOcurrences",
                query = "SELECT COUNT(o) FROM OrderItem o " +
                        "WHERE o.productId = :PRODUCT " ,
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),

        @NamedQuery(name = "OrderItem.getProductRanking",
                query = "SELECT o.productName, COUNT(o) AS TOTAL FROM OrderItem o " +
                        "WHERE o.status = 'PROVISIONED' AND " +
                        "(o.orderId.orderDate >= :ORDER_START_DATE AND o.orderId.orderDate <= :ORDER_END_DATE) " +
                        "GROUP BY o.productName " +
                        "ORDER BY TOTAL DESC",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),

        @NamedQuery(name = "OrderItem.update",
                query = "UPDATE OrderItem o SET o.status = :STATUS, o.transportComments= :TRANSPORT_COMMENTS," +
                        "o.transportTravelDate = :TRANSPORT_TRAVEL_DATE, o.transportSourceCity = :TRANSPORT_SOURCE_CITY," +
                        "o.transportTargetCity = :TRANSPORT_TARGET_CITY, o.transportTravelNumber = :TRANSPORT_TRAVEL_NUMBER," +
                        "o.transportChairNumber = :TRANSPORT_CHAIR_NUMBER, o.transportOutTime = :TRANSPORT_OUT_TIME," +
                        "o.spectacleComments = :SPECTACLE_COMMENTS, o.spectacleId = :SPECTACLE_ID," +
                        "o.spectacleTicket = :SPECTACLE_TICKET, o.lodgingComments = :LODGING_COMMENTS " +
                        "WHERE o.orderId.id = :ORDER_ID AND o.itemNo = :ITEM_NO"),
        @NamedQuery(name = "OrderItem.findAll", query = "SELECT o FROM OrderItem o"),

        @NamedQuery(name = "OrderItem.TopFiveProductByOrder",
                query = "SELECT oi.productId,oi.productName, COUNT( oi.productId ) FROM OrderItem oi " +
                        "WHERE oi.orderId.id IN( SELECT oii.orderId.id FROM OrderItem oii WHERE oii.productId = :PRODUCT_ID )" +
                        "GROUP BY oi.productId,oi.productName " +
                        "ORDER BY  COUNT( oi.productId ) DESC ",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
        @NamedQuery(name = "OrderItem.getOrderItems",
                query = "SELECT NEW co.com.touresbalon.foundation.orders.entity.OrderItem( oi.productId, oi.productName, oi.price,oi.itemNo," +
                        "oi.status, oi.transportComments, oi.transportTravelDate, oi.transportSourceCity," +
                        "oi.transportTargetCity, oi.transportTravelNumber, oi.transportChairNumber," +
                        "oi.transportOutTime, oi.spectacleComments, oi.spectacleId, oi.spectacleTicket," +
                        "oi.lodgingComments, oi.transportTravelProvider, oi.lodgingReservationProvider, oi.lodgingProvider )" +
                        "FROM OrderItem oi WHERE oi.orderId.id = :ID_SALES_ORDER ",
                hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
})
@SequenceGenerator(name = "ORDER_ITEM_GEN", sequenceName = "ORDER_ITEM_SEQ", initialValue = 1, allocationSize = 1)
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_ITEM_GEN")
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRICE")
    private Long price;

    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
    @ManyToOne
    private SalesOrder orderId;

    //[added fields]-------------------------

    @Column(name = "ITEM_NO")
    private String itemNo;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "TRANSPORT_COMMENTS")
    private String transportComments;

    @Column(name = "TRANSPORT_TRAVEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transportTravelDate;

    @Column(name = "TRANSPORT_SOURCE_CITY")
    private String transportSourceCity;

    @Column(name = "TRANSPORT_TARGET_CITY")
    private String transportTargetCity;

    @Column(name = "TRANSPORT_TRAVEL_NUMBER")
    private String transportTravelNumber;

    @Column(name = "TRANSPORT_CHAIR_NUMBER")
    private String transportChairNumber;

    @Column(name = "TRANSPORT_OUT_TIME")
    private String transportOutTime;

    @Column(name = "TRANSPORT_TRAVEL_PROVIDER")
    private String transportTravelProvider;

    @Column(name = "SPECTACLE_COMMENTS")
    private String spectacleComments;

    @Column(name = "SPECTACLE_ID")
    private Long spectacleId;

    @Column(name = "SPECTACLE_TICKET")
    private Long spectacleTicket;

    @Column(name = "LODGING_COMMENTS")
    private String lodgingComments;

    @Column(name = "LODGING_RESERVATION_PROVIDER")
    private Long lodgingReservationProvider;

    @Column(name = "LODGING_PROVIDER")
    private String lodgingProvider;


    public OrderItem() {
    }

    public OrderItem(Long productId, String productName, Long price, String itemNo,
                     String status, String transportComments, Date transportTravelDate, String transportSourceCity,
                     String transportTargetCity, String transportTravelNumber, String transportChairNumber,
                     String transportOutTime, String spectacleComments, Long spectacleId, Long spectacleTicket,
                     String lodgingComments, String transportTravelProvider ,Long lodgingReservationProvider, String lodgingProvider ) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.itemNo = itemNo;
        this.status = status;
        this.transportComments = transportComments;
        this.transportTravelDate = transportTravelDate;
        this.transportSourceCity = transportSourceCity;
        this.transportTargetCity = transportTargetCity;
        this.transportTravelNumber = transportTravelNumber;
        this.transportChairNumber = transportChairNumber;
        this.transportOutTime = transportOutTime;
        this.spectacleComments = spectacleComments;
        this.spectacleId = spectacleId;
        this.spectacleTicket = spectacleTicket;
        this.lodgingComments = lodgingComments;
        this.transportTravelProvider =transportTravelProvider;
        this.lodgingReservationProvider =lodgingReservationProvider;
        this.lodgingProvider =lodgingProvider;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransportComments() {
        return transportComments;
    }

    public void setTransportComments(String transportComments) {
        this.transportComments = transportComments;
    }

    public Date getTransportTravelDate() {
        return transportTravelDate;
    }

    public void setTransportTravelDate(Date transportTravelDate) {
        this.transportTravelDate = transportTravelDate;
    }

    public String getTransportSourceCity() {
        return transportSourceCity;
    }

    public void setTransportSourceCity(String transportSourceCity) {
        this.transportSourceCity = transportSourceCity;
    }

    public String getTransportTargetCity() {
        return transportTargetCity;
    }

    public void setTransportTargetCity(String transportTargetCity) {
        this.transportTargetCity = transportTargetCity;
    }

    public String getTransportTravelNumber() {
        return transportTravelNumber;
    }

    public void setTransportTravelNumber(String transportTravelNumber) {
        this.transportTravelNumber = transportTravelNumber;
    }

    public String getTransportChairNumber() {
        return transportChairNumber;
    }

    public void setTransportChairNumber(String transportChairNumber) {
        this.transportChairNumber = transportChairNumber;
    }

    public String getTransportOutTime() {
        return transportOutTime;
    }

    public void setTransportOutTime(String transportOutTime) {
        this.transportOutTime = transportOutTime;
    }

    public String getTransportTravelProvider() {return transportTravelProvider;}
    public void setTransportTravelProvider(String transportTravelProvider) {this.transportTravelProvider = transportTravelProvider;}

    public String getSpectacleComments() {
        return spectacleComments;
    }

    public void setSpectacleComments(String spectacleComments) {
        this.spectacleComments = spectacleComments;
    }

    public Long getSpectacleId() {
        return spectacleId;
    }

    public void setSpectacleId(Long spectacleId) {
        this.spectacleId = spectacleId;
    }

    public Long getSpectacleTicket() {
        return spectacleTicket;
    }

    public void setSpectacleTicket(Long spectacleTicket) {
        this.spectacleTicket = spectacleTicket;
    }

    public String getLodgingComments() {
        return lodgingComments;
    }

    public void setLodgingComments(String lodgingComments) {
        this.lodgingComments = lodgingComments;
    }

    public Long getLodgingReservationProvider() {return lodgingReservationProvider;}

    public void setLodgingReservationProvider(Long lodgingReservationProvider) {
        this.lodgingReservationProvider = lodgingReservationProvider;
    }

    public String getLodgingProvider() {
        return lodgingProvider;
    }

    public void setLodgingProvider(String lodgingProvider) {
        this.lodgingProvider = lodgingProvider;
    }

    public OrderItem(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
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
