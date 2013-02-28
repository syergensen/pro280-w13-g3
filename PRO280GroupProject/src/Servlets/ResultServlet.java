package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet meant to set up and receive the post of the Results.jsp page
 * User: Jflores
 * Date: 2/27/13
 * Time: 6:40 PM   -- Created
 */
public class ResultServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Model Calculate:
        // return results list <String nameType, int dollarValue>
        // Set to attribute : allResults
        // Get QuarterExtra default=0;
        request.getRequestDispatcher("Results.jsp").forward(request, response);
    }
}
