package co.com.touresbalon.foundation.oms.usecases.products;

import co.com.touresbalon.foundation.oms.facades.OrdersFacade;
import co.com.touresbalon.foundation.oms.facades.ProductsFacade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

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
    @Inject
    private OrdersFacade ordersFacade;

    //[action] ------------------
    public void productsRankingAction()
    {
        model.setProductsRanking( ordersFacade.getRankingSoldProducts( model.getProductRankingSD(),model.getProductRankingED() ) );
        System.out.println("------------------- productsRankingAction");
    }

    //[action] ------------------
    public void cleanFormAction(){
        model.cleanForm();
    }

    //[action] ------------------
    public void cleanFormProductRankingAction(){
        model.setProductRankingED(new Date());
        model.setProductRankingSD(new Date());
    }

}
