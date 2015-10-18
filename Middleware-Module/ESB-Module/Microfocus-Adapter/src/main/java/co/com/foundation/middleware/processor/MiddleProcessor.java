package co.com.foundation.middleware.processor;

import co.com.foundation.middleware.model.AccountTransaction;
import co.com.foundation.middleware.model.AccountTransactionCobol;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by garciniegas on 18/10/2015.
 */
public class MiddleProcessor implements Processor {

    private JAXBContext ctx;

    public MiddleProcessor() {
        try {
            ctx = JAXBContext.newInstance(AccountTransaction.class);
        } catch (JAXBException je) {
            throw new RuntimeException(je);
        }
    }

    public void process(Exchange exchange) throws Exception {

        String payload = exchange.getIn().getBody().toString();
        Unmarshaller um = ctx.createUnmarshaller();
        InputStream stream = new ByteArrayInputStream(payload.getBytes());
        AccountTransaction domain = (AccountTransaction) um.unmarshal(stream);
        stream.close();

        AccountTransactionCobol account = new AccountTransactionCobol( domain );
        exchange.getIn().setBody( account, AccountTransactionCobol.class );

    }
}
