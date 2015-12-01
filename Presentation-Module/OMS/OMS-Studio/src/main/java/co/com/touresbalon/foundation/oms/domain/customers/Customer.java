package co.com.touresbalon.foundation.oms.domain.customers;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by harcalejo on 21/11/15.
 */
@XmlRootElement
public class Customer implements Serializable{
    private String customerId;

    private String customerDocType;

    private String productName;

    private long price;

    private Date orderDate;

    private long invoicedTotal;

    public Customer(){
        super();
    }

    public Customer(String customerId, String customerDocType, String productName, long price, Date orderDate){
        this.customerId = customerId;
        this.customerDocType = customerDocType;
        this.productName = productName;
        this.price = price;
        this.orderDate = orderDate;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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
