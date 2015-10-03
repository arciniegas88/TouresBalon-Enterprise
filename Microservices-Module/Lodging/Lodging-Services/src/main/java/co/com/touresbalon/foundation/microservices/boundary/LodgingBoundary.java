package co.com.touresbalon.foundation.microservices.boundary;

import co.com.touresbalon.foundation.crosscutting.exceptions.BusinessException;
import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import co.com.touresbalon.foundation.microservices.dto.soap.FaultMsg;
import co.com.touresbalon.foundation.microservices.dto.soap.SystemFault;
import co.com.touresbalon.foundation.microservices.entity.Room;
import co.com.touresbalon.foundation.microservices.entity.TouresbalonReservations;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.transaction.UserTransaction;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by harcalejo on 6/09/15.
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class LodgingBoundary {

    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction utx;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public LodgingBoundary() {

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Room consultRoomsAvailability(Date checkIn, Date checkOut, String brand, String city) throws FaultMsg {
        try {
            List resultList = em.createNamedQuery("Room.Availability")
                    .setParameter("checkIn", checkIn, TemporalType.DATE)
                    .setParameter("checkOut", checkOut, TemporalType.DATE)
                    .setParameter("brand", brand)
                    .setParameter("city", city)
                    .setMaxResults(1)
                    .getResultList();

            if (resultList.isEmpty()) {
                throw new BusinessException("The result is Empty");
            } else {
                return (Room) resultList.get(0);
            }
        } catch (Exception e) {
            SystemFault fault = new SystemFault();
            fault.setDescription(e.getMessage());
            fault.setCode("00");

            throw new FaultMsg(e.getMessage(), fault);
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Lock(LockType.WRITE)
    public TouresbalonReservations doReservation(Long orderId, Long hotelId, Long roomNumber, String guestName, Date checkIn, Date checkOut)
            throws FaultMsg {

        TouresbalonReservations reservation;
        try {

            utx.begin();

            Long reservationId = this.getReservationId();

            reservation = new TouresbalonReservations(reservationId, orderId, checkIn, checkOut, guestName, hotelId,
                    roomNumber);

            em.persist(reservation);

            utx.commit();
            return reservation;
        } catch (Exception e) {
            SystemFault fault = new SystemFault();
            fault.setDescription(e.getMessage());
            fault.setCode("00");

            throw new FaultMsg(e.getMessage(), fault);
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public String updateReservation(Long reservationId, Long status) throws SystemException {
        try {


            TouresbalonReservations reservation = em.find(TouresbalonReservations.class, reservationId);
            if (null != reservation) {
                utx.begin();

                reservation.setState(status);

                em.merge(reservation);

                utx.commit();
            } else {
                return "Error, wrong reservation Id";
            }

        } catch (Exception e) {
            throw new SystemException(e.getMessage());
        }

        return "Service Completed";

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public TouresbalonReservations getReservation(Long reservationId) throws SystemException {

        try {
            return em.find(TouresbalonReservations.class, reservationId);
        } catch (Exception e) {
            throw new SystemException(e.getMessage());
        }
    }

    private Long getReservationId() throws SystemException {
        String sql = "SELECT TOURESBALON_RESERVATION_SEQ.NEXTVAL FROM dual";

        try {
            return ((BigDecimal) em.createNativeQuery(sql).getSingleResult()).longValue();
        } catch (Exception e) {
            throw new SystemException(e.getMessage());
        }
    }
}
