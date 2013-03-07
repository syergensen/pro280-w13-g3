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

    public List<Region> getRegions() {
        TypedQuery<Region> allRegQuery = em.createQuery("Select r from Regions r", Region.class);
        return allRegQuery.getResultList();
    }
}//end of class