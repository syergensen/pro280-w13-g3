package Servlets;

import Model.DatabaseEntities.Group;
import Model.DatabaseEntities.User;
import Model.Managers.GroupManager;
import Model.Managers.UserManager;
import encryption.Encryption;
import encryption.EncryptionType;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * A servlet meant to set up the log in page, and authenticate users
 * User: jflores
 * Date: 2/27/13
 * Time: 5:58 PM -- Created
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String DUMMY_PASSWORD = "dummyPassword";

    @EJB
    UserManager userManager;

    @EJB
    GroupManager groupManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String role = request.getParameter("role");

            Group group = groupManager.getGroup(role);
            if(group == null) {
                group = new Group();
                group.setName(role);
                groupManager.saveGroup(group);
            }

            User user = userManager.getUser(username);
            if(user == null) {
                user = new User();
                user.setName(username);
                user.setPassword(Encryption.digest(DUMMY_PASSWORD, EncryptionType.MD5));
                Set<Group> groups = new HashSet<Group>();
                groups.add(group);
                user.setGroups(groups);
                userManager.saveUser(user);
            }

            request.logout();

            request.login(username, DUMMY_PASSWORD);
            response.sendRedirect(request.getContextPath());
        } catch(ServletException e) {
            request.getRequestDispatcher("/WEB-INF/login/login_error.jsp").forward(request, response);
        }
    }
}
