package co.com.touresbalon.foundation.products.boundary;

import co.com.touresbalon.foundation.crosscutting.exceptions.ExceptionBuilder;
import co.com.touresbalon.foundation.crosscutting.exceptions.SystemException;
import co.com.touresbalon.foundation.products.entity.Campaign;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Created by Jenny Rodriguez on 17/08/15.
 */

@Stateless
public class CampaignBoundary {

    @Inject
    private Logger logger;

    @Inject
    private ExceptionBuilder exceptionBuilder;

    @PersistenceContext
    private EntityManager em;


    public CampaignBoundary() {

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Campaign> searchCampaign() throws SystemException {

        try {
            return em.createNamedQuery("Campaign.findAll", Campaign.class)
                    .getResultList();
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createCampaingn(Campaign campaign) throws SystemException {
        try {
            em.persist(campaign);
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateCampaingn(Campaign campaign)throws SystemException{
        try {
            em.createNamedQuery("Campaign.update")
                    .setParameter("NAME", campaign.getName())
                    .setParameter("IMAGE_REF", campaign.getImageRef())
                    .setParameter("EFFECTIVE_DATE", campaign.getEffectiveDate())
                    .setParameter("ID", campaign.getId())
                    .executeUpdate();
            em.flush();

        }catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteCampaingn(Long id)throws SystemException{
        try {
            em.createNamedQuery("Campaign.delete")
                    .setParameter("ID", id)
                    .executeUpdate();
            em.flush();

        }catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Campaign> searchCampaignByIdProduct(Long idProduct) throws SystemException {
        try {
            return em.createNamedQuery("Campaign.ByIdProduct", Campaign.class)
                    .setParameter("ID_PRODUCT", idProduct)
                    .getResultList();
        } catch (Throwable enf) {
            logger.error(exceptionBuilder.getSystemErrorMessage() + " : " + enf.getMessage(), enf);
            throw exceptionBuilder.buildSystemException();
        }
    }







}
