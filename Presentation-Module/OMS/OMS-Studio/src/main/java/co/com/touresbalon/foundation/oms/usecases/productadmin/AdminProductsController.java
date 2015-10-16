package co.com.touresbalon.foundation.oms.usecases.productadmin;

import co.com.touresbalon.foundation.oms.domain.products.Product;
import co.com.touresbalon.foundation.oms.exceptions.BusinessException;
import co.com.touresbalon.foundation.oms.exceptions.SystemException;
import co.com.touresbalon.foundation.oms.facades.ProductsFacade;
import co.com.touresbalon.foundation.oms.usecases.portal.PortalController;
import co.com.touresbalon.foundation.oms.util.FacesUtil;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by garciniegas on 12/10/2015.
 */

@Named
@RequestScoped
public class AdminProductsController {

    @Inject
    private FacesUtil util;
    @Inject
    private ProductsFacade facade;
    @Inject
    private AdminProductsModel model;

    public void handleFileUpload(FileUploadEvent event) {
        model.getProduct().setImageRef(event.getFile().getContents());
    }

    public void loadSourceCities() {
        model.setSourceCities(facade.getCitiesByContry(model.getCountrySource()));
    }

    public void loadTargetCities() {
        model.setTargetCities(facade.getCitiesByContry(model.getCountryTarget()));
    }

    public String createProduct() {

        Product p = model.getProduct();
        boolean productOk = true;

        if (p.getSourceCity() == null || p.getSourceCity().getId() == null) {
            util.addErrorMessage("La ciudad origen no ha sido ingresada");
            productOk = false;
        }

        if (p.getTargetCity() == null || p.getTargetCity().getId() == null) {
            util.addErrorMessage("La ciudad destino no ha sido ingresada");
            productOk = false;
        }

        if (p.getTransportType() == null || p.getTransportType().getId() == null) {
            util.addErrorMessage("El transporte no ha sido ingresado");
            productOk = false;
        }

        if (p.getLodgingType() == null || p.getLodgingType().getId() == null) {
            util.addErrorMessage("El ospedaje no ha sido ingresado");
            productOk = false;
        }

        if (p.getSpectacleType() == null || p.getSpectacleType().getId() == null) {
            util.addErrorMessage("El espectáculo no ha sido ingresado");
            productOk = false;
        }

        if (p.getImageRef() == null) {
            util.addErrorMessage("La imagen delproducto no ha sido ingresada");
            productOk = false;
        }

        String target = "";

        if (productOk) {
            try {

                if( model.isCreationFlow() )
                {
                    facade.createProduct(p);
                    util.addInfoMessage("El producto ha sido creado exitosamente");
                    target = util.redirect("/dashboard.xhtml");
                }else
                {
                    facade.updateProduct(p);
                    util.addInfoMessage("El producto ha sido actualizado exitosamente");
                    target = util.redirect("/content/products/productSearch.xhtml");
                }

                cleanForm();
            } catch (SystemException | BusinessException e) {
                util.addErrorMessage(e.getMessage());
            }
        }

        return target;
    }

    public void cleanForm() {
        model.cleanModel();
    }


}
