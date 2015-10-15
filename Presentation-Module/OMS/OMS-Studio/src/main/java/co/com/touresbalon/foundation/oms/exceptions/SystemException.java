package co.com.touresbalon.foundation.oms.exceptions;

/**
 * Created by garciniegas on 28/08/2015.
 */

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
