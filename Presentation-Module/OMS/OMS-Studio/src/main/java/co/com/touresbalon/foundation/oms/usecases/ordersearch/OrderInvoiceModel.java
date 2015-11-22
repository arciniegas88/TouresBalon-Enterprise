package co.com.touresbalon.foundation.oms.usecases.ordersearch;

import co.com.touresbalon.foundation.oms.domain.orders.SalesOrder;
import co.com.touresbalon.foundation.oms.facades.OrdersFacade;
import co.com.touresbalon.foundation.oms.infrastructure.BeanLocator;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Usuario on 16/11/2015.
 */
@Named
@SessionScoped
public class OrderInvoiceModel extends LazyDataModel<SalesOrder> implements Serializable {

    private SalesOrder salesOrder;
    private Date dateOrder;
    private String totalFacturado;
    private List<SalesOrder> listSalesOrderInvoice;

    public OrderInvoiceModel() {
        OrdersFacade facade = BeanLocator.getBean(OrdersFacade.class);
        DecimalFormat df = new DecimalFormat("###,###,###");
        this.setTotalFacturado(df.format(new BigDecimal(facade.searchOrderSalesTotalInvoice(""))));
    }


    @Override
    public List<SalesOrder> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        OrdersFacade facade = BeanLocator.getBean(OrdersFacade.class);
        System.out.println("la fecha type Date  seleccionada es :" + dateOrder);
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM");
        String dateString = "";
        if(dateOrder!=null) {
            dateString = formateador.format(dateOrder);
            System.out.println("la fecha type String  seleccionada es :" + dateString);
        }
        setRowCount(facade.searchOrderSalesCountInvoice(dateString));

        totalFacturado = facade.searchOrderSalesTotalInvoice(dateString);
        System.out.println("total facturado: " + totalFacturado);
        listSalesOrderInvoice = facade.searchSalesOrdersInvoice(dateString,first,pageSize);
        return listSalesOrderInvoice;
    }

    @Override
    public SalesOrder getRowData(String rowKey) {
        for (SalesOrder o : listSalesOrderInvoice){
            if(o.getId().toString().equals(rowKey)){
                return o;
            }
        }
        return null;
    }


    public void cleanModel() {
        dateOrder = null;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public List<SalesOrder> getListSalesOrderInvoice() {
        return listSalesOrderInvoice;
    }

    public void setListSalesOrderInvoice(List<SalesOrder> listSalesOrderInvoice) {
        this.listSalesOrderInvoice = listSalesOrderInvoice;
    }

    public String getTotalFacturado() {
        return totalFacturado;
    }

    public void setTotalFacturado(String totalFacturado) {
        this.totalFacturado = totalFacturado;
    }
}
