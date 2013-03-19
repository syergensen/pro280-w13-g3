package Model.Managers;

import Model.DatabaseEntities.SelectGroup;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


//Manager for the SelectGroup entity
@LocalBean
@Stateless
public class SelectGroupManager {
    @PersistenceContext
    EntityManager em;

    //gets selectGroup by description
    public SelectGroup getSelectGroupByDescription(String description)
    {
        TypedQuery<SelectGroup> selectGroupQuery = em.createQuery("select s from SelectGroup s where s.description = :description", SelectGroup.class);
        selectGroupQuery.setParameter("description", description);
        return selectGroupQuery.getSingleResult();
    }

    //gets all selectGroups
    public List<SelectGroup> getSelectGroups()
    {
        TypedQuery<SelectGroup> selectGroupQuery = em.createQuery("select s from SelectGroup s", SelectGroup.class);
        return selectGroupQuery.getResultList();
    }

    //gets a selectGroup by id
    public SelectGroup getSelectGroup(int id)
    {
        return em.find(SelectGroup.class, id);
    }
}//end of class