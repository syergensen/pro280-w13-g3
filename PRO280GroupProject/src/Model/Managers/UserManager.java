package Model.Managers;

import Model.DatabaseEntities.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cknox
 * Date: 3/8/13
 *
 * Manager for the User entity
 */
@Stateless
@LocalBean
public class UserManager {

    @PersistenceContext
    private EntityManager em;

    //gets all users
    public List<User> getUsers() {
        TypedQuery<User> query = em.createNamedQuery(User.ALL_USERS_QUERY, User.class);
        return query.getResultList();
    }

    //gets a user by username
    public User getUser(String username) {
        TypedQuery<User> query = em.createNamedQuery(User.USER_NAME_QUERY, User.class);
        query.setParameter("name", username);
        List<User> users = query.getResultList();
        if(users != null && users.size() != 0)
            return users.get(0);
        return null;
    }

    //saves a user
    public void saveUser(User user) {
        em.persist(user);
    }
}
