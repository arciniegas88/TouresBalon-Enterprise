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
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Long countTotalProductOccurrences(Long productId)throws SystemException{

        try {

            return em.createNamedQuery("OrderItem.getProductTotalOcurrences", Long.class)
                    .setParameter("PRODUCT", productId)
                    .getSingleResult();

        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    public void changeSalesOrderStatus(SalesOrder so) {

        em.createNamedQuery("SalesOrder.changeStatus")
                .setParameter("STATUS", so.getStatus())
                .setParameter("COMMENTS", so.getComments())
                .setParameter("ID", so.getId())
                .executeUpdate();

        em.flush();
    }

    public Long createSalesOrder(SalesOrder so, List<OrderItem> ois) throws SystemException {

        so.setOrderDate(new Date());
        em.persist(so);

        int productNumber = 1;

        if (ois != null) {
            for (OrderItem oi : ois) {
                oi.setOrderId(so);
                oi.setItemNo(String.valueOf(productNumber++));
                em.persist(oi);
            }
        }

        em.flush();
        return so.getId();
    }

    public void updateItem(OrderItem oi) {

        String itemNo = String.valueOf(new Double(oi.getItemNo()).intValue());

        oi.setSpectacleId(oi.getSpectacleId() != null && oi.getSpectacleId() < 0 ? null : oi.getSpectacleId());
        oi.setSpectacleTicket(oi.getSpectacleTicket() != null && oi.getSpectacleTicket() < 0 ? null : oi.getSpectacleTicket());

        if (oi.getTransportTravelDate() != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(oi.getTransportTravelDate());

            if (c.get(Calendar.YEAR) == 2000)
                oi.setTransportTravelDate(null);
        }

        em.createNamedQuery("OrderItem.update")
                .setParameter("STATUS", oi.getStatus())
                .setParameter("TRANSPORT_COMMENTS", oi.getTransportComments())
                .setParameter("TRANSPORT_TRAVEL_DATE", oi.getTransportTravelDate())
                .setParameter("TRANSPORT_SOURCE_CITY", oi.getTransportSourceCity())
                .setParameter("TRANSPORT_TARGET_CITY", oi.getTransportTargetCity())
                .setParameter("TRANSPORT_TRAVEL_NUMBER", oi.getTransportTravelNumber())
                .setParameter("TRANSPORT_CHAIR_NUMBER", oi.getTransportChairNumber())
                .setParameter("TRANSPORT_OUT_TIME", oi.getTransportOutTime())
                .setParameter("SPECTACLE_COMMENTS", oi.getSpectacleComments())
                .setParameter("SPECTACLE_ID", oi.getSpectacleId())
                .setParameter("SPECTACLE_TICKET", oi.getSpectacleTicket())
                .setParameter("LODGING_COMMENTS", oi.getLodgingComments())
                .setParameter("ORDER_ID", oi.getOrderId().getId())
                .setParameter("ITEM_NO", itemNo)
                .executeUpdate();

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
                    .setParameter("STATUS", SalesOrderStatus.IN_VALIDATION.toString())
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

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<String> getRankingSoldProducts(String startOrderDate, String endOrderDate) throws SystemException {

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            List<Object[]> data = em.createNamedQuery("OrderItem.getProductRanking")
                    .setParameter("ORDER_START_DATE", sdf.parse(startOrderDate), TemporalType.DATE)
                    .setParameter("ORDER_END_DATE", sdf.parse(endOrderDate), TemporalType.DATE)
                    .getResultList();

            List<String> ranking = new ArrayList<>();

            for (Object[] row : data) {
                ranking.add(row[0].toString());
            }

            return ranking;

        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public SalesOrder searchSalesOrderById(Long salesOrderId) throws SystemException {
        try {
            SalesOrder salesOrder = em.createNamedQuery("SalesOrder.ById", SalesOrder.class)
                    .setParameter("ID_SALES_ORDER", salesOrderId)
                    .getSingleResult();
            salesOrder.setOrderItemList(em.createNamedQuery("OrderItem.getOrderItems", OrderItem.class)
                    .setParameter("ID_SALES_ORDER", salesOrderId)
                    .getResultList());
            return salesOrder;

        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }
}
