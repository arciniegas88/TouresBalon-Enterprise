package co.com.touresbalon.foundation.oms.usecases.customeradmin;

import co.com.touresbalon.foundation.oms.domain.customers.AddressType;
import co.com.touresbalon.foundation.oms.domain.customers.CreateCustomerResponseType;
import co.com.touresbalon.foundation.oms.domain.customers.CreateCustomerType;
import co.com.touresbalon.foundation.oms.domain.customers.CustomerType;
import co.com.touresbalon.foundation.oms.facades.CustomerFacade;
import co.com.touresbalon.foundation.oms.infrastructure.BeanLocator;
import co.com.touresbalon.foundation.oms.util.FacesUtil;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by harcalejo on 18/11/15.
 */
@Named
@RequestScoped
public class AdminCustomerContoller implements Serializable {

    @Inject
    private AdminCustomerModel model;

    @Inject
    private FacesUtil util;

    public void showDirectionDetail() {
        model.setCreateDirection(true);

        model.setAddress(new AddressType());

        RequestContext.getCurrentInstance().execute("PF('directionDialog').show()");
    }

    public void createCustomer() {
        boolean customerOK = true;

        CustomerType customer = model.getCustomer();
        CreateCustomerType request = new CreateCustomerType(customer);

        if (customer.getDocType().compareTo("0") == 0) {
            util.addErrorMessage("Debe seleccionar un tipo de documento");
            customerOK = false;
        }

        if (customer.getId() == null || customer.getId().compareTo("") == 0) {
            util.addErrorMessage("El Id del cliente no ha sido ingresado");
            customerOK = false;
        }

        if (customer.getFirstName() == null || customer.getFirstName().compareTo("") == 0) {
            util.addErrorMessage("El nombre del cliente no ha sido ingresado");
            customerOK = false;
        }

        if (customer.getLastName() == null || customer.getLastName().compareTo("") == 0) {
            util.addErrorMessage("El apellido del cliente no ha sido ingresado");
            customerOK = false;
        }

        if (customer.getCreditcardType().compareTo("0") == 0) {
            util.addErrorMessage("Debe seleccionar un tipo de tarjeta");
            customerOK = false;
        }

        if (customer.getCreditcardNumber() == null || customer.getCreditcardNumber().compareTo("") == 0) {
            util.addErrorMessage("El número de tarjeta del cliente no ha sido ingresado");
            customerOK = false;
        }

        if (customer.getEmail() == null || customer.getEmail().compareTo("") == 0) {
            util.addErrorMessage("El correo del cliente no ha sido ingresado");
            customerOK = false;
        }

        if (customer.getPhoneNumber() == null || customer.getPhoneNumber().compareTo("") == 0) {
            util.addErrorMessage("El teléfono del cliente no ha sido ingresado");
            customerOK = false;
        }

        if (customer.getStatus().compareTo("0") == 0) {
            util.addErrorMessage("Debe seleccionar un el estado del cliente");
            customerOK = false;
        }

        if (customer.getPassword() == null || customer.getPassword().compareTo("") == 0) {
            util.addErrorMessage("El password del cliente no ha sido ingresado");
            customerOK = false;
        } else if (customer.getPassword().compareTo(model.getNewPassword()) != 0) {
            util.addErrorMessage("Los dos password deben ser iguales");
            customerOK = false;
        }

        if(customerOK){
            CustomerFacade facade = BeanLocator.getBean(CustomerFacade.class);

            CreateCustomerResponseType response = facade.createCustomer(request);

            if (response.getCreateCustomerResult().getStatus().compareTo("OK") == 0) {
                util.addInfoMessage("Cliente creado de forma exitosa");
                this.cleanForm();
            } else {
                util.addErrorMessage(response.getCreateCustomerResult().getMessage());
            }
        }else{
            util.addErrorMessage("No se ha podido crear el cliente");
        }
    }

    public void createDirection() {
        boolean addressOk = true;

        AddressType address = model.getAddress();

        if (address.getAddressType().compareTo("0") == 0) {
            util.addErrorMessage("El tipo de dirección no ha sido ingresada");
            addressOk = false;
        }

        if (address.getCity() == null || address.getCity().compareTo("") == 0) {
            util.addErrorMessage("La ciudad no ha sido ingresada");
            addressOk = false;
        }

        if (address.getCountry() == null || address.getCountry().compareTo("") == 0) {
            util.addErrorMessage("El país no ha sido ingresado");
            addressOk = false;
        }

        if (address.getState() == null || address.getState().compareTo("") == 0) {
            util.addErrorMessage("El estado no ha sido ingresado");
            addressOk = false;
        }

        if (address.getStreet() == null || address.getStreet().compareTo("") == 0) {
            util.addErrorMessage("La dirección no ha sido ingresada");
            addressOk = false;
        }

        if (address.getZip() == null || address.getZip().compareTo("") == 0) {
            util.addErrorMessage("El código zip no ha sido ingresado");
            addressOk = false;
        }

        if (addressOk) {
            model.getCustomer().getAddress().getAddress().add(address);

            util.addInfoMessage("La dirección se ha creado con éxito");
            model.setAddress(new AddressType());
        }

        model.setCreateDirection(false);
        RequestContext.getCurrentInstance().execute("PF('directionDialog').hide()");
    }

    public void updateCustomer() {

    }

    public void cleanForm() {
        model.setAddress(new AddressType());
        model.setCustomer(new CustomerType());
    }
}
