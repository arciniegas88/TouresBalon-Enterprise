
package co.com.touresbalon.foundation.oms.domain.customers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customersResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customersResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getCustomersResult" type="{}customersResultType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customersResponseType", propOrder = {
    "getCustomersResult"
})
public class CustomersResponseType {

    @XmlElement(required = true)
    protected CustomersResultType getCustomersResult;

    /**
     * Gets the value of the getCustomersResult property.
     * 
     * @return
     *     possible object is
     *     {@link CustomersResultType }
     *     
     */
    public CustomersResultType getGetCustomersResult() {
        return getCustomersResult;
    }

    /**
     * Sets the value of the getCustomersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomersResultType }
     *     
     */
    public void setGetCustomersResult(CustomersResultType value) {
        this.getCustomersResult = value;
    }

}
