/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.danncarlton.services;

import co.com.touresbalon.foundation.danncarlton.dto.PublicReservationsDTO;
import co.com.touresbalon.foundation.danncarlton.persistence.ReservationsPersistenceService;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nrodriguez
 */
@WebService()
public class Reservaciones {

    
    
    @EJB
    private ReservationsPersistenceService reservationsPersistenceService; 
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultarDisponibilidad",action = "consultarDisponibilidad")
    public List<PublicReservationsDTO> consultarDisponibilidad(@WebParam(name = "room") BigDecimal room,@WebParam(name = "hotelId") BigDecimal hotelId) {
        return null;
    }
}
