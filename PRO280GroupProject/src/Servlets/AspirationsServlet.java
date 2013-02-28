package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet meant to set up and receive the post of the Aspiration.jsp page
 * User: jflores
 * Date: 2/27/13
 * Time: 6:37 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("Aspirations.do")
public class AspirationsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //PreferredRegion
        //PreferredCarState
        //PrefferedLivingCondition
        response.sendRedirect("Results.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // May have to request attribute:
        // PrefferedRegions, CarUsed, CarFuelEconomies, CarRating,
        // and LivingConditionOptions.
        // request.getRequestDispatcher("Aspirations.jsp").forward(request,responce);
        response.sendRedirect("Aspiration.jsp");
    }
}
