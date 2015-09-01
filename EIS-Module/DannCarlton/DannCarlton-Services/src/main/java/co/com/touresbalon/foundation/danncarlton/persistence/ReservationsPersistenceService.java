/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.danncarlton.persistence;

import co.com.touresbalon.foundation.danncarlton.dto.PublicReservationsDTO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nrodriguez
 */

@Stateless
public class ReservationsPersistenceService {
    @PersistenceContext(unitName="DANNCARLTON-PU")
    private EntityManager em;

    public ReservationsPersistenceService() {
    }
    
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<PublicReservationsDTO> consultarDisponibilidad(BigDecimal room,BigDecimal hotelID){
        List<PublicReservationsDTO>  listReservationsDTO = new ArrayList<PublicReservationsDTO>();
        
//        if((idTipoServicio!=null) && (idCompania!=null)){
//         Companias compania = em.createNamedQuery("Companias.findByIdPK", Companias.class)
//                 .setParameter("idTipoServicio", idTipoServicio)
//                 .setParameter("idCompania", idCompania).getSingleResult();
//         if(compania!=null){
//            CompaniasDTO companiasDTO = new CompaniasDTO(); 
//            companiasDTO.setIdCompania(compania.getCompaniasPK().getIdCompania());
//            companiasDTO.setNombre(compania.getNombre());
//            companiasDTO.setIdTipoServicio(compania.getCompaniasPK().getIdTipoServicio());
//            listCompaniasDTO.add(companiasDTO);
//         }
//        }
//        
//        if((idTipoServicio==null) && (idCompania!=null)){
//            List<Companias> listCompanias = em.createNamedQuery("Companias.findByIdCompania", Companias.class).
//                    setParameter("idCompania", idCompania).getResultList();
//            
//            for (Companias compania : listCompanias) {
//                CompaniasDTO companiasDTO = new CompaniasDTO(); 
//                companiasDTO.setIdCompania(compania.getCompaniasPK().getIdCompania());
//                companiasDTO.setNombre(compania.getNombre());
//                companiasDTO.setIdTipoServicio(compania.getCompaniasPK().getIdTipoServicio());
//                listCompaniasDTO.add(companiasDTO);
//            }
//
//        }
//        
//        if((idTipoServicio!=null) && (idCompania==null)){
//            List<Companias> listCompanias = em.createNamedQuery("Companias.findByIdTipoServicio", Companias.class).
//                    setParameter("idTipoServicio", idTipoServicio).getResultList();
//            
//            for (Companias compania : listCompanias) {
//                CompaniasDTO companiasDTO = new CompaniasDTO(); 
//                companiasDTO.setIdCompania(compania.getCompaniasPK().getIdCompania());
//                companiasDTO.setNombre(compania.getNombre());
//                companiasDTO.setIdTipoServicio(compania.getCompaniasPK().getIdTipoServicio());
//                listCompaniasDTO.add(companiasDTO);
//            }
//
//        }
//        
//        if((idTipoServicio==null) && (idCompania==null)){
//            List<Companias> listCompanias = em.createNamedQuery("Companias.findAll", Companias.class).getResultList();
//            for (Companias compania : listCompanias) {
//                
//                CompaniasDTO companiasDTO = new CompaniasDTO(); 
//                companiasDTO.setIdCompania(compania.getCompaniasPK().getIdCompania());
//                companiasDTO.setNombre(compania.getNombre());
//                companiasDTO.setIdTipoServicio(compania.getCompaniasPK().getIdTipoServicio());
//                listCompaniasDTO.add(companiasDTO);
//            }
//        }
        return listReservationsDTO;
         
    }
    
    
}
