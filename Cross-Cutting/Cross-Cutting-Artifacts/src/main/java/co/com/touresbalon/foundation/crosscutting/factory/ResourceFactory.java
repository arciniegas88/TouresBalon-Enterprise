package co.com.touresbalon.foundation.crosscutting.factory;

import org.slf4j.LoggerFactory;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.slf4j.Logger;

/**
 * Created by garciniegas on 12/08/2015.
 */

@ApplicationScoped
public class ResourceFactory {

    public ResourceFactory() {
    }

    //-------------------------------------------

    @Produces
    public Logger produceLogArtifact(){
        Logger logger = LoggerFactory.getLogger("co.com.touresbalon.foundation.logservice");
        return logger;
    }

}
