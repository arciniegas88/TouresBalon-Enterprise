package co.com.touresbalon.foundation.orders.boundary;

import co.com.touresbalon.foundation.crosscutting.annotations.cache.CacheStore;
import co.com.touresbalon.foundation.orders.dto.Product;
import co.com.touresbalon.foundation.orders.entity.OrderItem;
import co.com.touresbalon.foundation.orders.entity.SalesOrder;
import org.slf4j.Logger;

import javax.cache.Cache;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Jenny Rodriguez on 19/08/2015.
 */

@Stateless
public class SalesOrdersBoundary {

    @Inject
    private Logger logger;

    @Inject
    @CacheStore("application-cache")
    private Cache<String,Object> cache;

    @PersistenceContext
    private EntityManager em;


    public SalesOrdersBoundary() {
    }



    public List<Product> getTopFiveProducts(Long idProduct){

        int maxResult =6;
        List<Product> productsList =new ArrayList<>();

        List<Object[]> results = em.createNamedQuery("OrderItem.TopFiveProductByOrder")
                                .setParameter("PRODUCT_ID", idProduct)
                                .setMaxResults(maxResult)
                                .getResultList();

        for (Object oRow : results) {
            Object[] r = (Object[]) oRow;

            if(Long.parseLong(r[0].toString()) !=idProduct){
                Product product=new Product();
                product.setIdProduct(Long.parseLong(r[0].toString()));
                product.setNameProduct(r[1].toString());
                productsList.add(product);
            }


        }
        return productsList;

    }
    
    public String testCache(){
        return cache.get("prueba").toString();
    }

}
