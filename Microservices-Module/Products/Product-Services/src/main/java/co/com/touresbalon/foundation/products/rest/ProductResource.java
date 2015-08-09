package co.com.touresbalon.foundation.products.rest;

import co.com.touresbalon.foundation.products.boundary.ProductBoundary;
import co.com.touresbalon.foundation.products.entity.Product;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by garciniegas on 07/08/2015.
 */

@Path("/products")
public class ProductResource {

    // -------------------------------
    @Inject
    private ProductBoundary boundary;

    public ProductResource() {
    }

    // [search all products] -------------------------------

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Product> searchProductsByCriteria( @QueryParam("code") String code,
                                                   @QueryParam("name") String name,
                                                   @QueryParam("descritption") String descritption ) {
        return boundary.searchProducts(code, name, descritption);
    }


}
