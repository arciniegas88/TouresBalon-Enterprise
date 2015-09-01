/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.danncarlton.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "PUBLIC_RESERVATIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PublicReservations.findAll", query = "SELECT p FROM PublicReservations p"),
    @NamedQuery(name = "PublicReservations.findByCheckInDate", query = "SELECT p FROM PublicReservations p WHERE p.publicReservationsPK.checkInDate = :checkInDate"),
    @NamedQuery(name = "PublicReservations.findByCheckOutDate", query = "SELECT p FROM PublicReservations p WHERE p.publicReservationsPK.checkOutDate = :checkOutDate")})
public class PublicReservations implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PublicReservationsPK publicReservationsPK;
    @JoinColumns({
        @JoinColumn(name = "ROOM_NUMBER", referencedColumnName = "ROOM_NUMBER"),
        @JoinColumn(name = "HOTEL_ID", referencedColumnName = "HOTEL_ID")})
    @ManyToOne(optional = false)
    private Room room;

    public PublicReservations() {
    }

    public PublicReservations(PublicReservationsPK publicReservationsPK) {
        this.publicReservationsPK = publicReservationsPK;
    }

    public PublicReservations(Date checkInDate, Date checkOutDate) {
        this.publicReservationsPK = new PublicReservationsPK(checkInDate, checkOutDate);
    }

    public PublicReservationsPK getPublicReservationsPK() {
        return publicReservationsPK;
    }

    public void setPublicReservationsPK(PublicReservationsPK publicReservationsPK) {
        this.publicReservationsPK = publicReservationsPK;
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
        hash += (publicReservationsPK != null ? publicReservationsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicReservations)) {
            return false;
        }
        PublicReservations other = (PublicReservations) object;
        if ((this.publicReservationsPK == null && other.publicReservationsPK != null) || (this.publicReservationsPK != null && !this.publicReservationsPK.equals(other.publicReservationsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.touresbalon.foundation.danncarlton.entity.PublicReservations[ publicReservationsPK=" + publicReservationsPK + " ]";
    }
    
}
