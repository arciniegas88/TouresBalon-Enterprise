
package co.com.touresbalon.foundation.oms.domain.customers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerByEmailResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerByEmailResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getCustomerByEmailResult" type="{}customerType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerByEmailResponseType", propOrder = {
    "getCustomerByEmailResult"
})
public class CustomerByEmailResponseType {

    @XmlElement(required = true)
    protected CustomerType getCustomerByEmailResult;

    /**
     * Gets the value of the getCustomerByEmailResult property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerType }
     *     
     */
    public CustomerType getGetCustomerByEmailResult() {
        return getCustomerByEmailResult;
    }

    /**
     * Sets the value of the getCustomerByEmailResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerType }
     *     
     */
    public void setGetCustomerByEmailResult(CustomerType value) {
        this.getCustomerByEmailResult = value;
    }

}
