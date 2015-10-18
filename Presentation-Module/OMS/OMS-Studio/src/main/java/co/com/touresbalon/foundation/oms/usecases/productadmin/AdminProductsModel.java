package co.com.touresbalon.foundation.oms.usecases.productadmin;

import co.com.touresbalon.foundation.oms.domain.products.*;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by garciniegas on 12/10/2015.
 */

@Named
@SessionScoped
public class AdminProductsModel implements Serializable{

    private boolean creationFlow;
    private Product product;
    private List<Country> countries;
    private List<City> sourceCities;
    private List<City> targetCities;
    private List<Transport> transports;
    private List<Lodging> lodgings;
    private List<Spectacle> spectacles;

    //[custom fields]----------------

    private Integer countrySource;
    private Integer countryTarget;

    public AdminProductsModel()
    {
        cleanModel();
        creationFlow = true;
    }

    public void cleanModel(){
        product = new Product();
        product.setArrivalDate( new Date());
        product.setDepartureDate( new Date());
        product.setLodgingType(new Lodging());
        product.setSourceCity(new City());
        product.setTargetCity(new City());
        product.setSpectacleType(new Spectacle());
        product.setTransportType( new Transport() );
    }

    public boolean isCreationFlow() {
        return creationFlow;
    }

    public void setCreationFlow(boolean creationFlow) {
        this.creationFlow = creationFlow;
    }

    public Integer getCountrySource() {
        return countrySource;
    }

    public void setCountrySource(Integer countrySource) {
        this.countrySource = countrySource;
    }

    public Integer getCountryTarget() {
        return countryTarget;
    }

    public void setCountryTarget(Integer countryTarget) {
        this.countryTarget = countryTarget;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<City> getSourceCities() {
        return sourceCities;
    }

    public void setSourceCities(List<City> sourceCities) {
        this.sourceCities = sourceCities;
    }

    public List<City> getTargetCities() {
        return targetCities;
    }

    public void setTargetCities(List<City> targetCities) {
        this.targetCities = targetCities;
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
