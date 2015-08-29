package co.com.touresbalon.foundation.transports.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by garciniegas on 23/08/2015.
 */
public class TravelConfirmation {

    private static SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");

    private String firstName;
    private String lastName;
    private Date outDate;
    private String travelNumber;
    private String chairNumber;

    public TravelConfirmation() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
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

    @Override
    public String toString() {
        return lastName+ ',' +firstName + ',' +df.format(outDate) + ',' + travelNumber +  ',' + chairNumber + ", \n";
    }
}
