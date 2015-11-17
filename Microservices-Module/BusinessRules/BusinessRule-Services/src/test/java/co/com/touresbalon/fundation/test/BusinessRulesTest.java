package co.com.touresbalon.fundation.test;

import co.com.touresbalon.foundation.businessrules.model.OrderFact;
import co.com.touresbalon.fundation.artifacts.BusinessRulesWS;
import org.junit.Before;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created by garciniegas on 16/11/2015.
 */

public class BusinessRulesTest {

    private BusinessRulesWS client;

    @Before
    public void init(){

        try {

            QName qname = new QName( "http://touresbalon.com.co/businessrules/service/utility/1.0.0","BusinessRulesWSService" );
            Service s = Service.create(new URL("http://localhost:9090/BusinessRule-Services/BusinessRulesWS?wsdl"), qname);
            client = s.getPort( BusinessRulesWS.class );

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------------

    @Test()
    public void evaluateBusinessRule_PLATINUM(){

        OrderFact fact = new OrderFact();
        fact.setUserType("PLATINUM");
        fact.setOrderAmount(1000000L);
        fact = client.evaluateRule( fact );

        assertTrue(" Evaluate PLATINUM user type: ", fact.getApproval());
    }


    // ------------------------------------

    @Test()
    public void evaluateBusinessRule_GOLD(){

        OrderFact fact = new OrderFact();
        fact.setUserType("GOLD");
        fact.setOrderAmount(1000000L);
        fact = client.evaluateRule( fact );

        assertTrue(" Evaluate GOLD user type: ", fact.getApproval());
    }

    // ------------------------------------

    @Test()
    public void evaluateBusinessRule_GOLD_ORDER_GT_6000000(){

        OrderFact fact = new OrderFact();
        fact.setUserType("GOLD");
        fact.setOrderAmount(7000000L);
        fact = client.evaluateRule( fact );

        assertFalse(" Evaluate GOLD user, order gt 6000000 type: ", fact.getApproval());
    }

    // ------------------------------------

    @Test()
    public void evaluateBusinessRule_GOLD_ORDER_LT_6000000(){

        OrderFact fact = new OrderFact();
        fact.setUserType("GOLD");
        fact.setOrderAmount(5000000L);
        fact = client.evaluateRule( fact );

        assertFalse(" Evaluate GOLD user, order lt 6000000 type: ", fact.getApproval());
    }

}
