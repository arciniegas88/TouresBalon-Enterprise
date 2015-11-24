package co.com.touresbalon.foundation.microservices.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by harcalejo on 23/09/15.
 */
@Entity
@Table(name = "PUBLIC_RESERVATIONS")
@XmlRootElement
public class PublicReservations {
    private Long reservationId;
    private Date checkInDate;
    private Date checkOutDate;
    private Long hotelId;
    private Long roomNumber;
    private Room room;

    @Id
    @Column(name = "RESERVATION_ID")
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    @Basic
    @Column(name = "CHECK_IN_DATE")
    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    @Basic
    @Column(name = "CHECK_OUT_DATE")
    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PublicReservations that = (PublicReservations) o;

        if (reservationId != null ? !reservationId.equals(that.reservationId) : that.reservationId != null)
            return false;
        if (checkInDate != null ? !checkInDate.equals(that.checkInDate) : that.checkInDate != null) return false;
        return !(checkOutDate != null ? !checkOutDate.equals(that.checkOutDate) : that.checkOutDate != null);

    }

    @Override
    public int hashCode() {
        int result = reservationId != null ? reservationId.hashCode() : 0;
        result = 31 * result + (checkInDate != null ? checkInDate.hashCode() : 0);
        result = 31 * result + (checkOutDate != null ? checkOutDate.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "HOTEL_ID", insertable = false, updatable = false)
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "ROOM_NUMBER", insertable = false, updatable = false)
    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "HOTEL_ID", referencedColumnName = "HOTEL_ID", nullable = false), @JoinColumn(name = "ROOM_NUMBER", referencedColumnName = "ROOM_NUMBER", nullable = false)})
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
