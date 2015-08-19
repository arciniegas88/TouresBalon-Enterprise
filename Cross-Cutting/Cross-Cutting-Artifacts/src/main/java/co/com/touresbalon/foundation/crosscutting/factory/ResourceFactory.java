package co.com.touresbalon.foundation.crosscutting.factory;

import co.com.touresbalon.foundation.crosscutting.annotations.cache.CacheStore;
import co.com.touresbalon.foundation.crosscutting.annotations.cache.HazelcastService;
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
    @HazelcastService
    public HazelcastInstance createHazelcastInstance() {
        HazelcastInstance hzInstance = com.hazelcast.core.Hazelcast.newHazelcastInstance();
        return hzInstance;
    }


    // [cache manager service] -------------------------------------------

    @Produces
    @Singleton
    @Hazelcast
    public CacheManager createHazelcastCacheManager( @HazelcastService HazelcastInstance hzInstance ) {
        HazelcastServerCachingProvider cacheProvider = HazelcastServerCachingProvider.createCachingProvider(hzInstance);
        return cacheProvider.getCacheManager();
    }


    // [cache service] -------------------------------------------

    @Produces
    @CacheStore(value = "",keyType = Class.class, valueType =  Class.class)
    public Cache getCache( @Hazelcast CacheManager cm,InjectionPoint ip ){

        String name = ip.getAnnotated().getAnnotation( CacheStore.class ).value();
        Class kType = ip.getAnnotated().getAnnotation( CacheStore.class ).keyType();
        Class vType = ip.getAnnotated().getAnnotation( CacheStore.class ).valueType();

        Cache cache = cm.getCache( name,kType,vType );
        return cache;
    }


}
