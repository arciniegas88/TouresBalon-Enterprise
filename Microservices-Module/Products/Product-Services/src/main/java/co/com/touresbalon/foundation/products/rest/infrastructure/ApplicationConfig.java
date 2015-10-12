package co.com.touresbalon.foundation.products.rest.infrastructure;

import co.com.touresbalon.foundation.products.rest.CampaignResource;
import co.com.touresbalon.foundation.products.rest.PartnerServicesResource;
import co.com.touresbalon.foundation.products.rest.ProductResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/web-api")
public class ApplicationConfig extends Application {

    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList( ProductResource.class ,CampaignResource.class,
                                                    PartnerServicesResource.class));
    }
}