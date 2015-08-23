package co.com.touresbalon.foundation.transports.boundary;

import co.com.touresbalon.foundation.transports.control.AviancaReservationExecutor;
import co.com.touresbalon.foundation.transports.control.BolivarianoReservationExecutor;
import co.com.touresbalon.foundation.transports.control.ReservationExecutor;
import co.com.touresbalon.foundation.transports.model.ReservationRequestMessage;
import co.com.touresbalon.foundation.transports.model.ReservationResponseMessage;
import co.com.touresbalon.foundation.transports.soap.TransportWS;
import org.slf4j.Logger;

import javax.ejb.*;
import javax.inject.Inject;
import javax.jws.WebService;

/**
 * Created by garciniegas on 19/08/2015.
 */

@Singleton
@WebService(endpointInterface = "co.com.touresbalon.foundation.transports.soap.TransportWS")
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class TransportBoundary implements TransportWS {

    //[attributes] --------------------------

    @Inject
    private Logger logger;
    @Inject
    private BolivarianoReservationExecutor bolivarianoExecutor;
    @Inject
    private AviancaReservationExecutor aviancaExecutor;

    //[constructor] --------------------------

    public TransportBoundary()
    {}


    //[service] --------------------------

    @Override
    @Lock(LockType.WRITE)
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ReservationResponseMessage generateReservation( ReservationRequestMessage request ) {

        ReservationExecutor executor = null;

        switch ( request.getProvider() ){

            case AVIANCA:{
                executor = aviancaExecutor;
                break;
            }
            case BOLIVARIANO:{
                executor = bolivarianoExecutor;
                break;
            }
        }

        return executor.generateReservation( request );
    }
}
