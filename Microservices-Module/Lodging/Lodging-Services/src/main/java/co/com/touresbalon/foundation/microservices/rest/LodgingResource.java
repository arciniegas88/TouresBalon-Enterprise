package co.com.touresbalon.foundation.microservices.rest;

import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import co.com.touresbalon.foundation.microservices.boundary.LodgingBoundary;
import co.com.touresbalon.foundation.microservices.entity.Room;
import co.com.touresbalon.foundation.microservices.entity.TouresbalonReservations;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * Created by harcalejo on 23/09/15.
 */

@Path("/lodging")
public class LodgingResource {

    @Context
    private HttpHeaders headers;

    @Inject
    private LodgingBoundary boundary;

    public LodgingResource() {

    }

//    @GET
//    @Path("/roomsAviability")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Room consultRoomsAviability(@QueryParam("hotelBrand") String hotelBrand,
//                                       @QueryParam("checkIn") String checkIn,
//                                       @QueryParam("checkOut") String checkOut,
//                                       @QueryParam("city") String city) throws SystemException {
//
//        return boundary.consultRoomsAviability(hotelBrand, city, checkIn, checkOut);
//    }

//    @GET
//    @Path("/doReservation")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public TouresbalonReservations doReservation(@QueryParam("orderId") Long orderId,
//                              @QueryParam("hotelId") Long hotelId,
//                              @QueryParam("room") Long room,
//                              @QueryParam("name") String name,
//                              @QueryParam("checkIn") String checkIn,
//                              @QueryParam("checkOut") String checkOut) throws SystemException {
//
//        return boundary.doReservation(orderId, hotelId, room, name, checkIn, checkOut);
//    }

//    @GET
//    @Path("/confirmReservation/{reservationId}")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public String confirmReservation(@PathParam("reservationId") Long reservationId) throws SystemException {
//
//        return boundary.updateReservation(reservationId, 1L);
//    }

//    @GET
//    @Path("/cancelReservation/{reservationId}")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public String cancelReservation(@PathParam("reservationId") Long reservationId) throws SystemException {
//
//        return boundary.updateReservation(reservationId, -1L);
//    }

//    @GET
//    @Path("/getReservation/{reservationId}")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public TouresbalonReservations getReservation(@PathParam("reservationId") Long reservationId) throws SystemException {
//
//        return boundary.getReservation(reservationId);
//    }
}
