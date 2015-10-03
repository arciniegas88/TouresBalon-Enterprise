
package co.com.touresbalon.foundation.microservices.dto.soap;

import co.com.touresbalon.foundation.microservices.entity.TouresbalonReservations;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;


/**
 * <p>Java class for TouresBalonReservation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TouresBalonReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reservationId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="checkIn" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="checkOut" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="guestName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hotelId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="roomNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TouresBalonReservation", namespace = "http://touresbalon.com.co/model/lodging/schema/v1", propOrder = {
    "reservationId",
    "orderId",
    "checkIn",
    "checkOut",
    "state",
    "guestName",
    "hotelId",
    "roomNumber"
})
public class TouresBalonReservation {

    protected long reservationId;
    protected long orderId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected Date checkIn;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected Date checkOut;
    protected long state;
    @XmlElement(required = true)
    protected String guestName;
    protected long hotelId;
    protected long roomNumber;

    public TouresBalonReservation(){}

    public TouresBalonReservation(TouresbalonReservations reservations){
        this.reservationId = reservations.getReservationId();
        this.orderId = reservations.getOrderId();
        this.checkIn = reservations.getCheckInDate();
        this.checkOut = reservations.getCheckOutDate();
        this.state = reservations.getState();
        this.guestName = reservations.getGuestName();
        this.hotelId = reservations.getHotelId();
        this.roomNumber = reservations.getRoomNumber();
    }
    /**
     * Gets the value of the reservationId property.
     * 
     */
    public long getReservationId() {
        return reservationId;
    }

    /**
     * Sets the value of the reservationId property.
     * 
     */
    public void setReservationId(long value) {
        this.reservationId = value;
    }

    /**
     * Gets the value of the orderId property.
     * 
     */
    public long getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the orderId property.
     * 
     */
    public void setOrderId(long value) {
        this.orderId = value;
    }

    /**
     * Gets the value of the checkIn property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getCheckIn() {
        return checkIn;
    }

    /**
     * Sets the value of the checkIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setCheckIn(Date value) {
        this.checkIn = value;
    }

    /**
     * Gets the value of the checkOut property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * Sets the value of the checkOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setCheckOut(Date value) {
        this.checkOut = value;
    }

    /**
     * Gets the value of the state property.
     * 
     */
    public long getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     */
    public void setState(long value) {
        this.state = value;
    }

    /**
     * Gets the value of the guestName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * Sets the value of the guestName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestName(String value) {
        this.guestName = value;
    }

    /**
     * Gets the value of the hotelId property.
     * 
     */
    public long getHotelId() {
        return hotelId;
    }

    /**
     * Sets the value of the hotelId property.
     * 
     */
    public void setHotelId(long value) {
        this.hotelId = value;
    }

    /**
     * Gets the value of the roomNumber property.
     * 
     */
    public long getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the value of the roomNumber property.
     * 
     */
    public void setRoomNumber(long value) {
        this.roomNumber = value;
    }

}
