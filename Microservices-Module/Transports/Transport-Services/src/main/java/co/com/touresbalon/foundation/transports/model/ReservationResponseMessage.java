package co.com.touresbalon.foundation.transports.model;

/**
 * Created by garciniegas on 21/08/2015.
 */

public class ReservationResponseMessage {

    private boolean available;
    private String description;
    private String travelNumber;
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
