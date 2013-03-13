package Servlets;

import Model.Managers.CarManager;
import Model.Managers.MileageManager;
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
    @EJB
    CarManager carManager;
    @EJB
    MileageManager mileageManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Model Calculate:
        // return results list <String nameType, int dollarValue>
        // Set to attribute : allResults
        // Get QuarterExtra default=0;
        HttpSession session = request.getSession();

        String degree = (String) session.getAttribute("school_program");
        String region = (String) session.getAttribute("aspirations_region");

        double salary = salaryManager.getSalaryByDegreeAndRegion(degree, region).getSalary();
        double salaryPerMonth = salary / 12;

        double studentLoanPercent = (Double) session.getAttribute("school_loanPercent");
        int extraQuarters = (Integer) session.getAttribute("school_extraQuarters");
        if(request.getParameter("additionalQuarter")!=null)
        {
            extraQuarters++;
            session.setAttribute("school_extraQuarters", extraQuarters);
        }
        int quarters = (degreeManager.getQuarters(degree).getQuarters()) + extraQuarters;
        double grants = (Double)session.getAttribute("school_grants");
        double schoolInterest = (Double)session.getAttribute("school_interest");
        double initialSchoolPay = (quarters*7200)-grants;
        double studentLoanPayment = (((initialSchoolPay) / 120)+(initialSchoolPay*(schoolInterest/100))) * (studentLoanPercent / 100);

        double taxPercent = salaryManager.getSalaryByDegreeAndRegion(degree, region).getTaxBracket();
        double incomeTax = salary * taxPercent;
        double incomeTaxPerMonth = incomeTax / 12;


        //Miscellaneous
        double miscellaneous;
        double foodBudgetWeekly = (Double) session.getAttribute("weekly_food_budget");
        double monthlyFoodExpense = (foodBudgetWeekly * 52) / 12;
        double gameSpending = (Double) session.getAttribute("lifestyle_gameSpending");
        double otherSpending = (Double) session.getAttribute("other_spending");
        miscellaneous = foodBudgetWeekly + monthlyFoodExpense + gameSpending + otherSpending;

        //Car
        String carCondition = (String)session.getAttribute("aspirations_carCondition");
        String carQuality = (String)session.getAttribute("aspirations_carQuality");
        int carCost;
        if(carCondition.equals("No car"))
        {
            carCost = 0;
        }
        else if(carQuality.equals("Above average car"))
        {
            carCost = carManager.getCarByQuality(carCondition).getHigh();
        }
        else if(carQuality.equals("Below average car"))
        {
            carCost = carManager.getCarByQuality(carCondition).getLow();
        }
        else
        {
            carCost = carManager.getCarByQuality(carCondition).getMiddle();
        }
        double carInterest = (Double)session.getAttribute("aspirations_interest");
        double monthlyCarExpenses = (carCost/(12*5))+(carCost*(carInterest/100));

        double discretionaryIncome = salaryPerMonth - studentLoanPayment - incomeTaxPerMonth - miscellaneous - monthlyCarExpenses;

        request.setAttribute("salary", salaryPerMonth);
        request.setAttribute("studentLoans", studentLoanPayment);
        request.setAttribute("incomeTax", incomeTaxPerMonth);
        request.setAttribute("miscellaneous", miscellaneous);
        request.setAttribute("carExpenses", monthlyCarExpenses);
        request.setAttribute("discretionaryIncome", discretionaryIncome);
        request.getRequestDispatcher(getServletContext().getInitParameter("result")).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(getServletContext().getInitParameter("result")).forward(request, response);
    }
}
