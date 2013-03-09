package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Kills the session, which i guess logs out the user, and redirects back to the front page
 * User: jflores
 * Date: 2/27/13
 * Time: 6:19 PM -- Created
 */
@WebServlet("/logout.do")
public class LogOutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.logout();
        request.getSession().invalidate();
        response.sendRedirect("./");
    }
}
