package co.com.touresbalon.foundation.orders.boundary;

import co.com.touresbalon.foundation.crosscutting.exceptions.ExceptionBuilder;
import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import co.com.touresbalon.foundation.orders.dto.Product;
import co.com.touresbalon.foundation.orders.entity.OrderItem;
import co.com.touresbalon.foundation.orders.entity.SalesOrder;
import co.com.touresbalon.foundation.orders.entity.SalesOrderStatus;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jenny Rodriguez on 19/08/2015.
 */

@Stateless
public class SalesOrdersBoundary {

    @Inject
    private Logger logger;

    @Inject
    private ExceptionBuilder exceptionBuilder;

    @PersistenceContext
    private EntityManager em;


    public SalesOrdersBoundary() {
    }

    public Long createSalesOrder( SalesOrder so, List<OrderItem> ois)throws SystemException{
        System.out.println( so );
        System.out.println( ois );
        return new Long("23");
    }

    public void updateItem( OrderItem oi ){
        System.out.println( oi );
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Product> getTopFiveProducts(Long idProduct) throws SystemException {

        int maxResult = 6;
        List<Product> productsList = new ArrayList<>();
        try {
            List<Object[]> results = em.createNamedQuery("OrderItem.TopFiveProductByOrder")
                    .setParameter("PRODUCT_ID", idProduct)
                    .setMaxResults(maxResult)
                    .getResultList();
            for (Object oRow : results) {
                Object[] r = (Object[]) oRow;

                if (Long.parseLong(r[0].toString()) != idProduct) {
                    Product product = new Product();
                    product.setIdProduct(Long.parseLong(r[0].toString()));
                    product.setNameProduct(r[1].toString());
                    productsList.add(product);
                }
            }
            return productsList;

        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SalesOrder> searchSalesOrderByCustomer(String typeDocument, String numberDocument) throws SystemException {

        try {

            return em.createNamedQuery("SalesOrder.ByCustomer", SalesOrder.class)
                    .setParameter("TYPE_DOCUMENT", typeDocument)
                    .setParameter("NUMBER_DOCUMENT", numberDocument)
                    .setParameter("STATUS", SalesOrderStatus.IN_VALIDATION.toString() )
                    .getResultList();

        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Long generateSalesOrderId() throws SystemException {
        String sql = "SELECT sequence_sales_orders.nextval FROM dual";
        try {
            return ((BigDecimal) em.createNativeQuery(sql).getSingleResult()).longValue();
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<OrderItem> getOrderItems(Long idSalesOrder) throws SystemException {
        try {
            return em.createNamedQuery("OrderItem.getOrderItems", OrderItem.class)
                    .setParameter("ID_SALES_ORDER", idSalesOrder)
                    .getResultList();
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SalesOrder> getSalesOrderDetail(Long idSalesOrder) throws SystemException {
        try {
            return em.createNamedQuery("SalesOrder.getDetail", SalesOrder.class)
                    .setParameter("ID_SALES_ORDER", idSalesOrder)
                    .getResultList();
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

}
