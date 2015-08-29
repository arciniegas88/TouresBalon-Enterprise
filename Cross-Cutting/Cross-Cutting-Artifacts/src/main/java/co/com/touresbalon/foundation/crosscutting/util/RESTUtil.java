package co.com.touresbalon.foundation.crosscutting.util;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * Created by garciniegas on 28/08/2015.
 */
public class RESTUtil {

    public static MediaType getAcceptedMediaType( HttpHeaders headers ){

        if( headers.getAcceptableMediaTypes().isEmpty() ){
            return MediaType.APPLICATION_XML_TYPE;
        }else{

            for( MediaType mt : headers.getAcceptableMediaTypes() ){
                if( mt.equals( MediaType.APPLICATION_JSON_TYPE ) )
                    return MediaType.APPLICATION_JSON_TYPE;
            }

            return MediaType.APPLICATION_XML_TYPE;
        }
    }

    public static String getNegotiatedContent( HttpHeaders headers, Object value, String label ){

        MediaType mt = getAcceptedMediaType(headers);

        if( mt.equals( MediaType.APPLICATION_JSON_TYPE ) )
            return "{"+label+": "+ value +"}";
        else
            return "<"+label+">"+value+"</"+label+">";
    }

}
