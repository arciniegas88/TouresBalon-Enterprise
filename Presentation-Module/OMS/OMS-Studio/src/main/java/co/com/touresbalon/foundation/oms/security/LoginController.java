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
    private LoginModel model;

    //-----------------------------------

    // [constructor] ---------------------------------
    
    public LoginController() {
    }
    
    // [login] ---------------------------------
    
    public String login(){

        if(StringUtils.equals( model.getUser().getLogin(),"admin" ) && StringUtils.equals( model.getUser().getPassword(),"admin" )){
            model.setAuthenticated(true);
            return FacesUtil.redirect("/dashboard.xhtml");
        }else{
            FacesUtil.addErrorMessage("Login error");
            return "";
        }

    }

    // [login] ---------------------------------

    public String forgotPassword(){
        FacesUtil.addErrorMessage("forgot password");
        return "";
    }
    
    
    // [logout] ---------------------------------
    
    public void logout(){
        FacesUtil.invalidateSession();
        RequestContext.getCurrentInstance().execute("window.location.href='http://localhost:9090/OMS-Studio/login.xhtml';");
    }
    
    
    
    // [clean] ---------------------------------
    
    public void clean(){
        model.clear();
    }
   
}
