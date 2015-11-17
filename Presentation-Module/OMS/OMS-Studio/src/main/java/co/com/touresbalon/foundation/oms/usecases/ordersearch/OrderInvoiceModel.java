package co.com.touresbalon.foundation.oms.usecases.ordersearch;

import co.com.touresbalon.foundation.oms.domain.orders.SalesOrder;
import co.com.touresbalon.foundation.oms.facades.OrdersFacade;
import co.com.touresbalon.foundation.oms.infrastructure.BeanLocator;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
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

    private String status;
    private SalesOrder salesOrder;
    private int totalRegister;
    private Date dateOrder;

    private List<SalesOrder> listSalesOrderInvoice;


    @Override
    public List<SalesOrder> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        OrdersFacade facade = BeanLocator.getBean(OrdersFacade.class);
        setRowCount(facade.getTotalOrderStatus(status));


        System.out.println("la fecha type Date  seleccionada es :" + dateOrder);
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM");
        if(dateOrder!=null) {
            String fecha = formateador.format(dateOrder);
            System.out.println("la fecha type String  seleccionada es :" + fecha);
        }
        this.setTotalRegister(facade.getTotalOrderStatus(status));

        totalRegister = (facade.getTotalOrderStatus(status));
        System.out.println("cuantos registros son :" + totalRegister);
        listSalesOrderInvoice = facade.searchSalesOrdersStatus(status,first,pageSize);
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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public int getTotalRegister() {
        return totalRegister;
    }

    public void setTotalRegister(int totalRegister) {
        this.totalRegister = totalRegister;
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
}
