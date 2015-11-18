package co.com.touresbalon.foundation.oms.domain.security;

/**
 * Created by garciniegas on 17/11/2015.
 */
public class RoleStore {

    private boolean adminProducts;
    private boolean adminRates;
    private boolean productSearch;
    private boolean adminCampigns;
    private boolean adminCustomer;
    private boolean customerSearch;
    private boolean orderSearch;
    private boolean orderCancel;

    public RoleStore() {
        adminProducts = false;
        adminRates = false;
        productSearch = false;
        adminCampigns = false;
        adminCustomer = false;
        customerSearch = false;
        orderSearch = false;
        orderCancel = false;
    }

    public boolean isAdminProducts() {
        return adminProducts;
    }

    public void setAdminProducts(boolean adminProducts) {
        this.adminProducts = adminProducts;
    }

    public boolean isAdminRates() {
        return adminRates;
    }

    public void setAdminRates(boolean adminRates) {
        this.adminRates = adminRates;
    }

    public boolean isProductSearch() {
        return productSearch;
    }

    public void setProductSearch(boolean productSearch) {
        this.productSearch = productSearch;
    }

    public boolean isAdminCampigns() {
        return adminCampigns;
    }

    public void setAdminCampigns(boolean adminCampigns) {
        this.adminCampigns = adminCampigns;
    }

    public boolean isAdminCustomer() {
        return adminCustomer;
    }

    public void setAdminCustomer(boolean adminCustomer) {
        this.adminCustomer = adminCustomer;
    }

    public boolean isCustomerSearch() {
        return customerSearch;
    }

    public void setCustomerSearch(boolean customerSearch) {
        this.customerSearch = customerSearch;
    }

    public boolean isOrderSearch() {
        return orderSearch;
    }

    public void setOrderSearch(boolean orderSearch) {
        this.orderSearch = orderSearch;
    }

    public boolean isOrderCancel() {
        return orderCancel;
    }

    public void setOrderCancel(boolean orderCancel) {
        this.orderCancel = orderCancel;
    }
}
