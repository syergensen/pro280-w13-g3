package Model.Managers;

import Model.DatabaseEntities.Car;

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
public class CarManager {
    @PersistenceContext
    private EntityManager em;

    public Car getCarByQuality(String quality)
    {
        TypedQuery<Car> query = em.createQuery("select c from Car c where c.quality = :quality", Car.class);
        query.setParameter("quality", quality);
        return query.getSingleResult();
    }

    public List<Car> getCars()
    {
        TypedQuery<Car> query = em.createQuery("select c from Car c", Car.class);
        return query.getResultList();
    }
}
