
package co.com.touresbalon.foundation.oms.domain.orders;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for orderItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="itemNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lodgingComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderId" type="{}salesOrder" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spectacleComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spectacleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="spectacleTicket" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transportChairNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transportComments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transportOutTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transportSourceCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transportTargetCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transportTravelDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="transportTravelNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderItem", propOrder = {
    "id",
    "itemNo",
    "lodgingComments",
    "orderId",
    "price",
    "productId",
    "productName",
    "spectacleComments",
    "spectacleId",
    "spectacleTicket",
    "status",
    "transportChairNumber",
    "transportComments",
    "transportOutTime",
    "transportSourceCity",
    "transportTargetCity",
    "transportTravelDate",
    "transportTravelNumber"
})
public class OrderItem {

    protected Long id;
    protected String itemNo;
    protected String lodgingComments;
    protected SalesOrder orderId;
    protected Long price;
    protected Long productId;
    protected String productName;
    protected String spectacleComments;
    protected Long spectacleId;
    protected Long spectacleTicket;
    protected String status;
    protected String transportChairNumber;
    protected String transportComments;
    protected String transportOutTime;
    protected String transportSourceCity;
    protected String transportTargetCity;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transportTravelDate;
    protected String transportTravelNumber;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the itemNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemNo() {
        return itemNo;
    }

    /**
     * Sets the value of the itemNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemNo(String value) {
        this.itemNo = value;
    }

    /**
     * Gets the value of the lodgingComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLodgingComments() {
        return lodgingComments;
    }

    /**
     * Sets the value of the lodgingComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLodgingComments(String value) {
        this.lodgingComments = value;
    }

    /**
     * Gets the value of the orderId property.
     * 
     * @return
     *     possible object is
     *     {@link SalesOrder }
     *     
     */
    public SalesOrder getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the orderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link SalesOrder }
     *     
     */
    public void setOrderId(SalesOrder value) {
        this.orderId = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrice(Long value) {
        this.price = value;
    }

    /**
     * Gets the value of the productId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Sets the value of the productId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProductId(Long value) {
        this.productId = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the spectacleComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpectacleComments() {
        return spectacleComments;
    }

    /**
     * Sets the value of the spectacleComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpectacleComments(String value) {
        this.spectacleComments = value;
    }

    /**
     * Gets the value of the spectacleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSpectacleId() {
        return spectacleId;
    }

    /**
     * Sets the value of the spectacleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSpectacleId(Long value) {
        this.spectacleId = value;
    }

    /**
     * Gets the value of the spectacleTicket property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSpectacleTicket() {
        return spectacleTicket;
    }

    /**
     * Sets the value of the spectacleTicket property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSpectacleTicket(Long value) {
        this.spectacleTicket = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the transportChairNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportChairNumber() {
        return transportChairNumber;
    }

    /**
     * Sets the value of the transportChairNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportChairNumber(String value) {
        this.transportChairNumber = value;
    }

    /**
     * Gets the value of the transportComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportComments() {
        return transportComments;
    }

    /**
     * Sets the value of the transportComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportComments(String value) {
        this.transportComments = value;
    }

    /**
     * Gets the value of the transportOutTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportOutTime() {
        return transportOutTime;
    }

    /**
     * Sets the value of the transportOutTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportOutTime(String value) {
        this.transportOutTime = value;
    }

    /**
     * Gets the value of the transportSourceCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportSourceCity() {
        return transportSourceCity;
    }

    /**
     * Sets the value of the transportSourceCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportSourceCity(String value) {
        this.transportSourceCity = value;
    }

    /**
     * Gets the value of the transportTargetCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportTargetCity() {
        return transportTargetCity;
    }

    /**
     * Sets the value of the transportTargetCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportTargetCity(String value) {
        this.transportTargetCity = value;
    }

    /**
     * Gets the value of the transportTravelDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransportTravelDate() {
        return transportTravelDate;
    }

    /**
     * Sets the value of the transportTravelDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransportTravelDate(XMLGregorianCalendar value) {
        this.transportTravelDate = value;
    }

    /**
     * Gets the value of the transportTravelNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportTravelNumber() {
        return transportTravelNumber;
    }

    /**
     * Sets the value of the transportTravelNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportTravelNumber(String value) {
        this.transportTravelNumber = value;
    }

}
