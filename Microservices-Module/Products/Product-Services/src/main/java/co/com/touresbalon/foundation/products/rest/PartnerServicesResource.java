package co.com.touresbalon.foundation.products.rest;

import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import co.com.touresbalon.foundation.products.boundary.PartnerServicesBoundary;
import co.com.touresbalon.foundation.products.entity.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by garciniegas on 11/10/2015.
 */

@Path("/partnerServices")
public class PartnerServicesResource {

    @Inject
    private PartnerServicesBoundary boundary;

    @GET
    @Path("/transports")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Transport> getTransports() throws SystemException{
        return boundary.getTransports();
    }


    @GET
    @Path("/spectacles")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Spectacle> getSpectacles() throws SystemException{
        return boundary.getSpectacles();
    }


    @GET
    @Path("/lodging")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Lodging> getLodging() throws SystemException{
        return boundary.getLodging();
    }


    @GET
    @Path("/countries")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Country> getCountries() throws SystemException{
        return boundary.getCountries();
    }


    @GET
    @Path("/cities")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<City> getCitiesByContry( @QueryParam("country") Integer country ) throws SystemException{
        return boundary.getCitiesByContry(country);
    }


}
