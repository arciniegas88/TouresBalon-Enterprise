
package co.com.touresbalon.foundation.oms.domain.customers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for countCustomersResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="countCustomersResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countCustomersResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "countCustomersResponseType", propOrder = {
    "countCustomersResult"
})
public class CountCustomersResponseType {

    protected int countCustomersResult;

    /**
     * Gets the value of the countCustomersResult property.
     * 
     */
    public int getCountCustomersResult() {
        return countCustomersResult;
    }

    /**
     * Sets the value of the countCustomersResult property.
     * 
     */
    public void setCountCustomersResult(int value) {
        this.countCustomersResult = value;
    }

}
