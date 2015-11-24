package co.com.touresbalon.foundation.oms.webclient;

import co.com.touresbalon.foundation.oms.domain.customers.Customer;
import co.com.touresbalon.foundation.oms.domain.orders.CollectionWrapper;
import co.com.touresbalon.foundation.oms.domain.orders.OrderItem;
import co.com.touresbalon.foundation.oms.domain.orders.SalesOrder;
import co.com.touresbalon.foundation.oms.domain.products.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by garciniegas on 06/10/2015.
 */

@Path("/orders")
public interface OrdersWebClient {


    @GET
    @Path("/topItems/{idProduct}")
    @Produces({MediaType.APPLICATION_XML})
    List<Product> getTopFiveProducts(@PathParam("idProduct") Long idProduct);

    @GET
    @Path("/customerOrders")
    @Produces({MediaType.APPLICATION_XML})
    List<SalesOrder>searchSalesOrderByCustomer(@QueryParam("typeDocument") String typeDocument ,@QueryParam("numberDocument") String numberDocument);

    @GET
    @Path("/generateOrderId")
    @Produces({MediaType.APPLICATION_XML})
    Response generateSalesOrderId() ;


    @GET
    @Path("/orderItems/{idSalesOrder}")
    @Produces({MediaType.APPLICATION_XML})
    List<OrderItem> getOrderItems(@PathParam("idSalesOrder")Long idSalesOrder);

    @GET
    @Path("/{idSalesOrder}")
    @Produces({MediaType.APPLICATION_XML})
    List<SalesOrder> getSalesOrderDetail(@PathParam("idSalesOrder") Long idSalesOrder);


    @GET
    @Path("/soldProducts/ranking")
    @Produces({MediaType.APPLICATION_XML})
    CollectionWrapper getRankingSoldProducts( @QueryParam("startOrderDate") String startOrderDate,
                                              @QueryParam("endOrderDate")  String endOrderDate );

    @GET
    @Path("/soldProducts/occurrences/{productId}")
    @Produces({MediaType.APPLICATION_XML})
    Response countProductTotalOccurrences( @PathParam("productId") Long productId );


    @GET
    @Path("/orderSales")
    @Produces({MediaType.APPLICATION_XML})
    List<SalesOrder> searchSalesOrders( @QueryParam("id") String id,
                                        @QueryParam("productId") String productId,
                                        @QueryParam("pageIndex") int pageIndex,
                                        @QueryParam("pageSize") int pageSize);
    @GET
    @Path("/count")
    @Produces({MediaType.APPLICATION_XML})
    String getTotalPagesBySalesOrdersSearch( @QueryParam("id") String id,
                                             @QueryParam("productId") String productId);


    @GET
    @Path("/orderSalesStatus")
    @Produces({MediaType.APPLICATION_XML})
    List<SalesOrder> searchSalesOrdersStatus(@QueryParam("status") String status,
                                             @QueryParam("pageIndex") int pageIndex,
                                             @QueryParam("pageSize") int pageSize);

    @GET
    @Path("/countStatus")
    @Produces({MediaType.APPLICATION_XML})
    String getTotalOrderStatus(@QueryParam("status") String status);

    @GET
    @Path("/orderSalesInvoice")
    @Produces({MediaType.APPLICATION_XML})
    List<SalesOrder> searchSalesOrdersInvoce(@QueryParam("fecha") String fecha,
                                                    @QueryParam("pageIndex") int pageIndex,
                                                    @QueryParam("pageSize") int pageSize);


    @GET
    @Path("/orderSalesCountInvoice")
    @Produces({MediaType.APPLICATION_XML})
    String searchOrderSalesCountInvoice(@QueryParam("fecha") String fecha);


    @GET
    @Path("/orderSalesTotalInvoice")
    @Produces({MediaType.APPLICATION_XML})
    String searchOrderSalesTotalInvoice(@QueryParam("fecha") String fecha);

    @GET
    @Path("/orderSalesRankingStatus")
    @Produces({MediaType.APPLICATION_XML})
    List<SalesOrder> searchOrderSalesRankingStatus(@QueryParam("status") String status,
                                                          @QueryParam("pageIndex") int pageIndex,
                                                          @QueryParam("pageSize") int pageSize);

    @GET
    @Path("/orderSalesCountRankingStatus")
    @Produces({MediaType.APPLICATION_XML})
    String searchOrderSalesCountRankingStatus(@QueryParam("status") String status);

    @GET
    @Path("/orderSalesRankingPrice")
    @Produces({MediaType.APPLICATION_XML})
    List<SalesOrder> searchOrderSalesRankingPrice(@QueryParam("fechaInicio") String fechaInicio,
                                                         @QueryParam("fechaFin") String fechaFin,
                                                         @QueryParam("status") String status,
                                                         @QueryParam("pageIndex") int pageIndex,
                                                         @QueryParam("pageSize") int pageSize);

    @GET
    @Path("/orderSalesCountRankingPrice")
    @Produces({MediaType.APPLICATION_XML})
    String searchOrderSalesCountRankingPrice(@QueryParam("fechaInicio") String fechaInicio,
                                                      @QueryParam("fechaFin") String fechaFin,
                                                      @QueryParam("status") String status);

    @GET
    @Path("/sales/customersProduct/count")
    @Produces(MediaType.APPLICATION_XML)
    String countCustomerByProductsSold(@QueryParam("productId") Long productId);

    @GET
    @Path("/sales/customersProduct")
    @Produces(MediaType.APPLICATION_XML)
    List<Customer> getCustomersByProductsSold(@QueryParam("productId") Long productId,
                                              @QueryParam("pageIndex") int pageIndex,
                                              @QueryParam("pageSize") int pageSize);

    @GET
    @Path("/sales/customerRanking/count")
    @Produces(MediaType.APPLICATION_XML)
    String countCustomerRanking(@QueryParam("startDate") String startDate,
                                         @QueryParam("endDate") String endDate);

    @GET
    @Path("/sales/customerRanking")
    @Produces(MediaType.APPLICATION_XML)
    List<Customer> getCustomerRanking(@QueryParam("startDate") String startDate,
                                             @QueryParam("endDate") String endDate,
                                             @QueryParam("pageIndex") int pageIndex,
                                             @QueryParam("pageSize") int pageSize);
}
