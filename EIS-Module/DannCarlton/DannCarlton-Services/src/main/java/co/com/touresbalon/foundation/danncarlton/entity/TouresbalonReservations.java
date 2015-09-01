/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.danncarlton.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "TOURESBALON_RESERVATIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TouresbalonReservations.findAll", query = "SELECT t FROM TouresbalonReservations t"),
    @NamedQuery(name = "TouresbalonReservations.findByOrderId", query = "SELECT t FROM TouresbalonReservations t WHERE t.touresbalonReservationsPK.orderId = :orderId"),
    @NamedQuery(name = "TouresbalonReservations.findByHotelId", query = "SELECT t FROM TouresbalonReservations t WHERE t.touresbalonReservationsPK.hotelId = :hotelId"),
    @NamedQuery(name = "TouresbalonReservations.findByRoomNumber", query = "SELECT t FROM TouresbalonReservations t WHERE t.touresbalonReservationsPK.roomNumber = :roomNumber"),
    @NamedQuery(name = "TouresbalonReservations.findByCheckInDate", query = "SELECT t FROM TouresbalonReservations t WHERE t.touresbalonReservationsPK.checkInDate = :checkInDate"),
    @NamedQuery(name = "TouresbalonReservations.findByCheckOutDate", query = "SELECT t FROM TouresbalonReservations t WHERE t.touresbalonReservationsPK.checkOutDate = :checkOutDate"),
    @NamedQuery(name = "TouresbalonReservations.findByState", query = "SELECT t FROM TouresbalonReservations t WHERE t.state = :state"),
    @NamedQuery(name = "TouresbalonReservations.findByGuestName", query = "SELECT t FROM TouresbalonReservations t WHERE t.guestName = :guestName")})
public class TouresbalonReservations implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TouresbalonReservationsPK touresbalonReservationsPK;
    @Column(name = "STATE")
    private BigInteger state;
    @Size(max = 4000)
    @Column(name = "GUEST_NAME")
    private String guestName;
    @JoinColumns({
        @JoinColumn(name = "ROOM_NUMBER", referencedColumnName = "ROOM_NUMBER", insertable = false, updatable = false),
        @JoinColumn(name = "HOTEL_ID", referencedColumnName = "HOTEL_ID", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Room room;

    public TouresbalonReservations() {
    }

    public TouresbalonReservations(TouresbalonReservationsPK touresbalonReservationsPK) {
        this.touresbalonReservationsPK = touresbalonReservationsPK;
    }

    public TouresbalonReservations(String orderId, BigInteger hotelId, BigInteger roomNumber, Date checkInDate, Date checkOutDate) {
        this.touresbalonReservationsPK = new TouresbalonReservationsPK(orderId, hotelId, roomNumber, checkInDate, checkOutDate);
    }

    public TouresbalonReservationsPK getTouresbalonReservationsPK() {
        return touresbalonReservationsPK;
    }

    public void setTouresbalonReservationsPK(TouresbalonReservationsPK touresbalonReservationsPK) {
        this.touresbalonReservationsPK = touresbalonReservationsPK;
    }

    public BigInteger getState() {
        return state;
    }

    public void setState(BigInteger state) {
        this.state = state;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (touresbalonReservationsPK != null ? touresbalonReservationsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TouresbalonReservations)) {
            return false;
        }
        TouresbalonReservations other = (TouresbalonReservations) object;
        if ((this.touresbalonReservationsPK == null && other.touresbalonReservationsPK != null) || (this.touresbalonReservationsPK != null && !this.touresbalonReservationsPK.equals(other.touresbalonReservationsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.foundation.danncarlton.entity.TouresbalonReservations[ touresbalonReservationsPK=" + touresbalonReservationsPK + " ]";
    }
    
}
