package co.com.touresbalon.foundation.oms.facades;

import co.com.touresbalon.foundation.oms.domain.orderprocessing.CancelOrdersBPELRequest;
import co.com.touresbalon.foundation.oms.mqclient.OrdersMQClient;
import co.com.touresbalon.foundation.oms.webclient.OrdersWebClient;

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


    // ------------------------------

    public void cancelOrder(CancelOrdersBPELRequest request) throws SystemException {
        ordersMQ.cancelOrder(request);
    }


}
