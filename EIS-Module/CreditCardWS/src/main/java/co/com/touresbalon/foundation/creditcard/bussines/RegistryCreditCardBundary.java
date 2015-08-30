/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.creditcard.bussines;

import co.com.touresbalon.foundation.creditcard.dto.Transaction;

import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.*;

/**
 * @author nrodriguez
 */


@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class RegistryCreditCardBundary implements Serializable {

    private File file = new File( System.getProperty("touresbalon.creditcard.repository") );

    public RegistryCreditCardBundary() {
    }

    /**
     * Adicionar tarjeta de credito
     *
     * @param card
     * @return
     * @throws IOException
     */

    @Lock(LockType.WRITE)
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void executeTransaction(Transaction card) {

        try {

            FileWriter fw = new FileWriter(file,true);
            fw.write( card.toString()+"\n" );
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

} 
    
