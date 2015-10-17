package co.com.touresbalon.foundation.oms.usecases.ratesadmin;

import co.com.touresbalon.foundation.oms.domain.products.PartnerServiceWrapper;
import co.com.touresbalon.foundation.oms.exceptions.BusinessException;
import co.com.touresbalon.foundation.oms.exceptions.SystemException;
import co.com.touresbalon.foundation.oms.facades.ProductsFacade;
import co.com.touresbalon.foundation.oms.util.FacesUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by garciniegas on 16/10/2015.
 */


@Named
@RequestScoped
public class RatesController {

    @Inject
    private FacesUtil util;
    @Inject
    private RatesModel model;
    @Inject
    private ProductsFacade facade;

    public String updateRates(){

        PartnerServiceWrapper wrapper = new PartnerServiceWrapper();
        wrapper.setSpectacles(model.getSpectacles());
        wrapper.setLodgings(model.getLodgings());
        wrapper.setTransports(model.getTransports());

        try {

            facade.updatePartnerRates( wrapper );
            util.addInfoMessage("Las tarifas han sido actualizadas con éxito");

        } catch (SystemException | BusinessException e) {
            util.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void restaurar(){

        model.setTransports( facade.getTransports() );
        model.setLodgings( facade.getLodging() );
        model.setSpectacles( facade.getSpectacles() );

    }

}
