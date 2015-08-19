package co.com.touresbalon.foundation.orders.infraestructure;

import co.com.touresbalon.foundation.crosscutting.annotations.cache.Hazelcast;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.cache.CacheManager;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

/**
 * Created by garciniegas on 19/08/2015.
 */

@Startup
@Singleton
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class CacheInitializer {

    @Inject
    @Hazelcast
    private CacheManager cm;
    @Inject
    private Logger loggger;

    public CacheInitializer() {
    }

    @PostConstruct
    public void init(){

        loggger.info("--------------[ intializing cache stores ]-------------------");
        loggger.info( String.valueOf(cm) );

    }

}
