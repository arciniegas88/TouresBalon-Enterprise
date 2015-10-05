package co.com.touresbalon.foundation.oms.facades;

import co.com.touresbalon.foundation.oms.domain.products.Product;
import co.com.touresbalon.foundation.oms.domain.products.ProductsWrapper;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;

/**
 * Created by garciniegas on 04/10/2015.
 */

@ApplicationScoped
public class ProductsFacade {



    public static void main( String... args ){

        Client client = ClientBuilder.newClient();
        Invocation.Builder b = client.target("http://localhost:9496/esb/services/web-api/products")
                                     .request()
                                     .accept("application/xml");
        System.out.println( b.get(ProductsWrapper.class).getProduct().get(0).getName() );
        System.out.println( "--------------" );
    }


}
