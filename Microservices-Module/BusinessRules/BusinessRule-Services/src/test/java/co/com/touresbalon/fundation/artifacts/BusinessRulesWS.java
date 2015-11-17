package co.com.touresbalon.fundation.artifacts;

import co.com.touresbalon.foundation.businessrules.model.OrderFact;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by Jenny on 23/09/2015.
 */

@WebService(targetNamespace = "http://touresbalon.com.co/businessrules/service/utility/1.0.0")
public interface BusinessRulesWS {

    @WebMethod(operationName = "evaluateRule" , action = "evaluateRule")
    OrderFact evaluateRule(@WebParam(name = "fact")OrderFact fact);

}
