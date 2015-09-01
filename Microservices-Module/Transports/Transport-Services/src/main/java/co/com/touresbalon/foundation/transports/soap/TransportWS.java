package co.com.touresbalon.foundation.transports.soap;

import co.com.touresbalon.foundation.transports.boundary.TransportBoundary;
import co.com.touresbalon.foundation.transports.model.*;

import javax.inject.Inject;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

/**
 * Created by garciniegas on 21/08/2015.
 */

@WebService(targetNamespace = "http://touresbalon.com.co/transport/service/task/1.0.0")
public class TransportWS {

    @Inject
    private TransportBoundary boundary;

    //[service] --------------------------

    @Oneway
    @WebMethod(operationName = "cancelReservation", action = "cancelReservation")
    public void cancelReservation(@WebParam(name = "reservation") Reservation reservation,
                                  @WebParam(name = "travelDate") Date travelDate,
                                  @WebParam(name = "provider") TravelProvider provider) {

        switch (provider) {

            case AVIANCA: {
                boundary.cancelAviancaReservation(reservation, travelDate);
            }
            case AMERICAN_AIRLINES: {
                boundary.cancelAAReservation(reservation, travelDate);
            }
            case BOLIVARIANO: {
                boundary.cancelBolivarianoReservation(reservation, travelDate);
            }
        }
    }

    //[service] --------------------------

    @Oneway
    @WebMethod(operationName = "confirmTravel", action = "confirmTravel")
    public void confirmTravel(@WebParam(name = "orderId") Long orderId,
                              @WebParam(name = "confirmations") List<TravelConfirmation> confirmations) {
        boundary.confirmTravel(orderId, confirmations);
    }

    //[service] --------------------------

    @WebMethod(operationName = "generateReservation", action = "generateReservation")
    public ReservationResponseMessage generateReservation(@WebParam(name = "request") ReservationRequestMessage request) {

        switch (request.getProvider()) {

            case AVIANCA: {
                return boundary.generateAviancaReservation(request);
            }
            case AMERICAN_AIRLINES: {
                return boundary.generateAAReservation(request);
            }
            case BOLIVARIANO: {
                return boundary.generateBolivarianoReservation(request);
            }
            default: {

                ReservationResponseMessage response = new ReservationResponseMessage();
                response.setAvailable(false);
                response.setDescription("Invalid provider spicified");

                return response;
            }
        }
    }

}
