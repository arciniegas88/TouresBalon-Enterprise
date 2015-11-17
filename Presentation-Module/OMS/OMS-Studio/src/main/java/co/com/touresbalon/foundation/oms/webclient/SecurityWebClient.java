package co.com.touresbalon.foundation.oms.webclient;

import co.com.touresbalon.foundation.oms.domain.security.User;
import co.com.touresbalon.foundation.oms.exceptions.BusinessException;
import co.com.touresbalon.foundation.oms.exceptions.SystemException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.xml.sax.InputSource;

import javax.inject.Inject;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.io.StringReader;

/**
 * Created by garciniegas on 16/11/2015.
 */

public class SecurityWebClient {

    private XPath xPath =  XPathFactory.newInstance().newXPath();

    @Inject
    private HttpPost post;

    public User login( User user ) throws BusinessException, SystemException{

        StringBuilder request = new StringBuilder();
        request.append("<authenticationResource>");
        request.append("<email>" + user.getLogin() + "</email>");
        request.append("<password>" + user.getPassword() + "</password>");
        request.append("</authenticationResource>");

        try {

            HttpClient client = HttpClientBuilder.create().build();
            post.setEntity(new StringEntity(request.toString()));

            HttpResponse r = client.execute( post );
            String message = IOUtils.toString((InputStream) r.getEntity().getContent());

            if (r.getStatusLine().getStatusCode() == 200) {

                String exp = "/authenticationResourceResponse/authenticationResourceResult/email";
                user.setEmail(xPath.compile(exp).evaluate(new InputSource(new StringReader(message))));

                exp = "/authenticationResourceResponse/authenticationResourceResult/userName";
                user.setFirstName(xPath.compile(exp).evaluate(new InputSource(new StringReader(message))));

                exp = "/authenticationResourceResponse/authenticationResourceResult/lastName";
                user.setLastName(xPath.compile(exp).evaluate(new InputSource(new StringReader(message))));

                exp = "/authenticationResourceResponse/authenticationResourceResult/userGroup";
                user.setUserGroup(xPath.compile(exp).evaluate(new InputSource(new StringReader(message))));

                exp = "/authenticationResourceResponse/authenticationResourceResult/userId";
                user.setId(xPath.compile(exp).evaluate(new InputSource(new StringReader(message))));

                return user;
            } else {
                throw new BusinessException("Las credenciales son erroneas");
            }

        }catch (Exception e){
            System.out.println( e );
            throw new SystemException("Ha ocurrido un error interno en el sistema");
        }
    }

}
