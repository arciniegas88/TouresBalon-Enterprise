
package co.com.touresbalon.foundation.microservices.dto.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for confirmReservationRes_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="confirmReservationRes_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://touresbalon.com.co/model/lodging/schema/v1}GeneralResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "confirmReservationRes_type", propOrder = {
    "generalResponse"
})
public class ConfirmReservationResType {

    @XmlElement(name = "GeneralResponse", namespace = "http://touresbalon.com.co/model/lodging/schema/v1", required = true)
    protected GeneralResponse generalResponse;

    public ConfirmReservationResType(){}

    public ConfirmReservationResType(String message){
        this.generalResponse = new GeneralResponse();
        generalResponse.setMessage(message);
    }

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
