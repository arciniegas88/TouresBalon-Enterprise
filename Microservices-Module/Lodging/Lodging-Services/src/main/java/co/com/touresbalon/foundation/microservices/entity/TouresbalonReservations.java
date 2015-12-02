package co.com.touresbalon.foundation.microservices.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by harcalejo on 23/09/15.
 */
@Entity
@Table(name = "TOURESBALON_RESERVATIONS")
@XmlRootElement
public class TouresbalonReservations {
    private Long reservationId;
    private Date checkInDate;
    private Date checkOutDate;
    private Long state;
    private String guestName;
    private Long hotelId;
    private Long roomNumber;

    public TouresbalonReservations(Long reservationId, Date checkInDate, Date checkOutDate,
                                   String guestName, Long hotelId, Long roomNumber) {
        this.reservationId = reservationId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guestName = guestName;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;

        this.setState(0L);
    }

    public TouresbalonReservations() {
    }

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

    @Basic
    @Column(name = "STATE")
    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    @Basic
    @Column(name = "GUEST_NAME")
    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TouresbalonReservations that = (TouresbalonReservations) o;

        if (reservationId != null ? !reservationId.equals(that.reservationId) : that.reservationId != null)
            return false;
        if (checkInDate != null ? !checkInDate.equals(that.checkInDate) : that.checkInDate != null) return false;
        if (checkOutDate != null ? !checkOutDate.equals(that.checkOutDate) : that.checkOutDate != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        return !(guestName != null ? !guestName.equals(that.guestName) : that.guestName != null);

    }

    @Override
    public int hashCode() {
        int result = reservationId != null ? reservationId.hashCode() : 0;
        result = 31 * result + (checkInDate != null ? checkInDate.hashCode() : 0);
        result = 31 * result + (checkOutDate != null ? checkOutDate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (guestName != null ? guestName.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "HOTEL_ID")
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "ROOM_NUMBER")
    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

//    @ManyToOne
//    @JoinColumns({@JoinColumn(name = "HOTEL_ID", referencedColumnName = "HOTEL_ID", nullable = false), @JoinColumn(name = "ROOM_NUMBER", referencedColumnName = "ROOM_NUMBER", nullable = false)})
//    public Room getRoom() {
//        return room;
//    }

//    public void setRoom(Room room) {
//        this.room = room;
//    }
}
