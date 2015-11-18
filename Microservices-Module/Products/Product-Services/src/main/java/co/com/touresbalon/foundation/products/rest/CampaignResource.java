package co.com.touresbalon.foundation.products.rest;

import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import co.com.touresbalon.foundation.products.boundary.CampaignBoundary;
import co.com.touresbalon.foundation.products.entity.Campaign;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Jenny Rodriguez on 17/08/15.
 */
@Path("/campaigns")
public class CampaignResource {

    @Inject
    private CampaignBoundary boundary;

    public CampaignResource() {

    }

    // [search all Campaigns] -------------------------------

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Campaign> searchProducts() throws SystemException {
        return boundary.searchCampaign();
    }

    // [create service] -------------------------------

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    public void createCampaingn(Campaign campaign) throws SystemException {
        boundary.createCampaingn(campaign);
    }

    // [update service] -------------------------------

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void updateCampaingn(Campaign campaign) throws SystemException {
        boundary.updateCampaingn(campaign);
    }

    // [delete service] -------------------------------

    @DELETE
    @Path("/{id}")
    public void deleteCampaingn(@PathParam("id") Long id) throws SystemException {
        boundary.deleteCampaingn(id);
    }

    // [search campaign filter by name service] -------------------------------
    @GET
    @Path("/byIdProduct")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Campaign> searchCampaignByIdProduct(@QueryParam("idProduct") Long idProduct)  throws SystemException {
        return boundary.searchCampaignByIdProduct(idProduct);
    }

}
