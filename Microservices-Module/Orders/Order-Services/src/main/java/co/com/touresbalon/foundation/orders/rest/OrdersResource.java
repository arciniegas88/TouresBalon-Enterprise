package co.com.touresbalon.foundation.orders.rest;

import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import co.com.touresbalon.foundation.orders.boundary.SalesOrdersBoundary;
import co.com.touresbalon.foundation.orders.dto.Product;
import co.com.touresbalon.foundation.orders.entity.OrderItem;
import co.com.touresbalon.foundation.orders.entity.SalesOrder;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Jenny Rodriguez on 19/08/2015.
 */

@Path("/orders")
public class OrdersResource {

    @Inject
    private SalesOrdersBoundary boundary;

    public OrdersResource() {
    }

    @GET
    @Path("/topItems/{idProduct}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Product> getTopFiveProducts(@PathParam("idProduct") Long idProduct) throws SystemException {
        return boundary.getTopFiveProducts(idProduct);
    }

    @GET
    @Path("/customerOrders")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<SalesOrder>searchSalesOrderByCustomer(@QueryParam("typeDocument") String typeDocument ,@QueryParam("numberDocument") String numberDocument) throws SystemException {
        return boundary.searchSalesOrderByCustomer(typeDocument, numberDocument);
    }

    @GET
    @Path("/generateOrderId")
    @Produces({MediaType.APPLICATION_JSON})
    public Response generateSalesOrderId() throws SystemException {
        Long idSalesOrder =boundary.generateSalesOrderId();
        return Response.status(200).entity("{idOrder: "+ idSalesOrder +"}").build();

    }


    @GET
    @Path("/orderItems/{idSalesOrder}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<OrderItem> getOrderItems(@PathParam("idSalesOrder")Long idSalesOrder) throws SystemException {
        return boundary.getOrderItems(idSalesOrder);
    }

    @GET
    @Path("/{idSalesOrder}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<SalesOrder> getSalesOrderDetail(@PathParam("idSalesOrder") Long idSalesOrder) throws SystemException {
        return boundary.getSalesOrderDetail(idSalesOrder);
    }

}
