package co.com.touresbalon.foundation.transports.control;

import co.com.touresbalon.foundation.transports.model.ReservationRequestMessage;
import co.com.touresbalon.foundation.transports.model.ReservationResponseMessage;

/**
 * Created by garciniegas on 21/08/2015.
 */
public interface ReservationExecutor {

    ReservationResponseMessage generateReservation( ReservationRequestMessage request );

}
