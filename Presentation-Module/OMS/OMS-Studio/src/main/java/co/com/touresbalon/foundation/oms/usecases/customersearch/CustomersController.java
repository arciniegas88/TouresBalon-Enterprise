package co.com.touresbalon.foundation.oms.usecases.customersearch;

import co.com.touresbalon.foundation.oms.domain.customers.Customer;
import co.com.touresbalon.foundation.oms.domain.customers.CustomerType;
import co.com.touresbalon.foundation.oms.facades.CustomerFacade;
import co.com.touresbalon.foundation.oms.usecases.customeradmin.AdminCustomerModel;
import co.com.touresbalon.foundation.oms.usecases.portal.PortalController;
import co.com.touresbalon.foundation.oms.util.FacesUtil;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by harcalejo on 4/11/15.
 */
@Named
@RequestScoped
public class CustomersController implements Serializable{

    @Inject
    private AdminCustomerModel adminCustomerModel;
    @Inject
    private CustomersModel customerModel;
    @Inject
    private CustomersProductModel productModel;
    @Inject
    private CustomersRankingModel rankingModel;
    @Inject
    private FacesUtil util;
    @Inject
    private CustomerFacade facade;

    public void showCustomerDetail(String customerId){
        customerModel.setCustomer(facade.getCustomerById(customerId).getGetCustomerResult());
        RequestContext.getCurrentInstance().execute("PF('customerDialog').show()");
    }

    public void updateCustomerDetail(CustomerType customer){
        adminCustomerModel.setCreationFlow(false);
        adminCustomerModel.cleanModel();
        adminCustomerModel.setCustomer(facade.getCustomerById(customer.getId()).getGetCustomerResult());

        RequestContext.getCurrentInstance().execute( "window.location.href='"+ PortalController.CUSTOMER_ADMIN_PAGE+"';" );
    }

    public void deleteCustomer(CustomerType customer){
        facade.deleteCustomer(customer.getId());
        util.addInfoMessage("El cliente se ha desactivado de forma exitosa");
    }

    public void cleanFormCustomersProduct(){
        productModel.setProductId(new Long(0));
    }

    public void cleanFormCustomerRanking(){
        rankingModel.setEndDate(new Date());
        rankingModel.setEndDate(new Date());
    }

    public void cleanFormCustomer(){
        customerModel.setId("");
        customerModel.setEmail("");
    }
}
