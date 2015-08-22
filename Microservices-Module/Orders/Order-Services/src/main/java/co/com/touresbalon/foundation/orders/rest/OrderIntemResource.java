package co.com.touresbalon.foundation.orders.rest;

import co.com.touresbalon.foundation.orders.boundary.SalesOrdersBoundary;
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
 * Created by garciniegas on 19/08/2015.
 */

@Path("/order-items")
public class OrderIntemResource {

    @Inject
    private SalesOrdersBoundary boundary;

    public OrderIntemResource() {
    }

    @GET
    @Path("/orders")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<SalesOrder> searchSalesOrderByIdProduct (@QueryParam("idProduct")Long idProduct){
        return boundary.searchSalesOrderByIdProduct(idProduct);
    }


    @GET
    @Path("/items")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<OrderItem> searchOrderItemsByIdOrder(@QueryParam("idOrder") Long idOrder){
        return boundary.searchOrderItemsByIdOrder(idOrder);
    }





    // [cache service] -------------------------------

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response testCache() {
        return Response.status(200).entity("{total: "+ boundary.testCache() +"}").build();
    }


}
