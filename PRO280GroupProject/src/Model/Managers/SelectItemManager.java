package Model.Managers;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class SelectItemManager {
    @PersistenceContext
    EntityManager em;
}//end of class