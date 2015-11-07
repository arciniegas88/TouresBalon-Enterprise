
package co.com.touresbalon.foundation.oms.domain.customers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateCustomerResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateCustomerResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="updateCustomerResult" type="{}generalResponseType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateCustomerResponseType", propOrder = {
    "updateCustomerResult"
})
public class UpdateCustomerResponseType {

    @XmlElement(required = true)
    protected GeneralResponseType updateCustomerResult;

    /**
     * Gets the value of the updateCustomerResult property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralResponseType }
     *     
     */
    public GeneralResponseType getUpdateCustomerResult() {
        return updateCustomerResult;
    }

    /**
     * Sets the value of the updateCustomerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralResponseType }
     *     
     */
    public void setUpdateCustomerResult(GeneralResponseType value) {
        this.updateCustomerResult = value;
    }

}
