package co.com.touresbalon.foundation.oms.usecases.ordersearch;

import co.com.touresbalon.foundation.oms.domain.orders.SalesOrder;
import co.com.touresbalon.foundation.oms.facades.OrdersFacade;
import co.com.touresbalon.foundation.oms.infrastructure.BeanLocator;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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
public class OrderRankingPriceModel extends LazyDataModel<SalesOrder> implements Serializable {

    private String status;
    private SalesOrder salesOrder;
    private Date dateStart;
    private Date dateFinal;

    private List<SalesOrder> listSalesOrder;

    public OrderRankingPriceModel() {
    }

    @Override
    public List<SalesOrder> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        OrdersFacade facade = BeanLocator.getBean(OrdersFacade.class);


        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String dateStartString = "";
        String dateFinalString = "";
        status = "CLOSED";
        if(dateStart!=null && dateFinal!=null) {
            dateStartString = formateador.format(dateStart);
            dateFinalString = formateador.format(dateFinal);
        }

        setRowCount(facade.searchOrderSalesCountRankingPrice(dateStartString, dateFinalString, status));
        listSalesOrder = facade.searchOrderSalesRankingPrice(dateStartString, dateFinalString,status, first, pageSize);
        return listSalesOrder;
    }

    @Override
    public SalesOrder getRowData(String rowKey) {
        for (SalesOrder o : listSalesOrder){
            if(o.getId().toString().equals(rowKey)){
                return o;
            }
        }
        return null;
    }


    public void cleanModel() {
        dateStart = null;
        dateFinal = null;
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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(Date dateFinal) {
        this.dateFinal = dateFinal;
    }
}
