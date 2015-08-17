package co.com.touresbalon.foundation.products.rest;

import co.com.touresbalon.foundation.products.boundary.CampaignBoundary;
import co.com.touresbalon.foundation.products.entity.Campaign;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by gustavo on 17/08/15.
 */
@Path("/campaigns")
public class CampaignResource {

    @Inject
    private CampaignBoundary boundary;

    public CampaignResource(){

    }

    // [search all Campaigns] -------------------------------

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Campaign> searchProducts() {
        return boundary.searchCampaign();
    }
}
