package co.com.touresbalon.foundation.businessrules.soap;

import co.com.touresbalon.foundation.businessrules.boundary.BusinessRulesBoundary;
import co.com.touresbalon.foundation.businessrules.model.OrderFact;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by Jenny on 23/09/2015.
 */

@WebService(targetNamespace = "http://touresbalon.com.co/transport/service/task/1.0.0")
public class BusinessRulesWS {

    @Inject
    private BusinessRulesBoundary rulesBoundary;

    @WebMethod(operationName = "evaluateRule" , action = "evaluateRule")
    public OrderFact evaluateRule(@WebParam(name = "fact")OrderFact fact){
        return rulesBoundary.evaluateBusinessRule(fact);
    }

}
