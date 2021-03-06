package Servlets;

import Model.Managers.SelectGroupManager;
import Model.Managers.SelectItemManager;

import javax.ejb.EJB;
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
    @EJB
    SelectItemManager selectItemManager;

    @EJB
    SelectGroupManager selectGroupManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //======  HousingSituation
        session.setAttribute("lifestyle_housing", request.getParameter("housing"));
        try {
            //======  MonthlyRent
            int rent = (int) Double.parseDouble(request.getParameter("rent"));
            session.setAttribute("lifestyle_rent", rent);
            //======  UtilitiesBill
            int bills = (int) Double.parseDouble(request.getParameter("bills"));
            session.setAttribute("lifestyle_bills", bills);

            //======  Weekly food money spent
            double foodBill = Double.parseDouble(request.getParameter("weeklyFoodMoney"));
            session.setAttribute("weekly_food_budget", foodBill);

            //======  MonthlyVideoGameTime
            double gameSpending = Double.parseDouble(request.getParameter("gameSpending"));
            session.setAttribute("lifestyle_gameSpending", gameSpending);

            //======  Other spending:
            double otherSpending = Double.parseDouble(request.getParameter("otherSpending"));
            session.setAttribute("other_spending", otherSpending);

            //====== Savings
            double savings = Double.parseDouble(request.getParameter("savings"));
            session.setAttribute("lifestyle_savings", savings);

            response.sendRedirect("./postGraduation.do");

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Please enter a number.");
            SetUpGetAttributes(request, response);
        }
    }

    /**
     * Sets up the attributes that the "get" method for this class would have used, however since attributes do not persist through re-directs we
     * settled for getRequestDispatcher.
     */
    private void SetUpGetAttributes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("housingOptions", selectItemManager.getSelectItemsByGroup(selectGroupManager.getSelectGroupByDescription("InSchoolHousing").getGroupId()));
        request.getRequestDispatcher(getServletContext().getInitParameter("lifestyle")).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Sets the housing Options attributes.
        SetUpGetAttributes(request, response);
    }
}
