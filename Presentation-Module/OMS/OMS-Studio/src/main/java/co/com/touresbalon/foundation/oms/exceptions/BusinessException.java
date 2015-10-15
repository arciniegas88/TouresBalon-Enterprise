package co.com.touresbalon.foundation.oms.exceptions;


/**
 * Created by garciniegas on 28/08/2015.
 */

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
