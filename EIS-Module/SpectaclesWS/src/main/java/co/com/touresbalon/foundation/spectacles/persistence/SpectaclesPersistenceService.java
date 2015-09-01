/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.spectacles.persistence;

import co.com.touresbalon.foundation.spectacles.dto.MensajeRespuesta;
import co.com.touresbalon.foundation.spectacles.dto.SpectacleDTO;
import co.com.touresbalon.foundation.spectacles.dto.TicketResponseDTO;
import co.com.touresbalon.foundation.spectacles.entity.Spectacle;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nrodriguez
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class SpectaclesPersistenceService {

    private static final String spectacleTicketClosed = "C";
    private static final String spectacleTicketOpen = "O";
    private static final String spectacleTicketReservation = "R";

    @PersistenceContext(unitName = "SPECTACLES-PU")
    private EntityManager entityManager;

    public SpectaclesPersistenceService() {
    }

    @Lock(LockType.READ)
    public TicketResponseDTO searchTicketByIdSpectacle(BigInteger idSpectacle) {

        TicketResponseDTO tickecResponseDTO = new TicketResponseDTO();
        tickecResponseDTO.setTicket(new BigInteger("0"));
        tickecResponseDTO.setTransactionSuccess(false);

        List<Spectacle> listSpectacle = new ArrayList<Spectacle>();
        if (idSpectacle != null) {
            listSpectacle = entityManager.createNamedQuery("Spectacle.findBySpectacleAndState", Spectacle.class)
                    .setParameter("idSpectacle", idSpectacle)
                    .setParameter("state", spectacleTicketOpen).getResultList();
        }

        if (!listSpectacle.isEmpty()) {
            Spectacle spectacle = listSpectacle.get(0);
            if (updateStateTikect(spectacle, spectacleTicketReservation)) {
                tickecResponseDTO.setTicket(spectacle.getSpectaclePK().getIdTicket());
                tickecResponseDTO.setTransactionSuccess(true);
            }
        }

        return tickecResponseDTO;
    }

    @Lock(LockType.READ)
    public boolean buySpectacleByTicket(BigInteger idSpectacle, BigInteger idTicket) {
        boolean valido = false;

        if (idSpectacle != null && idTicket != null) {
            try {
                Spectacle spectacle = entityManager.createNamedQuery("Spectacle.findByBuySpectacle", Spectacle.class)
                        .setParameter("idSpectacle", idSpectacle)
                        .setParameter("idTicket", idTicket)
                        .setParameter("state", spectacleTicketReservation).getSingleResult();

                if (spectacle != null) {
                    valido = updateStateTikect(spectacle, spectacleTicketClosed);
                }
            } catch (NoResultException e) {
                System.out.println("noo se encontro registros");
            }
        }
        return valido;
    }
    @Lock(LockType.READ)
    public boolean cancelSpectacleReservation(BigInteger idSpectacle, BigInteger idTicket) {
        boolean valido = false;

        if (idSpectacle != null && idTicket != null) {
            try {
                Spectacle spectacle = entityManager.createNamedQuery("Spectacle.findByBuySpectacle", Spectacle.class)
                        .setParameter("idSpectacle", idSpectacle)
                        .setParameter("idTicket", idTicket)
                        .setParameter("state", spectacleTicketReservation).getSingleResult();

                if (spectacle != null) {
                    valido = updateStateTikect(spectacle, spectacleTicketOpen);
                }
            } catch (NoResultException e) {
                System.out.println("noo se encontro registros");
            }
        }
        return valido;
    }

    /**
     *
     * @param spectacle
     * @param state
     * @return
     */
    @Lock(LockType.WRITE)
    public boolean updateStateTikect(Spectacle spectacle, String state) {
        boolean valida = true;
        try {
            spectacle.setState(state);
            entityManager.merge(spectacle);
            entityManager.flush();

        } catch (Exception e) {
            e.printStackTrace();
            valida = false;
        }
        return valida;
    }

    /**
     * Realizar una busqum<.eda de espectaculos por estado @param idSpectacle
     *
     * @
     * param state
     * @return
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SpectacleDTO> searchSpectaclesByIdAndState(BigInteger idSpectacle, String state) {
        List<SpectacleDTO> listSpectacleDTO = new ArrayList<SpectacleDTO>();
        List<Spectacle> listSpectacle = new ArrayList<Spectacle>();
        if (idSpectacle != null && state != null) {
            listSpectacle = entityManager.createNamedQuery("Spectacle.findBySpectacleAndState", Spectacle.class)
                    .setParameter("idSpectacle", idSpectacle)
                    .setParameter("state", state).getResultList();
        }

        for (Spectacle spectacle : listSpectacle) {
            SpectacleDTO spectacleDTO = new SpectacleDTO();
            spectacleDTO.setIdSpectacle(spectacle.getSpectaclePK().getIdSpectacle());
            spectacleDTO.setIdTicket(spectacle.getSpectaclePK().getIdTicket());
            spectacleDTO.setDescriptionSpectacle(spectacle.getDescriptionSpectacle());
            spectacleDTO.setState(spectacle.getState());
            listSpectacleDTO.add(spectacleDTO);
        }

        return listSpectacleDTO;
    }

    /**
     * realizar una compra por varios espectaculos
     *
     * @param spectacleList
     * @return
     */
    public MensajeRespuesta buyReservationSpectacle(List<SpectacleDTO> spectacleList) {
        MensajeRespuesta mensajeRespuesta = new MensajeRespuesta();

        for (SpectacleDTO spectacleDTO : spectacleList) {
            Spectacle spectacle = entityManager.createNamedQuery("Spectacle.findByPK", Spectacle.class)
                    .setParameter("idSpectacle", spectacleDTO.getIdSpectacle())
                    .setParameter("idTicket", spectacleDTO.getIdTicket()).getSingleResult();
            if (spectacle.getState().compareTo(spectacleTicketClosed) == 0) {
                mensajeRespuesta.setCodigoRespuesta("002");
                mensajeRespuesta.setDescripcionRespuesta("El tiquite ya no esta disponible");
                break;
            }

        }

        return mensajeRespuesta;
    }

}
