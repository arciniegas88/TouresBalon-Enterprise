package co.com.touresbalon.foundation.oms.usecases.customersearch;

import co.com.touresbalon.foundation.oms.domain.customers.CustomerType;
import co.com.touresbalon.foundation.oms.facades.CustomerFacade;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by harcalejo on 4/11/15.
 */
@Named
@SessionScoped
public class CustomersController implements Serializable{

    @Inject
    private CustomersModel model;

    @Inject
    private CustomerFacade facade;

    public void showCustomerDetail(CustomerType customer){
        model.setCustomer(facade.getCustomerById(customer.getId()).getGetCustomerResult());
        RequestContext.getCurrentInstance().execute("PF('customerDialog').show()");
    }

    public void updateCustomerDetail(CustomerType customer){

    }

    public void deleteCustomer(CustomerType customer){

    }
}
