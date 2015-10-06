package co.com.touresbalon.foundation.oms.facades;

import co.com.touresbalon.foundation.oms.domain.products.Product;
import co.com.touresbalon.foundation.oms.webclient.ProductsWebClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by garciniegas on 04/10/2015.
 */

@ApplicationScoped
public class ProductsFacade {

    //[fields] injected service client fields -----------------------

    @Inject
    private ProductsWebClient productsWC;

    // ------------------------------

    public Product searchProduct( Long id ){
        return productsWC.searchProduct(id);
    }


    // ------------------------------

    public List<Product> searchProducts( String code, String name,String description,
                                         int pageIndex,int pageSize){
        return productsWC.searchProducts(code,name,description,pageIndex,pageSize);
    }


    public int getTotalPagesByProductSearch( String code, String name,String description){

        String total = productsWC.getTotalPagesByProductSearch(code, name, description);
        return Integer.parseInt( total.replaceAll("<total>","").replaceAll("</total>","") );
    }

}
