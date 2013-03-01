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
@WebServlet("/LifeStyle.do")
public class LifeStyleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // HousingSituation
        // MonthlyRent
        // UtilitiesBill
        // DietLunchEatOutWeekly
        // DietDinnerEatOutWeekly
        // MonthlyVideoGameTime
        response.sendRedirect("Aspirations.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Possible to have to request attribute:
        // HousingSituationTypes
        // request.getRequestDispatcher("LifeStyle.jsp").forward(request, responce);
        response.sendRedirect("lifestyle.jsp");
    }
}
