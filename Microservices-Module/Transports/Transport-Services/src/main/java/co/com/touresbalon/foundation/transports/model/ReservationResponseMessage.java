package co.com.touresbalon.foundation.transports.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by garciniegas on 21/08/2015.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ReservationResponseMessage {

    @XmlElement(nillable=true)
    private boolean available;
    @XmlElement(nillable=true)
    private String description;
    @XmlElement(nillable=true)
    private String travelNumber;
    @XmlElement(nillable=true)
    private String chairNumber;

    public ReservationResponseMessage() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getTravelNumber() {
        return travelNumber;
    }

    public void setTravelNumber(String travelNumber) {
        this.travelNumber = travelNumber;
    }

    public String getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(String chairNumber) {
        this.chairNumber = chairNumber;
    }
}
