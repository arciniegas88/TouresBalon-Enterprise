package co.com.touresbalon.foundation.transports.boundary;

import co.com.touresbalon.foundation.crosscutting.annotations.cache.CacheStore;
import co.com.touresbalon.foundation.transports.model.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private Cache<String,Object> cacheBolivariano;

    @Inject
    @CacheStore("aa-cache")
    private Cache<String,Object> cacheAa;

    @Inject
    @CacheStore("avianca-cache")
    private Cache<String,Object> cacheAvianca;

    //[constructor] --------------------------

    public TransportBoundary()
    {}


    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void confirmTravel( Long orderId, TravelProvider provider , List<TravelConfirmation> request ){

        String folder = null;

        switch ( provider ) {

            case AVIANCA: {
                folder = System.getProperty("touresbalon.transports.avianca.shared_directory");
                break;
            }
            case AMERICAN_AIRLINES: {
                folder = System.getProperty("touresbalon.transports.aa.shared_directory");
                break;
            }
            case BOLIVARIANO: {
                folder = System.getProperty("touresbalon.transports.bolivariano.shared_directory");
                break;
            }
            default:{
                logger.error("Invalid provider spicified");
                return;
            }
        }

        try{

            File outFile = FileUtils.getFile(folder + "/confirmations/touresbalon_orden_"+orderId+".csv");
            for ( TravelConfirmation c : request ){
                FileUtils.write(outFile, c.toString(), true);
            }

        }catch (IOException io) {
            logger.error("An internal server error has ocurred: " + io.getMessage(),io);
        }
    }


    //[service] --------------------------

    @Lock(LockType.WRITE)
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ReservationResponseMessage generateBolivarianoReservation( ReservationRequestMessage request ) {
        return generateReservation( cacheBolivariano,request );
    }


    //[service] --------------------------

    @Lock(LockType.WRITE)
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ReservationResponseMessage generateAAReservation( ReservationRequestMessage request ) {
        return generateReservation( cacheAa,request );
    }


    //[service] --------------------------

    @Lock(LockType.WRITE)
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ReservationResponseMessage generateAviancaReservation( ReservationRequestMessage request ) {
        return generateReservation( cacheAvianca,request );
    }

    @Lock(LockType.WRITE)
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void cancelAviancaReservation( Reservation reservation, Date travelDate ){
        cancelReservation( reservation,travelDate,cacheAvianca );
    }

    @Lock(LockType.WRITE)
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void cancelAAReservation( Reservation reservation, Date travelDate ){
        cancelReservation( reservation,travelDate,cacheAa );
    }

    @Lock(LockType.WRITE)
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void cancelBolivarianoReservation( Reservation reservation, Date travelDate ){
        cancelReservation( reservation,travelDate,cacheBolivariano );
    }

    public void cancelReservation( Reservation reservation, Date travelDate, Cache<String,Object> cache ){

        Iterator<Entry<String,Object>> iterator = cache.iterator();

        while( iterator.hasNext() ){

            Entry<String,Object> entry = iterator.next();

            if( StringUtils.equals( entry.getKey(), df.format( travelDate ) )){
                List<Reservation> data = (List<Reservation>) entry.getValue();
                data.add( reservation );
                cache.put( entry.getKey(), data );
            }
        }
    }

    public ReservationResponseMessage generateReservation(  Cache<String,Object> cache, ReservationRequestMessage request ) {

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

}
