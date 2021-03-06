package co.com.touresbalon.foundation.microservices.rest.infrastructure;

import co.com.touresbalon.foundation.microservices.rest.LodgingResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/web-api")
public class ApplicationConfig extends Application {

    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(LodgingResource.class));
    }
}
