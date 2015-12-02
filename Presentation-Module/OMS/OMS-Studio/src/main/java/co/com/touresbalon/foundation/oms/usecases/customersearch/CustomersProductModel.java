package co.com.touresbalon.foundation.oms.usecases.customersearch;

import co.com.touresbalon.foundation.oms.domain.customers.Customer;
import co.com.touresbalon.foundation.oms.facades.OrdersFacade;
import co.com.touresbalon.foundation.oms.infrastructure.BeanLocator;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.WebApplicationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by harcalejo on 23/11/15.
 */
@Named
@SessionScoped
public class CustomersProductModel extends LazyDataModel<Customer> {

    private Long productId;

    private Customer customer;
    private List<Customer> cacheCustomers;

    @Override
    public List<Customer> load(int firts, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        OrdersFacade facade = BeanLocator.getBean(OrdersFacade.class);

        try {
            setRowCount(facade.countCustomersByProduct(productId));
            cacheCustomers = facade.getCustomerByProductSold(productId, firts, pageSize);
        }catch(WebApplicationException e){
            setRowCount(0);
            cacheCustomers = new ArrayList<>();
        }
        return cacheCustomers;
    }

    @Override
    public Customer getRowData(String rowKey) {
        for (Customer c : cacheCustomers) {
            if (c.getCustomerId().toString().equals(rowKey)) {
                return c;
            }
        }

        return null;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
