package Servlets;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Model Calculate:
        // return results list <String nameType, int dollarValue>
        // Set to attribute : allResults
        // Get QuarterExtra default=0;
        HttpSession session = request.getSession();

        String degree = (String)session.getAttribute("school_program");
        String region = (String)session.getAttribute("aspirations_region");

        request.setAttribute("test", salaryManager.getSalaryByDegreeAndRegion(degree, region));
        request.getRequestDispatcher(getServletContext().getInitParameter("result")).forward(request, response);
    }
}
