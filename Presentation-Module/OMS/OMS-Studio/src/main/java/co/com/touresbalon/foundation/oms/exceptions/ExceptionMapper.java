package co.com.touresbalon.foundation.oms.exceptions;

import org.apache.commons.io.IOUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by garciniegas on 14/10/2015.
 */

public class ExceptionMapper {

    private static final String BUSINESS_EXC_BEGIN = "<businessException><message>";
    private static final String BUSINESS_EXC_END   = "</message></businessException>";

    private static final String SYSTEM_EXC_BEGIN = "<systemException><message>";
    private static final String SYSTEM_EXC_END   = "</message></systemException>";

    public static void mapRemoteException( WebApplicationException ex )throws BusinessException, SystemException{

        try {

            Response r = ex.getResponse();
            String message = IOUtils.toString((InputStream) r.getEntity());

            if (message.contains("<businessException>")) {
                String detail = message.replaceAll(BUSINESS_EXC_BEGIN, "").replaceAll(BUSINESS_EXC_END, "");
                throw new BusinessException(detail);
            } else {
                String detail = message.replaceAll(SYSTEM_EXC_BEGIN, "").replaceAll(SYSTEM_EXC_END, "");
                throw new SystemException(detail);
            }

        }catch ( IOException e){
            throw new SystemException( "Un error interno a ocurrido en el sistema: " + e.getMessage() );
        }
    }

}
