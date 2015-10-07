package co.com.touresbalon.foundation.oms.usecases.products;

import co.com.touresbalon.foundation.oms.domain.products.Product;
import co.com.touresbalon.foundation.oms.facades.ProductsFacade;
import co.com.touresbalon.foundation.oms.infrastructure.BeanLocator;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by garciniegas on 04/10/2015.
 */

@Named
@SessionScoped
public class ProductsModel extends LazyDataModel<Product> implements Serializable {

    // search field ------------------
    private String code;
    private String name;
    private String description;
    private String spectacleName;

    //product ranking fields --------------------

    private Date productRankingSD;
    private Date productRankingED;
    private List<String> productsRanking;

    // model fields ------------------------
    private Product product;

    public ProductsModel() {
        productsRanking = new ArrayList<>();
        productRankingSD = new Date();
        productRankingED = new Date();
    }

    /**
     * @Override public Product getRowData(String rowKey) {
     * <p/>
     * return null;
     * }
     **/

    @Override
    public List<Product> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        ProductsFacade facade = BeanLocator.getBean( ProductsFacade.class );
        setRowCount( facade.getTotalPagesByProductSearch( code,name,description,spectacleName ) );
        return facade.searchProducts(code,name,description,spectacleName,first,pageSize);
    }

    public void cleanForm(){
        code = null;
        name = null;
        description = null;
        spectacleName = null;
    }

    public List<String> getProductsRanking() {
        return productsRanking;
    }

    public void setProductsRanking(List<String> productsRanking) {
        this.productsRanking = productsRanking;
    }

    public Date getProductRankingSD() {
        return productRankingSD;
    }

    public void setProductRankingSD(Date productRankingSD) {
        this.productRankingSD = productRankingSD;
    }

    public Date getProductRankingED() {
        return productRankingED;
    }

    public void setProductRankingED(Date productRankingED) {
        this.productRankingED = productRankingED;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSpectacleName() {
        return spectacleName;
    }

    public void setSpectacleName(String spectacleName) {
        this.spectacleName = spectacleName;
    }
}
