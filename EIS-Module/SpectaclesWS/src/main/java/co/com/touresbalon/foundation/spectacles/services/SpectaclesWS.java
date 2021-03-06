/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.spectacles.services;

import co.com.touresbalon.foundation.spectacles.dto.TicketResponseDTO;
import co.com.touresbalon.foundation.spectacles.persistence.SpectaclesPersistenceService;
import java.math.BigInteger;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nrodriguez
 */

@WebService(targetNamespace = "http://spectacles.com.co/service/task/1.0.0")
public class SpectaclesWS {

    /**
     * This is a sample web service operation
     */
    @Inject
    private SpectaclesPersistenceService spectaclesPersistenceServices;
    
    
   /**
     * @param idSpectacle
     * @return
     */

    @WebMethod(operationName = "searchTicketByIdSpectacle",action = "searchTicketByIdSpectacle")
    public TicketResponseDTO searchTicketByIdSpectacle(@WebParam(name = "idSpectacle") BigInteger idSpectacle){
        return spectaclesPersistenceServices.searchTicketByIdSpectacle(idSpectacle);
    }
    /**
     * @param idSpectacle
     * @param idTicket
     * @return
     */
    @WebMethod(operationName = "buySpectacleByTicket",action = "buySpectacleByTicket")
    public boolean buySpectacleByTicket(@WebParam(name = "idSpectacle") BigInteger idSpectacle, @WebParam(name = "idTicket") BigInteger idTicket){
        return spectaclesPersistenceServices.buySpectacleByTicket(idSpectacle,idTicket);
    }

    /**
     * @param idSpectacle
     * @param idTicket
     * @return
     */
    @WebMethod(operationName = "cancelSpectacleReservation",action = "cancelSpectacleReservation")
    public boolean cancelSpectacleReservation(@WebParam(name = "idSpectacle") BigInteger idSpectacle, @WebParam(name = "idTicket") BigInteger idTicket){
        return spectaclesPersistenceServices.cancelSpectacleReservation(idSpectacle,idTicket);
    }
    
    
    
}  
