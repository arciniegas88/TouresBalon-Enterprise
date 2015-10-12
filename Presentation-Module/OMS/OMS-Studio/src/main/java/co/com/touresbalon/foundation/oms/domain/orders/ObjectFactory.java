
package co.com.touresbalon.foundation.oms.domain.orders;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.touresbalon.foundation.oms.domain.orders package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CollectionWrapper_QNAME = new QName("", "wrapper");
    private final static QName _OrderItem_QNAME = new QName("", "orderItem");
    private final static QName _SalesOrder_QNAME = new QName("", "salesOrder");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.touresbalon.foundation.oms.domain.orders
     * 
     */
    public ObjectFactory() {
    }

    public CollectionWrapper createCollectionWrapper() {
        return new CollectionWrapper();
    }

    /**
     * Create an instance of {@link OrderItem }
     * 
     */
    public OrderItem createOrderItem() {
        return new OrderItem();
    }

    /**
     * Create an instance of {@link SalesOrder }
     * 
     */
    public SalesOrder createSalesOrder() {
        return new SalesOrder();
    }

    @XmlElementDecl(namespace = "", name = "wrapper")
    public JAXBElement<CollectionWrapper> createCollectionWrapper(CollectionWrapper value) {
        return new JAXBElement<CollectionWrapper>(_CollectionWrapper_QNAME, CollectionWrapper.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "orderItem")
    public JAXBElement<OrderItem> createOrderItem(OrderItem value) {
        return new JAXBElement<OrderItem>(_OrderItem_QNAME, OrderItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalesOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "salesOrder")
    public JAXBElement<SalesOrder> createSalesOrder(SalesOrder value) {
        return new JAXBElement<SalesOrder>(_SalesOrder_QNAME, SalesOrder.class, null, value);
    }

}
