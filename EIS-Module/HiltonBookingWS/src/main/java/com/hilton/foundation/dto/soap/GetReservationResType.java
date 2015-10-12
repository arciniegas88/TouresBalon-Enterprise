
package com.hilton.foundation.dto.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getReservationRes_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getReservationRes_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://hilton.com/model/booking/schema/v1}touresBalonReservation"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getReservationRes_type", namespace = "http://hilton.com/enterprise/booking/schema/v1", propOrder = {
    "touresBalonReservation"
})
public class GetReservationResType {

    @XmlElement(namespace = "http://hilton.com/model/booking/schema/v1", required = true)
    protected TouresBalonReservation touresBalonReservation;

    /**
     * Gets the value of the touresBalonReservation property.
     * 
     * @return
     *     possible object is
     *     {@link TouresBalonReservation }
     *     
     */
    public TouresBalonReservation getTouresBalonReservation() {
        return touresBalonReservation;
    }

    /**
     * Sets the value of the touresBalonReservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TouresBalonReservation }
     *     
     */
    public void setTouresBalonReservation(TouresBalonReservation value) {
        this.touresBalonReservation = value;
    }

}
