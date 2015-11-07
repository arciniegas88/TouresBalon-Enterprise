
package co.com.touresbalon.foundation.oms.domain.customers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteCustomerResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteCustomerResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deleteCustomerResult" type="{}generalResponseType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteCustomerResponseType", propOrder = {
    "deleteCustomerResult"
})
public class DeleteCustomerResponseType {

    @XmlElement(required = true)
    protected GeneralResponseType deleteCustomerResult;

    /**
     * Gets the value of the deleteCustomerResult property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralResponseType }
     *     
     */
    public GeneralResponseType getDeleteCustomerResult() {
        return deleteCustomerResult;
    }

    /**
     * Sets the value of the deleteCustomerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralResponseType }
     *     
     */
    public void setDeleteCustomerResult(GeneralResponseType value) {
        this.deleteCustomerResult = value;
    }

}
