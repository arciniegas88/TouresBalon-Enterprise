package co.com.touresbalon.foundation.oms.usecases.customeradmin;

import co.com.touresbalon.foundation.oms.domain.customers.AddressType;
import co.com.touresbalon.foundation.oms.domain.customers.CustomerType;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
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
    private boolean createDirection;
    private CustomerType customer;
    private AddressType address;
    private String cardType;
    private String newPassword;

    private List<SelectItem> cardTypes;
    private List<SelectItem> docTypes;
    private List<SelectItem> customerTypes;
    private List<SelectItem> customerStatus;
    private List<SelectItem> addressTypes;

    public AdminCustomerModel(){
        cleanModel();
        creationFlow = true;
        createDirection = false;
        address = new AddressType();
        customer = new CustomerType();

        cardTypes = new ArrayList<>();
        cardTypes.add(new SelectItem("0","--SELECT--"));
        cardTypes.add(new SelectItem("MAST","MASTER"));
        cardTypes.add(new SelectItem("VISA","VISA"));

        docTypes = new ArrayList<>();
        docTypes.add(new SelectItem("0","--SELECT--"));
        docTypes.add(new SelectItem("CC", "CC"));
        docTypes.add(new SelectItem("NIT","NIT"));
        docTypes.add(new SelectItem("PP","PP"));

        customerTypes = new ArrayList<>();
        customerTypes.add(new SelectItem("0","--SELECT--"));
        customerTypes.add(new SelectItem("SILVER","SILVER"));
        customerTypes.add(new SelectItem("GOLD","GOLD"));
        customerTypes.add(new SelectItem("PLATINUM","PLATINUM"));

        customerStatus = new ArrayList<>();
        customerStatus.add(new SelectItem("0","--SELECT--"));
        customerStatus.add(new SelectItem("1","ACTIVO"));
        customerStatus.add(new SelectItem("0","INACTIVO"));

        addressTypes = new ArrayList<>();
        addressTypes.add(new SelectItem("0", "--SELECT--"));
        addressTypes.add(new SelectItem("CASA", "CASA"));
        addressTypes.add(new SelectItem("APTO", "APARTAMENTO"));
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

    public List<SelectItem> getCardTypes() {
        return cardTypes;
    }

    public void setCardTypes(List<SelectItem> cardTypes) {
        this.cardTypes = cardTypes;
    }

    public List<SelectItem> getDocTypes() {
        return docTypes;
    }

    public void setDocTypes(List<SelectItem> docTypes) {
        this.docTypes = docTypes;
    }

    public List<SelectItem> getCustomerTypes() {
        return customerTypes;
    }

    public void setCustomerTypes(List<SelectItem> customerTypes) {
        this.customerTypes = customerTypes;
    }

    public List<SelectItem> getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(List<SelectItem> customerStatus) {
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

    public boolean isCreateDirection() {
        return createDirection;
    }

    public void setCreateDirection(boolean createDirection) {
        this.createDirection = createDirection;
    }

    public List<SelectItem> getAddressTypes() {
        return addressTypes;
    }

    public void setAddressTypes(List<SelectItem> addressTypes) {
        this.addressTypes = addressTypes;
    }
}
