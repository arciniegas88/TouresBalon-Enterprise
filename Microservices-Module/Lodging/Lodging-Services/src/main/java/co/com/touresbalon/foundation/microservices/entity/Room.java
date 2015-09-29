package co.com.touresbalon.foundation.microservices.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by harcalejo on 23/09/15.
 */
@Entity
@IdClass(RoomPK.class)
@XmlRootElement
@NamedQueries(value = @NamedQuery(name = "Room.aviability",
        query = "SELECT r FROM Room r INNER JOIN r.hotelByHotelId h " +
                "WHERE r.roomNumber NOT IN (SELECT pr.roomNumber FROM PublicReservations pr " +
                "WHERE :checkIn BETWEEN pr.checkInDate AND pr.checkOutDate " +
                "OR :checkOut BETWEEN pr.checkInDate AND pr.checkOutDate " +
                "OR pr.checkInDate BETWEEN :checkIn AND :checkOut " +
                "OR pr.checkOutDate BETWEEN :checkIn AND :checkOut) " +
                "AND h.brand = :brand AND h.city = :city"))
public class Room {
    private Long roomNumber;
    private Long hotelId;
    private String type;
    private String price;
    private List<PublicReservations> publicReservations;
    private Hotel hotelByHotelId;
    //private List<TouresbalonReservations> touresbalonReservations;

    @Id
    @Column(name = "ROOM_NUMBER")
    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Id
    @Column(name = "HOTEL_ID")
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "PRICE")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (roomNumber != null ? !roomNumber.equals(room.roomNumber) : room.roomNumber != null) return false;
        if (hotelId != null ? !hotelId.equals(room.hotelId) : room.hotelId != null) return false;
        if (type != null ? !type.equals(room.type) : room.type != null) return false;
        return !(price != null ? !price.equals(room.price) : room.price != null);

    }

    @Override
    public int hashCode() {
        int result = roomNumber != null ? roomNumber.hashCode() : 0;
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "room")
    @XmlTransient
    public List<PublicReservations> getPublicReservations() {
        return publicReservations;
    }

    public void setPublicReservations(List<PublicReservations> publicReservations) {
        this.publicReservations = publicReservations;
    }

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID", referencedColumnName = "HOTEL_ID", nullable = false, insertable = false, updatable = false)
    public Hotel getHotelByHotelId() {
        return hotelByHotelId;
    }

    public void setHotelByHotelId(Hotel hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }

//    @OneToMany(mappedBy = "room")
//    @XmlTransient
//    public List<TouresbalonReservations> getTouresbalonReservationses() {
//        return touresbalonReservations;
//    }
//
//    public void setTouresbalonReservationses(List<TouresbalonReservations> touresbalonReservationses) {
//        this.touresbalonReservations = touresbalonReservationses;
//    }
}
