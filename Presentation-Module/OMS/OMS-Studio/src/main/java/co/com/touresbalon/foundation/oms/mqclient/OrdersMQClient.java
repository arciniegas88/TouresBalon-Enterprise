package co.com.touresbalon.foundation.oms.mqclient;

import co.com.touresbalon.foundation.oms.domain.orderprocessing.CancelOrdersBPELRequest;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.jms.*;
import javax.transaction.SystemException;

/**
 * Created by Jenny on 25/10/2015.
 */

@Singleton
public class OrdersMQClient {

    @Inject
    private ActiveMQConnectionFactory factory;

    public void cancelOrder( CancelOrdersBPELRequest request ) throws SystemException{

        try {

            Connection connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("MQ-CancelOrderRequest");

            MessageProducer producer = session.createProducer(destination);
            TextMessage m = session.createTextMessage(request.toString());
            producer.send(destination, m);
            session.close();
            connection.close();

        }catch (JMSException j){
            throw new SystemException( j.getMessage() );
        }
    }

}
