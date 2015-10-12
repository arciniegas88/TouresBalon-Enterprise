
package co.com.touresbalon.foundation.oms.domain.products;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.touresbalon.foundation.oms.domain.products package. 
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
    private final static QName _ProductaWrapper_QNAME = new QName("", "collection");
    private final static QName _Product_QNAME = new QName("", "product");
    private final static QName _Transport_QNAME = new QName("", "transport");
    private final static QName _Campaign_QNAME = new QName("", "campaign");
    private final static QName _Spectacle_QNAME = new QName("", "spectacle");
    private final static QName _Lodging_QNAME = new QName("", "lodging");
    private final static QName _City_QNAME = new QName("", "city");
    private final static QName _Country_QNAME = new QName("", "country");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.touresbalon.foundation.oms.domain.products
     * 
     */
    public ObjectFactory() {
    }

    public CollectionWrapper createCollectionWrapper() {
        return new CollectionWrapper();
    }

    public ProductsWrapper createProductsWrapper() {
        return new ProductsWrapper();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link Transport }
     * 
     */
    public Transport createTransport() {
        return new Transport();
    }

    /**
     * Create an instance of {@link Campaign }
     * 
     */
    public Campaign createCampaign() {
        return new Campaign();
    }

    /**
     * Create an instance of {@link Spectacle }
     * 
     */
    public Spectacle createSpectacle() {
        return new Spectacle();
    }

    /**
     * Create an instance of {@link Lodging }
     * 
     */
    public Lodging createLodging() {
        return new Lodging();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
    }


    @XmlElementDecl(namespace = "", name = "wrapper")
    public JAXBElement<CollectionWrapper> createCollectionWrapper(CollectionWrapper value) {
        return new JAXBElement<CollectionWrapper>(_CollectionWrapper_QNAME, CollectionWrapper.class, null, value);
    }

    @XmlElementDecl(namespace = "", name = "collection")
    public JAXBElement<ProductsWrapper> createProduct(ProductsWrapper value) {
        return new JAXBElement<ProductsWrapper>(_ProductaWrapper_QNAME, ProductsWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "product")
    public JAXBElement<Product> createProduct(Product value) {
        return new JAXBElement<Product>(_Product_QNAME, Product.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "transport")
    public JAXBElement<Transport> createTransport(Transport value) {
        return new JAXBElement<Transport>(_Transport_QNAME, Transport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Campaign }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "campaign")
    public JAXBElement<Campaign> createCampaign(Campaign value) {
        return new JAXBElement<Campaign>(_Campaign_QNAME, Campaign.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Spectacle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "spectacle")
    public JAXBElement<Spectacle> createSpectacle(Spectacle value) {
        return new JAXBElement<Spectacle>(_Spectacle_QNAME, Spectacle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lodging }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "lodging")
    public JAXBElement<Lodging> createLodging(Lodging value) {
        return new JAXBElement<Lodging>(_Lodging_QNAME, Lodging.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link City }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "city")
    public JAXBElement<City> createCity(City value) {
        return new JAXBElement<City>(_City_QNAME, City.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Country }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "country")
    public JAXBElement<Country> createCountry(Country value) {
        return new JAXBElement<Country>(_Country_QNAME, Country.class, null, value);
    }

}
