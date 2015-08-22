package co.com.touresbalon.foundation.orders.boundary;

import co.com.touresbalon.foundation.crosscutting.annotations.cache.CacheStore;
import co.com.touresbalon.foundation.orders.entity.OrderItem;
import co.com.touresbalon.foundation.orders.entity.SalesOrder;
import org.slf4j.Logger;

import javax.cache.Cache;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by garciniegas on 19/08/2015.
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


    public List<SalesOrder> searchSalesOrderByIdProduct (Long idProduct){

        return em.createNamedQuery("SalesOrder.byIdProduct" ,SalesOrder.class)
                .setParameter("PRODUCT_ID",idProduct)
                .getResultList();
    }

    public List<OrderItem> searchOrderItemsByIdOrder(Long idOrder){
        return em.createNamedQuery("OrderItem.OrderItemByOrderId", OrderItem.class)
                .setParameter("ID_ORDEN", idOrder)
                .getResultList();
    }


    public String testCache(){
        return cache.get("prueba").toString();
    }

}
