package co.com.touresbalon.foundation.oms.webclient;

import co.com.touresbalon.foundation.oms.domain.orders.CollectionWrapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by garciniegas on 06/10/2015.
 */

@Path("/orders")
public interface OrdersWebClient {

    @GET
    @Path("/soldProducts/ranking")
    @Consumes({MediaType.APPLICATION_XML})
    CollectionWrapper getRankingSoldProducts( @QueryParam("startOrderDate") String startOrderDate,
                                              @QueryParam("endOrderDate")  String endOrderDate );


}
