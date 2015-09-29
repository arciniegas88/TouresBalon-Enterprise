package co.com.touresbalon.foundation.microservices.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by harcalejo on 23/09/15.
 */
public class RoomPK implements Serializable {
    private Long roomNumber;
    private Long hotelId;

    @Column(name = "ROOM_NUMBER")
    @Id
    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Column(name = "HOTEL_ID")
    @Id
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomPK roomPK = (RoomPK) o;

        if (roomNumber != null ? !roomNumber.equals(roomPK.roomNumber) : roomPK.roomNumber != null) return false;
        return !(hotelId != null ? !hotelId.equals(roomPK.hotelId) : roomPK.hotelId != null);

    }

    @Override
    public int hashCode() {
        int result = roomNumber != null ? roomNumber.hashCode() : 0;
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        return result;
    }
}
