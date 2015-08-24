package co.com.touresbalon.foundation.transports.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Created by garciniegas on 22/08/2015.
 */

public class Reservation implements Serializable{

    private String sourceCity;
    private String targetCity;
    private String travelNumber;
    private String chairNumber;
    private String outTime;

    public Reservation() {
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

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public boolean isEqualsTo( String sourceCity, String targetCity , String outTime){
        return StringUtils.equals(this.sourceCity,sourceCity) && StringUtils.equals(this.targetCity,targetCity) &&
               StringUtils.equals(this.outTime,outTime);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "sourceCity='" + sourceCity + '\'' +
                ", targetCity='" + targetCity + '\'' +
                ", travelNumber='" + travelNumber + '\'' +
                ", chairNumber='" + chairNumber + '\'' +
                ", outTime='" + outTime + '\'' +
                '}';
    }
}
