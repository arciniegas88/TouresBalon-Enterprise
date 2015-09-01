/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.danncarlton.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
@Embeddable
public class RoomPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOM_NUMBER")
    private BigInteger roomNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOTEL_ID")
    private BigInteger hotelId;

    public RoomPK() {
    }

    public RoomPK(BigInteger roomNumber, BigInteger hotelId) {
        this.roomNumber = roomNumber;
        this.hotelId = hotelId;
    }

    public BigInteger getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(BigInteger roomNumber) {
        this.roomNumber = roomNumber;
    }

    public BigInteger getHotelId() {
        return hotelId;
    }

    public void setHotelId(BigInteger hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomNumber != null ? roomNumber.hashCode() : 0);
        hash += (hotelId != null ? hotelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomPK)) {
            return false;
        }
        RoomPK other = (RoomPK) object;
        if ((this.roomNumber == null && other.roomNumber != null) || (this.roomNumber != null && !this.roomNumber.equals(other.roomNumber))) {
            return false;
        }
        if ((this.hotelId == null && other.hotelId != null) || (this.hotelId != null && !this.hotelId.equals(other.hotelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.foundation.danncarlton.entity.RoomPK[ roomNumber=" + roomNumber + ", hotelId=" + hotelId + " ]";
    }
    
}
