package co.com.touresbalon.foundation.orders.rest;

import co.com.touresbalon.foundation.orders.boundary.SalesOrdersBoundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by garciniegas on 19/08/2015.
 */

@Path("/order-items")
public class OrderIntemResource {

    @Inject
    private SalesOrdersBoundary boundary;

    public OrderIntemResource() {
    }


    // [cache service] -------------------------------

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response testCache() {
        return Response.status(200).entity("{total: "+ boundary.testCache() +"}").build();
    }


}
