package co.com.touresbalon.foundation.products.boundary;

import co.com.touresbalon.foundation.products.entity.Product;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by garciniegas on 07/08/2015.
 */

@Stateless
public class ProductBoundary {

    // [attributes] -------------------------------

    @PersistenceContext
    private EntityManager em;

    public ProductBoundary() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Product> searchProducts(){

        return em.createNamedQuery("Product.findAll",Product.class)
                 .getResultList();
    }

}
