package Model.Managers;

import Model.DatabaseEntities.AppProperty;

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

    public List<AppProperty> getAppProperties() {
        TypedQuery<AppProperty> appPropertyTypedQuery = em.createQuery("Select app FROM AppProperty app", AppProperty.class);
        return appPropertyTypedQuery.getResultList();
    }

    public AppProperty getAppPropertyByName(String appName) {
        TypedQuery<AppProperty> appPropertyTypedQuery = em.createQuery("select app from AppProperty app where :aName = app.fileName", AppProperty.class);
        appPropertyTypedQuery.setParameter("aName", appName);
        return appPropertyTypedQuery.getSingleResult();
    }

    public void persistAppProperty(AppProperty appProperty) {
        em.persist(appProperty);
    }

}//end of class