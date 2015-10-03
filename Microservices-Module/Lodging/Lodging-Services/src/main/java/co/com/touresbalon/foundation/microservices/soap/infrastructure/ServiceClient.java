
package co.com.touresbalon.foundation.microservices.soap.infrastructure;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 */
@WebServiceClient(name = "ServiceClient", targetNamespace = "http://touresbalon.com.co/task/lodging/v1", wsdlLocation = "file:///j01/workspace/idea_projects/TouresBalon-Enterprise/Microservices-Module/Lodging/Lodging-Services/src/main/webapp/WEB-INF/wsdl/ServiceClient.wsdl")
public class ServiceClient
        extends Service {

    private final static URL LODGINGSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(ServiceClient.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = ServiceClient.class.getResource(".");
            url = new URL(baseUrl, "file:///j01/workspace/idea_projects/TouresBalon-Enterprise/Microservices-Module/Lodging/Lodging-Services/src/main/webapp/WEB-INF/wsdl/ServiceClient.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:///j01/workspace/idea_projects/TouresBalon-Enterprise/Microservices-Module/Lodging/Lodging-Services/src/main/webapp/WEB-INF/wsdl/ServiceClient.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        LODGINGSERVICE_WSDL_LOCATION = url;
    }

    public ServiceClient(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServiceClient() {
        super(LODGINGSERVICE_WSDL_LOCATION, new QName("http://touresbalon.com.co/task/lodging/v1", "ServiceClient"));
    }

    /**
     * @return returns LodgingPort
     */
    @WebEndpoint(name = "LodgingPort")
    public LodgingPort getLodgingPort() {
        return super.getPort(new QName("http://touresbalon.com.co/task/lodging/v1", "LodgingPort"), LodgingPort.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns LodgingPort
     */
    @WebEndpoint(name = "LodgingPort")
    public LodgingPort getLodgingPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://touresbalon.com.co/task/lodging/v1", "LodgingPort"), LodgingPort.class, features);
    }

}
