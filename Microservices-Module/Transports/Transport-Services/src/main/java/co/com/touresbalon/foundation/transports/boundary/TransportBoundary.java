package co.com.touresbalon.foundation.transports.boundary;

import co.com.touresbalon.foundation.crosscutting.annotations.cache.CacheStore;
import co.com.touresbalon.foundation.transports.model.Reservation;
import co.com.touresbalon.foundation.transports.model.ReservationRequestMessage;
import co.com.touresbalon.foundation.transports.model.ReservationResponseMessage;
import org.slf4j.Logger;

import java.util.Iterator;
import java.util.List;

import static javax.cache.Cache.Entry;
import javax.cache.Cache;
import javax.ejb.*;
import javax.inject.Inject;

/**
 * Created by garciniegas on 19/08/2015.
 */

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class TransportBoundary {

    //[attributes] --------------------------

    @Inject
    private Logger logger;

    @Inject
    @CacheStore("bolivariano-cache")
    private Cache<String,Object> cache;

    //[constructor] --------------------------

    public TransportBoundary()
    {}


    //[service] --------------------------

    @Lock(LockType.WRITE)
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ReservationResponseMessage generateBolivarianoReservation( ReservationRequestMessage request ) {

        ReservationResponseMessage response = new ReservationResponseMessage();
        response.setAvailable(false);


        Iterator<Entry<String,Object>> iterator = cache.iterator();

        while( iterator.hasNext() ){
            Entry<String,Object> entry = iterator.next();
            List<Reservation> list = (List<Reservation>) entry.getValue();

            for( Reservation r: list ){
                System.out.println( r );
            }

        }

        return response;
    }


    //[service] --------------------------

    @Lock(LockType.WRITE)
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ReservationResponseMessage generateAviancaReservation( ReservationRequestMessage request ) {

        ReservationResponseMessage response = new ReservationResponseMessage();
        response.setAvailable(false);

        return response;
    }
}
