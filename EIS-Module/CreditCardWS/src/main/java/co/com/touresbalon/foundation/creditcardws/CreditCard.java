/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.creditcardws;

import co.com.touresbalon.foundation.creditcard.bussines.RegistryCreditCardBundary;
import co.com.touresbalon.foundation.creditcard.bussines.SearchCreditCardBundary;
import co.com.touresbalon.foundation.creditcard.dto.Transaction;
import co.com.touresbalon.foundation.creditcard.dto.Person;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nrodriguez
 */

@WebService(targetNamespace = "http://redeban.com/creditcards/ws")
public class CreditCard {
    
    private final SearchCreditCardBundary searchCreditCardBundary = new SearchCreditCardBundary();
    private final RegistryCreditCardBundary registryCreditCardBundary = new RegistryCreditCardBundary();
    
    
    @WebMethod(operationName = "validateCreditCard",action = "validateCreditCard")
    public boolean validateCreditCard(@WebParam(name = "person") Person person ){
        return searchCreditCardBundary.searchCreditCardBundary(person);
    }

    @Oneway
    @WebMethod(operationName = "executeTransaction",action = "executeTransaction")
    public void executeTransaction(@WebParam(name = "card") Transaction card ){
        registryCreditCardBundary.executeTransaction(card);
    }
    
}
