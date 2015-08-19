package co.com.touresbalon.foundation.orders.infraestructure;

import co.com.touresbalon.foundation.crosscutting.annotations.cache.Hazelcast;
import co.com.touresbalon.foundation.crosscutting.annotations.cache.HazelcastService;
import com.hazelcast.core.HazelcastInstance;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.AccessedExpiryPolicy;
import javax.cache.expiry.Duration;
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


    // [attributes] ---------------------------------------

    @Inject
    @Hazelcast
    private CacheManager cm;

    @Inject
    @HazelcastService
    private HazelcastInstance instance;

    @Inject
    private Logger loggger;


    public CacheInitializer() {
    }


    // [ start-up service ] --------------------------------------

    @PostConstruct
    public void init() {

        loggger.info("--------------[ intializing cache stores ]-------------------");
        initializeProductTopFiveCache();
    }



    // [ top 5 products cache service ] --------------------------------------

    private void initializeProductTopFiveCache() {

        MutableConfiguration<String, Object> config = new MutableConfiguration<>();

        config.setStoreByValue(true)
                .setTypes(String.class, Object.class)
                .setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(Duration.ETERNAL))
                .setStatisticsEnabled(false);

        Cache<String,Object> cache = cm.createCache("application-cache", config);
        cache.put("prueba", "hola como estas qwerty..?");
    }



    // [ clean-up service ] --------------------------------------

    @PreDestroy
    public void clean(){

        loggger.info("--------------[ destroying cache stores ]-------------------");
        instance.shutdown();

    }

}
