
package com.hilton.foundation.dto.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for confirmRoomReq_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="confirmRoomReq_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="hotelId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="room" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="guestName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="checkIn" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="checkOut" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "confirmRoomReq_type", namespace = "http://hilton.com/enterprise/booking/schema/v1", propOrder = {
    "orderId",
    "hotelId",
    "room",
    "guestName",
    "checkIn",
    "checkOut"
})
public class ConfirmRoomReqType {

    protected long orderId;
    protected long hotelId;
    protected long room;
    @XmlElement(required = true)
    protected String guestName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar checkIn;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar checkOut;

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
     * Gets the value of the room property.
     * 
     */
    public long getRoom() {
        return room;
    }

    /**
     * Sets the value of the room property.
     * 
     */
    public void setRoom(long value) {
        this.room = value;
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
     * Gets the value of the checkIn property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckIn() {
        return checkIn;
    }

    /**
     * Sets the value of the checkIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckIn(XMLGregorianCalendar value) {
        this.checkIn = value;
    }

    /**
     * Gets the value of the checkOut property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckOut() {
        return checkOut;
    }

    /**
     * Sets the value of the checkOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckOut(XMLGregorianCalendar value) {
        this.checkOut = value;
    }

}
