package co.com.touresbalon.foundation.oms.usecases.ordersearch;

import co.com.touresbalon.foundation.oms.domain.orders.OrderItem;
import co.com.touresbalon.foundation.oms.domain.orders.SalesOrder;
import co.com.touresbalon.foundation.oms.facades.OrdersFacade;
import org.primefaces.context.RequestContext;
import co.com.touresbalon.foundation.oms.util.FacesUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Inject
    private OrderStatusModel ordersStatusModel;

    @Inject
    private OrderInvoiceModel orderInvoiceModel;

    @Inject
    private OrderRankingPriceModel orderRankingPriceModel;

    @Inject
    private OrderRankingStatusModel orderRankingStatusModel;

    //[action] ------------------
    public void showSalesOrderDetail(SalesOrder salesOrder) {
        try {

            System.out.println("no esta ingresando a la busqueda de ordenes");

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


    public void updateValueTotal(){
        ordersStatusModel.setTotalRegister(ordersFacade.getTotalOrderStatus(ordersStatusModel.getStatus()));
    }

    public void updateValueTotalPrice(){
        System.out.println("la fecha type Date  seleccionada es :" + orderInvoiceModel.getDateOrder());
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM");
        String dateString = "";
        if(orderInvoiceModel.getDateOrder()!=null) {
            dateString = formateador.format(orderInvoiceModel.getDateOrder());
            System.out.println("la fecha type String  seleccionada es :" + dateString);
        }
        DecimalFormat df = new DecimalFormat("###,###,###");
        String total = ordersFacade.searchOrderSalesTotalInvoice(dateString);
        orderInvoiceModel.setTotalFacturado(df.format(new BigDecimal(total)));
    }


    //[action] ------------------
    public void cleanFormAction() {
        ordersModel.cleanModel();
    }


    //[action] ------------------
    public void cleanFormStatusAction() {
        ordersStatusModel.cleanStatusModel();
    }

    //[action] ------------------
    public void cleanFormInvoiceAction() {
        orderInvoiceModel.cleanModel();
    }

    public void cleanOrderRankingPriceModel(){
        orderRankingPriceModel.cleanModel();
    }

    public void cleanOrderRankingStatusModel(){
        orderRankingStatusModel.cleanModel();
    }
}

