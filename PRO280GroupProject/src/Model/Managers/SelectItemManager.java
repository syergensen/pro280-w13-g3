package Model.Managers;


import Model.DatabaseEntities.SelectItem;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

//Manager for the SelectItem entity
@LocalBean
@Stateless
public class SelectItemManager {
    @PersistenceContext
    EntityManager em;

    //gets selectItems by groupId
    public List<SelectItem> getSelectItemsByGroup(int groupId)
    {
        TypedQuery<SelectItem> selectItemQuery = em.createQuery("select s from SelectItem s where s.selectGroup.groupId = :groupId", SelectItem.class);
        selectItemQuery.setParameter("groupId", groupId);
        return selectItemQuery.getResultList();
    }

    //gets all selectItems
    public List<SelectItem> getSelectItems()
    {
        TypedQuery<SelectItem> selectItemQuery = em.createQuery("select s from SelectItem s", SelectItem.class);
        return selectItemQuery.getResultList();
    }

    //gets a selectItem by id
    public SelectItem getSelectItem(int id)
    {
        return em.find(SelectItem.class, id);
    }
}//end of class