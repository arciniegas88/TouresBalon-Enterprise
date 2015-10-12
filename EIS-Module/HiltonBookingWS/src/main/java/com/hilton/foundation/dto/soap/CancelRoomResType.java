
package com.hilton.foundation.dto.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cancelRoomRes_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cancelRoomRes_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://hilton.com/model/booking/schema/v1}GeneralResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelRoomRes_type", namespace = "http://hilton.com/enterprise/booking/schema/v1", propOrder = {
    "generalResponse"
})
public class CancelRoomResType {

    @XmlElement(name = "GeneralResponse", namespace = "http://hilton.com/model/booking/schema/v1", required = true)
    protected GeneralResponse generalResponse;

    /**
     * Gets the value of the generalResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralResponse }
     *     
     */
    public GeneralResponse getGeneralResponse() {
        return generalResponse;
    }

    /**
     * Sets the value of the generalResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralResponse }
     *     
     */
    public void setGeneralResponse(GeneralResponse value) {
        this.generalResponse = value;
    }

}
