package co.com.touresbalon.foundation.oms.usecases.customeradmin;

import co.com.touresbalon.foundation.oms.domain.customers.AddressType;
import co.com.touresbalon.foundation.oms.domain.customers.CustomerType;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by harcalejo on 18/11/15.
 */
@Named
@SessionScoped
public class AdminCustomerModel implements Serializable{

    private boolean creationFlow;
    private CustomerType customer;
    private AddressType address;
    private String cardType;
    private String newPassword;

    private List<String> cardTypes;
    private List<String> docTypes;
    private List<String> customerTypes;
    private List<String> customerStatus;

    public AdminCustomerModel(){
        cleanModel();
        creationFlow = true;
        address = new AddressType();
        customer = new CustomerType();

        cardTypes = new ArrayList<>();
        cardTypes.add("MASTER");
        cardTypes.add("VISA");

        docTypes = new ArrayList<>();
        docTypes.add("CC");
        docTypes.add("NIT");
        docTypes.add("PP");

        customerTypes = new ArrayList<>();
        customerTypes.add("PLATEADO");
        customerTypes.add("DORADO");
        customerTypes.add("PLATINO");

        customerStatus = new ArrayList<>();
        customerStatus.add("ACTIVO");
        customerStatus.add("INACTIVO");
    }

    public void cleanModel(){
        customer = new CustomerType();
    }

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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public List<String> getCardTypes() {
        return cardTypes;
    }

    public void setCardTypes(List<String> cardTypes) {
        this.cardTypes = cardTypes;
    }

    public List<String> getDocTypes() {
        return docTypes;
    }

    public void setDocTypes(List<String> docTypes) {
        this.docTypes = docTypes;
    }

    public List<String> getCustomerTypes() {
        return customerTypes;
    }

    public void setCustomerTypes(List<String> customerTypes) {
        this.customerTypes = customerTypes;
    }

    public List<String> getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(List<String> customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public AddressType getAddress() {
        return address;
    }

    public void setAddress(AddressType address) {
        this.address = address;
    }
}
