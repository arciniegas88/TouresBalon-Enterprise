package co.com.touresbalon.foundation.products.boundary;

import co.com.touresbalon.foundation.crosscutting.exceptions.ExceptionBuilder;
import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import co.com.touresbalon.foundation.products.dto.PartnerServiceWrapper;
import co.com.touresbalon.foundation.products.entity.*;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by garciniegas on 11/10/2015.
 */

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PartnerServicesBoundary {

    @Inject
    private Logger logger;

    @Inject
    private ExceptionBuilder exceptionBuilder;

    @PersistenceContext
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void updateRates(PartnerServiceWrapper wrapper)throws SystemException{

        try {

            if (wrapper.getTransports() != null) {

                for (Transport t : wrapper.getTransports()) {
                    em.createNamedQuery("Transport.updateRate")
                            .setParameter("COST", t.getCost())
                            .setParameter("ID", t.getId())
                            .executeUpdate();
                    em.flush();
                }
            }

            if (wrapper.getLodgings() != null) {

                for (Lodging t : wrapper.getLodgings()) {
                    em.createNamedQuery("Lodging.updateRate")
                            .setParameter("COST", t.getCost())
                            .setParameter("ID", t.getId())
                            .executeUpdate();
                    em.flush();
                }
            }

            if (wrapper.getSpectacles() != null) {

                for (Spectacle t : wrapper.getSpectacles()) {
                    em.createNamedQuery("Spectacle.updateRate")
                            .setParameter("COST", t.getCost())
                            .setParameter("ID", t.getId())
                            .executeUpdate();
                    em.flush();
                }
            }

        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    public List<Transport> getTransports() throws SystemException {
        try {

            return em.createNamedQuery("Transport.findAll", Transport.class)
                    .getResultList();
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    public List<Spectacle> getSpectacles() throws SystemException {
        try {

            return em.createNamedQuery("Spectacle.findAll", Spectacle.class)
                    .getResultList();
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    public List<Lodging> getLodging() throws SystemException {
        try {

            return em.createNamedQuery("Lodging.findAll", Lodging.class)
                    .getResultList();
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    public List<Country> getCountries() throws SystemException {

        try {
            return em.createNamedQuery("Country.findAll", Country.class)
                    .getResultList();
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    public List<City> getCitiesByContry(Integer country) throws SystemException {

        try {

            return em.createNamedQuery("City.findAllByCountry", City.class)
                    .setParameter("COUNTRY", country)
                    .getResultList();
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

}
