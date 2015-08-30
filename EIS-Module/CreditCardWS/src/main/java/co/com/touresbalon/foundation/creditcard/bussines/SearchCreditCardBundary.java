/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.creditcard.bussines;

import co.com.touresbalon.foundation.creditcard.dto.Person;
import java.io.Serializable;


/**
 *
 * @author nrodriguez
 */

public class SearchCreditCardBundary implements Serializable{

    public static String numberCardDefaul = "318586";
    
    public boolean searchCreditCardBundary(Person person){
        if(person!=null && person.getNumberCreditCard()!=null){
            return person.getNumberCreditCard().contains(numberCardDefaul);
        }
        return false;
    }
    
    
    
}
