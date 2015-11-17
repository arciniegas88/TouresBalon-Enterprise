package co.com.touresbalon.foundation.oms.facades;

import co.com.touresbalon.foundation.oms.domain.orderprocessing.CancelOrdersBPELRequest;
import co.com.touresbalon.foundation.oms.mqclient.OrdersMQClient;
import co.com.touresbalon.foundation.oms.webclient.OrdersWebClient;
import co.com.touresbalon.foundation.oms.domain.orders.OrderItem;
import co.com.touresbalon.foundation.oms.domain.orders.SalesOrder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.SystemException;
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

}
