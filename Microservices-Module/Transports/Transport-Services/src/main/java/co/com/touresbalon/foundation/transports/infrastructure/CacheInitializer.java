package co.com.touresbalon.foundation.transports.infrastructure;

import co.com.touresbalon.foundation.crosscutting.annotations.cache.Hazelcast;
import co.com.touresbalon.foundation.crosscutting.annotations.cache.HazelcastService;
import com.hazelcast.core.HazelcastInstance;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.AccessedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;

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
    private Logger logger;

    public CacheInitializer() {
    }


    // [ start-up service ] --------------------------------------

    @PostConstruct
    public void init() {

        logger.info("--------------[ intializing cache stores ]-------------------");
        initializeCSVCache();
    }



    // [ bolivariano csv cache service ] --------------------------------------

    private void initializeCSVCache() {

        String[] caches = { "bolivariano-cache", "aa-cache", "avianca-cache"};
        String[] paths  = { System.getProperty("touresbalon.transports.bolivariano.shared_directory"),
                            System.getProperty("touresbalon.transports.aa.shared_directory"),
                            System.getProperty("touresbalon.transports.avianca.shared_directory")};

        for( int i=0;i<3;++i )
        {
            initializeCache(caches[i]);
            installFileListener( paths[i], caches[i] );
        }
    }

    private void initializeCache( String cacheName ){

        MutableConfiguration<String, Object> config = new MutableConfiguration<>();

        config.setStoreByValue(true)
                .setTypes(String.class, Object.class)
                .setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(Duration.ETERNAL))
                .setStatisticsEnabled(false);

        cm.createCache(cacheName, config);
    }

    private void installFileListener( String directory, String cacheName ){

        directory = directory + "/reserves";
        CSVFilesMonitor listener = new CSVFilesMonitor(cm,logger, cacheName);
        File folder = new File( directory );

        try{

            for( File f : folder.listFiles()){
                logger.info("prepare file loading: " + f.getName());
                listener.loadCSVToCache( f );
            }

        }catch (IOException io) {
            logger.error("CacheInitializer - an internal server error has ocurred: " + io.getMessage());
        }

        try{

            FileAlterationObserver observer = new FileAlterationObserver(directory);
            FileAlterationMonitor monitor = new FileAlterationMonitor(10000);
            observer.addListener(listener);
            monitor.addObserver(observer);
            monitor.start();

            logger.info("csv file monitor starter: " );

        }catch (Exception io) {
            logger.error("CacheInitializer - an internal server error has ocurred: " + io.getMessage());
        }

    }

    // [ clean-up service ] --------------------------------------

    @PreDestroy
    public void clean(){

        logger.info("--------------[ destroying cache stores ]-------------------");
        instance.shutdown();
    }

}
