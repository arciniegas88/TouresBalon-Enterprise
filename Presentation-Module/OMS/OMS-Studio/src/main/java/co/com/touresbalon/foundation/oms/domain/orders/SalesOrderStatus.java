
package co.com.touresbalon.foundation.oms.domain.orders;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for salesOrderStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="salesOrderStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IN_VALIDATION"/>
 *     &lt;enumeration value="IN_BOOKING"/>
 *     &lt;enumeration value="CLOSED"/>
 *     &lt;enumeration value="REJECTED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "salesOrderStatus")
@XmlEnum
public enum SalesOrderStatus {

    IN_VALIDATION,
    IN_BOOKING,
    CLOSED,
    REJECTED;

    public String value() {
        return name();
    }

    public static SalesOrderStatus fromValue(String v) {
        return valueOf(v);
    }

}
