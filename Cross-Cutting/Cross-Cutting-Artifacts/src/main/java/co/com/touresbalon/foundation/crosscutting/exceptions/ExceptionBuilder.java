package co.com.touresbalon.foundation.crosscutting.exceptions;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;

/**
 * Created by garciniegas on 28/08/2015.
 */

public class ExceptionBuilder {

    private Logger logger;

    private Properties messages;

    public ExceptionBuilder( Logger logger ) {

        try {

            this.logger = logger;
            messages = new Properties();
            logger.info("loading system messages repository: " + System.getProperty("touresbalon.system.messages"));
            File file = new File(System.getProperty("touresbalon.system.messages"));
            messages.load(FileUtils.openInputStream(file));

        }catch (IOException io){
            logger.error( "error system messages repository: " + io.getMessage(),io );
        }
    }


    // ---------------------------------

    public SystemException buildSystemException(){
        return new SystemException( getMessage("microservices.general.systemexception") );
    }


    // ---------------------------------

    public BusinessException buildBusinessException( String key ){
        return new BusinessException( messages.getProperty(key) );
    }

    // ---------------------------------

    public String getSystemErrorMessage(){
        return messages.getProperty("microservices.general.systemexception");
    }

    // ---------------------------------

    public String getMessage( String key ){
        return messages.getProperty( key );
    }

}
