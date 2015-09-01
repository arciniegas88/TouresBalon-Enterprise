/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.danncarlton.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
@Embeddable
public class PublicReservationsPK implements Serializable {
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

    public PublicReservationsPK() {
    }

    public PublicReservationsPK(Date checkInDate, Date checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
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
        hash += (checkInDate != null ? checkInDate.hashCode() : 0);
        hash += (checkOutDate != null ? checkOutDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicReservationsPK)) {
            return false;
        }
        PublicReservationsPK other = (PublicReservationsPK) object;
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
        return "co.com.touresbalon.foundation.danncarlton.entity.PublicReservationsPK[ checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + " ]";
    }
    
}
