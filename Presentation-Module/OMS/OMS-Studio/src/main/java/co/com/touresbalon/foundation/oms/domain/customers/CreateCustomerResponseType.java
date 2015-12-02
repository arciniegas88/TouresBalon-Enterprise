
package co.com.touresbalon.foundation.oms.domain.customers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createCustomerResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createCustomerResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createCustomerResult" type="{}createCustomerResultType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createCustomerResponseType", propOrder = {
    "createCustomerResult"
})
public class CreateCustomerResponseType {

    @XmlElement(required = true)
    protected CreateCustomerResultType createCustomerResult;

    /**
     * Gets the value of the createCustomerResult property.
     * 
     * @return
     *     possible object is
     *     {@link CreateCustomerResultType }
     *     
     */
    public CreateCustomerResultType getCreateCustomerResult() {
        return createCustomerResult;
    }

    /**
     * Sets the value of the createCustomerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateCustomerResultType }
     *     
     */
    public void setCreateCustomerResult(CreateCustomerResultType value) {
        this.createCustomerResult = value;
    }

}
