package co.com.touresbalon.foundation.products.boundary;

import co.com.touresbalon.foundation.products.entity.Product;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public List<Product> searchProducts( String code, String name ,String descritption ){

        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT p FROM Product p WHERE 1=1 ");
        jpql.append( code != null ? "AND p.code = :CODE " : "" );
        jpql.append( name != null ? "AND LOWER(p.name) LIKE TRIM(LOWER(:NAME)) " : "");
        jpql.append( descritption != null ? "AND LOWER(p.description) LIKE TRIM(LOWER(:DESCRIPTION)) " : "" );

        Query query = em.createQuery(jpql.toString(),Product.class);

        if(!StringUtils.isEmpty( code ))
            query.setParameter("CODE", code);

        if(!StringUtils.isEmpty( descritption ))
            query.setParameter("DESCRIPTION","%"+ descritption+"%");

        if(!StringUtils.isEmpty( name ))
            query.setParameter("NAME", "%"+name+"%");

        return query.getResultList();
    }

}
