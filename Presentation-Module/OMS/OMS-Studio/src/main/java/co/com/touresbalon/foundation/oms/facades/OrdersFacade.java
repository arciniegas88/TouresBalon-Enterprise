package co.com.touresbalon.foundation.oms.facades;

import co.com.touresbalon.foundation.oms.webclient.OrdersWebClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by garciniegas on 06/10/2015.
 */

@ApplicationScoped
public class OrdersFacade {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    //[fields] injected service client fields -----------------------

    @Inject
    private OrdersWebClient ordersWC;

    
    // ------------------------------

    public List<String> getRankingSoldProducts( Date startOrderDate, Date endOrderDate ){
        return ordersWC.getRankingSoldProducts( sdf.format(startOrderDate),sdf.format(endOrderDate)).getData();
    }

}
