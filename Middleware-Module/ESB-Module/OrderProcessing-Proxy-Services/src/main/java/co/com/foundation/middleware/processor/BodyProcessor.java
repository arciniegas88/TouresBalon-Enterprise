package co.com.foundation.middleware.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.xml.sax.InputSource;

import javax.jms.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Created by garciniegas on 01/11/2015.
 */

public class BodyProcessor implements Processor{

    private ActiveMQConnectionFactory factory;
    private XPath xPath =  XPathFactory.newInstance().newXPath();
    private String endpoint;

    public BodyProcessor(){
    }

    public void process( Exchange exchange) throws Exception {

        String payload = exchange.getIn().getBody().toString();
        payload = processItemDetailBuilding(payload);
        payload = generateOrderId(exchange,payload);

        exchange.getIn().setBody(payload, String.class);
    }

    private String generateOrderId( Exchange exchange, String payload )throws Exception{

        ClientResource client     = new ClientResource(endpoint);
        Representation response   = client.get();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        response.write(out);
        payload = payload.replaceAll("<id>DEFAULT</id>", "<id>" + out.toString() + "</id>");
        publishResponseMessage(out.toString(), exchange.getIn().getHeader("JMSCorrelationID").toString() );
        out.close();

        return payload;
    }


    private void publishResponseMessage( String orderId, String correlationId )throws Exception{

        QueueConnection qc = factory.createQueueConnection();
        QueueSession session = qc.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("MQ-ProcessOrderResponse");
        MessageProducer producer = session.createProducer(queue);
        TextMessage message = session.createTextMessage(orderId);
        message.setJMSCorrelationID(correlationId);
        producer.send(message);

        session.close();
        qc.close();
    }

    private String processItemDetailBuilding( String payload )throws Exception{

        String count      = "count(/*[local-name() = 'CreateSalesOrderRequest']/order/items)";
        int size = Integer.parseInt(xPath.compile(count).evaluate(new InputSource(new StringReader(payload))));
        StringBuilder builder =new StringBuilder();

        for( int i=1;i<=size;++i ){

            String productName = "/*[local-name() = 'CreateSalesOrderRequest']/order/items[" +i+"]/productName";
            String price       = "/*[local-name() = 'CreateSalesOrderRequest']/order/items[" +i+"]/price";
            String contentProductName = xPath.compile(productName).evaluate(new InputSource( new StringReader( payload ) ));
            String contentPrice       = xPath.compile(price).evaluate(new InputSource( new StringReader( payload ) ));

            builder.append(contentProductName )
                    .append(" : \\$")
                    .append(contentPrice)
                    .append("<br/>");
        }

        payload = payload.replaceAll("<custom>DEFAULT</custom>","<custom><![CDATA["+builder.toString()+"]]></custom>");
        return payload;
    }

    public ActiveMQConnectionFactory getFactory() {
        return factory;
    }

    public void setFactory(ActiveMQConnectionFactory factory) {
        this.factory = factory;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

}
