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
@WebServlet("/lifestyle.do")
public class LifeStyleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // HousingSituation
        session.setAttribute("lifestyle_housing", request.getParameter("housing"));
        try{
            // MonthlyRent
            double rent = Double.parseDouble(request.getParameter("rent"));
            session.setAttribute("lifestyle_rent", rent);
            // UtilitiesBill
            double bills = Double.parseDouble(request.getParameter("bills"));
            session.setAttribute("lifestyle_bills", bills);

            // DietLunchEatOutWeekly
            int lunchDays = Integer.parseInt(request.getParameter("lunchDays"));
            session.setAttribute("lifestyle_lunchDays", lunchDays);
            // DietDinnerEatOutWeekly
            int dinnerDays = Integer.parseInt(request.getParameter("dinnerDays"));
            session.setAttribute("lifestyle_dinnerDays", dinnerDays);
            // MonthlyVideoGameTime
            int gameSpending = Integer.parseInt(request.getParameter("gameSpending"));
            session.setAttribute("lifestyle_gameSpending", gameSpending);

            request.getRequestDispatcher(getServletContext().getInitParameter("aspirations")).forward(request, response);
        }catch (NumberFormatException e){
            request.setAttribute("error", "Please enter a number.");
            request.getRequestDispatcher(getServletContext().getInitParameter("lifestyle")).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Possible to have to request attribute:
        // HousingSituationTypes
        request.getRequestDispatcher(getServletContext().getInitParameter("lifestyle")).forward(request, response);
    }
}
