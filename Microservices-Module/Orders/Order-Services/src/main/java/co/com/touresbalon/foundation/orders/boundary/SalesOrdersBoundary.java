package co.com.touresbalon.foundation.orders.boundary;

import co.com.touresbalon.foundation.crosscutting.exceptions.ExceptionBuilder;
import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import co.com.touresbalon.foundation.orders.dto.Customer;
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

import static org.apache.commons.lang3.StringUtils.isEmpty;

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
    public Long countTotalProductOccurrences(Long productId) throws SystemException {

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
                .setParameter("LODGING_PROVIDER", oi.getLodgingProvider())
                .setParameter("LODGING_RESERVATION_PROVIDER", oi.getLodgingReservationProvider())
                .setParameter("TRANSPORT_TRAVEL_PROVIDER", oi.getTransportTravelProvider())
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
        String sql = "SELECT SALES_ORDER_SEQ.NEXTVAL FROM DUAL";
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


    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SalesOrder> searchSalesOrder(String id, String productId, int pageIndex, int pageSize) throws SystemException {

        try {

            id = (id != null && id.trim().equals("")) ? null : id;
            productId = (productId != null && productId.trim().equals("")) ? null : productId;

            if (isEmpty(id) && isEmpty(productId)) {
                return em.createNamedQuery("SalesOrder.findAll", SalesOrder.class)
                        .setMaxResults(pageSize)
                        .setFirstResult(pageIndex)
                        .getResultList();
            } else if (!isEmpty(id) && isEmpty(productId)) {
                return em.createNamedQuery("SalesOrder.findAllByCriteria", SalesOrder.class)
                        .setParameter("ID", id)
                        .setMaxResults(pageSize)
                        .setFirstResult(pageIndex)
                        .getResultList();
            } else if (isEmpty(id) && !isEmpty(productId)) {
                return em.createNamedQuery("SalesOrder.findAllByProduct", SalesOrder.class)
                        .setParameter("PRODUCTID", productId)
                        .setMaxResults(pageSize)
                        .setFirstResult(pageIndex)
                        .getResultList();
            } else {
                return em.createNamedQuery("SalesOrder.findAllByIdAndProduct", SalesOrder.class)
                        .setParameter("ID", id)
                        .setParameter("PRODUCTID", productId)
                        .setMaxResults(pageSize)
                        .setFirstResult(pageIndex)
                        .getResultList();
            }
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }


    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public int countSalesOrders(String id, String productId) throws SystemException {
        try {

            id = (id != null && id.trim().equals("")) ? null : id;
            productId = (productId != null && productId.trim().equals("")) ? null : productId;

            if (isEmpty(id) && isEmpty(productId)) {
                return em.createNamedQuery("SalesOrder.findAllCount", Long.class)
                        .getSingleResult().intValue();
            } else if (!isEmpty(id) && isEmpty(productId)) {
                return em.createNamedQuery("SalesOrder.findAllByCriteriaCount", Long.class)
                        .setParameter("ID", id)
                        .getSingleResult().intValue();
            } else if (isEmpty(id) && !isEmpty(productId)) {
                return em.createNamedQuery("SalesOrder.findAllByCountProduct", Long.class)
                        .setParameter("PRODUCTID", productId)
                        .getSingleResult().intValue();
            } else {
                return em.createNamedQuery("SalesOrder.findAllByCountIdAndProduct", Long.class)
                        .setParameter("ID", id)
                        .setParameter("PRODUCTID", productId)
                        .getSingleResult().intValue();
            }
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }


    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SalesOrder> searchSalesOrderStatus(String status, int pageIndex, int pageSize) throws SystemException {

        try {
            status = (status != null && status.trim().equals("")) ? null : status;
            if (isEmpty(status)) {
                return em.createNamedQuery("SalesOrder.findAll", SalesOrder.class)
                        .setMaxResults(pageSize)
                        .setFirstResult(pageIndex)
                        .getResultList();
            } else {
                return em.createNamedQuery("SalesOrder.findAllByStatus", SalesOrder.class)
                        .setParameter("STATUS", "%" + status + "%")
                        .setMaxResults(pageSize)
                        .setFirstResult(pageIndex)
                        .getResultList();
            }
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public int countSalesOrdersStatus(String status) throws SystemException {
        try {

            status = (status != null && status.trim().equals("")) ? null : status;

            if (isEmpty(status)) {
                return em.createNamedQuery("SalesOrder.findAllCount", Long.class)
                        .getSingleResult().intValue();
            } else {
                return em.createNamedQuery("SalesOrder.findAllByStatusCount", Long.class)
                        .setParameter("STATUS", "%" + status + "%")
                        .getSingleResult().intValue();
            }
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public int countCustomersByProductsSold(String productId) throws SystemException{
        try{
            if (null == productId || productId.compareTo("") == 0) {
                return em.createNamedQuery("SalesOrder.countAllCustomersByProduct", Long.class)
                        .getSingleResult().intValue();
            }else{
                return em.createNamedQuery("SalesOrder.countCustomersByProduct", Long.class)
                        .setParameter("PRODUCTID", productId)
                        .getSingleResult().intValue();
            }
        }catch(Throwable enf){
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw  exceptionBuilder.buildSystemException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Customer> getCustomersByProductSold(Long productId, int pageIndex, int pageSize) throws SystemException {
        try {

            if (null == productId || productId == 0) {
                return em.createNamedQuery("SalesOrder.findAllCustomersByProduct", Customer.class)
                        .setMaxResults(pageSize)
                        .setFirstResult(pageIndex)
                        .getResultList();
            } else {

                return em.createNamedQuery("SalesOrder.findCustomersByProduct", Customer.class)
                        .setParameter("PRODUCTID", productId)
                        .setMaxResults(pageSize)
                        .setFirstResult(pageIndex)
                        .getResultList();
            }

        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public int countCustomerRanking(String startDate, String endDate) throws SystemException{
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            return em.createNamedQuery("SalesOrder.countCustomersRanking", Long.class)
                    .setParameter("STARTDATE", sdf.parse(startDate), TemporalType.DATE)
                    .setParameter("ENDDATE", sdf.parse(endDate), TemporalType.DATE )
                    .getSingleResult()
                    .intValue();

        }catch(Throwable enf){
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Customer> getCustomerRanking(String startDate, String endDate, int pageIndex, int pageSize) throws SystemException{
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            return em.createNamedQuery("SalesOrder.findCustomersRanking", Customer.class)
                    .setParameter("STARTDATE", sdf.parse(startDate), TemporalType.DATE)
                    .setParameter("ENDDATE", sdf.parse(endDate), TemporalType.DATE)
                    .setFirstResult(pageIndex)
                    .setMaxResults(pageSize)
                    .getResultList();

        }catch(Throwable enf){
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw  exceptionBuilder.buildSystemException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public int searchOrderSalesCountInvoice(String fecha) throws SystemException {
        fecha = (fecha != null && fecha.trim().equals("")) ? null : fecha;
        try {
            if (!isEmpty(fecha)) {
                String sql = "select count(*) from SALES_ORDER S where to_char(S.ORDER_DATE, 'yyyy-mm') = '" + fecha + "' order by S.ORDER_DATE";
                BigDecimal value  =(BigDecimal) em.createNativeQuery(sql).getSingleResult();
                if(value!=null) {
                    return value.intValue();
                }else{
                    return 0;
                }
            }else{
                return em.createNamedQuery("SalesOrder.findAllCount", Long.class)
                        .getSingleResult().intValue();

            }
        }catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SalesOrder> searchOrderSalesInvoice(String fecha,int pageIndex, int pageSize) throws SystemException {
        fecha = (fecha != null && fecha.trim().equals("")) ? null : fecha;
        List<SalesOrder> listSalesOrder = new ArrayList<>();
        try {
            if (!isEmpty(fecha)) {
                String sql = "select * from SALES_ORDER S where to_char(S.ORDER_DATE, 'yyyy-mm') = '" + fecha + "' order by S.ORDER_DATE";
                List<SalesOrder> listSales = em.createNativeQuery(sql, SalesOrder.class).setMaxResults(pageSize)
                        .setFirstResult(pageIndex).getResultList();
                if(!listSales.isEmpty()) {
                    for (SalesOrder o : listSales) {
                        SalesOrder sales = new co.com.touresbalon.foundation.orders.entity.SalesOrder(o.getId(),
                                o.getOrderDate(), o.getPrice(),o.getStatus(), o.getComments(), o.getCustDocumentNumber()
                                ,o.getCustDocumentType());
                        listSalesOrder.add(sales);
                    }
                }
                return listSalesOrder;
            }else{
                return em.createNamedQuery("SalesOrder.findAll", SalesOrder.class)
                        .setMaxResults(pageSize)
                        .setFirstResult(pageIndex)
                        .getResultList();
            }
        }catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public String searchOrderSalesTotalInvoice(String fecha) throws SystemException {
        fecha = (fecha != null && fecha.trim().equals("")) ? null : fecha;
        try {
            if (!isEmpty(fecha)) {
                String sql = "select SUM(S.PRICE) as total from SALES_ORDER S where to_char(S.ORDER_DATE, 'yyyy-mm') = '" + fecha + "' order by S.ORDER_DATE";
                BigDecimal value  =(BigDecimal) em.createNativeQuery(sql).getSingleResult();
                if(value!=null) {
                    return value.toString();
                }else{
                    return "";
                }
            }else{
                String sql = "select SUM(S.PRICE) as total from SALES_ORDER S order by S.ORDER_DATE";
                BigDecimal value  =(BigDecimal) em.createNativeQuery(sql).getSingleResult();
                if(value!=null) {
                    return value.toString();
                }else{
                    return "";
                }
            }
        }catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SalesOrder> searchOrderSalesRankingStatus(String status,int pageIndex, int pageSize) throws SystemException {

        //status = (status != null && status.trim().equals("")) ? "'IN_VALIDATION','IN_BOOKING'" : "'"+status+"'";
        if(status == null || status.equals("")){
            status = "'IN_VALIDATION','IN_BOOKING'";
        } else if(!status.trim().equals("")){
            status ="'"+status+"'";
        }


        List<SalesOrder> listSalesOrder = new ArrayList<>();
        try {

                String sql = "select * from SALES_ORDER S where S.STATUS IN("+status+")  ORDER BY S.ORDER_DATE";



            List<SalesOrder> listSales = em.createNativeQuery(sql, SalesOrder.class).setMaxResults(pageSize)
                        .setFirstResult(pageIndex).getResultList();
                if(!listSales.isEmpty()) {
                    for (SalesOrder o : listSales) {
                        SalesOrder sales = new co.com.touresbalon.foundation.orders.entity.SalesOrder(o.getId(),
                                o.getOrderDate(), o.getPrice(),o.getStatus(), o.getComments(), o.getCustDocumentNumber()
                                ,o.getCustDocumentType());
                        listSalesOrder.add(sales);
                    }
                }
                return listSalesOrder;

        }catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }

    }


    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public int searchOrderSalesCountRankingStatus(String status) throws SystemException {

        if(status == null || status.equals("")){
            status = "'IN_VALIDATION','IN_BOOKING'";
        } else if(!status.trim().equals("")){
            status ="'"+status+"'";
        }
        try {

            String sql = "select count(*) from SALES_ORDER S where S.STATUS in("+status+")";


            BigDecimal value  = (BigDecimal)  em.createNativeQuery(sql).getSingleResult();
            if(value!=null) {
                return value.intValue();
            }else{
                return 0;
            }

        }catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }

    }


    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SalesOrder> searchOrderSalesRankingPrice(String fechaInicio,String fechaFin,String status,int pageIndex, int pageSize) throws SystemException {

        status = (status != null && status.trim().equals("")) ? null : "'"+status+"'";
        fechaInicio = (fechaInicio != null && fechaInicio.trim().equals("")) ? null : fechaInicio;
        fechaFin = (fechaFin != null && fechaFin.trim().equals("")) ? null : fechaFin;


        String whereDate="";
        if(fechaInicio!=null && fechaFin!=null){
            whereDate="AND S.ORDER_DATE BETWEEN TO_DATE('"+fechaInicio+"','yyyy-MM-dd') and TO_DATE('"+fechaFin+"','yyyy-MM-dd')";
        }


        List<SalesOrder> listSalesOrder = new ArrayList<>();
        try {

            String sql = "SELECT * FROM SALES_ORDER S " +
                    " WHERE S.STATUS = " + status +
                    "" + whereDate
                    +" ORDER BY S.PRICE DESC ";



            List<SalesOrder> listSales = em.createNativeQuery(sql, SalesOrder.class).setMaxResults(pageSize)
                    .setFirstResult(pageIndex).getResultList();
            if(!listSales.isEmpty()) {
                for (SalesOrder o : listSales) {
                    SalesOrder sales = new co.com.touresbalon.foundation.orders.entity.SalesOrder(o.getId(),
                            o.getOrderDate(), o.getPrice(),o.getStatus(), o.getComments(), o.getCustDocumentNumber()
                            ,o.getCustDocumentType());
                    listSalesOrder.add(sales);
                }
            }
            return listSalesOrder;

        }catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }

    }


    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public int searchOrderSalesCountRankingPrice(String fechaInicio,String fechaFin,String status) throws SystemException {

        status = (status != null && status.trim().equals("")) ? null : "'"+status+"'";
        fechaInicio = (fechaInicio != null && fechaInicio.trim().equals("")) ? null : fechaInicio;
        fechaFin = (fechaFin != null && fechaFin.trim().equals("")) ? null : fechaFin;


        String whereDate="";
        if(fechaInicio!=null && fechaFin!=null){
            whereDate="AND S.ORDER_DATE BETWEEN TO_DATE('"+fechaInicio+"','yyyy-MM-dd') and TO_DATE('"+fechaFin+"','yyyy-MM-dd')";
        }

        try {

            String sql = "SELECT count(*) FROM SALES_ORDER S " +
                    " WHERE S.STATUS = "+status+" " +
                    "" + whereDate;

            BigDecimal value  = (BigDecimal)  em.createNativeQuery(sql).getSingleResult();
            if(value!=null) {
                return value.intValue();
            }else{
                return 0;
            }

        }catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }

    }




}
