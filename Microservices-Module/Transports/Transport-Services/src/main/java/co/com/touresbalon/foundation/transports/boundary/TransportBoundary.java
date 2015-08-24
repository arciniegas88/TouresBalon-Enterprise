package co.com.touresbalon.foundation.transports.boundary;

import co.com.touresbalon.foundation.crosscutting.annotations.cache.CacheStore;
import co.com.touresbalon.foundation.transports.model.Reservation;
import co.com.touresbalon.foundation.transports.model.ReservationRequestMessage;
import co.com.touresbalon.foundation.transports.model.ReservationResponseMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.text.SimpleDateFormat;
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

    private SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");

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
        response.setDescription("No chairs available");

        Iterator<Entry<String,Object>> iterator = cache.iterator();

        while( iterator.hasNext() ){
            Entry<String,Object> entry = iterator.next();

            if( StringUtils.equals( entry.getKey(), df.format( request.getDate() ) )){

                List<Reservation> data = (List<Reservation>) entry.getValue();
                Iterator<Reservation> iteratorRes = data.iterator();

                while( iteratorRes.hasNext() )
                {
                    Reservation r = iteratorRes.next();
                    if( r.isEqualsTo( request.getSourceCity(),request.getTargetCity(), request.getTime() ) )
                    {
                        iteratorRes.remove();
                        response.setAvailable(true);
                        response.setTravelNumber(r.getTravelNumber());
                        response.setChairNumber(r.getChairNumber());
                        response.setDescription("Reservation executed ok");
                        cache.put( entry.getKey(),data );
                        return response;
                    }
                }

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
