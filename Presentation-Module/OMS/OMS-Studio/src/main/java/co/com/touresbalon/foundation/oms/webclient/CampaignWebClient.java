package co.com.touresbalon.foundation.oms.webclient;

import co.com.touresbalon.foundation.oms.domain.products.Campaign;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Jenny on 16/11/2015.
 */

@Path("/campaigns")
public interface CampaignWebClient {

    // [create service] -------------------------------
    @POST
    @Produces({MediaType.APPLICATION_XML})
    public void createCampaingn(Campaign campaign);


    // [update service] -------------------------------
    @PUT
    @Produces({MediaType.APPLICATION_XML})
    public void updateCampaingn(Campaign campaign);


    // [delete service] -------------------------------
    @DELETE
    @Path("/delete/{id}")
    public void deleteCampaingn(@PathParam("id") Long id);


    // [search campaign filter by name service] -------------------------------
    @GET
    @Path("/byIdProduct")
    @Consumes({ MediaType.APPLICATION_XML})
    public List<Campaign> searchCampaignByIdProduct(@QueryParam("idProduct") Long idProduct);


}
