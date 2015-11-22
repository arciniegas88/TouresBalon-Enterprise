package co.com.touresbalon.foundation.oms.usecases.customeradmin;
import co.com.touresbalon.foundation.oms.domain.customers.AddressType;
import co.com.touresbalon.foundation.oms.domain.customers.CustomerType;
import co.com.touresbalon.foundation.oms.exceptions.SystemException;
import co.com.touresbalon.foundation.oms.util.FacesUtil;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by harcalejo on 18/11/15.
 */
@Named
@SessionScoped
public class AdminCustomerContoller implements Serializable{

    @Inject
    private AdminCustomerModel model;

    @Inject
    private FacesUtil util;

    public void showDirectionDetail(){
        model.setAddress(new AddressType());

        RequestContext.getCurrentInstance().execute("PF('directionDialog').show()");
    }

    public void createCustomer(){
        CustomerType customer = model.getCustomer();
    }

    public void createDirection(){
        boolean addressOk = true;

        AddressType address = model.getAddress();

        if(address.getAddressType() == null){
            util.addErrorMessage("El tipo de dirección no ha sido ingresada");
            addressOk =false;
        }

        if(address.getCity() == null){
            util.addErrorMessage("La ciudad no ha sido ingresada");
            addressOk =false;
        }

        if(address.getCountry() == null){
            util.addErrorMessage("El país no ha sido ingresado");
            addressOk =false;
        }

        if(address.getState() == null){
            util.addErrorMessage("El estado no ha sido ingresado");
            addressOk =false;
        }

        if(address.getStreet() == null){
            util.addErrorMessage("La dirección no ha sido ingresada");
            addressOk =false;
        }

        if(address.getZip() == null){
            util.addErrorMessage("El código zip no ha sido ingresado");
            addressOk =false;
        }

        if(addressOk){
            model.getCustomer().getAddress().getAddress().add(address);

            util.addInfoMessage("La dirección se ha creado con éxito");
            model.setAddress(new AddressType());
        }

        RequestContext.getCurrentInstance().execute("PF('directionDialog').hide()");
    }

    public void cleanForm(){

    }
}
