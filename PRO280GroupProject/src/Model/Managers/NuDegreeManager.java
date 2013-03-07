package Model.Managers;

import Model.DatabaseEntities.NuDegrees;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jflores
 * Date: 3/6/13
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
@LocalBean
@Stateless
public class NuDegreeManager {
    @PersistenceContext
    EntityManager em;

    public List<NuDegrees> getRegions() {
        TypedQuery<NuDegrees> allRegQuery = em.createQuery("Select d from NuDegrees d", NuDegrees.class);
        return allRegQuery.getResultList();
    }
}//end of class