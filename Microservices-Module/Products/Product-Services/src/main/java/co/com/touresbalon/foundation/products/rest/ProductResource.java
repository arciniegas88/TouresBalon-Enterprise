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

import co.com.touresbalon.foundation.products.dto.CollectionWrapper;
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
    @Path("/byName")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Product searchProductByName( @QueryParam("name") String name ) throws SystemException {

        return boundary.getProductByName(name);
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
                                         @QueryParam("spectacleName")String spectacleName,
                                         @QueryParam("pageIndex") int pageIndex,
                                         @QueryParam("pageSize") int pageSize)throws SystemException  {

        return boundary.searchProducts(code, name, description, spectacleName, pageIndex, pageSize);
    }



    // [count service] -------------------------------

    @GET
    @Path("/count")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getTotalPagesByProductSearch( @QueryParam("code") String code,
                                                  @QueryParam("name") String name,
                                                  @QueryParam("description") String description,
                                                  @QueryParam("spectacleName")String spectacleName) throws SystemException {

        int totalPages = boundary.countProducts(code, name, description, spectacleName);
        String content = RESTUtil.getNegotiatedContent(headers,totalPages,"total");
        return Response.status(200).entity(content).type( RESTUtil.getAcceptedMediaType(headers) ).build();
    }


    @POST
    @Path("/soldSpectacles/ranking")
    @Produces({MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_XML})
    public CollectionWrapper getRankingSoldOrders( CollectionWrapper request ) throws SystemException {

        CollectionWrapper wrapper = new CollectionWrapper();
        wrapper.setData( boundary.findEspectaclesRealedToProducts( request.getData() ) );

        return wrapper;
    }


}
