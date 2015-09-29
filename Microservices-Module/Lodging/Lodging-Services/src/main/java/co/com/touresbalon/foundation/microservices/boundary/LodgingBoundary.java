package co.com.touresbalon.foundation.microservices.boundary;

import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
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
    public Room consultRoomsAviability(String hotelBrand, String city, String checkIn, String checkOut) throws SystemException {
        Room room;

        try {

            Date in = dateFormat.parse(checkIn);
            Date out = dateFormat.parse(checkOut);

            room = (Room) em.createNamedQuery("Room.aviability")
                    .setParameter("checkIn", in, TemporalType.DATE)
                    .setParameter("checkOut", out, TemporalType.DATE)
                    .setParameter("brand", hotelBrand)
                    .setParameter("city", city)
                    .setMaxResults(1)
                    .getResultList()
                    .get(0);

            return room;
        } catch (Exception e) {
            throw new SystemException(e.getMessage());
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Lock(LockType.WRITE)
    public TouresbalonReservations doReservation(Long orderId, Long hotelId, Long roomNumber, String guestName, String checkIn, String checkOut)
            throws SystemException {

        TouresbalonReservations reservation;
        try {

            Date in = dateFormat.parse(checkIn);
            Date out = dateFormat.parse(checkOut);

            utx.begin();

            Long reservationId = this.getReservationId();

            reservation = new TouresbalonReservations(reservationId, orderId, in, out, guestName, hotelId, roomNumber);

            em.persist(reservation);

            utx.commit();
            return reservation;
        } catch (Exception e) {
            throw new SystemException(e.getMessage());
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
