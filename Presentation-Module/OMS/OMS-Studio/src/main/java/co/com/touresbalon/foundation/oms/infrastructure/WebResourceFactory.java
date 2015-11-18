package co.com.touresbalon.foundation.oms.infrastructure;

import co.com.touresbalon.foundation.oms.webclient.CustomerWebClient;
import co.com.touresbalon.foundation.oms.webclient.OrdersWebClient;
import co.com.touresbalon.foundation.oms.webclient.PartnerServicesWebClient;
import co.com.touresbalon.foundation.oms.webclient.ProductsWebClient;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.http.client.methods.HttpPost;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Created by garciniegas on 05/10/2015.
 */

@ApplicationScoped
public class WebResourceFactory {

    //----------------------------------

    @Produces
    public HttpPost createSecurityPOSTResourceClient(){

        StringBuilder endpoint = new StringBuilder();
        endpoint.append("http://")
                .append(System.getProperty("touresbalon.locations.esb.security"))
                .append("/esb/services/web-api/security/login");

        HttpPost post = new HttpPost( endpoint.toString() );
        return post;
    }


    //----------------------------------

    @Produces
    @Singleton
    private ActiveMQConnectionFactory createMQConnectionFactory(){

        StringBuilder endpoint = new StringBuilder();
        endpoint.append("tcp://")
                .append(System.getProperty("touresbalon.locations.esb.mq"));

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory( endpoint.toString() );
        connectionFactory.setUserName("admin");
        connectionFactory.setPassword("admin");

        return connectionFactory;
    }


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

    @Produces
    @Singleton
    private CustomerWebClient createCustomersRestClient(){
        StringBuilder endpoint = new StringBuilder();
        endpoint.append("http://")
                .append(System.getProperty("touresbalon.locations.esb.customers"))
                .append("/esb/services/web-api");
        CustomerWebClient client = JAXRSClientFactory.create(endpoint.toString(), CustomerWebClient.class);
        return client;
    }

}
