package co.com.touresbalon.foundation.products.boundary;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import co.com.touresbalon.foundation.crosscutting.exceptions.ExceptionBuilder;
import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import org.slf4j.Logger;

import co.com.touresbalon.foundation.products.entity.Product;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @Inject
    private ExceptionBuilder exceptionBuilder;

    @PersistenceContext
    private EntityManager em;

    public ProductBoundary() {
    }

    // [method] -----------------------------

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Product getProductDetail(Long id) throws SystemException {

        try {

            return em.createNamedQuery("Product.findById", Product.class)
                    .setParameter("ID", id)
                    .getSingleResult();

        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }


    // [method] -----------------------------

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Product> searchProducts(String code, String name, String description, String spectacleName,
                                        int pageIndex, int pageSize) throws SystemException {

        try {

            code = (code != null && code.trim().equals("")) ? null : code;
            name = (name != null && name.trim().equals("")) ? null : name;
            description = (description != null && description.trim().equals("")) ? null : description;
            spectacleName = (spectacleName != null && spectacleName.trim().equals("")) ? null : spectacleName;

            if (isEmpty(code) && isEmpty(name) && isEmpty(description) && isEmpty(spectacleName)) {
                return em.createNamedQuery("Product.findAll", Product.class)
                        .setMaxResults(pageSize)
                        .setFirstResult(pageIndex)
                        .getResultList();
            } else {
                return em.createNamedQuery("Product.findAllByCriteria", Product.class)
                        .setParameter("CODE", code)
                        .setParameter("NAME", "%" + name + "%")
                        .setParameter("DESCRIPTION", "%" + description + "%")
                        .setParameter("SPECT_NAME", "%" + spectacleName + "%")
                        .setMaxResults(pageSize)
                        .setFirstResult(pageIndex)
                        .getResultList();
            }

        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }


    // [method] -----------------------------

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public int countProducts(String code, String name, String description, String spectacleName) throws SystemException {

        try {

            code = (code != null && code.trim().equals("")) ? null : code;
            name = (name != null && name.trim().equals("")) ? null : name;
            description = (description != null && description.trim().equals("")) ? null : description;
            spectacleName = (spectacleName != null && spectacleName.trim().equals("")) ? null : spectacleName;

            if (isEmpty(code) && isEmpty(name) && isEmpty(description) && isEmpty(spectacleName)) {
                return em.createNamedQuery("Product.findAllCount", Long.class)
                        .getSingleResult().intValue();
            } else {
                return em.createNamedQuery("Product.findAllByCriteriaCount", Long.class)
                        .setParameter("CODE", code)
                        .setParameter("NAME", "%" + name + "%")
                        .setParameter("DESCRIPTION", "%" + description + "%")
                        .setParameter("SPECT_NAME", "%" + spectacleName + "%")
                        .getSingleResult().intValue();
            }

        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }


    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<String> findEspectaclesRealedToProducts( List<String> products ) throws SystemException {

        try {
            return em.createNamedQuery("Product.findEspectaclesRelatedToProducts")
                    .setParameter("NAMES", products)
                    .getResultList();

        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

}
