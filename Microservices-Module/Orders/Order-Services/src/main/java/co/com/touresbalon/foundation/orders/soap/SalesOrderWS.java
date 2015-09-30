package co.com.touresbalon.foundation.orders.soap;

import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import co.com.touresbalon.foundation.orders.boundary.SalesOrdersBoundary;
import co.com.touresbalon.foundation.orders.entity.OrderItem;
import co.com.touresbalon.foundation.orders.entity.SalesOrder;

import javax.inject.Inject;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by garciniegas on 28/09/2015.
 */

@WebService(targetNamespace = "http://touresbalon.com.co/salesorder/service/task/1.0.0")
public class SalesOrderWS {

    @Inject
    private SalesOrdersBoundary boundary;

    @Oneway
    @WebMethod(operationName = "changeSalesOrderStatus",action = "changeSalesOrderStatus")
    public void changeSalesOrderStatus( @WebParam(name = "order") SalesOrder so ){
        boundary.changeSalesOrderStatus( so );
    }

    @WebMethod(operationName = "createSalesOrder",action = "createSalesOrder")
    public Long createSalesOrder( @WebParam(name = "order") SalesOrder so, @WebParam(name = "items") List<OrderItem> ois)throws SystemException {
        return boundary.createSalesOrder(so,ois);
    }

    @Oneway
    @WebMethod(operationName = "updateItem",action = "updateItem")
    public void updateItem( @WebParam(name = "item") OrderItem oi ){
        boundary.updateItem(oi);
    }

    @Oneway
    @WebMethod(operationName = "changeItemStatus",action = "changeItemStatus")
    public void changeItemStatus( @WebParam(name = "item") OrderItem oi ){
        boundary.updateItem(oi);
    }

}