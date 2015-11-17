package co.com.touresbalon.foundation.oms.facades;

import co.com.touresbalon.foundation.oms.domain.security.User;
import co.com.touresbalon.foundation.oms.exceptions.BusinessException;
import co.com.touresbalon.foundation.oms.exceptions.SystemException;
import co.com.touresbalon.foundation.oms.webclient.SecurityWebClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Created by garciniegas on 16/11/2015.
 */

@ApplicationScoped
public class SecurityFacade {

    //[fields] injected service client fields -----------------------

    @Inject
    private SecurityWebClient securityWC;


    // ------------------------------

    public User login( User user ) throws BusinessException, SystemException {
        return securityWC.login(user);
    }

}
