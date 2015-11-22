package co.com.touresbalon.foundation.orders.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by harcalejo on 21/11/15.
 */
@XmlRootElement
public class Customer implements Serializable{
    private String customerId;

    private String customerDocType;

    private long invoicedTotal;

    public Customer(){
        super();
    }

    public Customer(String customerId, String customerDocType){
        this.customerId = customerId;
        this.customerDocType = customerDocType;
    }

    public Customer(String customerId, String customerDocType, long invoicedTotal){
        this.customerId = customerId;
        this.customerDocType = customerDocType;
        this.invoicedTotal = invoicedTotal;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerDocType() {
        return customerDocType;
    }

    public void setCustomerDocType(String customerDocType) {
        this.customerDocType = customerDocType;
    }

    public long getInvoicedTotal() {
        return invoicedTotal;
    }

    public void setInvoicedTotal(long invoicedTotal) {
        this.invoicedTotal = invoicedTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != null ? !customerId.equals(customer.customerId) : customer.customerId != null) return false;
        return !(customerDocType != null ? !customerDocType.equals(customer.customerDocType) : customer.customerDocType != null);

    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (customerDocType != null ? customerDocType.hashCode() : 0);
        return result;
    }
}
