package co.com.touresbalon.foundation.oms.usecases.customersearch;

import co.com.touresbalon.foundation.oms.domain.customers.CustomerType;
import co.com.touresbalon.foundation.oms.facades.CustomerFacade;
import co.com.touresbalon.foundation.oms.util.FacesUtil;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by harcalejo on 4/11/15.
 */
@Named
@RequestScoped
public class CustomersController implements Serializable{

    @Inject
    private CustomersModel model;
    @Inject
    private FacesUtil util;
    @Inject
    private CustomerFacade facade;

    public void showCustomerDetail(CustomerType customer){
        model.setCustomer(facade.getCustomerById(customer.getId()).getGetCustomerResult());
        RequestContext.getCurrentInstance().execute("PF('customerDialog').show()");
    }


    public void updateCustomerDetail(CustomerType customer){

    }

    public void deleteCustomer(CustomerType customer){
        facade.deleteCustomer(customer.getId());
        util.addInfoMessage("El cliente se ha desactivado de forma exitosa");
    }
}
