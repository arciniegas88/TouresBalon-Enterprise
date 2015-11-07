
package co.com.touresbalon.foundation.oms.domain.customers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getCustomerResult" type="{}customerType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerResponseType", propOrder = {
    "getCustomerResult"
})
public class CustomerResponseType {

    @XmlElement(required = true)
    protected CustomerType getCustomerResult;

    /**
     * Gets the value of the getCustomerResult property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerType }
     *     
     */
    public CustomerType getGetCustomerResult() {
        return getCustomerResult;
    }

    /**
     * Sets the value of the getCustomerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerType }
     *     
     */
    public void setGetCustomerResult(CustomerType value) {
        this.getCustomerResult = value;
    }

}
