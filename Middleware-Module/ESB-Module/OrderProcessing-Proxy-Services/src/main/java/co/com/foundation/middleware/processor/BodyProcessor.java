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
        int size = Integer.parseInt( xPath.compile( count ).evaluate( new InputSource( new StringReader( payload ) ) ) );

        for( int i=1;i<=size;++i ){

            InputSource is = new InputSource( new StringReader( payload ) );
            String expression = "/*[local-name() = 'CreateSalesOrderRequest']/order/items[" +i+"]/productName";
            String content = xPath.compile(expression).evaluate(is);
            System.out.println("-----------------> " + content);
        }

    }
}
