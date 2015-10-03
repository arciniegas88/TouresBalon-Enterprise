package co.com.touresbalon.foundation.microservices.soap;

import co.com.touresbalon.foundation.microservices.boundary.LodgingBoundary;
import co.com.touresbalon.foundation.microservices.dto.soap.*;
import co.com.touresbalon.foundation.microservices.entity.TouresbalonReservations;
import co.com.touresbalon.foundation.microservices.soap.infrastructure.LodgingPort;
import co.com.touresbalon.foundation.microservices.soap.infrastructure.ObjectFactory;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Created by harcalejo on 2/10/15.
 */
@WebService(name = "LodgingPort", targetNamespace = "http://touresbalon.com.co/task/lodging/v1")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class LodgingService implements LodgingPort {

    @Inject
    private LodgingBoundary boundary;

    @Override
    @WebMethod
    @WebResult(name = "availabilityResponse", targetNamespace = "http://touresbalon.com.co/task/lodging/schema/v1", partName = "body")
    public AvailabilityResType consultRoomsAvailability(@WebParam(name = "availabilityRequest",
            targetNamespace = "http://touresbalon.com.co/task/lodging/schema/v1", partName = "body")
                                                        AvailabilityReqType body) throws FaultMsg {
        AvailabilityResType response = new AvailabilityResType();

        co.com.touresbalon.foundation.microservices.entity.Room room = boundary.consultRoomsAvailability(body.getCheckIn(),
                body.getCheckOut(), body.getHotelBrand(), body.getCity());
        Room roomType = new Room();
        roomType.setHotelId(room.getHotelId());
        roomType.setPrice(room.getPrice());
        roomType.setRoomNumber(room.getRoomNumber());
        roomType.setType(room.getType());

        response.setRoom(roomType);

        return response;
    }

    @Override
    @WebMethod
    @WebResult(name = "doReservationResponse", targetNamespace = "http://touresbalon.com.co/task/lodging/schema/v1", partName = "body")
    public DoReservationResType doReservation(
            @WebParam(name = "doReservationRequest", targetNamespace = "http://touresbalon.com.co/task/lodging/schema/v1", partName = "body")
            DoReservationReqType body) throws FaultMsg {

        TouresbalonReservations reservation = boundary.doReservation(body.getOrderId(), body.getHotelId(), body.getRoom(), body.getGuestName(),
                body.getCheckIn(), body.getCheckOut());

        TouresBalonReservation reservationType = new TouresBalonReservation(reservation);
        DoReservationResType response = new DoReservationResType();
        response.setTouresBalonReservation(reservationType);

        return response;
    }

    @Override
    @WebMethod
    @WebResult(name = "confirmReservationResponse", targetNamespace = "http://touresbalon.com.co/task/lodging/schema/v1", partName = "body")
    public ConfirmReservationResType confirmReservation(
            @WebParam(name = "confirmReservationRequest", targetNamespace = "http://touresbalon.com.co/task/lodging/schema/v1", partName = "body")
            ConfirmReservationReqType body)
            throws FaultMsg {

        String result = boundary.updateReservation(body.getReservationId(), 1L);
        ConfirmReservationResType response = new ConfirmReservationResType(result);

        return response;
    }

    @Override
    @WebMethod
    @WebResult(name = "cancelReservationResponse", targetNamespace = "http://touresbalon.com.co/task/lodging/schema/v1", partName = "body")
    public CancelReservationResType cancelReservation(
            @WebParam(name = "cancelReservationRequest", targetNamespace = "http://touresbalon.com.co/task/lodging/schema/v1", partName = "body")
            CancelReservationReqType body)
            throws FaultMsg {

        String result = boundary.updateReservation(body.getReservationId(), -1L);
        CancelReservationResType response = new CancelReservationResType(result);

        return response;
    }

    @Override
    @WebMethod
    @WebResult(name = "getReservationResponse", targetNamespace = "http://touresbalon.com.co/task/lodging/schema/v1", partName = "body")
    public GetReservationResType getReservation(
            @WebParam(name = "getReservationRequest", targetNamespace = "http://touresbalon.com.co/task/lodging/schema/v1", partName = "body")
            GetReservationReqType body)
            throws FaultMsg{

        TouresbalonReservations reservation = boundary.getReservation(body.getReservationId());

        TouresBalonReservation touresBalonReservation = new TouresBalonReservation(reservation);
        GetReservationResType response = new GetReservationResType();
        response.setTouresBalonReservation(touresBalonReservation);

        return response;
    }
}
