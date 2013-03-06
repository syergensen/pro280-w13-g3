package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * A servlet meant to set up and receive the post of the School.jsp page
 * User: jflores
 * Date: 2/27/13
 * Time: 6:28 PM -- Created
 */
@WebServlet("/school.do")
public class SchoolServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //StartingQuarter,StartingYear,SelectedProgram
        session.setAttribute("school_quarter", request.getParameter("quarter"));
        session.setAttribute("school_year", request.getParameter("year"));
        session.setAttribute("school_program", request.getParameter("program"));
        //FullTime,PartTime
        session.setAttribute("school_fullTime", request.getParameter("fullTime"));
        session.setAttribute("school_partTime", request.getParameter("partTime"));
        //LoanTypePercentage
        session.setAttribute("school_loanPercent", request.getParameter("loanPercent"));
        //Grants/Scholarships,InterestRate
        session.setAttribute("school_grants", request.getParameter("grants"));
        session.setAttribute("school_interest", request.getParameter("interest"));
        //CreditDebtAmount
        session.setAttribute("school_creditDebt", request.getParameter("creditDebt"));
        //MedicalDebtAmount
        session.setAttribute("school_medicalDebt", request.getParameter("medicalDebt"));
        //OutStandingDebtAmount
        session.setAttribute("school_loanDebt", request.getParameter("loanDebt"));

        request.getRequestDispatcher(getServletContext().getInitParameter("lifestyle")).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Request Attributes for??:
        // Quarters, Programs, "Loan-Types" Strings from static variable in model
        request.getRequestDispatcher(getServletContext().getInitParameter("school")).forward(request, response);

    }
}
