package co.com.touresbalon.foundation.transports.control;

import co.com.touresbalon.foundation.transports.model.ReservationRequestMessage;
import co.com.touresbalon.foundation.transports.model.ReservationResponseMessage;
import org.slf4j.Logger;

import javax.inject.Inject;

/**
 * Created by garciniegas on 21/08/2015.
 */
public class AviancaReservationExecutor implements ReservationExecutor {

    @Inject
    private Logger logger;

    @Override
    public ReservationResponseMessage generateReservation(ReservationRequestMessage request) {
        return null;
    }

}
