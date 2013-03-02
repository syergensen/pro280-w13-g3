package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        //StartingQuarter,StartingYear,SelectedProgram
        //FullTime,PartTime
        //LoanTypePercentage
        //CreditDebtAmount
        //MedicalDebtAmount
        //OutStandingDebtAmount

        request.getRequestDispatcher(getServletContext().getInitParameter("lifestyle")).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Request Attributes for??:
        // Quarters, Programs, "Loan-Types" Strings from static variable in model
        request.getRequestDispatcher(getServletContext().getInitParameter("school")).forward(request, response);

    }
}
