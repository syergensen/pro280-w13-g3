package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet meant to set up and receive the post of the Start.jsp page
 * User: jflores
 * Date: 2/27/13
 * Time: 6:21 PM -- Created
 */
@WebServlet("/start.do")
public class StartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //If agreed to terms and service
        if(request.getParameter("agree")!=null)
        {
            response.sendRedirect("./school.do");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pull data from model about terms and service.
    }
}
