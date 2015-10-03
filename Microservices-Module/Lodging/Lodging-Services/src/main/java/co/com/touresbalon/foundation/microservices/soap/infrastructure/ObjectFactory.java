
package co.com.touresbalon.foundation.microservices.soap.infrastructure;

import co.com.touresbalon.foundation.microservices.dto.soap.*;

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

    private final static QName _ConfirmReservationResponse_QNAME = new QName("http://touresbalon.com.co/task/lodging/schema/v1", "confirmReservationResponse");
    private final static QName _Room_QNAME = new QName("http://touresbalon.com.co/model/lodging/schema/v1", "room");
    private final static QName _GetReservationRequest_QNAME = new QName("http://touresbalon.com.co/task/lodging/schema/v1", "getReservationRequest");
    private final static QName _GetReservationResponse_QNAME = new QName("http://touresbalon.com.co/task/lodging/schema/v1", "getReservationResponse");
    private final static QName _CancelReservationResponse_QNAME = new QName("http://touresbalon.com.co/task/lodging/schema/v1", "cancelReservationResponse");
    private final static QName _CancelReservationRequest_QNAME = new QName("http://touresbalon.com.co/task/lodging/schema/v1", "cancelReservationRequest");
    private final static QName _TouresBalonReservation_QNAME = new QName("http://touresbalon.com.co/model/lodging/schema/v1", "touresBalonReservation");
    private final static QName _Hotel_QNAME = new QName("http://touresbalon.com.co/model/lodging/schema/v1", "hotel");
    private final static QName _DoReservationResponse_QNAME = new QName("http://touresbalon.com.co/task/lodging/schema/v1", "doReservationResponse");
    private final static QName _AvailabilityRequest_QNAME = new QName("http://touresbalon.com.co/task/lodging/schema/v1", "availabilityRequest");
    private final static QName _ConfirmReservationRequest_QNAME = new QName("http://touresbalon.com.co/task/lodging/schema/v1", "confirmReservationRequest");
    private final static QName _DoReservationRequest_QNAME = new QName("http://touresbalon.com.co/task/lodging/schema/v1", "doReservationRequest");
    private final static QName _AvailabilityResponse_QNAME = new QName("http://touresbalon.com.co/task/lodging/schema/v1", "availabilityResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.touresbalon.foundation.microservices.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConfirmReservationResType }
     * 
     */
    public ConfirmReservationResType createConfirmReservationResType() {
        return new ConfirmReservationResType();
    }

    /**
     * Create an instance of {@link CancelReservationResType }
     * 
     */
    public CancelReservationResType createCancelReservationResType() {
        return new CancelReservationResType();
    }

    /**
     * Create an instance of {@link CancelReservationReqType }
     * 
     */
    public CancelReservationReqType createCancelReservationReqType() {
        return new CancelReservationReqType();
    }

    /**
     * Create an instance of {@link ConfirmReservationReqType }
     * 
     */
    public ConfirmReservationReqType createConfirmReservationReqType() {
        return new ConfirmReservationReqType();
    }

    /**
     * Create an instance of {@link AvailabilityResType }
     * 
     */
    public AvailabilityResType createAvailabilityResType() {
        return new AvailabilityResType();
    }

    /**
     * Create an instance of {@link BusinessFault }
     * 
     */
    public BusinessFault createBusinessFault() {
        return new BusinessFault();
    }

    /**
     * Create an instance of {@link Room }
     * 
     */
    public Room createRoom() {
        return new Room();
    }

    /**
     * Create an instance of {@link GetReservationReqType }
     * 
     */
    public GetReservationReqType createGetReservationReqType() {
        return new GetReservationReqType();
    }

    /**
     * Create an instance of {@link GeneralResponse }
     * 
     */
    public GeneralResponse createGeneralResponse() {
        return new GeneralResponse();
    }

    /**
     * Create an instance of {@link TouresBalonReservation }
     * 
     */
    public TouresBalonReservation createTouresBalonReservation() {
        return new TouresBalonReservation();
    }

    /**
     * Create an instance of {@link DoReservationResType }
     * 
     */
    public DoReservationResType createDoReservationResType() {
        return new DoReservationResType();
    }

    /**
     * Create an instance of {@link AvailabilityReqType }
     * 
     */
    public AvailabilityReqType createAvailabilityReqType() {
        return new AvailabilityReqType();
    }

    /**
     * Create an instance of {@link DoReservationReqType }
     * 
     */
    public DoReservationReqType createDoReservationReqType() {
        return new DoReservationReqType();
    }

    /**
     * Create an instance of {@link SystemFault }
     * 
     */
    public SystemFault createSystemFault() {
        return new SystemFault();
    }

    /**
     * Create an instance of {@link EvaluationResponse }
     * 
     */
    public EvaluationResponse createEvaluationResponse() {
        return new EvaluationResponse();
    }

    /**
     * Create an instance of {@link GetReservationResType }
     * 
     */
    public GetReservationResType createGetReservationResType() {
        return new GetReservationResType();
    }

    /**
     * Create an instance of {@link RoomList }
     * 
     */
    public RoomList createRoomList() {
        return new RoomList();
    }

    /**
     * Create an instance of {@link CanonicalFault }
     * 
     */
    public CanonicalFault createCanonicalFault() {
        return new CanonicalFault();
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmReservationResType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://touresbalon.com.co/task/lodging/schema/v1", name = "confirmReservationResponse")
    public JAXBElement<ConfirmReservationResType> createConfirmReservationResponse(ConfirmReservationResType value) {
        return new JAXBElement<ConfirmReservationResType>(_ConfirmReservationResponse_QNAME, ConfirmReservationResType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Room }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://touresbalon.com.co/model/lodging/schema/v1", name = "room")
    public JAXBElement<Room> createRoom(Room value) {
        return new JAXBElement<Room>(_Room_QNAME, Room.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReservationReqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://touresbalon.com.co/task/lodging/schema/v1", name = "getReservationRequest")
    public JAXBElement<GetReservationReqType> createGetReservationRequest(GetReservationReqType value) {
        return new JAXBElement<GetReservationReqType>(_GetReservationRequest_QNAME, GetReservationReqType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReservationResType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://touresbalon.com.co/task/lodging/schema/v1", name = "getReservationResponse")
    public JAXBElement<GetReservationResType> createGetReservationResponse(GetReservationResType value) {
        return new JAXBElement<GetReservationResType>(_GetReservationResponse_QNAME, GetReservationResType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelReservationResType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://touresbalon.com.co/task/lodging/schema/v1", name = "cancelReservationResponse")
    public JAXBElement<CancelReservationResType> createCancelReservationResponse(CancelReservationResType value) {
        return new JAXBElement<CancelReservationResType>(_CancelReservationResponse_QNAME, CancelReservationResType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelReservationReqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://touresbalon.com.co/task/lodging/schema/v1", name = "cancelReservationRequest")
    public JAXBElement<CancelReservationReqType> createCancelReservationRequest(CancelReservationReqType value) {
        return new JAXBElement<CancelReservationReqType>(_CancelReservationRequest_QNAME, CancelReservationReqType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TouresBalonReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://touresbalon.com.co/model/lodging/schema/v1", name = "touresBalonReservation")
    public JAXBElement<TouresBalonReservation> createTouresBalonReservation(TouresBalonReservation value) {
        return new JAXBElement<TouresBalonReservation>(_TouresBalonReservation_QNAME, TouresBalonReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://touresbalon.com.co/model/lodging/schema/v1", name = "hotel")
    public JAXBElement<Hotel> createHotel(Hotel value) {
        return new JAXBElement<Hotel>(_Hotel_QNAME, Hotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoReservationResType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://touresbalon.com.co/task/lodging/schema/v1", name = "doReservationResponse")
    public JAXBElement<DoReservationResType> createDoReservationResponse(DoReservationResType value) {
        return new JAXBElement<DoReservationResType>(_DoReservationResponse_QNAME, DoReservationResType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AvailabilityReqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://touresbalon.com.co/task/lodging/schema/v1", name = "availabilityRequest")
    public JAXBElement<AvailabilityReqType> createAvailabilityRequest(AvailabilityReqType value) {
        return new JAXBElement<AvailabilityReqType>(_AvailabilityRequest_QNAME, AvailabilityReqType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmReservationReqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://touresbalon.com.co/task/lodging/schema/v1", name = "confirmReservationRequest")
    public JAXBElement<ConfirmReservationReqType> createConfirmReservationRequest(ConfirmReservationReqType value) {
        return new JAXBElement<ConfirmReservationReqType>(_ConfirmReservationRequest_QNAME, ConfirmReservationReqType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoReservationReqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://touresbalon.com.co/task/lodging/schema/v1", name = "doReservationRequest")
    public JAXBElement<DoReservationReqType> createDoReservationRequest(DoReservationReqType value) {
        return new JAXBElement<DoReservationReqType>(_DoReservationRequest_QNAME, DoReservationReqType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AvailabilityResType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://touresbalon.com.co/task/lodging/schema/v1", name = "availabilityResponse")
    public JAXBElement<AvailabilityResType> createAvailabilityResponse(AvailabilityResType value) {
        return new JAXBElement<AvailabilityResType>(_AvailabilityResponse_QNAME, AvailabilityResType.class, null, value);
    }

}
