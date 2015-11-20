package co.com.touresbalon.foundation.oms.usecases.campaingnadmin;

import co.com.touresbalon.foundation.oms.domain.products.Campaign;
import co.com.touresbalon.foundation.oms.domain.products.Product;
import org.primefaces.model.StreamedContent;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Jenny on 16/11/2015.
 */

@Named
@SessionScoped
public class AdminCampaingnModel implements Serializable {


    private boolean creationFlow;
    private Campaign campaign;
    private List<Campaign> listCampaigns;
    private Product product;
    private StreamedContent campaignImage;



    public AdminCampaingnModel(){

        creationFlow=true;
        campaign =new Campaign();
    }

    public void cleanModel(){
        campaign =new Campaign();
        campaign.setProduct(new Product());
    }

    public boolean isCreationFlow() {
        return creationFlow;
    }

    public void setCreationFlow(boolean creationFlow) {
        this.creationFlow = creationFlow;
    }


    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public List<Campaign> getListCampaigns() {
        return listCampaigns;
    }
    public void setListCampaigns(List<Campaign> listCampaigns) {
        this.listCampaigns = listCampaigns;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public StreamedContent getCampaignImage() {
        return campaignImage;
    }

    public void setCampaignImage(StreamedContent campaignImage) {
        this.campaignImage = campaignImage;
    }
}
