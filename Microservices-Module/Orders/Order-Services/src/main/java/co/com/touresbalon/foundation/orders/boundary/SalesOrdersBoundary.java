package co.com.touresbalon.foundation.orders.boundary;

import co.com.touresbalon.foundation.crosscutting.annotations.cache.CacheStore;
import org.slf4j.Logger;

import javax.cache.Cache;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by garciniegas on 19/08/2015.
 */

@Stateless
public class SalesOrdersBoundary {

    @Inject
    private Logger logger;

    @Inject
    @CacheStore("application-cache")
    private Cache<String,Object> cache;


    public SalesOrdersBoundary()
    {}

    public String testCache(){
        return cache.get("prueba").toString();
    }

}
