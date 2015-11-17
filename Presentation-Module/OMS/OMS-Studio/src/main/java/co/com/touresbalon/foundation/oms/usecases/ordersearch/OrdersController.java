package co.com.touresbalon.foundation.oms.usecases.ordersearch;

import co.com.touresbalon.foundation.oms.domain.orders.OrderItem;
import co.com.touresbalon.foundation.oms.domain.orders.SalesOrder;
import co.com.touresbalon.foundation.oms.facades.OrdersFacade;
import org.primefaces.context.RequestContext;
import co.com.touresbalon.foundation.oms.util.FacesUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by nrodriguez on 02/11/2015.
 */
@Named
@RequestScoped
public class OrdersController {
    @Inject
    private FacesUtil util;

    @Inject
    private OrdersFacade ordersFacade;

    @Inject
    private OrdersModel ordersModel;

//[action] ------------------

    public void showSalesOrderDetail(SalesOrder salesOrder ) {
        try {
            ordersModel.setSalesOrder(ordersFacade.getSalesOrderDetail(salesOrder.getId()).get(0));

            System.out.println("que esta llegando a este ejb" + salesOrder.getId());


            System.out.println("que esta llegando a este ejb" + ordersModel.getSalesOrder().getId());

            ordersModel.setCacheOrderItem(ordersFacade.getOrderItems(salesOrder.getId()));

            for (OrderItem o : ordersModel.getCacheOrderItem()){
                System.out.println(" esto tiene la lista " + o.getProductId());
            }


        } catch (Exception e) {
            e.printStackTrace();
            util.addErrorMessage( "Ha ocurrido un error interno en la aplicación" );
        }
        RequestContext.getCurrentInstance().execute("PF('salesOrderDialog').show()");
    }

}
