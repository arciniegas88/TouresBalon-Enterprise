package co.com.touresbalon.foundation.oms.usecases.customersearch;

import co.com.touresbalon.foundation.oms.domain.customers.CustomerType;
import co.com.touresbalon.foundation.oms.facades.CustomerFacade;
import co.com.touresbalon.foundation.oms.infrastructure.BeanLocator;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.WebApplicationException;
import javax.xml.ws.WebServiceException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by harcalejo on 4/11/15.
 */
@Named
@SessionScoped
public class CustomersModel extends LazyDataModel<CustomerType>{

    private String id;
    private String email;

    private CustomerType customer;
    private List<CustomerType> cacheCustomers;

    public CustomersModel(){
        id="";
        email="";
    }

    @Override
    public  List<CustomerType> load(int firts, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters){
        CustomerFacade facade = BeanLocator.getBean(CustomerFacade.class);

        try {
            setRowCount(facade.getTotalPagesByCustomers(id, email));
            cacheCustomers = facade.getCustomers(id, email, firts, pageSize);
        }catch(WebApplicationException e){
            setRowCount(0);
            cacheCustomers = new ArrayList<>();


        }
        return cacheCustomers;
    }

    @Override
    public CustomerType getRowData(String rowKey) {

        for (CustomerType c : cacheCustomers) {
            if (c.getId().toString().equals(rowKey))
                return c;
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerType getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerType customer) {
        this.customer = customer;
    }
}
