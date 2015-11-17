package co.com.touresbalon.foundation.oms.security;


import co.com.touresbalon.foundation.oms.domain.security.User;
import co.com.touresbalon.foundation.oms.exceptions.BusinessException;
import co.com.touresbalon.foundation.oms.exceptions.SystemException;
import co.com.touresbalon.foundation.oms.facades.SecurityFacade;
import co.com.touresbalon.foundation.oms.util.FacesUtil;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * LoginController - 
 * @author javeriana
 */


@Named
@RequestScoped
public class LoginController {
    
	//-----------------------------------

    @Inject
    private FacesUtil util;

    @Inject
    private LoginModel model;

    @Inject
    private SecurityFacade facade;

    //-----------------------------------

    // [constructor] ---------------------------------
    
    public LoginController() {
    }
    
    // [login] ---------------------------------
    
    public String login(){

        try {

            User local = facade.login( model.getUser() );
            model.setAuthenticated(true);
            model.setUser( local );

            return util.redirect("/dashboard.xhtml");

        } catch (BusinessException | SystemException e) {
            util.addErrorMessage( e.getMessage() );
            return "";
        }

    }

    // [login] ---------------------------------

    public String forgotPassword(){
        util.addErrorMessage("forgot password");
        return "";
    }
    
    
    // [logout] ---------------------------------
    
    public void logout(){
        util.invalidateSession();
        RequestContext.getCurrentInstance().execute("window.location.href='/OMS-Studio/login.xhtml';");
    }
    
    
    
    // [clean] ---------------------------------
    
    public void clean(){
        model.clear();
    }
   
}
