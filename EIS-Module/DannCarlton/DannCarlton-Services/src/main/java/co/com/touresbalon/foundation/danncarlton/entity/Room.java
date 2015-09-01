/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.danncarlton.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "ROOM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findByRoomNumber", query = "SELECT r FROM Room r WHERE r.roomPK.roomNumber = :roomNumber"),
    @NamedQuery(name = "Room.findByHotelId", query = "SELECT r FROM Room r WHERE r.roomPK.hotelId = :hotelId"),
    @NamedQuery(name = "Room.findByType", query = "SELECT r FROM Room r WHERE r.type = :type"),
    @NamedQuery(name = "Room.findByPrice", query = "SELECT r FROM Room r WHERE r.price = :price")})
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoomPK roomPK;
    @Size(max = 4000)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 4000)
    @Column(name = "PRICE")
    private String price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private Collection<PublicReservations> publicReservationsCollection;
    @JoinColumn(name = "HOTEL_ID", referencedColumnName = "HOTEL_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hotel hotel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private Collection<TouresbalonReservations> touresbalonReservationsCollection;

    public Room() {
    }

    public Room(RoomPK roomPK) {
        this.roomPK = roomPK;
    }

    public Room(BigInteger roomNumber, BigInteger hotelId) {
        this.roomPK = new RoomPK(roomNumber, hotelId);
    }

    public RoomPK getRoomPK() {
        return roomPK;
    }

    public void setRoomPK(RoomPK roomPK) {
        this.roomPK = roomPK;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<PublicReservations> getPublicReservationsCollection() {
        return publicReservationsCollection;
    }

    public void setPublicReservationsCollection(Collection<PublicReservations> publicReservationsCollection) {
        this.publicReservationsCollection = publicReservationsCollection;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @XmlTransient
    public Collection<TouresbalonReservations> getTouresbalonReservationsCollection() {
        return touresbalonReservationsCollection;
    }

    public void setTouresbalonReservationsCollection(Collection<TouresbalonReservations> touresbalonReservationsCollection) {
        this.touresbalonReservationsCollection = touresbalonReservationsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomPK != null ? roomPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.roomPK == null && other.roomPK != null) || (this.roomPK != null && !this.roomPK.equals(other.roomPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.foundation.danncarlton.entity.Room[ roomPK=" + roomPK + " ]";
    }
    
}
