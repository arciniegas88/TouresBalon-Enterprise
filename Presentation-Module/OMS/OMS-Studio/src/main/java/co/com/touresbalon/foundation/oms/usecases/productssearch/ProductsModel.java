package co.com.touresbalon.foundation.oms.usecases.productssearch;

import co.com.touresbalon.foundation.oms.domain.products.Product;
import co.com.touresbalon.foundation.oms.facades.ProductsFacade;
import co.com.touresbalon.foundation.oms.infrastructure.BeanLocator;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.*;
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

    //spectacle ranking fields --------------------

    private Date spectacleRankingSD;
    private Date spectacleRankingED;
    private List<String> spectaclesRanking;
    private StreamedContent productImage;

    // model fields ------------------------
    private Product product;
    private List<Product> cacheProducts;

    public ProductsModel() {
        productsRanking = new ArrayList<>();
        productRankingSD = new Date();
        productRankingED = new Date();
        spectacleRankingSD = new Date();
        spectacleRankingED = new Date();
        spectaclesRanking = new ArrayList<>();
    }

    /**
     * @Override public Product getRowData(String rowKey) {
     * <p/>
     * return null;
     * }
     **/

    @Override
    public List<Product> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        ProductsFacade facade = BeanLocator.getBean(ProductsFacade.class);
        setRowCount(facade.getTotalPagesByProductSearch(code, name, description, spectacleName));
        cacheProducts = facade.searchProducts(code, name, description, spectacleName, first, pageSize);
        return cacheProducts;
    }

    @Override
    public Product getRowData(String rowKey) {

        for (Product p : cacheProducts) {
            if (p.getId().toString().equals(rowKey))
                return p;
        }

        return null;
    }

    public void cleanForm() {
        code = null;
        name = null;
        description = null;
        spectacleName = null;
    }

    public void cleanModel() {

        cleanForm();

        productRankingSD = new Date();
        productRankingED = new Date();
        productsRanking.clear();

        spectacleRankingSD = new Date();
        spectacleRankingED = new Date();
        spectaclesRanking.clear();
    }

    public StreamedContent getProductImage() {
        return productImage;
    }

    public void setProductImage(StreamedContent productImage) {
        this.productImage = productImage;
    }

    public Date getSpectacleRankingSD() {
        return spectacleRankingSD;
    }

    public void setSpectacleRankingSD(Date spectacleRankingSD) {
        this.spectacleRankingSD = spectacleRankingSD;
    }

    public Date getSpectacleRankingED() {
        return spectacleRankingED;
    }

    public void setSpectacleRankingED(Date spectacleRankingED) {
        this.spectacleRankingED = spectacleRankingED;
    }

    public List<String> getSpectaclesRanking() {
        return spectaclesRanking;
    }

    public void setSpectaclesRanking(List<String> spectaclesRanking) {
        this.spectaclesRanking = spectaclesRanking;
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
