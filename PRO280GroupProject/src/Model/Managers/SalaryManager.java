package Model.Managers;

import Model.DatabaseEntities.Salary;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jflores
 * Date: 3/7/13
 * Time: 12:56 AM
 * To change this template use File | Settings | File Templates.
 */
@LocalBean
@Stateless
public class SalaryManager {
    @PersistenceContext
    EntityManager em;

    public List<Salary> getSalaries() {
        TypedQuery<Salary> allSalaryQuery = em.createQuery("Select sal from Salaries sal", Salary.class);
        return allSalaryQuery.getResultList();
    }

}//end of class