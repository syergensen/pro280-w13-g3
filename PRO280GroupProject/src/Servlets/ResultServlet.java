package Servlets;

import Model.Managers.NuDegreeManager;
import Model.Managers.SalaryManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * A servlet meant to set up and receive the post of the Results.jsp page
 * User: Jflores
 * Date: 2/27/13
 * Time: 6:40 PM   -- Created
 */
@WebServlet("/result.do")
public class ResultServlet extends HttpServlet {
    @EJB
    SalaryManager salaryManager;
    @EJB
    NuDegreeManager degreeManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Model Calculate:
        // return results list <String nameType, int dollarValue>
        // Set to attribute : allResults
        // Get QuarterExtra default=0;
        HttpSession session = request.getSession();

        String degree = (String) session.getAttribute("school_program");
        String region = (String) session.getAttribute("aspirations_region");

        double salary = salaryManager.getSalaryByDegreeAndRegion(degree, region).getSalary();
        double salaryPerMonth = salary/12;

        double studentLoanPercent = (Double)session.getAttribute("school_loanPercent");
        int extraQuarters = (Integer)session.getAttribute("school_extraQuarters");
        int quarters = (degreeManager.getQuarters(degree).getQuarters())+extraQuarters;
        double studentLoanPayment = ((quarters*7200)/120)*(studentLoanPercent/100);

        double taxPercent = salaryManager.getSalaryByDegreeAndRegion(degree, region).getTaxBracket();
        double incomeTax = salary*taxPercent;
        double incomeTaxPerMonth = incomeTax/12;

        double discretionaryIncome = salaryPerMonth - studentLoanPayment - incomeTaxPerMonth;

        request.setAttribute("salary", salaryPerMonth);
        request.setAttribute("studentLoans", studentLoanPayment);
        request.setAttribute("incomeTax", incomeTaxPerMonth);

        request.setAttribute("discretionaryIncome", discretionaryIncome);
        request.getRequestDispatcher(getServletContext().getInitParameter("result")).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(getServletContext().getInitParameter("result")).forward(request, response);
    }
}
