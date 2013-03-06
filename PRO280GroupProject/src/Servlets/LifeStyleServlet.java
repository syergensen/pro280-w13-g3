package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session = request.getSession();
        // HousingSituation
        session.setAttribute("lifestyle_housing", request.getParameter("housing"));
        // MonthlyRent
        session.setAttribute("lifestyle_rent", request.getParameter("rent"));
        // UtilitiesBill
        session.setAttribute("lifestyle_bills", request.getParameter("bills"));
        // DietLunchEatOutWeekly
        session.setAttribute("lifestyle_lunchDays", request.getParameter("lunchDays"));
        // DietDinnerEatOutWeekly
        session.setAttribute("lifestyle_dinnerDays", request.getParameter("dinnerDays"));
        // MonthlyVideoGameTime
        session.setAttribute("lifestyle_gameSpending", request.getParameter("gameSpending"));

        request.getRequestDispatcher(getServletContext().getInitParameter("aspirations")).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Possible to have to request attribute:
        // HousingSituationTypes
        request.getRequestDispatcher(getServletContext().getInitParameter("lifestyle")).forward(request, response);
    }
}
