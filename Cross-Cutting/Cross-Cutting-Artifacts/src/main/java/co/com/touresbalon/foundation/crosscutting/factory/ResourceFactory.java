package co.com.touresbalon.foundation.crosscutting.factory;

import co.com.touresbalon.foundation.crosscutting.annotations.cache.CacheStore;
import com.hazelcast.cache.impl.HazelcastServerCachingProvider;
import co.com.touresbalon.foundation.crosscutting.annotations.cache.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;

/**
 * Created by garciniegas on 12/08/2015.
 */

@ApplicationScoped
public class ResourceFactory {

    public ResourceFactory() {
    }

    // [log service] -------------------------------------------

    @Produces
    public Logger createLogArtifact() {
        Logger logger = LoggerFactory.getLogger("co.com.touresbalon.foundation.logservice");
        return logger;
    }


    // [cache manager service] -------------------------------------------

    @Produces
    @Singleton
    @Hazelcast
    public CacheManager createHazelcastInstance() {
        HazelcastInstance hzInstance = com.hazelcast.core.Hazelcast.newHazelcastInstance();
        HazelcastServerCachingProvider cacheProvider = HazelcastServerCachingProvider.createCachingProvider(hzInstance);
        return cacheProvider.getCacheManager();
    }


    // [cache service] -------------------------------------------

    @Produces
    @CacheStore("")
    public Cache getCache(InjectionPoint ip, @Hazelcast CacheManager cm){

        Cache cache = cm.getCache( ip.getAnnotated().getAnnotation( CacheStore.class ).value() );
        return cache;
    }


}
