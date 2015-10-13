package co.com.touresbalon.foundation.oms.infrastructure;

import co.com.touresbalon.foundation.oms.webclient.OrdersWebClient;
import co.com.touresbalon.foundation.oms.webclient.PartnerServicesWebClient;
import co.com.touresbalon.foundation.oms.webclient.ProductsWebClient;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

/**
 * Created by garciniegas on 05/10/2015.
 */

@ApplicationScoped
public class WebResourceFactory {


    //----------------------------------

    @Produces
    @Singleton
    private OrdersWebClient createOrdersRestClient(){

        StringBuilder endpoint = new StringBuilder();
        endpoint.append("http://")
                .append(System.getProperty("touresbalon.locations.esb.orders"))
                .append("/esb/services/web-api");
        OrdersWebClient client = JAXRSClientFactory.create(endpoint.toString(), OrdersWebClient.class);
        return client;
    }

    //----------------------------------

    @Produces
    @Singleton
    private ProductsWebClient createProductsRestClient(){

        StringBuilder endpoint = new StringBuilder();
        endpoint.append("http://")
                .append(System.getProperty("touresbalon.locations.esb.products"))
                .append("/esb/services/web-api");
        ProductsWebClient client = JAXRSClientFactory.create(endpoint.toString(), ProductsWebClient.class);
        return client;
    }

    @Produces
    @Singleton
    private PartnerServicesWebClient createPartnersRestClient(){

        StringBuilder endpoint = new StringBuilder();
        endpoint.append("http://")
                .append(System.getProperty("touresbalon.locations.esb.products"))
                .append("/esb/services/web-api");
        PartnerServicesWebClient client = JAXRSClientFactory.create(endpoint.toString(), PartnerServicesWebClient.class);
        return client;
    }

}
