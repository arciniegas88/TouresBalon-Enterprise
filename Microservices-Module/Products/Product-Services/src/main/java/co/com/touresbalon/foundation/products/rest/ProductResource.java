package co.com.touresbalon.foundation.products.rest;

import co.com.touresbalon.foundation.products.boundary.ProductBoundary;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import co.com.touresbalon.foundation.products.entity.Product;

/**
 * Created by garciniegas on 07/08/2015.
 */

@Path("/products")
public class ProductResource {

    // [attributes] -------------------------------
    @Inject
    private ProductBoundary boundary;

    public ProductResource() {
    }

    // [return product detail] -------------------------------

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Product searchProduct( @PathParam("id") Long id ) {
        return boundary.getProductDetail(id);
    }


    // [search all products] -------------------------------

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Product> searchProducts( @QueryParam("code") String code,
                                         @QueryParam("name") String name,
                                         @QueryParam("description") String description,
                                         @QueryParam("pageIndex") int pageIndex,
                                         @QueryParam("pageSize") int pageSize) {
        return boundary.searchProducts(code, name, description,pageIndex,pageSize);
    }



    // [count service] -------------------------------

    @GET
    @Path("/count")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTotalPagesByProductSearch( @QueryParam("code") String code,
                                         @QueryParam("name") String name,
                                         @QueryParam("description") String description,
                                         @QueryParam("pageSize") int pageSize) {
        int totalPages = boundary.countProducts(code, name, description, pageSize);
        return Response.status(200).entity("{total: "+ totalPages +"}").build();
    }


}
