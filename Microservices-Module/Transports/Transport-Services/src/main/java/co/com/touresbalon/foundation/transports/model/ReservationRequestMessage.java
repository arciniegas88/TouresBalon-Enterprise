package co.com.touresbalon.foundation.transports.model;

import java.util.Date;

/**
 * Created by garciniegas on 21/08/2015.
 */
public class ReservationRequestMessage {

    private TravelProvider provider;
    private String sourceCity;
    private String targetCity;
    private Date date;
    private String time;

    public ReservationRequestMessage() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TravelProvider getProvider() {
        return provider;
    }

    public void setProvider(TravelProvider provider) {
        this.provider = provider;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public String getTargetCity() {
        return targetCity;
    }

    public void setTargetCity(String targetCity) {
        this.targetCity = targetCity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
