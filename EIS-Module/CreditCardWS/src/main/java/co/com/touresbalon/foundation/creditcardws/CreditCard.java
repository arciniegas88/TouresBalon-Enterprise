/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.creditcardws;

import co.com.touresbalon.foundation.creditcard.bussines.RegistryCreditCardBundary;
import co.com.touresbalon.foundation.creditcard.bussines.SearchCreditCardBundary;
import co.com.touresbalon.foundation.creditcard.dto.Card;
import co.com.touresbalon.foundation.creditcard.dto.Person;
import java.io.IOException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nrodriguez
 */
@WebService()
public class CreditCard {
    
    private final SearchCreditCardBundary searchCreditCardBundary = new SearchCreditCardBundary();
    private final RegistryCreditCardBundary registryCreditCardBundary = new RegistryCreditCardBundary();
    
    
    @WebMethod(operationName = "validateCreditCard",action = "validateCreditCard")
    public boolean validateCreditCard(@WebParam(name = "person") Person person ){
        return searchCreditCardBundary.searchCreditCardBundary(person);
    }
    
    @WebMethod(operationName = "registryCreditCard",action = "registryCreditCard")
    public boolean registryCreditCard(@WebParam(name = "card") Card card ) throws IOException{
        return registryCreditCardBundary.addTarjetaCredito(card);
    }
    
}
