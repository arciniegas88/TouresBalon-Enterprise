package co.com.touresbalon.foundation.oms.usecases.portal;

import co.com.touresbalon.foundation.oms.facades.ProductsFacade;
import co.com.touresbalon.foundation.oms.usecases.products.ProductsModel;
import co.com.touresbalon.foundation.oms.util.FacesUtil;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by garciniegas on 05/10/2015.
 */

@Named
@RequestScoped
public class PortalController {

    private static final String PRODUCT_SEARCH_PAGE = "/OMS-Studio/content/products/productSearch.xhtml";

    @Inject
    private FacesUtil util;
    @Inject
    private ProductsModel productModel;
    @Inject
    private ProductsFacade productFacade;

    public void searchProductsAction() {
        RequestContext.getCurrentInstance().execute( "window.location.href='"+PRODUCT_SEARCH_PAGE+"';" );
    }

}
