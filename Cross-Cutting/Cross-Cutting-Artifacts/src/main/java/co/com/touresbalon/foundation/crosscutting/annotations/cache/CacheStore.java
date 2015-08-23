package co.com.touresbalon.foundation.crosscutting.annotations.cache;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by garciniegas on 19/08/2015.
 */

@Qualifier
@Retention(RUNTIME)
@Target({TYPE, METHOD, FIELD, PARAMETER})
public @interface CacheStore {

    @Nonbinding String value();
    @Nonbinding Class keyType() default String.class;
    @Nonbinding Class valueType() default Object.class;

}