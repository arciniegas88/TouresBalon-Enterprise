package co.com.touresbalon.foundation.oms.usecases.productssearch;

import co.com.touresbalon.foundation.oms.facades.OrdersFacade;
import co.com.touresbalon.foundation.oms.facades.ProductsFacade;
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
    private ProductsFacade facade;
    @Inject
    private OrdersFacade ordersFacade;

    //[action] ------------------
    public void showProductLinkDetail( String product  ) {
        model.setProduct( facade.searchProductByName( product ) );
        showProductDetail();
    }


    //[action] ------------------
    public void showProductDetail() {

        try {

            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(model.getProduct().getImageRef()));
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


}
