package co.com.touresbalon.foundation.oms.webclient;

import co.com.touresbalon.foundation.oms.domain.products.CollectionWrapper;
import co.com.touresbalon.foundation.oms.domain.products.Product;
import co.com.touresbalon.foundation.oms.exceptions.BusinessException;
import co.com.touresbalon.foundation.oms.exceptions.SystemException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by garciniegas on 05/10/2015.
 */

@Path("/products")
public interface ProductsWebClient {


    @GET
    @Path("/byName")
    @Consumes(MediaType.APPLICATION_XML)
    Product searchProductByName( @QueryParam("name") String name );


    // [return product detail] -------------------------------

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    Product searchProduct( @PathParam("id") Long id );


    // [search all products] -------------------------------

    @GET
    @Consumes(MediaType.APPLICATION_XML)
    List<Product> searchProducts( @QueryParam("code") String code,
                                         @QueryParam("name") String name,
                                         @QueryParam("description") String description,
                                         @QueryParam("spectacleName")String spectacleName,
                                         @QueryParam("pageIndex") int pageIndex,
                                         @QueryParam("pageSize") int pageSize);



    // [count service] -------------------------------

    @GET
    @Path("/count")
    @Consumes(MediaType.APPLICATION_XML)
    String getTotalPagesByProductSearch( @QueryParam("code") String code,
                                         @QueryParam("name") String name,
                                         @QueryParam("description") String description,
                                         @QueryParam("spectacleName")String spectacleName);


    @GET
    @Path("/soldSpectacles/ranking")
    @Consumes({MediaType.APPLICATION_XML})
    CollectionWrapper getRankingSoldOrders( @QueryParam("startOrderDate") String startOrderDate,
                                            @QueryParam("endOrderDate")  String endOrderDate );



    @POST
    @Produces({MediaType.APPLICATION_XML})
    void createProduct( Product product ) throws BusinessException, SystemException;

}
