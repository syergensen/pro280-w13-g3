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
 *
 * Manager for the Salary entity
 */
@LocalBean
@Stateless
public class SalaryManager {
    @PersistenceContext
    EntityManager em;

    //gets a salary by degree and region
    public Salary getSalaryByDegreeAndRegion(String degree, String region)
    {
        TypedQuery<Salary> salaryQuery = em.createQuery("select s from Salaries s where s.salaryPk.degree = :degree and s.salaryPk.region = :region", Salary.class);
        salaryQuery.setParameter("degree", degree);
        salaryQuery.setParameter("region", region);
        return salaryQuery.getSingleResult();
    }

    //gets all salaries
    public List<Salary> getSalaries() {
        TypedQuery<Salary> allSalaryQuery = em.createQuery("Select sal from Salaries sal", Salary.class);
        return allSalaryQuery.getResultList();
    }

}//end of class