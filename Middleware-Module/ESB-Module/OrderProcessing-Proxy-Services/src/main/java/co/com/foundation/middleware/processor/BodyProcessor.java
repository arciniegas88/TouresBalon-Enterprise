package co.com.foundation.middleware.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

/**
 * Created by garciniegas on 01/11/2015.
 */
public class BodyProcessor implements Processor {

    private XPath xPath =  XPathFactory.newInstance().newXPath();

    public BodyProcessor(){

    }

    @Override
    public void process(Exchange exchange) throws Exception {

        String count      = "count(/*[local-name() = 'CreateSalesOrderRequest']/order/items)";
        String payload    = exchange.getIn().getBody().toString();
        int size = Integer.parseInt(xPath.compile(count).evaluate(new InputSource(new StringReader(payload))));
        StringBuilder builder =new StringBuilder();

        for( int i=1;i<=size;++i ){

            String productName = "/*[local-name() = 'CreateSalesOrderRequest']/order/items[" +i+"]/productName";
            String price       = "/*[local-name() = 'CreateSalesOrderRequest']/order/items[" +i+"]/price";
            String contentProductName = xPath.compile(productName).evaluate(new InputSource( new StringReader( payload ) ));
            String contentPrice       = xPath.compile(price).evaluate(new InputSource( new StringReader( payload ) ));

            builder.append(contentProductName )
                    .append(" : $")
                    .append(contentPrice)
                    .append("<br/>");

        }
        payload=payload.replaceAll("<custom/>","<custom><![CDATA["+builder.toString()+"]]></custom>");
        exchange.getIn().setBody(payload, String.class);
    }
}
