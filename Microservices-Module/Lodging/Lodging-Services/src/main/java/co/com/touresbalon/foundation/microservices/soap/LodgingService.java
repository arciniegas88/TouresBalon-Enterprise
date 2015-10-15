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
public class LodgingService{

    @Inject
    private LodgingBoundary boundary;

    @WebMethod(operationName = "consultRoomsAvailability", action = "consultRoomsAvailability")
    public AvailabilityResType consultRoomsAvailability(@WebParam(name = "availabilityRequest")
                                                        AvailabilityReqType body) throws FaultMsg {
        AvailabilityResType response = new AvailabilityResType();

        co.com.touresbalon.foundation.microservices.entity.Room room = boundary.consultRoomsAvailability(body.getCheckIn(),
                body.getCheckOut(), body.getHotelBrand(), body.getCity());

        TouresbalonReservations reservation = boundary.doReservation(new Long(0), room.getHotelId(), room.getRoomNumber(), body.getGuestName(), body.getCheckIn(), body.getCheckOut());

        Room roomType = new Room();
        roomType.setHotelId(room.getHotelId());
        roomType.setPrice(room.getPrice());
        roomType.setRoomNumber(room.getRoomNumber());
        roomType.setType(room.getType());
        roomType.setReservationId(reservation.getReservationId());

        response.setRoom(roomType);

        return response;
    }

    @WebMethod(operationName = "doReservation", action = "doReservation")
    public DoReservationResType doReservation(
            @WebParam(name = "doReservationRequest")
            DoReservationReqType body) throws FaultMsg {

        TouresbalonReservations reservation = boundary.doReservation(body.getOrderId(), body.getHotelId(), body.getRoom(), body.getGuestName(),
                body.getCheckIn(), body.getCheckOut());

        TouresBalonReservation reservationType = new TouresBalonReservation(reservation);
        DoReservationResType response = new DoReservationResType();
        response.setTouresBalonReservation(reservationType);

        return response;
    }

    @WebMethod(operationName = "confirmReservation", action = "confirmReservation")
    public ConfirmReservationResType confirmReservation(
            @WebParam(name = "confirmReservationRequest")
            ConfirmReservationReqType body)
            throws FaultMsg {

        String result = boundary.updateReservation(body.getReservationId(), 1L);
        ConfirmReservationResType response = new ConfirmReservationResType(result);

        return response;
    }

    @WebMethod(operationName = "cancelReservation", action = "cancelReservation")
    public CancelReservationResType cancelReservation(
            @WebParam(name = "cancelReservationRequest")
            CancelReservationReqType body)
            throws FaultMsg {

        String result = boundary.updateReservation(body.getReservationId(), -1L);
        CancelReservationResType response = new CancelReservationResType(result);

        return response;
    }

    @WebMethod(operationName = "getReservation", action = "getReservation")
    public GetReservationResType getReservation(
            @WebParam(name = "getReservationRequest")
            GetReservationReqType body)
            throws FaultMsg{

        TouresbalonReservations reservation = boundary.getReservation(body.getReservationId());

        TouresBalonReservation touresBalonReservation = new TouresBalonReservation(reservation);
        GetReservationResType response = new GetReservationResType();
        response.setTouresBalonReservation(touresBalonReservation);

        return response;
    }
}
