package co.com.touresbalon.foundation.oms.domain.products;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by garciniegas on 16/10/2015.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "partnerServiceWrapper", propOrder = {
        "transports","lodgings","spectacles"
})
public class PartnerServiceWrapper {

    private List<Transport> transports;
    private List<Lodging> lodgings;
    private List<Spectacle> spectacles;

    public List<Transport> getTransports() {

        transports = (transports == null ? new ArrayList<Transport>() : transports);
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }

    public List<Lodging> getLodgings() {

        lodgings = (lodgings == null ? new ArrayList<Lodging>() : lodgings);
        return lodgings;
    }

    public void setLodgings(List<Lodging> lodgings) {
        this.lodgings = lodgings;
    }

    public List<Spectacle> getSpectacles() {

        spectacles = (spectacles == null ? new ArrayList<Spectacle>() : spectacles);
        return spectacles;
    }

    public void setSpectacles(List<Spectacle> spectacles) {
        this.spectacles = spectacles;
    }
}
