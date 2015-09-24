package co.com.touresbalon.foundation.crosscutting.service.factory;

import co.com.touresbalon.foundation.crosscutting.annotations.cache.CacheStore;
import co.com.touresbalon.foundation.crosscutting.annotations.cache.HazelcastService;
import co.com.touresbalon.foundation.crosscutting.annotations.rules.RulesContainer;
import co.com.touresbalon.foundation.crosscutting.exceptions.ExceptionBuilder;
import com.hazelcast.cache.impl.HazelcastServerCachingProvider;
import co.com.touresbalon.foundation.crosscutting.annotations.cache.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.Message;
import org.kie.api.io.KieResources;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;

import org.kie.api.runtime.KieContainer;

/**
 * Created by garciniegas on 12/08/2015.
 */

@ApplicationScoped
public class ServiceFactory {

    public ServiceFactory() {
    }


    // [exception-builder service] -------------------------------------------

    @Produces
    @Singleton
    public ExceptionBuilder createExceptionBuilder(){
        ExceptionBuilder builder = new ExceptionBuilder( LoggerFactory.getLogger("co.com.touresbalon.foundation.logservice") );
        return builder;
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

    @Produces
    @Singleton
    public KieSession createKieSession(@RulesContainer KieContainer  container){
        return container.newKieSession();
    }


    @Produces
    @Singleton
    @RulesContainer
    public KieContainer createKieContainer(){

        KieServices kieServices = KieServices.Factory.get();
        KieResources kieResources = kieServices.getResources();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        KieRepository kieRepository = kieServices.getRepository();

        Resource resource = kieResources.newFileSystemResource(System.getProperty("touresbalon.businessrules.drl"));
        kieFileSystem.write( resource);

        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();

        if (kb.getResults().hasMessages(Message.Level.ERROR)) {
            throw new RuntimeException("Build Errors:\n" + kb.getResults().toString());
        }

        return kieServices.newKieContainer(kieRepository.getDefaultReleaseId());
    }

}
