package co.com.touresbalon.foundation.products.boundary;

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
 * Created by gustavo on 17/08/15.
 */

@Stateless
public class CampaignBoundary {

    @Inject
    private Logger logger;

    @PersistenceContext
    private EntityManager em;


    public CampaignBoundary(){

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Campaign> searchCampaign(){

        return em.createNamedQuery("Campaign.findAll", Campaign.class)
                .getResultList();
    }



}
