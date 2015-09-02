package co.com.touresbalon.foundation.transports.infrastructure;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * Created by garciniegas on 02/09/2015.
 */

public class TransportSoapMessageWSHandler implements SOAPHandler<SOAPMessageContext> {

    private MessageFactory factory;

    private String oldNamespace = "xmlns=\"http://touresbalon.com.co/transport/service/task/1.0.0\"";
    private String newNamespace = "xmlns:ns=\"http://touresbalon.com.co/transport/service/task/1.0.0\"";

    public TransportSoapMessageWSHandler() {

        try {
            factory = MessageFactory.newInstance();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {

        SOAPMessage msg = context.getMessage();

        try {

            QName opn = (QName) context.get(SOAPMessageContext.WSDL_OPERATION);

            if( !opn.getLocalPart().equals("confirmTravel") )
                return true;

            ByteArrayOutputStream streamOut = new ByteArrayOutputStream();
            msg.writeTo(streamOut);
            String newMesage = streamOut.toString();
            streamOut.close();

            newMesage = newMesage.replaceAll(oldNamespace,newNamespace);
            newMesage = newMesage.replaceAll("confirmTravel","ns:confirmTravel");

            context.setMessage( buildMessage(newMesage) );

        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private SOAPMessage buildMessage(String xml) throws SOAPException, IOException {
        SOAPMessage message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
        return message;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}
