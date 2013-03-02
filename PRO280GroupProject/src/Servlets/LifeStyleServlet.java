package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet meant to set up and receive the post of the LifeStyle.jsp page
 * User: jflores
 * Date: 2/27/13
 * Time: 6:33 PM -- Created
 */
@WebServlet("/lifeStyle.do")
public class LifeStyleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // HousingSituation
        // MonthlyRent
        // UtilitiesBill
        // DietLunchEatOutWeekly
        // DietDinnerEatOutWeekly
        // MonthlyVideoGameTime
        request.getRequestDispatcher(getServletContext().getInitParameter("aspirations")).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Possible to have to request attribute:
        // HousingSituationTypes
        request.getRequestDispatcher(getServletContext().getInitParameter("lifestyle")).forward(request, response);
    }
}
