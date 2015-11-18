package co.com.touresbalon.foundation.oms.usecases.campaingnadmin;

import co.com.touresbalon.foundation.oms.domain.products.Campaign;
import co.com.touresbalon.foundation.oms.facades.ProductsFacade;
import co.com.touresbalon.foundation.oms.usecases.productadmin.AdminProductsModel;
import co.com.touresbalon.foundation.oms.util.FacesUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Jenny on 16/11/2015.
 */

@Named
@RequestScoped
public class AdminCampaingnController {

    @Inject
    private FacesUtil util;
    @Inject
    private ProductsFacade facade;
    @Inject
    private AdminProductsModel model;

    public void showProductDetail(Campaign campaign){

    }

    public void updateProduct(Campaign campaign){

    }

    public void deleteProduct(Campaign campaign){

    }



}
