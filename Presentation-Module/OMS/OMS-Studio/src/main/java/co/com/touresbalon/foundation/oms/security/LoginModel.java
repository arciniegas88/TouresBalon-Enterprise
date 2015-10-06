package co.com.touresbalon.foundation.oms.security;

import co.com.touresbalon.foundation.oms.domain.security.User;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 * LoginModel - 
 * @author javeriana
 */


@Named
@SessionScoped
public class LoginModel implements Serializable {

	private static final long serialVersionUID = -7824017455084697106L;
	
	//-----------------------------------
	private User user;
    private boolean authenticated;

    public LoginModel() {
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public void clear(){

    }
}
