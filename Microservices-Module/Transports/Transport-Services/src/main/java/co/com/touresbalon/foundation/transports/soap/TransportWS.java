package co.com.touresbalon.foundation.transports.soap;

import co.com.touresbalon.foundation.transports.boundary.TransportBoundary;
import co.com.touresbalon.foundation.transports.model.ReservationRequestMessage;
import co.com.touresbalon.foundation.transports.model.ReservationResponseMessage;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by garciniegas on 21/08/2015.
 */

@WebService(targetNamespace = "http://touresbalon.com.co/transport/service/task/1.0.0")
public class TransportWS {

    @Inject
    private TransportBoundary boundary;

    //[service] --------------------------

    @WebMethod(operationName = "generateReservation",action = "generateReservation")
    public ReservationResponseMessage generateReservation( @WebParam(name = "request") ReservationRequestMessage request ){

        switch ( request.getProvider() ){

            case AVIANCA:{
                return boundary.generateAviancaReservation( request );
            }
            case AMERICAN_AIRLINES:{

            }
            case BOLIVARIANO:{
                return boundary.generateBolivarianoReservation(request);
            }
            default :{
                return boundary.generateBolivarianoReservation(request);
            }
        }
    }

}
