package co.com.touresbalon.foundation.orders.rest;

import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import co.com.touresbalon.foundation.orders.boundary.SalesOrdersBoundary;
import co.com.touresbalon.foundation.orders.dto.CollectionWrapper;
import co.com.touresbalon.foundation.orders.dto.Product;
import co.com.touresbalon.foundation.orders.entity.OrderItem;
import co.com.touresbalon.foundation.orders.entity.SalesOrder;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
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


    @GET
    @Path("/soldProducts/ranking")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CollectionWrapper getRankingSoldProducts( @QueryParam("startOrderDate") String startOrderDate,
                                                     @QueryParam("endOrderDate")  String endOrderDate ) throws SystemException {

        CollectionWrapper wrapper = new CollectionWrapper();
        wrapper.setData( boundary.getRankingSoldProducts(startOrderDate,endOrderDate) );

        return wrapper;
    }

    @GET
    @Path("/soldProducts/occurrences/{productId}")
    @Produces({MediaType.APPLICATION_XML})
    public Response countProductTotalOccurrences( @PathParam("productId") Long productId )throws SystemException{

        Long total = boundary.countTotalProductOccurrences( productId );
        return Response.status(200).entity("<response><occurrences>"+ (total == 0 ? false : true) +"</occurrences></response>").build();
    }

}
