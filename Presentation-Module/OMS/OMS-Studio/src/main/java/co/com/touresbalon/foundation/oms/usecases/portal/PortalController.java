package co.com.touresbalon.foundation.oms.usecases.portal;

import co.com.touresbalon.foundation.oms.domain.products.City;
import co.com.touresbalon.foundation.oms.facades.ProductsFacade;
import co.com.touresbalon.foundation.oms.usecases.customersearch.CustomersModel;
import co.com.touresbalon.foundation.oms.usecases.productadmin.AdminProductsModel;
import co.com.touresbalon.foundation.oms.usecases.productssearch.ProductsModel;
import co.com.touresbalon.foundation.oms.usecases.ratesadmin.RatesModel;
import co.com.touresbalon.foundation.oms.util.FacesUtil;
import co.com.touresbalon.foundation.oms.usecases.ordersearch.OrdersModel;
import co.com.touresbalon.foundation.oms.facades.OrdersFacade;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by garciniegas on 05/10/2015.
 */

@Named
@RequestScoped
public class PortalController {

    public static final String RATES_ADMIN_PAGE    = "/OMS-Studio/content/rates/ratesAdmin.xhtml";
    public static final String PRODUCT_SEARCH_PAGE = "/OMS-Studio/content/products/productSearch.xhtml";
    public static final String PRODUCTS_ADMIN_PAGE = "/OMS-Studio/content/productsAdmin/productAdmin.xhtml";
    private static final String CUSTOMER_SEARCH_PAGE = "/OMS-Studio/content/customers/customerSearch.xhtml";
    private static final String CUSTOMER_ADMIN_PAGE = "/OMS-Studio/content/customersAdmin/customerAdmin.xhtml";
    public static final String ORDERS_ADMIN_PAGE = "/OMS-Studio/content/orders/ordersSearch.xhtml";
    public static final String CAMPAIGN_ADMIN_PAGE = "/OMS-Studio/content/campaignAdmin/campaignAdmin.xhtml";

    @Inject
    private FacesUtil util;
    @Inject
    private ProductsModel productModel;
    @Inject
    private CustomersModel customersModel;
    @Inject
    private RatesModel ratesModel;
    @Inject
    private AdminProductsModel adminProductsModel;
    @Inject
    private ProductsFacade productFacade;
    @Inject
    private OrdersFacade orderFacade;
    @Inject
    private OrdersModel ordersModel;

    public void ratessAdminAction() {

        ratesModel.setTransports( productFacade.getTransports() );
        ratesModel.setLodgings( productFacade.getLodging() );
        ratesModel.setSpectacles( productFacade.getSpectacles() );

        RequestContext.getCurrentInstance().execute( "window.location.href='"+RATES_ADMIN_PAGE+"';" );
    }


    public void searchProductsAction() {
        productModel.cleanModel();
        RequestContext.getCurrentInstance().execute("window.location.href='" + PRODUCT_SEARCH_PAGE + "';");
    }

    public void productsAdminAction() {

        adminProductsModel.setCreationFlow( true );
        adminProductsModel.cleanModel();
        adminProductsModel.setCountries(productFacade.getCountries());
        List<City> cityList = productFacade.getCitiesByContry( adminProductsModel.getCountries().get(0).getId() );
        adminProductsModel.setSourceCities(cityList);
        adminProductsModel.setTargetCities(cityList);
        adminProductsModel.setTransports( productFacade.getTransports() );
        adminProductsModel.setLodgings( productFacade.getLodging() );
        adminProductsModel.setSpectacles(productFacade.getSpectacles());

        RequestContext.getCurrentInstance().execute( "window.location.href='"+PRODUCTS_ADMIN_PAGE+"';" );
    }

    public void searchCustomerAction(){
        productModel.cleanModel();
        RequestContext.getCurrentInstance().execute("window.location.href='" + CUSTOMER_SEARCH_PAGE + "';");
    }


    public void searchOrdersAction() {
        ordersModel.cleanModel();
        RequestContext.getCurrentInstance().execute("window.location.href='" + ORDERS_ADMIN_PAGE + "';");
    }

    public void customersAdminAction(){
        adminProductsModel.setCreationFlow(true);
        RequestContext.getCurrentInstance().execute("window.location.href='" + CUSTOMER_ADMIN_PAGE + "';");
    }

}
