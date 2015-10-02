package co.com.touresbalon.foundation.oms.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * FacesUtil -
 * @author javeriana
 */

public class FacesUtil {
    
	//[utility] -----------------------------------
	
    public static void invalidateSession(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session =  (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
    }
    
    
    //[utility] -----------------------------------
    
    public static final String redirect( String action ){
        return action+"?faces-redirect=true";
    }
    
    
    //[utility] -----------------------------------
    
    public static final void addInfoMessage( String message ){
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
        FacesContext.getCurrentInstance().addMessage(null,fm);
    }
    
    
    //[utility] -----------------------------------
    
    public static final void addErrorMessage( String message ){
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
        FacesContext.getCurrentInstance().addMessage(null,fm);
    }
    
    
    
    //[utility] -----------------------------------
    
    public static final void addWarningMessage( String message ){
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, message, message);
        FacesContext.getCurrentInstance().addMessage(null,fm);
    }
    
}
