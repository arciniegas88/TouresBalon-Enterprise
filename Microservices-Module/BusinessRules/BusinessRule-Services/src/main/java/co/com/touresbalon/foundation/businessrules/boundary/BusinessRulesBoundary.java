package co.com.touresbalon.foundation.businessrules.boundary;

import co.com.touresbalon.foundation.businessrules.model.OrderFact;
import co.com.touresbalon.foundation.crosscutting.service.factory.ServiceFactory;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;

import javax.inject.Inject;

/**
 * Created by Jenny on 22/09/2015.
 */


public class BusinessRulesBoundary {

    //[attributes] --------------------------

    @Inject
    private Logger logger;

    @Inject
    private KieSession session;

    public BusinessRulesBoundary(){

    }

    public OrderFact evaluateBusinessRule(OrderFact fact){

        session.insert(fact);
        session.fireAllRules();
        return fact;
    }

}
