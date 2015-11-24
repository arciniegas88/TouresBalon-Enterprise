package co.com.touresbalon.foundation.oms.facades;

import co.com.touresbalon.foundation.oms.domain.customers.Customer;
import co.com.touresbalon.foundation.oms.domain.orderprocessing.CancelOrdersBPELRequest;
import co.com.touresbalon.foundation.oms.mqclient.OrdersMQClient;
import co.com.touresbalon.foundation.oms.webclient.OrdersWebClient;
import co.com.touresbalon.foundation.oms.domain.orders.OrderItem;
import co.com.touresbalon.foundation.oms.domain.orders.SalesOrder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.SystemException;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by garciniegas on 06/10/2015.
 */

@ApplicationScoped
public class OrdersFacade {

    //[fields] injected service client fields -----------------------

    @Inject
    private OrdersWebClient ordersWC;
    @Inject
    private OrdersMQClient ordersMQ;

    // ------------------------------

    public List<String> getRankingSoldProducts(Date startOrderDate, Date endOrderDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return ordersWC.getRankingSoldProducts(sdf.format(startOrderDate), sdf.format(endOrderDate)).getData();
    }

    public List<SalesOrder> getSalesOrderDetail(Long idSalesOrder){
        return ordersWC.getSalesOrderDetail(idSalesOrder);
    }


    // ------------------------------

    public void cancelOrder(CancelOrdersBPELRequest request) throws SystemException {
        ordersMQ.cancelOrder(request);
    }

    public List<SalesOrder> searchSalesOrders(String id,String productId,int pageIndex,int pageSize){
        return ordersWC.searchSalesOrders(id, productId, pageIndex, pageSize);
    }


    public int getTotalPagesBySalesOrdersSearch(String id,String productId){
        String total = ordersWC.getTotalPagesBySalesOrdersSearch(id, productId);
        return Integer.parseInt(total.replaceAll("<total>", "").replaceAll("</total>", ""));
    }

    public List<SalesOrder> searchSalesOrdersStatus(String status,int pageIndex,int pageSize){
        return ordersWC.searchSalesOrdersStatus(status, pageIndex, pageSize);
    }


    public int getTotalOrderStatus(String status) {
        String total = ordersWC.getTotalOrderStatus(status);
        return Integer.parseInt(total.replaceAll("<total>", "").replaceAll("</total>", ""));
    }

    public List<OrderItem> getOrderItems(Long idSalesOrder){
        return ordersWC.getOrderItems(idSalesOrder);
    }


    public List<SalesOrder> searchSalesOrdersInvoice(String fecha,int pageIndex,int pageSize){
        return ordersWC.searchSalesOrdersInvoce(fecha, pageIndex, pageSize);
    }

    public int searchOrderSalesCountInvoice(String fecha){
        String total = ordersWC.searchOrderSalesCountInvoice(fecha);
        return Integer.parseInt(total.replaceAll("<total>", "").replaceAll("</total>", ""));
    }

    public String searchOrderSalesTotalInvoice(String fecha){
        return ordersWC.searchOrderSalesTotalInvoice(fecha);
    }

    public List<SalesOrder> searchOrderSalesRankingStatus(String status,int pageIndex, int pageSize){
        return ordersWC.searchOrderSalesRankingStatus(status, pageIndex, pageSize);
    }

    public int searchOrderSalesCountRankingStatus(String status){
        String total = ordersWC.searchOrderSalesCountRankingStatus(status);

        total = total.replaceAll("<total>", "").replaceAll("</total>", "");
        return Integer.parseInt(total);
    }

    public List<SalesOrder> searchOrderSalesRankingPrice(String fechaInicio,String fechaFin,String status,int pageIndex, int pageSize) {
        return ordersWC.searchOrderSalesRankingPrice(fechaInicio, fechaFin,status, pageIndex, pageSize);
    }

    public int searchOrderSalesCountRankingPrice(String fechaInicio,String fechaFin,String status){
        String total = ordersWC.searchOrderSalesCountRankingPrice(fechaInicio, fechaFin, status);
        return Integer.parseInt(total.replaceAll("<total>", "").replaceAll("</total>", ""));
    }

    public int countCustomersByProduct(Long productId){
        String total = ordersWC.countCustomerByProductsSold(productId);
        total = total.replaceAll("<response><occurrences>", "").replaceAll("</occurrences></response>", "");

        return Integer.parseInt(total);
    }

    public List<Customer> getCustomerByProductSold(Long productId, int pageIndex, int pageSize){
        return ordersWC.getCustomersByProductsSold(productId, pageIndex, pageSize);
    }

    public int countCustomersRanking(String startDate, String endDate){
        String total = ordersWC.countCustomerRanking(startDate, endDate);
        total = total.replaceAll("<response><occurrences>", "").replaceAll("</occurrences></response>", "");

        return Integer.parseInt(total);
    }

    public List<Customer> getCustomersRanking(String startDate, String endDate, int pageIndex, int pageSize){
        return ordersWC.getCustomerRanking(startDate, endDate, pageIndex, pageSize);
    }

}
