package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * A servlet meant to set up and receive the post of the Aspiration.jsp page
 * User: jflores
 * Date: 2/27/13
 * Time: 6:37 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/aspirations.do")
public class AspirationsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //PreferredRegion
        session.setAttribute("aspirations_region", request.getParameter("region"));
        //PreferredCarState
        session.setAttribute("aspirations_carCondition", request.getParameter("carCondition"));
        session.setAttribute("aspirations_carFuelEconomy", request.getParameter("carFuelEconomy"));
        session.setAttribute("aspirations_carQuality", request.getParameter("carQuality"));
        //PrefferedLivingCondition
        session.setAttribute("aspirations_house", request.getParameter("house"));
        request.getRequestDispatcher("/result.do").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // May have to request attribute:
        // PrefferedRegions, CarUsed, CarFuelEconomies, CarRating,
        // and LivingConditionOptions.
        request.getRequestDispatcher(getServletContext().getInitParameter("aspirations")).forward(request, response);

    }
}
