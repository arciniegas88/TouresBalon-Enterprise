package co.com.touresbalon.foundation.products.rest;

import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import co.com.touresbalon.foundation.crosscutting.util.RESTUtil;
import co.com.touresbalon.foundation.products.boundary.ProductBoundary;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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

    @Context
    private HttpHeaders headers;

    @Inject
    private ProductBoundary boundary;

    public ProductResource() {
    }

    // [return product detail] -------------------------------

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Product searchProduct( @PathParam("id") Long id ) throws SystemException {

        return boundary.getProductDetail(id);
    }


    // [search all products] -------------------------------

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Product> searchProducts( @QueryParam("code") String code,
                                         @QueryParam("name") String name,
                                         @QueryParam("description") String description,
                                         @QueryParam("pageIndex") int pageIndex,
                                         @QueryParam("pageSize") int pageSize)throws SystemException  {

        return boundary.searchProducts(code, name, description,pageIndex,pageSize);
    }



    // [count service] -------------------------------

    @GET
    @Path("/count")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getTotalPagesByProductSearch( @QueryParam("code") String code,
                                         @QueryParam("name") String name,
                                         @QueryParam("description") String description) throws SystemException {

        int totalPages = boundary.countProducts(code, name, description);
        String content = RESTUtil.getNegotiatedContent(headers,totalPages,"total");
        return Response.status(200).entity(content).type( RESTUtil.getAcceptedMediaType(headers) ).build();
    }


}
