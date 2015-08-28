package co.com.touresbalon.foundation.crosscutting.exceptions;

import javax.ejb.ApplicationException;

/**
 * Created by garciniegas on 28/08/2015.
 */

@ApplicationException(rollback = true)
public class SystemException extends Exception{

    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
