/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.danncarlton.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author nrodriguez
 */
public class PublicReservationsDTO {
    
    private BigDecimal room_number;
    private BigDecimal hotelId;
    private Date checkInDate ;
    private Date checkOutDate ;
    private String hotelName;

    public BigDecimal getRoom_number() {
        return room_number;
    }

    public void setRoom_number(BigDecimal room_number) {
        this.room_number = room_number;
    }

    public BigDecimal getHotelId() {
        return hotelId;
    }

    public void setHotelId(BigDecimal hotelId) {
        this.hotelId = hotelId;
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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    
    
}
