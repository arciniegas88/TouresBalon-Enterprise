package co.com.touresbalon.foundation.oms.webclient;

import co.com.touresbalon.foundation.oms.domain.products.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by garciniegas on 12/10/2015.
 */

@Path("/partnerServices")
public interface PartnerServicesWebClient {


    @GET
    @Path("/transports")
    @Consumes(MediaType.APPLICATION_XML)
    List<Transport> getTransports();


    @GET
    @Path("/spectacles")
    @Consumes(MediaType.APPLICATION_XML)
    List<Spectacle> getSpectacles();


    @GET
    @Path("/lodging")
    @Consumes(MediaType.APPLICATION_XML)
    List<Lodging> getLodging();


    @GET
    @Path("/countries")
    @Consumes(MediaType.APPLICATION_XML)
    List<Country> getCountries();

    @GET
    @Path("/cities")
    @Consumes(MediaType.APPLICATION_XML)
    List<City> getCitiesByContry( @QueryParam("country") Integer country );

}
