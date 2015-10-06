package co.com.touresbalon.foundation.oms.security;


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

    //-----------------------------------

    // [constructor] ---------------------------------
    
    public LoginController() {
    }
    
    // [login] ---------------------------------
    
    public String login(){

        if(StringUtils.equals( model.getUser().getLogin(),"admin" ) && StringUtils.equals( model.getUser().getPassword(),"admin" )){
            model.setAuthenticated(true);
            return util.redirect("/dashboard.xhtml");
        }else{
            util.addErrorMessage("Usuario o clave incorrectas");
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
