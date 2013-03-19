package Servlets;

import Model.DatabaseEntities.SelectGroup;
import Model.DatabaseEntities.SelectItem;
import Model.Managers.RegionManager;
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
 * A servlet meant to set up and receive the post of the Aspiration.jsp page
 * User: jflores
 * Date: 2/27/13
 * Time: 6:37 PM
 */
@WebServlet("/postGraduation.do")
public class AspirationsServlet extends HttpServlet {
    @EJB
    RegionManager regionManager;

    @EJB
    SelectItemManager selectItemManager;

    @EJB
    SelectGroupManager selectGroupManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //PreferredRegion
        session.setAttribute("aspirations_region", request.getParameter("region"));
        //PreferredCarState
        session.setAttribute("aspirations_carCondition", request.getParameter("carCondition"));
        session.setAttribute("aspirations_carFuelEconomy", request.getParameter("carFuelEconomy"));
        session.setAttribute("aspirations_carQuality", request.getParameter("carQuality"));
        try{
            double interest = Double.parseDouble(request.getParameter("interest"));
            session.setAttribute("aspirations_interest", interest);
            //PrefferedLivingCondition
            session.setAttribute("aspirations_house", request.getParameter("house"));
            request.getRequestDispatcher("/result.do").forward(request, response);
        }catch (NumberFormatException e){
            request.setAttribute("error", "Please enter a number.");
            request.setAttribute("regions", regionManager.getRegions());
            request.setAttribute("conditions", selectItemManager.getSelectItemsByGroup(selectGroupManager.getSelectGroupByDescription("CarAge").getGroupId()));
            request.setAttribute("economies", selectItemManager.getSelectItemsByGroup(selectGroupManager.getSelectGroupByDescription("CarFuel").getGroupId()));
            request.setAttribute("qualities", selectItemManager.getSelectItemsByGroup(selectGroupManager.getSelectGroupByDescription("CarRating").getGroupId()));
            request.setAttribute("housePreferences", selectItemManager.getSelectItemsByGroup(selectGroupManager.getSelectGroupByDescription("AfterHousing").getGroupId()));
            request.getRequestDispatcher(getServletContext().getInitParameter("aspirations")).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // May have to request attribute:
        // PrefferedRegions, CarUsed, CarFuelEconomies, CarRating,
        // and LivingConditionOptions.
        request.setAttribute("regions", regionManager.getRegions());
        request.setAttribute("conditions", selectItemManager.getSelectItemsByGroup(selectGroupManager.getSelectGroupByDescription("CarAge").getGroupId()));
        request.setAttribute("economies", selectItemManager.getSelectItemsByGroup(selectGroupManager.getSelectGroupByDescription("CarFuel").getGroupId()));
        request.setAttribute("qualities", selectItemManager.getSelectItemsByGroup(selectGroupManager.getSelectGroupByDescription("CarRating").getGroupId()));
        request.setAttribute("housePreferences", selectItemManager.getSelectItemsByGroup(selectGroupManager.getSelectGroupByDescription("AfterHousing").getGroupId()));
        request.getRequestDispatcher(getServletContext().getInitParameter("aspirations")).forward(request, response);

    }
}
