/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.danncarlton.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Usuario
 */
@Embeddable
public class TouresbalonReservationsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "ORDER_ID")
    private String orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOTEL_ID")
    private BigInteger hotelId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOM_NUMBER")
    private BigInteger roomNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHECK_IN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHECK_OUT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDate;

    public TouresbalonReservationsPK() {
    }

    public TouresbalonReservationsPK(String orderId, BigInteger hotelId, BigInteger roomNumber, Date checkInDate, Date checkOutDate) {
        this.orderId = orderId;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigInteger getHotelId() {
        return hotelId;
    }

    public void setHotelId(BigInteger hotelId) {
        this.hotelId = hotelId;
    }

    public BigInteger getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(BigInteger roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        hash += (hotelId != null ? hotelId.hashCode() : 0);
        hash += (roomNumber != null ? roomNumber.hashCode() : 0);
        hash += (checkInDate != null ? checkInDate.hashCode() : 0);
        hash += (checkOutDate != null ? checkOutDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TouresbalonReservationsPK)) {
            return false;
        }
        TouresbalonReservationsPK other = (TouresbalonReservationsPK) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        if ((this.hotelId == null && other.hotelId != null) || (this.hotelId != null && !this.hotelId.equals(other.hotelId))) {
            return false;
        }
        if ((this.roomNumber == null && other.roomNumber != null) || (this.roomNumber != null && !this.roomNumber.equals(other.roomNumber))) {
            return false;
        }
        if ((this.checkInDate == null && other.checkInDate != null) || (this.checkInDate != null && !this.checkInDate.equals(other.checkInDate))) {
            return false;
        }
        if ((this.checkOutDate == null && other.checkOutDate != null) || (this.checkOutDate != null && !this.checkOutDate.equals(other.checkOutDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.foundation.danncarlton.entity.TouresbalonReservationsPK[ orderId=" + orderId + ", hotelId=" + hotelId + ", roomNumber=" + roomNumber + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + " ]";
    }
    
}
