package Model.Managers;


import Model.DatabaseEntities.SelectItem;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@LocalBean
@Stateless
public class SelectItemManager {
    @PersistenceContext
    EntityManager em;

    public List<SelectItem> getSelectItemsByGroup(int groupId)
    {
        TypedQuery<SelectItem> selectItemQuery = em.createQuery("select s from SelectItem s where s.selectGroup.groupId = :groupId", SelectItem.class);
        selectItemQuery.setParameter("groupId", groupId);
        return selectItemQuery.getResultList();
    }

    public List<SelectItem> getSelectItems()
    {
        TypedQuery<SelectItem> selectItemQuery = em.createQuery("select s from SelectItem s", SelectItem.class);
        return selectItemQuery.getResultList();
    }

    public SelectItem getSelectItem(int id)
    {
        return em.find(SelectItem.class, id);
    }
}//end of class