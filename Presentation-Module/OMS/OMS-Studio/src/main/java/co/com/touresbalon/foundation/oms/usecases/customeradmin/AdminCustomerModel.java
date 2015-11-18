package co.com.touresbalon.foundation.oms.usecases.customeradmin;

import co.com.touresbalon.foundation.oms.domain.customers.CustomerType;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by harcalejo on 18/11/15.
 */
@Named
@SessionScoped
public class AdminCustomerModel implements Serializable{

    private boolean creationFlow;
    private CustomerType customer;

    public CustomerType getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerType customer) {
        this.customer = customer;
    }

    public boolean isCreationFlow() {
        return creationFlow;
    }

    public void setCreationFlow(boolean creationFlow) {
        this.creationFlow = creationFlow;
    }




}
