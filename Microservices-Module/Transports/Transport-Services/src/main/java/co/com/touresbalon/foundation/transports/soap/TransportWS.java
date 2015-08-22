package co.com.touresbalon.foundation.transports.soap;

import co.com.touresbalon.foundation.transports.model.ReservationRequestMessage;
import co.com.touresbalon.foundation.transports.model.ReservationResponseMessage;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by garciniegas on 21/08/2015.
 */

@WebService(targetNamespace = "http://touresbalon")
public interface TransportWS {

    //[service] --------------------------

    @WebMethod(operationName = "generateReservation",action = "generateReservation")
    ReservationResponseMessage generateReservation( @WebParam(name = "request") ReservationRequestMessage request );

}
