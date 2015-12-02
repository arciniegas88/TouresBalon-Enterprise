
package co.com.touresbalon.foundation.oms.domain.customers;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.touresbalon.foundation.microservices.soap package. 
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

    private final static QName _GetCustomerResponse_QNAME = new QName("", "getCustomerResponse");
    private final static QName _CountCustomersResponse_QNAME = new QName("", "countCustomersResponse");
    private final static QName _GetCustomersResponse_QNAME = new QName("", "getCustomersResponse");
    private final static QName _CreateCustomer_QNAME = new QName("", "createCustomer");
    private final static QName _UpdateCustomerResponse_QNAME = new QName("", "updateCustomerResponse");
    private final static QName _DeleteCustomerResponse_QNAME = new QName("", "deleteCustomerResponse");
    private final static QName _UpdateCustomer_QNAME = new QName("", "updateCustomer");
    private final static QName _GetCustomerByEmailResponse_QNAME = new QName("", "getCustomerByEmailResponse");
    private final static QName _CreateCustomerResponse_QNAME = new QName("", "createCustomerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.touresbalon.foundation.microservices.soap
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerResponseType }
     *
     */
    public CustomerResponseType createCustomerResponseType() {
        return new CustomerResponseType();
    }

    /**
     * Create an instance of {@link CustomersResponseType }
     *
     */
    public CustomersResponseType createCustomersResponseType() {
        return new CustomersResponseType();
    }

    /**
     * Create an instance of {@link CountCustomersResponseType }
     *
     */
    public CountCustomersResponseType createCountCustomersResponseType() {
        return new CountCustomersResponseType();
    }

    /**
     * Create an instance of {@link CreateCustomerType }
     *
     */
    public CreateCustomerType createCreateCustomerType() {
        return new CreateCustomerType();
    }

    /**
     * Create an instance of {@link UpdateCustomerResponseType }
     *
     */
    public UpdateCustomerResponseType createUpdateCustomerResponseType() {
        return new UpdateCustomerResponseType();
    }

    /**
     * Create an instance of {@link DeleteCustomerResponseType }
     *
     */
    public DeleteCustomerResponseType createDeleteCustomerResponseType() {
        return new DeleteCustomerResponseType();
    }

    /**
     * Create an instance of {@link UpdateCustomerType }
     *
     */
    public UpdateCustomerType createUpdateCustomerType() {
        return new UpdateCustomerType();
    }

    /**
     * Create an instance of {@link CustomerByEmailResponseType }
     *
     */
    public CustomerByEmailResponseType createCustomerByEmailResponseType() {
        return new CustomerByEmailResponseType();
    }

    /**
     * Create an instance of {@link CreateCustomerResponseType }
     *
     */
    public CreateCustomerResponseType createCreateCustomerResponseType() {
        return new CreateCustomerResponseType();
    }

    /**
     * Create an instance of {@link CreateCustomerResultType }
     *
     */
    public CreateCustomerResultType createCreateCustomerResultType() {
        return new CreateCustomerResultType();
    }

    /**
     * Create an instance of {@link CustomerType }
     *
     */
    public CustomerType createCustomerType() {
        return new CustomerType();
    }

    /**
     * Create an instance of {@link AddressType }
     *
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link CustomersResultType }
     *
     */
    public CustomersResultType createCustomersResultType() {
        return new CustomersResultType();
    }

    /**
     * Create an instance of {@link GeneralResponseType }
     *
     */
    public GeneralResponseType createGeneralResponseType() {
        return new GeneralResponseType();
    }

    /**
     * Create an instance of {@link AddressArrayType }
     *
     */
    public AddressArrayType createAddressArrayType() {
        return new AddressArrayType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "getCustomerResponse")
    public JAXBElement<CustomerResponseType> createGetCustomerResponse(CustomerResponseType value) {
        return new JAXBElement<CustomerResponseType>(_GetCustomerResponse_QNAME, CustomerResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountCustomersResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "countCustomersResponse")
    public JAXBElement<CountCustomersResponseType> createCountCustomersResponse(CountCustomersResponseType value) {
        return new JAXBElement<CountCustomersResponseType>(_CountCustomersResponse_QNAME, CountCustomersResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomersResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "getCustomersResponse")
    public JAXBElement<CustomersResponseType> createGetCustomersResponse(CustomersResponseType value) {
        return new JAXBElement<CustomersResponseType>(_GetCustomersResponse_QNAME, CustomersResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCustomerType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "createCustomer")
    public JAXBElement<CreateCustomerType> createCreateCustomer(CreateCustomerType value) {
        return new JAXBElement<CreateCustomerType>(_CreateCustomer_QNAME, CreateCustomerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCustomerResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "updateCustomerResponse")
    public JAXBElement<UpdateCustomerResponseType> createUpdateCustomerResponse(UpdateCustomerResponseType value) {
        return new JAXBElement<UpdateCustomerResponseType>(_UpdateCustomerResponse_QNAME, UpdateCustomerResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCustomerResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "deleteCustomerResponse")
    public JAXBElement<DeleteCustomerResponseType> createDeleteCustomerResponse(DeleteCustomerResponseType value) {
        return new JAXBElement<DeleteCustomerResponseType>(_DeleteCustomerResponse_QNAME, DeleteCustomerResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCustomerType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "updateCustomer")
    public JAXBElement<UpdateCustomerType> createUpdateCustomer(UpdateCustomerType value) {
        return new JAXBElement<UpdateCustomerType>(_UpdateCustomer_QNAME, UpdateCustomerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerByEmailResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "getCustomerByEmailResponse")
    public JAXBElement<CustomerByEmailResponseType> createGetCustomerByEmailResponse(CustomerByEmailResponseType value) {
        return new JAXBElement<CustomerByEmailResponseType>(_GetCustomerByEmailResponse_QNAME, CustomerByEmailResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCustomerResponseType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "createCustomerResponse")
    public JAXBElement<CreateCustomerResponseType> createCreateCustomerResponse(CreateCustomerResponseType value) {
        return new JAXBElement<CreateCustomerResponseType>(_CreateCustomerResponse_QNAME, CreateCustomerResponseType.class, null, value);
    }

}
