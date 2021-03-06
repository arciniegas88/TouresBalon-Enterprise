package co.com.touresbalon.foundation.oms.facades;

import co.com.touresbalon.foundation.oms.domain.customers.*;
import co.com.touresbalon.foundation.oms.webclient.CustomerWebClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by harcalejo on 4/11/15.
 */

@ApplicationScoped
public class CustomerFacade implements Serializable {

    @Inject
    private CustomerWebClient customerWC;

    public int getTotalPagesByCustomers(String id, String email) {
        CountCustomersResponseType response = customerWC.getCustomerCount(id, email);
        return response.getCountCustomersResult();
    }

    public List<CustomerType> getCustomers(String id, String email, int pageIndex, int pageSize) {
        List<CustomerType> customers = customerWC.getCustomers(pageIndex, pageSize, id, email)
                .getGetCustomersResult().getCustomer();
        return customers;
    }

    public CreateCustomerResponseType createCustomer(CreateCustomerType customer) {
        return customerWC.createCustomer(customer);
    }


    public CustomerResponseType getCustomerById(String id) {
        return customerWC.getCustomerById(id);
    }

    public void deleteCustomer(String id) {
        customerWC.delete(id);
    }

}
