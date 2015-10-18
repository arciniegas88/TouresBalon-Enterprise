package co.com.touresbalon.foundation.oms.util;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * FacesUtil -
 * @author javeriana
 */

@Named
@ApplicationScoped
public class FacesUtil {
    
	//[utility] -----------------------------------
	
    public void invalidateSession(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session =  (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
    }
    
    
    //[utility] -----------------------------------
    
    public String redirect( String action ){
        return action+"?faces-redirect=true";
    }
    
    
    //[utility] -----------------------------------
    
    public void addInfoMessage( String message ){
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
        FacesContext.getCurrentInstance().addMessage(null,fm);
    }
    
    
    //[utility] -----------------------------------
    
    public void addErrorMessage( String message ){
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
        FacesContext.getCurrentInstance().addMessage(null,fm);
    }
    
    
    
    //[utility] -----------------------------------
    
    public void addWarningMessage( String message ){
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, message, message);
        FacesContext.getCurrentInstance().addMessage(null,fm);
    }
    
}
