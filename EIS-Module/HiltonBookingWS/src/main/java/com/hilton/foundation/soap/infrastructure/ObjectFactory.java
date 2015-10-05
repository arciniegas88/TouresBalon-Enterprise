
package com.hilton.foundation.soap.infrastructure;

import com.hilton.foundation.dto.soap.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hilton.foundation.dto.soap package. 
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

    private final static QName _GetReservationResponse_QNAME = new QName("http://hilton.com/enterprise/booking/schema/v1", "getReservationResponse");
    private final static QName _GetReservationRequest_QNAME = new QName("http://hilton.com/enterprise/booking/schema/v1", "getReservationRequest");
    private final static QName _ConfirmRoomRequest_QNAME = new QName("http://hilton.com/enterprise/booking/schema/v1", "confirmRoomRequest");
    private final static QName _CancelRoomRequest_QNAME = new QName("http://hilton.com/enterprise/booking/schema/v1", "cancelRoomRequest");
    private final static QName _Hotel_QNAME = new QName("http://hilton.com/model/booking/schema/v1", "hotel");
    private final static QName _TouresBalonReservation_QNAME = new QName("http://hilton.com/model/booking/schema/v1", "touresBalonReservation");
    private final static QName _CancelRoomResponse_QNAME = new QName("http://hilton.com/enterprise/booking/schema/v1", "cancelRoomResponse");
    private final static QName _ConsultAvailabilityRequest_QNAME = new QName("http://hilton.com/enterprise/booking/schema/v1", "consultAvailabilityRequest");
    private final static QName _ConsultAvailabilityResponse_QNAME = new QName("http://hilton.com/enterprise/booking/schema/v1", "consultAvailabilityResponse");
    private final static QName _Room_QNAME = new QName("http://hilton.com/model/booking/schema/v1", "room");
    private final static QName _ConfirmRoomResponse_QNAME = new QName("http://hilton.com/enterprise/booking/schema/v1", "confirmRoomResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hilton.foundation.dto.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetReservationResType }
     * 
     */
    public GetReservationResType createGetReservationResType() {
        return new GetReservationResType();
    }

    /**
     * Create an instance of {@link ConsultAvailabilityReqType }
     * 
     */
    public ConsultAvailabilityReqType createConsultAvailabilityReqType() {
        return new ConsultAvailabilityReqType();
    }

    /**
     * Create an instance of {@link GeneralResponse }
     * 
     */
    public GeneralResponse createGeneralResponse() {
        return new GeneralResponse();
    }

    /**
     * Create an instance of {@link CancelRoomResType }
     * 
     */
    public CancelRoomResType createCancelRoomResType() {
        return new CancelRoomResType();
    }

    /**
     * Create an instance of {@link ConsultAvailabilityResType }
     * 
     */
    public ConsultAvailabilityResType createConsultAvailabilityResType() {
        return new ConsultAvailabilityResType();
    }

    /**
     * Create an instance of {@link GetReservationReqType }
     * 
     */
    public GetReservationReqType createGetReservationReqType() {
        return new GetReservationReqType();
    }

    /**
     * Create an instance of {@link Room }
     * 
     */
    public Room createRoom() {
        return new Room();
    }

    /**
     * Create an instance of {@link CanonicalFault }
     * 
     */
    public CanonicalFault createCanonicalFault() {
        return new CanonicalFault();
    }

    /**
     * Create an instance of {@link BusinessFault }
     * 
     */
    public BusinessFault createBusinessFault() {
        return new BusinessFault();
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link EvaluationResponse }
     * 
     */
    public EvaluationResponse createEvaluationResponse() {
        return new EvaluationResponse();
    }

    /**
     * Create an instance of {@link ConfirmRoomReqType }
     * 
     */
    public ConfirmRoomReqType createConfirmRoomReqType() {
        return new ConfirmRoomReqType();
    }

    /**
     * Create an instance of {@link SystemFault }
     * 
     */
    public SystemFault createSystemFault() {
        return new SystemFault();
    }

    /**
     * Create an instance of {@link ConfirmRoomResType }
     * 
     */
    public ConfirmRoomResType createConfirmRoomResType() {
        return new ConfirmRoomResType();
    }

    /**
     * Create an instance of {@link RoomList }
     * 
     */
    public RoomList createRoomList() {
        return new RoomList();
    }

    /**
     * Create an instance of {@link CancelRoomReqType }
     * 
     */
    public CancelRoomReqType createCancelRoomReqType() {
        return new CancelRoomReqType();
    }

    /**
     * Create an instance of {@link TouresBalonReservation }
     * 
     */
    public TouresBalonReservation createTouresBalonReservation() {
        return new TouresBalonReservation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReservationResType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hilton.com/enterprise/booking/schema/v1", name = "getReservationResponse")
    public JAXBElement<GetReservationResType> createGetReservationResponse(GetReservationResType value) {
        return new JAXBElement<GetReservationResType>(_GetReservationResponse_QNAME, GetReservationResType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReservationReqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hilton.com/enterprise/booking/schema/v1", name = "getReservationRequest")
    public JAXBElement<GetReservationReqType> createGetReservationRequest(GetReservationReqType value) {
        return new JAXBElement<GetReservationReqType>(_GetReservationRequest_QNAME, GetReservationReqType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmRoomReqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hilton.com/enterprise/booking/schema/v1", name = "confirmRoomRequest")
    public JAXBElement<ConfirmRoomReqType> createConfirmRoomRequest(ConfirmRoomReqType value) {
        return new JAXBElement<ConfirmRoomReqType>(_ConfirmRoomRequest_QNAME, ConfirmRoomReqType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelRoomReqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hilton.com/enterprise/booking/schema/v1", name = "cancelRoomRequest")
    public JAXBElement<CancelRoomReqType> createCancelRoomRequest(CancelRoomReqType value) {
        return new JAXBElement<CancelRoomReqType>(_CancelRoomRequest_QNAME, CancelRoomReqType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hotel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hilton.com/model/booking/schema/v1", name = "hotel")
    public JAXBElement<Hotel> createHotel(Hotel value) {
        return new JAXBElement<Hotel>(_Hotel_QNAME, Hotel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TouresBalonReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hilton.com/model/booking/schema/v1", name = "touresBalonReservation")
    public JAXBElement<TouresBalonReservation> createTouresBalonReservation(TouresBalonReservation value) {
        return new JAXBElement<TouresBalonReservation>(_TouresBalonReservation_QNAME, TouresBalonReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelRoomResType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hilton.com/enterprise/booking/schema/v1", name = "cancelRoomResponse")
    public JAXBElement<CancelRoomResType> createCancelRoomResponse(CancelRoomResType value) {
        return new JAXBElement<CancelRoomResType>(_CancelRoomResponse_QNAME, CancelRoomResType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultAvailabilityReqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hilton.com/enterprise/booking/schema/v1", name = "consultAvailabilityRequest")
    public JAXBElement<ConsultAvailabilityReqType> createConsultAvailabilityRequest(ConsultAvailabilityReqType value) {
        return new JAXBElement<ConsultAvailabilityReqType>(_ConsultAvailabilityRequest_QNAME, ConsultAvailabilityReqType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultAvailabilityResType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hilton.com/enterprise/booking/schema/v1", name = "consultAvailabilityResponse")
    public JAXBElement<ConsultAvailabilityResType> createConsultAvailabilityResponse(ConsultAvailabilityResType value) {
        return new JAXBElement<ConsultAvailabilityResType>(_ConsultAvailabilityResponse_QNAME, ConsultAvailabilityResType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Room }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hilton.com/model/booking/schema/v1", name = "room")
    public JAXBElement<Room> createRoom(Room value) {
        return new JAXBElement<Room>(_Room_QNAME, Room.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmRoomResType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hilton.com/enterprise/booking/schema/v1", name = "confirmRoomResponse")
    public JAXBElement<ConfirmRoomResType> createConfirmRoomResponse(ConfirmRoomResType value) {
        return new JAXBElement<ConfirmRoomResType>(_ConfirmRoomResponse_QNAME, ConfirmRoomResType.class, null, value);
    }

}
