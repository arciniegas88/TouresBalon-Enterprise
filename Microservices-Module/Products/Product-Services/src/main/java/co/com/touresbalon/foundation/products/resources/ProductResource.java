package co.com.touresbalon.foundation.products.resources;

import co.com.touresbalon.foundation.products.boundary.ProductBoundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * Created by garciniegas on 07/08/2015.
 */

@Path("/products")
public class ProductResource {

    @Inject
    private ProductBoundary boundary;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String getClichedMessage() {
        // Return some cliched textual content
        return "<dato>"+ boundary +"</dato>";
    }

}
