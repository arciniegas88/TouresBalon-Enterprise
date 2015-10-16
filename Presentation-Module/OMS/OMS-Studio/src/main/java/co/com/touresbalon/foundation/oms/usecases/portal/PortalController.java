package co.com.touresbalon.foundation.oms.usecases.portal;

import co.com.touresbalon.foundation.oms.domain.products.City;
import co.com.touresbalon.foundation.oms.facades.ProductsFacade;
import co.com.touresbalon.foundation.oms.usecases.productadmin.AdminProductsModel;
import co.com.touresbalon.foundation.oms.usecases.productssearch.ProductsModel;
import co.com.touresbalon.foundation.oms.util.FacesUtil;
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

    public static final String PRODUCT_SEARCH_PAGE = "/OMS-Studio/content/products/productSearch.xhtml";
    public static final String PRODUCTS_ADMIN_PAGE = "/OMS-Studio/content/productsAdmin/productAdmin.xhtml";

    @Inject
    private FacesUtil util;
    @Inject
    private ProductsModel productModel;
    @Inject
    private AdminProductsModel adminProductsModel;
    @Inject
    private ProductsFacade productFacade;

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
        adminProductsModel.setSpectacles( productFacade.getSpectacles() );

        RequestContext.getCurrentInstance().execute( "window.location.href='"+PRODUCTS_ADMIN_PAGE+"';" );
    }

}
