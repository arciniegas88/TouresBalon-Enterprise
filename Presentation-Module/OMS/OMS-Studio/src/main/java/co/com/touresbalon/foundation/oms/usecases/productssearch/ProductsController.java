package co.com.touresbalon.foundation.oms.usecases.productssearch;

import co.com.touresbalon.foundation.oms.domain.products.City;
import co.com.touresbalon.foundation.oms.domain.products.Product;
import co.com.touresbalon.foundation.oms.exceptions.BusinessException;
import co.com.touresbalon.foundation.oms.exceptions.SystemException;
import co.com.touresbalon.foundation.oms.facades.OrdersFacade;
import co.com.touresbalon.foundation.oms.facades.ProductsFacade;
import co.com.touresbalon.foundation.oms.usecases.campaingnadmin.AdminCampaingnModel;
import co.com.touresbalon.foundation.oms.usecases.portal.PortalController;
import co.com.touresbalon.foundation.oms.usecases.productadmin.AdminProductsModel;
import co.com.touresbalon.foundation.oms.util.FacesUtil;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by garciniegas on 04/10/2015.
 */

@Named
@RequestScoped
public class ProductsController {

    @Inject
    private FacesUtil util;
    @Inject
    private ProductsModel model;
    @Inject
    private AdminProductsModel adminProductsModel;
    @Inject
    private ProductsFacade facade;
    @Inject
    private OrdersFacade ordersFacade;

    @Inject
    private AdminCampaingnModel adminCampaingnModel;

    //[action] ------------------

    public void showProductLinkDetail( String product  ) {
        model.setProduct( facade.searchProductByName( product ) );
        showProductDetail( model.getProduct() );
    }

    //[action] ------------------

    public void updateProduct( Product product ){

        adminProductsModel.setCreationFlow(false);
        adminProductsModel.cleanModel();
        adminProductsModel.setCountries(facade.getCountries());
        List<City> cityList = facade.getCitiesByContry( adminProductsModel.getCountries().get(0).getId() );
        adminProductsModel.setSourceCities(cityList);
        adminProductsModel.setTargetCities(cityList);
        adminProductsModel.setTransports(facade.getTransports());
        adminProductsModel.setLodgings(facade.getLodging());
        adminProductsModel.setSpectacles(facade.getSpectacles());

        adminProductsModel.setProduct( facade.searchProduct( product.getId() ) );

        RequestContext.getCurrentInstance().execute( "window.location.href='"+ PortalController.PRODUCTS_ADMIN_PAGE+"';" );
    }

    //[action] ------------------

    public String deleteProduct( Product product ){

        try {

            facade.deleteProduct( product.getId() );
            util.addInfoMessage("El producto se ha eliminado con éxito");

        } catch (SystemException e) {
            util.addErrorMessage( e.getMessage() );
        } catch (BusinessException e) {
            util.addErrorMessage(e.getMessage());
        }

        return "";
    }

    //[action] ------------------

    public void showProductDetail( Product product ) {

        try {

            model.setProduct( facade.searchProduct( product.getId() ) );
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(product.getImageRef()));
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            int val = -1;
            /* this is a simple test method to double check values from the stream */

            while ((val = in.read()) != -1)
                out.write(val);

            byte[] bytes = out.toByteArray();
            DefaultStreamedContent content = new DefaultStreamedContent(new ByteArrayInputStream(bytes), "image/png", UUID.randomUUID().toString()+"_image.png");
            model.setProductImage( content );

        } catch (Exception e) {
            e.printStackTrace();
           util.addErrorMessage( "Ha ocurrido un error interno en la aplicación" );
        }

        RequestContext.getCurrentInstance().execute("PF('productDialog').show()");
    }




    //[action] ------------------
    public void spectaclesRankingAction() {
        model.setSpectaclesRanking(facade.getRankingSoldOrders(model.getSpectacleRankingSD(), model.getSpectacleRankingED()));
    }


    //[action] ------------------
    public void productsRankingAction() {
        model.setProductsRanking(ordersFacade.getRankingSoldProducts(model.getProductRankingSD(), model.getProductRankingED()));
    }

    //[action] ------------------
    public void cleanFormAction() {
        model.cleanForm();
    }

    //[action] ------------------
    public void cleanFormProductRankingAction() {
        model.setProductRankingED(new Date());
        model.setProductRankingSD(new Date());
    }

    //[action] ------------------
    public void cleanFormSpectacleRankingAction() {
        model.setSpectacleRankingED(new Date());
        model.setSpectacleRankingSD(new Date());
    }

    public void adminCompaign( Product product){
        adminCampaingnModel.setListCampaigns(facade.searchCampaignByIdProduct(product.getId()));
        adminCampaingnModel.setProduct(product);
        RequestContext.getCurrentInstance().execute("window.location.href='" + PortalController.CAMPAIGN_ADMIN_PAGE + "';");
    }


    public void createCampaign(Product product){
        adminCampaingnModel.setProduct(product);
        RequestContext.getCurrentInstance().execute("window.location.href='" + PortalController.CAMPAIGN_CREATE_PAGE + "';");
    }




}
