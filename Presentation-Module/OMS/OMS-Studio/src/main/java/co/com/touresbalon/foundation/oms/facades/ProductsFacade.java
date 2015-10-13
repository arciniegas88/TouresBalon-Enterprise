package co.com.touresbalon.foundation.oms.facades;

import co.com.touresbalon.foundation.oms.domain.products.*;
import co.com.touresbalon.foundation.oms.webclient.PartnerServicesWebClient;
import co.com.touresbalon.foundation.oms.webclient.ProductsWebClient;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by garciniegas on 04/10/2015.
 */

@ApplicationScoped
public class ProductsFacade {

    //[fields] injected service client fields -----------------------

    @Inject
    private ProductsWebClient productsWC;
    @Inject
    private PartnerServicesWebClient partnersWC;

    // ------------------------------

    public Product searchProductByName(String name ){
        return productsWC.searchProductByName(name);
    }

    // ------------------------------

    public Product searchProduct( Long id ){
        return productsWC.searchProduct(id);
    }


    // ------------------------------

    public List<Product> searchProducts( String code, String name,String description,String spectacleName,
                                         int pageIndex,int pageSize){
        return productsWC.searchProducts(code,name,description,spectacleName,pageIndex,pageSize);
    }


    // ------------------------------

    public int getTotalPagesByProductSearch( String code, String name,String description,String spectacleName){

        String total = productsWC.getTotalPagesByProductSearch(code, name, description,spectacleName);
        return Integer.parseInt(total.replaceAll("<total>", "").replaceAll("</total>", ""));
    }

    // ------------------------------

    public List<String> getRankingSoldOrders( Date startOrderDate, Date endOrderDate ){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return productsWC.getRankingSoldOrders( sdf.format(startOrderDate),sdf.format(endOrderDate)).getData();
    }

    // ------------------------------

    public List<Transport> getTransports() {
        return partnersWC.getTransports();
    }

    // ------------------------------

    public List<Spectacle> getSpectacles(){
        return partnersWC.getSpectacles();
    }

    // ------------------------------

    public List<Lodging> getLodging() {
        return partnersWC.getLodging();
    }

    // ------------------------------

    public List<Country> getCountries(){
        return partnersWC.getCountries();
    }

    // ------------------------------

    public List<City> getCitiesByContry( Integer country ){
        return partnersWC.getCitiesByContry(country);
    }

}
