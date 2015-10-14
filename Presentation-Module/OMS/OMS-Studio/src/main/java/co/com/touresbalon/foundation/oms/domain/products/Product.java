
package co.com.touresbalon.foundation.oms.domain.products;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
//import javax.xml.datatype.Date;


/**
 * <p>Java class for product complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arrivalDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departureDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="imageRef" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="lodgingType" type="{}lodging" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sourceCity" type="{}city" minOccurs="0"/>
 *         &lt;element name="spectacleDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="spectacleType" type="{}spectacle" minOccurs="0"/>
 *         &lt;element name="targetCity" type="{}city" minOccurs="0"/>
 *         &lt;element name="transportType" type="{}transport" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", propOrder = {
    "arrivalDate",
    "code",
    "departureDate",
    "description",
    "id",
    "imageRef",
    "lodgingType",
    "name",
    "price",
    "sourceCity",
    "spectacleType",
    "targetCity",
    "transportType"
})
public class Product {

    protected Date arrivalDate;
    protected String code;
    protected Date departureDate;
    protected String description;
    protected Long id;
    protected byte[] imageRef;
    protected Lodging lodgingType;
    protected String name;
    protected Long price;
    protected City sourceCity;
    protected Spectacle spectacleType;
    protected City targetCity;
    protected Transport transportType;

    /**
     * Gets the value of the arrivalDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the value of the arrivalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setArrivalDate(Date value) {
        this.arrivalDate = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the departureDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the value of the departureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDepartureDate(Date value) {
        this.departureDate = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

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
     * Gets the value of the imageRef property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImageRef() {
        return imageRef;
    }

    /**
     * Sets the value of the imageRef property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImageRef(byte[] value) {
        this.imageRef = value;
    }

    /**
     * Gets the value of the lodgingType property.
     * 
     * @return
     *     possible object is
     *     {@link Lodging }
     *     
     */
    public Lodging getLodgingType() {
        return lodgingType;
    }

    /**
     * Sets the value of the lodgingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Lodging }
     *     
     */
    public void setLodgingType(Lodging value) {
        this.lodgingType = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Gets the value of the sourceCity property.
     * 
     * @return
     *     possible object is
     *     {@link City }
     *     
     */
    public City getSourceCity() {
        return sourceCity;
    }

    /**
     * Sets the value of the sourceCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link City }
     *     
     */
    public void setSourceCity(City value) {
        this.sourceCity = value;
    }

    /**
     * Gets the value of the spectacleType property.
     * 
     * @return
     *     possible object is
     *     {@link Spectacle }
     *     
     */
    public Spectacle getSpectacleType() {
        return spectacleType;
    }

    /**
     * Sets the value of the spectacleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Spectacle }
     *     
     */
    public void setSpectacleType(Spectacle value) {
        this.spectacleType = value;
    }

    /**
     * Gets the value of the targetCity property.
     * 
     * @return
     *     possible object is
     *     {@link City }
     *     
     */
    public City getTargetCity() {
        return targetCity;
    }

    /**
     * Sets the value of the targetCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link City }
     *     
     */
    public void setTargetCity(City value) {
        this.targetCity = value;
    }

    /**
     * Gets the value of the transportType property.
     * 
     * @return
     *     possible object is
     *     {@link Transport }
     *     
     */
    public Transport getTransportType() {
        return transportType;
    }

    /**
     * Sets the value of the transportType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Transport }
     *     
     */
    public void setTransportType(Transport value) {
        this.transportType = value;
    }

}
