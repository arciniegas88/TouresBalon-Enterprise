package co.com.touresbalon.foundation.oms.usecases.campaingnadmin;

import co.com.touresbalon.foundation.oms.domain.products.Campaign;
import co.com.touresbalon.foundation.oms.exceptions.BusinessException;
import co.com.touresbalon.foundation.oms.exceptions.SystemException;
import co.com.touresbalon.foundation.oms.facades.ProductsFacade;
import co.com.touresbalon.foundation.oms.usecases.portal.PortalController;
import co.com.touresbalon.foundation.oms.usecases.productadmin.AdminProductsModel;
import co.com.touresbalon.foundation.oms.util.FacesUtil;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.UUID;

/**
 * Created by Jenny on 16/11/2015.
 */

@Named
@RequestScoped
public class AdminCampaingnController {

    @Inject
    private FacesUtil util;
    @Inject
    private ProductsFacade facade;
    @Inject
    private AdminCampaingnModel model;

    public void showCampaignDetail(Campaign campaign) {

        try {
            model.setCampaign(facade.searchCampaignById(campaign.getId()));

            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(model.getCampaign().getImageRef()));
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            int val = -1;
            while ((val = in.read()) != -1)
                out.write(val);

            byte[] bytes = out.toByteArray();
            DefaultStreamedContent content = new DefaultStreamedContent(new ByteArrayInputStream(bytes), "image/png", UUID.randomUUID().toString() + "_image.png");
            model.setCampaignImage(content);

        } catch (Exception e) {
            e.printStackTrace();
            util.addErrorMessage("Ha ocurrido un error interno en la aplicación");
        }

        RequestContext.getCurrentInstance().execute("PF('campaignDialog').show()");

    }

    public void handleFileUpload(FileUploadEvent event) {
        model.getCampaign().setImageRef(event.getFile().getContents());
    }


    public void showCampaignUpdate(Campaign campaign) {
            model.setCampaign(facade.searchCampaignById(campaign.getId()));
            RequestContext.getCurrentInstance().execute("window.location.href='" + PortalController.CAMPAIGN_UPDATE_PAGE + "';");
    }


    public void updateCampaign(Campaign campaign) {
        try {
            facade.updateCampaingn(campaign);
            util.addInfoMessage("La campaña se ha actualizado con éxito");
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }

    public void deleteCampaign(Campaign campaign) {
        try {
            facade.deleteCampaingn(campaign.getId());
            model.getListCampaigns().remove(campaign);
            util.addInfoMessage("La campaña se ha eliminado con éxito");
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

    public   void  createCampaign(){

        boolean campaignOk = true;

        if(model.getCampaign().getName()==null){
            util.addErrorMessage("El nombre de la campaña no ha sido ingresada");
            campaignOk =false;
        }
        if(model.getCampaign().getEffectiveDate()==null){
            util.addErrorMessage("La fecha de la campaña no ha sido ingresada");
            campaignOk =false;
        }
        if(model.getCampaign().getImageRef()==null){
            util.addErrorMessage("La imagen de la campaña no ha sido ingresada");
            campaignOk =false;
        }

        if(campaignOk== true){
            try {
                model.getCampaign().setProduct(model.getProduct());
                facade.createCampaingn(model.getCampaign());
                util.addInfoMessage("La campaña se ha creado con éxito");
                model.cleanModel();

            }catch (SystemException e) {
                e.printStackTrace();
            } catch (BusinessException e) {
                e.printStackTrace();
            }
        }


    }


}
