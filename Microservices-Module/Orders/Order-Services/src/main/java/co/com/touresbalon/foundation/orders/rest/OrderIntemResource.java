package co.com.touresbalon.foundation.orders.rest;

import co.com.touresbalon.foundation.orders.boundary.SalesOrdersBoundary;
import co.com.touresbalon.foundation.orders.dto.Product;
import co.com.touresbalon.foundation.orders.entity.OrderItem;
import co.com.touresbalon.foundation.orders.entity.SalesOrder;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Jenny Rodriguez on 19/08/2015.
 */

@Path("/order-items")
public class OrderIntemResource {

    @Inject
    private SalesOrdersBoundary boundary;

    public OrderIntemResource() {
    }

    @GET
    @Path("/topItems")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Product> getTopFiveProducts(@QueryParam("idProduct") Long idProduct){
        return boundary.getTopFiveProducts(idProduct);
    }

    // [cache service] -------------------------------

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response testCache() {
        return Response.status(200).entity("{total: "+ boundary.testCache() +"}").build();
    }


}
