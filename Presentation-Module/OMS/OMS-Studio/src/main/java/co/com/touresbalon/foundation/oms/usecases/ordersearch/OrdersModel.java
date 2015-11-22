package co.com.touresbalon.foundation.oms.usecases.ordersearch;


import co.com.touresbalon.foundation.oms.domain.orders.OrderItem;
import co.com.touresbalon.foundation.oms.domain.orders.SalesOrder;
import co.com.touresbalon.foundation.oms.facades.OrdersFacade;
import co.com.touresbalon.foundation.oms.infrastructure.BeanLocator;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by nrodriguez on 01/11/2015.
 */
@Named
@SessionScoped
public class OrdersModel  extends LazyDataModel<SalesOrder> implements Serializable {

    private String id;
    private String productId;
    private String status;
    private SalesOrder salesOrder;

    private List<SalesOrder> cacheOrder;
    private List<OrderItem> cacheOrderItem;


    public void cleanModel() {
        id = null;
        productId =null;
        status = null;
    }


    @Override
    public List<SalesOrder> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        OrdersFacade facade = BeanLocator.getBean(OrdersFacade.class);
        setRowCount(facade.getTotalPagesBySalesOrdersSearch(id, productId));
        cacheOrder = facade.searchSalesOrders(id,productId,first,pageSize);
        return cacheOrder;
    }

    @Override
    public SalesOrder getRowData(String rowKey) {
        for (SalesOrder o : cacheOrder){
            if(o.getId().toString().equals(rowKey)){
                return o;
            }
        }
        return null;
    }

    public List<SalesOrder> getCacheOrder() {return cacheOrder;}

    public void setCacheOrder(List<SalesOrder> cacheOrder) {this.cacheOrder = cacheOrder;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getProductId() {return productId;}

    public void setProductId(String productId) {this.productId = productId;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}


    public SalesOrder getSalesOrder() {return salesOrder;}

    public void setSalesOrder(SalesOrder salesOrder) {this.salesOrder = salesOrder;}


    public List<OrderItem> getCacheOrderItem() {
        return cacheOrderItem;
    }

    public void setCacheOrderItem(List<OrderItem> cacheOrderItem) {
        this.cacheOrderItem = cacheOrderItem;
    }
}
