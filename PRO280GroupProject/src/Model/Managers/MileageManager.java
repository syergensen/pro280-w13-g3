package Model.Managers;

import Model.DatabaseEntities.Mileage;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cknox
 * Date: 3/11/13
 */
@Stateless
@LocalBean
public class MileageManager {
    @PersistenceContext
    EntityManager em;

    public List<Mileage> getMileages()
    {
        TypedQuery<Mileage> query = em.createQuery("select m from Mileage m", Mileage.class);
        return query.getResultList();
    }
}
