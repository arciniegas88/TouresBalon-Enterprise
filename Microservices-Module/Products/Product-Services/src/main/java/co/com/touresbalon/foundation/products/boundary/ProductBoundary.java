package co.com.touresbalon.foundation.products.boundary;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import org.slf4j.Logger;

import co.com.touresbalon.foundation.products.entity.Product;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * ProductBoundary -
 * Created by garciniegas on 07/08/2015.
 */

@Stateless
public class ProductBoundary {

    // [attributes] -------------------------------

    @Inject
    private Logger logger;

    @PersistenceContext
    private EntityManager em;

    public ProductBoundary() {
    }

    // [method] -----------------------------

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Product getProductDetail(Long id) {
        return em.find( Product.class,id);
    }

    // [method] -----------------------------

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Product> searchProducts( String code, String name, String descripttion,int pageIndex,int pageSize){

        if( isEmpty( code ) && isEmpty( name ) && isEmpty( descripttion )) {
            return em.createNamedQuery("Product.findAll", Product.class)
                    .setMaxResults(pageSize)
                    .setFirstResult(pageIndex)
                    .getResultList();
        }else{
            return em.createNamedQuery("Product.findAllByCriteria", Product.class)
                    .setParameter("CODE", code)
                    .setParameter("NAME", "%" + name + "%")
                    .setParameter("DESCRIPTION", "%" + descripttion + "%")
                    .setMaxResults(pageSize)
                    .setFirstResult(pageIndex)
                    .getResultList();
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public int searchProductsCount( String code, String name, String descripttion,int pageSize){
        int count=0;

        if( isEmpty( code ) && isEmpty( name ) && isEmpty( descripttion )) {
           count =em.createNamedQuery("Product.findAllCount", Long.class)
                    .setMaxResults(pageSize)
                    .getSingleResult().intValue();

            return count;
        }else{
           count= em.createNamedQuery("Product.findAllByCriteriaCount",  Long.class)
                    .setParameter("CODE", code)
                    .setParameter("NAME", "%" + name + "%")
                    .setParameter("DESCRIPTION", "%" + descripttion + "%")
                    .setMaxResults(pageSize)
                    .getSingleResult().intValue();
            return count/pageSize;
        }
    }




    // [method] -----------------------------

    @Deprecated
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Product> searchProductsOld(String code, String name, String descritption) {

        logger.info("--------------------------> inicio de la consulta: " );

        StringBuilder jpql = new StringBuilder();

        jpql.append("SELECT NEW co.com.touresbalon.foundation.products.entity.Product(p.id, p.name, p.description, p.code, p.spectacleDate, p.arrivalDate, p.departureDate) ")
                .append("FROM Product p WHERE 1=1 ")
                .append(code != null ? "AND p.code = :CODE " : "")
                .append(name != null ? "AND LOWER(p.name) LIKE TRIM(LOWER(:NAME)) " : "")
                .append(descritption != null ? "AND LOWER(p.description) LIKE TRIM(LOWER(:DESCRIPTION)) " : "");

        Query query = em.createQuery(jpql.toString(), Product.class);

        if (!isEmpty(code)) query.setParameter("CODE", code);

        if (!isEmpty(descritption))
            query.setParameter("DESCRIPTION", "%" + descritption + "%");

        if (!isEmpty(name)) query.setParameter("NAME","%" + name + "%");

        return query.getResultList();
    }

}
