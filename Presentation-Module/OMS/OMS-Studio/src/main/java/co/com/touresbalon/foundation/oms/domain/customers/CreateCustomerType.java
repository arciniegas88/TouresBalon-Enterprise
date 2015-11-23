
package co.com.touresbalon.foundation.oms.domain.customers;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for createCustomerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createCustomerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customer" type="{}customerType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createCustomerType", propOrder = {
    "customer"
})
public class CreateCustomerType {

    @XmlElement(required = true)
    protected CustomerType customer;

    public CreateCustomerType(){
        super();
    }

    public CreateCustomerType(CustomerType customer){
        this.customer = customer;
    }

    /**
     * Gets the value of the customer property.
     *
     * @return
     *     possible object is
     *     {@link co.com.touresbalon.foundation.oms.domain.customers.CustomerType }
     *
     */
    public CustomerType getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     *
     * @param value
     *     allowed object is
     *     {@link co.com.touresbalon.foundation.oms.domain.customers.CustomerType }
     *
     */
    public void setCustomer(CustomerType value) {
        this.customer = value;
    }

}
