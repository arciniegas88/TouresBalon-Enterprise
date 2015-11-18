package co.com.touresbalon.foundation.oms.usecases.campaingnadmin;

import co.com.touresbalon.foundation.oms.domain.products.Campaign;
import co.com.touresbalon.foundation.oms.domain.products.Product;

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

    private Campaign campaign;
    private List<Campaign> listCampaigns;
    private Product product;


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
}
