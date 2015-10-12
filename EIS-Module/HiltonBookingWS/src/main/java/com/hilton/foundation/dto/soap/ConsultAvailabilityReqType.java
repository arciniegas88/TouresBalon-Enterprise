
package com.hilton.foundation.dto.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for consultAvailabilityReq_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultAvailabilityReq_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hotel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="checkIn" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="checkOut" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultAvailabilityReq_type", namespace = "http://hilton.com/enterprise/booking/schema/v1", propOrder = {
    "hotel",
    "checkIn",
    "checkOut",
    "city"
})
public class ConsultAvailabilityReqType {

    @XmlElement(required = true)
    protected String hotel;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar checkIn;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar checkOut;
    @XmlElement(required = true)
    protected String city;

    /**
     * Gets the value of the hotel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotel() {
        return hotel;
    }

    /**
     * Sets the value of the hotel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotel(String value) {
        this.hotel = value;
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

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

}
