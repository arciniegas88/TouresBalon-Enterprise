package co.com.touresbalon.foundation.oms.infrastructure;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;

/**
 * Created by garciniegas on 05/10/2015.
 */
public class BeanLocator {

    private static BeanManager bm;

    private static void initBeanManager(){

        if( bm != null )
            return;

        try {
            InitialContext context = new InitialContext();
            bm = (BeanManager) context.lookup("java:comp/BeanManager");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T>T getBean( Class<T> target  ){

        initBeanManager();
        Bean<T> bean = (Bean<T>) bm.getBeans(target).iterator().next();
        CreationalContext<T> ctx = bm.createCreationalContext(bean);
        T beanRef = (T) bm.getReference(bean, target, ctx);

        return beanRef;
    }

}
