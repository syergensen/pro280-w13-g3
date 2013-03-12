package Model.Managers;

import Model.DatabaseEntities.appProperty;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@LocalBean
@Stateless
public class AppPropertiesManager {

    @PersistenceContext
    EntityManager em;

    public List<appProperty> getAppProperties() {
        TypedQuery<appProperty> appPropertyTypedQuery = em.createQuery("Select app FROM appProperty app", appProperty.class);
        return appPropertyTypedQuery.getResultList();
    }

    public appProperty getAppPropertyByName(String appName) {
        TypedQuery<appProperty> appPropertyTypedQuery = em.createQuery("select app from appProperty app where :aName = app.fileName", appProperty.class);
        appPropertyTypedQuery.setParameter("aName", appName);
        return appPropertyTypedQuery.getSingleResult();
    }

    public void persistAppProperty(appProperty appProperty) {
        em.persist(appProperty);
    }

}//end of class