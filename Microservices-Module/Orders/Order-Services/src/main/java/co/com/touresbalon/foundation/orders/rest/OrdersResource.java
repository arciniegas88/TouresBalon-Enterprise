package co.com.touresbalon.foundation.orders.rest;

import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import co.com.touresbalon.foundation.crosscutting.util.RESTUtil;
import co.com.touresbalon.foundation.orders.boundary.SalesOrdersBoundary;
import co.com.touresbalon.foundation.orders.dto.CollectionWrapper;
import co.com.touresbalon.foundation.orders.dto.Customer;
import co.com.touresbalon.foundation.orders.dto.Product;
import co.com.touresbalon.foundation.orders.entity.OrderItem;
import co.com.touresbalon.foundation.orders.entity.SalesOrder;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Jenny Rodriguez on 19/08/2015.
 */

@Path("/orders")
public class OrdersResource {

    @Context
    private HttpHeaders headers;

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
    public List<SalesOrder> searchSalesOrderByCustomer(@QueryParam("typeDocument") String typeDocument, @QueryParam("numberDocument") String numberDocument) throws SystemException {
        return boundary.searchSalesOrderByCustomer(typeDocument, numberDocument);
    }

    @GET
    @Path("/generateOrderId")
    @Produces({MediaType.APPLICATION_JSON})
    public Response generateSalesOrderId() throws SystemException {
        Long idSalesOrder = boundary.generateSalesOrderId();
        return Response.status(200).entity("{idOrder: " + idSalesOrder + "}").build();

    }


    @GET
    @Path("/orderItems/{idSalesOrder}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<OrderItem> getOrderItems(@PathParam("idSalesOrder") Long idSalesOrder) throws SystemException {
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
    public CollectionWrapper getRankingSoldProducts(@QueryParam("startOrderDate") String startOrderDate,
                                                    @QueryParam("endOrderDate") String endOrderDate) throws SystemException {

        CollectionWrapper wrapper = new CollectionWrapper();
        wrapper.setData(boundary.getRankingSoldProducts(startOrderDate, endOrderDate));

        return wrapper;
    }

    @GET
    @Path("/soldProducts/occurrences/{productId}")
    @Produces({MediaType.APPLICATION_XML})
    public Response countProductTotalOccurrences(@PathParam("productId") Long productId) throws SystemException {

        Long total = boundary.countTotalProductOccurrences(productId);
        return Response.status(200).entity("<response><occurrences>" + (total == 0 ? false : true) + "</occurrences></response>").build();
    }

    // [search all sales Orders] -------------------------------

    @GET
    @Path("/orderSales")
    @Produces({MediaType.APPLICATION_XML})
    public List<SalesOrder> searchSalesOrders(@QueryParam("id") String id,
                                              @QueryParam("productId") String productId,
                                              @QueryParam("pageIndex") int pageIndex,
                                              @QueryParam("pageSize") int pageSize) throws SystemException {

        return boundary.searchSalesOrder(id, productId, pageIndex, pageSize);
    }


    // [count service] -------------------------------

    @GET
    @Path("/count")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getTotalPagesBySalesOrdersSearch(@QueryParam("id") String id,
                                                     @QueryParam("productId") String productId) throws SystemException {

        int totalPages = boundary.countSalesOrders(id, productId);
        String content = RESTUtil.getNegotiatedContent(headers, totalPages, "total");
        return Response.status(200).entity(content).type(RESTUtil.getAcceptedMediaType(headers)).build();
    }

    @GET
    @Path("/orderSalesStatus")
    @Produces({MediaType.APPLICATION_XML})
    public List<SalesOrder> searchSalesOrdersStatus(@QueryParam("status") String status,
                                                    @QueryParam("pageIndex") int pageIndex,
                                                    @QueryParam("pageSize") int pageSize) throws SystemException {

        return boundary.searchSalesOrderStatus(status, pageIndex, pageSize);
    }

    @GET
    @Path("/countStatus")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getTotalOrderStatus(@QueryParam("status") String status) throws SystemException {

        int totalPages = boundary.countSalesOrdersStatus(status);
        String content = RESTUtil.getNegotiatedContent(headers, totalPages, "total");
        return Response.status(200).entity(content).type(RESTUtil.getAcceptedMediaType(headers)).build();
    }

    @GET
    @Path("/salesOrder/customersProduct/count")
    @Produces(MediaType.APPLICATION_XML)
    public Response countCustomersByProductSold(@QueryParam("productId") String productId) throws SystemException {

        int count = boundary.countCustomersByProductsSold(productId);
        return Response.status(200).entity("<response><occurrences>" + count + "</occurrences></response>").build();
    }

    @GET
    @Path("/salesOrder/customersProduct")
    @Produces(MediaType.APPLICATION_XML)
    public List<Customer> getCustomersByProductSold(@QueryParam("productId") Long productId,
                                                    @QueryParam("pageIndex") int pageIndex,
                                                    @QueryParam("pageSize") int pageSize) throws SystemException {

        return boundary.getCustomersByProductSold(productId, pageIndex, pageSize);
    }

    @GET
    @Path("/salesOrder/customerRanking/count")
    @Produces(MediaType.APPLICATION_XML)
    public Response countCustomerRanking(@QueryParam("startDate") String startDate,
                                               @QueryParam("endDate") String endDate) throws SystemException{
        int count = boundary.countCustomerRanking(startDate, endDate);
        return Response.status(200).entity("<response><occurrences>" + count + "</occurrences></response>").build();
    }

    @GET
    @Path("/salesOrder/customerRanking")
    @Produces(MediaType.APPLICATION_XML)
    public List<Customer> getCustomerRanking(@QueryParam("startDate") String startDate,
                                             @QueryParam("endDate") String endDate,
                                             @QueryParam("pageIndex") int pageIndex,
                                             @QueryParam("pageSize") int pageSize) throws  SystemException{
        return boundary.getCustomerRanking(startDate, endDate, pageIndex, pageSize);

    }

}
