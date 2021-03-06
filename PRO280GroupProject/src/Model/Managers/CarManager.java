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
 *
 * Manager for the Car entity
 */
@Stateless
@LocalBean
public class CarManager {
    @PersistenceContext
    private EntityManager em;

    public static final int CAR_PAYMENT_PERIOD = 5;

    //gets a car by its quality
    public Car getCarByQuality(String quality)
    {
        TypedQuery<Car> query = em.createQuery("select c from Car c where c.quality = :quality", Car.class);
        query.setParameter("quality", quality);
        return query.getSingleResult();
    }

    //gets all cars
    public List<Car> getCars()
    {
        TypedQuery<Car> query = em.createQuery("select c from Car c", Car.class);
        return query.getResultList();
    }
}
