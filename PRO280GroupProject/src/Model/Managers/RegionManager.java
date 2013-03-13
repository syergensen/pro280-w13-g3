package Model.Managers;

import Model.DatabaseEntities.Region;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * User: jflores
 * Date: 3/6/13
 * Time: 6:02 PM
 * Weather man
 */
@LocalBean
@Stateless
public class RegionManager {
    @PersistenceContext
    EntityManager em;

    public static final int NUEMONT_HOUSING_COST = 1410;

    public List<Region> getRegions() {
        TypedQuery<Region> allRegQuery = em.createQuery("Select r from Regions r", Region.class);
        return allRegQuery.getResultList();
    }

    public Region getRegionBasedOffName(String regionName) {
        TypedQuery<Region> getRegion = em.createQuery("Select r from Regions r where r.regionName = :rName", Region.class);
        getRegion.setParameter("rName", regionName);
        return getRegion.getSingleResult();
    }

    public int getMortgageBasedOffRegionName(String regionName) {
        return getRegionBasedOffName(regionName).getMortgage();
    }

    public int getRentBasedOffRegionName(String regionName) {
        return getRegionBasedOffName(regionName).getRent();
    }

}//end of class