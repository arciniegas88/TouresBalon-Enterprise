package co.com.touresbalon.foundation.crosscutting.exceptions;

import javax.ejb.ApplicationException;

/**
 * Created by garciniegas on 28/08/2015.
 */

@ApplicationException(rollback = true)
public class BusinessException extends Exception {

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
