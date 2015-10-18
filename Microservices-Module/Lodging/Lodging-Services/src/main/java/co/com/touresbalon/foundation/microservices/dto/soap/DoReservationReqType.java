
package co.com.touresbalon.foundation.microservices.dto.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;


/**
 * <p>Java class for doReservationReq_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doReservationReq_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "doReservationReq_type", propOrder = {
        "hotelId",
    "room",
    "guestName",
    "checkIn",
    "checkOut"
})
public class DoReservationReqType {
    protected long hotelId;
    protected long room;
    @XmlElement(required = true)
    protected String guestName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected Date checkIn;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected Date checkOut;

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

}
