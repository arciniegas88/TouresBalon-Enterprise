package co.com.touresbalon.foundation.products.dto;

import co.com.touresbalon.foundation.products.entity.Lodging;
import co.com.touresbalon.foundation.products.entity.Spectacle;
import co.com.touresbalon.foundation.products.entity.Transport;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by garciniegas on 16/10/2015.
 */

@XmlRootElement(name = "partnerServiceWrapper")
public class PartnerServiceWrapper {

    private List<Transport>transports;
    private List<Lodging> lodgings;
    private List<Spectacle> spectacles;

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }

    public List<Lodging> getLodgings() {
        return lodgings;
    }

    public void setLodgings(List<Lodging> lodgings) {
        this.lodgings = lodgings;
    }

    public List<Spectacle> getSpectacles() {
        return spectacles;
    }

    public void setSpectacles(List<Spectacle> spectacles) {
        this.spectacles = spectacles;
    }
}
