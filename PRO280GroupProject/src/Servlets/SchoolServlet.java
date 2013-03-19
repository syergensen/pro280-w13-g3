package Servlets;

import Model.Managers.NuDegreeManager;
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
import java.util.Calendar;

/**
 * A servlet meant to set up and receive the post of the School.jsp page
 * We simply gathered the attributes in the school.jsp and recorded them in session.
 * User: jflores
 * Date: 2/27/13
 * Time: 6:28 PM -- Created
 */
@WebServlet("/school.do")
public class SchoolServlet extends HttpServlet {
    @EJB
    SelectItemManager selectItemManager;

    @EJB
    SelectGroupManager selectGroupManager;

    @EJB
    NuDegreeManager nuDegreeManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //StartingQuarter,StartingYear,SelectedProgram
        session.setAttribute("school_quarter", request.getParameter("quarter"));
        session.setAttribute("school_year", request.getParameter("year"));
        session.setAttribute("school_program", request.getParameter("program"));

        try {
            //====== FullTime,PartTime
            int fullTime = Integer.parseInt(request.getParameter("fullTime"));
            int partTime = Integer.parseInt(request.getParameter("partTime"));
            session.setAttribute("school_fullTime", fullTime);
            session.setAttribute("school_partTime", partTime);
            session.setAttribute("school_extraQuarters", fullTime + partTime);

            //====== LoanTypePercentage
            double loanPercent = Double.parseDouble(request.getParameter("loanPercent"));
            session.setAttribute("school_loanPercent", loanPercent);
            //====== Grants/Scholarships && InterestRate
            double grants = Double.parseDouble(request.getParameter("grants"));
            session.setAttribute("school_grants", grants);

            double interest = Double.parseDouble(request.getParameter("interest"));
            session.setAttribute("school_interest", interest);
            //====== CreditDebtAmount
            double creditDebt = Double.parseDouble(request.getParameter("creditDebt"));
            session.setAttribute("school_creditDebt", creditDebt);
            //====== MedicalDebtAmount
            double medicalDebt = Double.parseDouble(request.getParameter("medicalDebt"));
            session.setAttribute("school_medicalDebt", medicalDebt);
            //====== OutStandingDebtAmount
            double loanDebt = Double.parseDouble(request.getParameter("loanDebt"));
            session.setAttribute("school_loanDebt", loanDebt);

            response.sendRedirect("./lifestyle.do");
//            request.getRequestDispatcher(getServletContext().getInitParameter("lifestyle")).forward(request, response);
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
        request.setAttribute("quarters", selectItemManager.getSelectItemsByGroup(selectGroupManager.getSelectGroupByDescription("Quarters").getGroupId()));
        request.setAttribute("programs", nuDegreeManager.getNuDegrees());
        request.setAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        request.getRequestDispatcher(getServletContext().getInitParameter("school")).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Sets the attributes from previous visits to this servlet.
        SetUpGetAttributes(request, response);

    }
}
