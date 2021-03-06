package co.com.touresbalon.foundation.crosscutting.exceptions;

import co.com.touresbalon.foundation.crosscutting.util.RESTUtil;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by garciniegas on 28/08/2015.
 */

@Provider
public class SystemExceptionHttpStatusResolver implements ExceptionMapper<SystemException> {

    private static final String JSON_MESSAGE = "{\"systemException\":{\"message\": \"#message\"}}";
    private static final String XML_MESSAGE  = "<systemException><message>#message</message></systemException>";

    @Context
    private HttpHeaders headers;

    // -------------------------------

    public Response toResponse( SystemException e ) {

        MediaType mt = RESTUtil.getAcceptedMediaType(headers);
        Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;
        String message;

        if (mt.equals(MediaType.APPLICATION_JSON_TYPE)) {
            message = JSON_MESSAGE.replace("#message", e.getMessage());
        } else {
            message = XML_MESSAGE.replace("#message", e.getMessage());
        }

        return Response.status(status).entity(message).type(mt).build();
    }

}
