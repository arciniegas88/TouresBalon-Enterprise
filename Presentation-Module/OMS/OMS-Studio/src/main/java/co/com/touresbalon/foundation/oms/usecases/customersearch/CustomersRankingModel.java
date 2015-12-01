package co.com.touresbalon.foundation.oms.usecases.customersearch;

import co.com.touresbalon.foundation.oms.domain.customers.Customer;
import co.com.touresbalon.foundation.oms.facades.OrdersFacade;
import co.com.touresbalon.foundation.oms.infrastructure.BeanLocator;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by harcalejo on 23/11/15.
 */
@Named
@SessionScoped
public class CustomersRankingModel extends LazyDataModel<Customer> {

    private Date startDate;
    private Date endDate;

    private Customer customer;
    private List<Customer> customersCache;

    public CustomersRankingModel(){
        startDate = new Date();
        endDate = new Date();
    }


    @Override
    public List<Customer> load(int firts, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String startD = "";
        String endD = "";

        if(startDate != null && endDate != null){
            startD = sdf.format(startDate);
            endD = sdf.format(endDate);
        }

        OrdersFacade facade = BeanLocator.getBean(OrdersFacade.class);
        setRowCount(facade.countCustomersRanking(startD, endD));

        customersCache = facade.getCustomersRanking(startD, endD, firts, pageSize);
        return customersCache;

    }

    @Override
    public Customer getRowData(String rowKey){
        for (Customer c : customersCache){
            if (c.getCustomerId().toString().equals(rowKey)) {
                return c;
            }
        }

        return null;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomersCache() {
        return customersCache;
    }

    public void setCustomersCache(List<Customer> customersCache) {
        this.customersCache = customersCache;
    }
}
