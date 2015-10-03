
package co.com.touresbalon.foundation.microservices.dto.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for doReservationRes_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doReservationRes_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://touresbalon.com.co/model/lodging/schema/v1}touresBalonReservation"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doReservationRes_type", propOrder = {
    "touresBalonReservation"
})
public class DoReservationResType {

    @XmlElement(namespace = "http://touresbalon.com.co/model/lodging/schema/v1", required = true)
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
