package co.com.touresbalon.foundation.oms.usecases.ratesadmin;

import co.com.touresbalon.foundation.oms.domain.products.Lodging;
import co.com.touresbalon.foundation.oms.domain.products.Spectacle;
import co.com.touresbalon.foundation.oms.domain.products.Transport;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by garciniegas on 16/10/2015.
 */

@Named
@SessionScoped
public class RatesModel implements Serializable {

    private List<Transport> transports;
    private List<Lodging> lodgings;
    private List<Spectacle> spectacles;

    public RatesModel() {
    }

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
