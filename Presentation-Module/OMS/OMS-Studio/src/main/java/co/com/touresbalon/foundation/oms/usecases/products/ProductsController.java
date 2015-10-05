package co.com.touresbalon.foundation.oms.usecases.products;

import co.com.touresbalon.foundation.oms.facades.ProductsFacade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by garciniegas on 04/10/2015.
 */

@Named
@RequestScoped
public class ProductsController {

    @Inject
    private ProductsModel model;
    @Inject
    private ProductsFacade facade;


}
