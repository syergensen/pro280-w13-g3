package Servlets;

import Model.Managers.*;

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
    @EJB
    RegionManager regionManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //================================!!!!!!!!!!!!!!!!!!!!!!!!!!!================================
        // Hey guys. There is this bug where if you go from the start page to the Lifestyles page, then press submit we get a 500.
        // This results because some attributes have not been set from previous pages. See this application assumes that
        // The client went through the sequential order correctly you guys should fix that.
        // Also you may have to just re-write this whole servlet, for we have no guarantee that our implementations of the algorithms for this project work.
        // We were not given test data so we only followed instructions as best we could.
        //================================!!!!!!!!!!!!!!!!!!!!!!!!!!!================================
        // Model Calculate:
        // return results list <String nameType, int dollarValue>
        // Set to attribute : allResults
        // Get QuarterExtra default=0;
        HttpSession session = request.getSession();

        String degree = (String) session.getAttribute("school_program");
        String region = (String) session.getAttribute("aspirations_region");

        double salary = salaryManager.getSalaryByDegreeAndRegion(degree, region).getSalary();
        int salaryPerMonth = (int) (salary / 12);

        //===== Savings
        double savingsAmount = (Double) session.getAttribute("lifestyle_savings");
        int savings = (int) savingsAmount;

        //===== Student loan
        double studentLoanPercent = (Double) session.getAttribute("school_loanPercent");
        int extraQuarters = (Integer) session.getAttribute("school_extraQuarters");
        if (request.getParameter("additionalQuarter") != null) {
            extraQuarters++;
            session.setAttribute("school_extraQuarters", extraQuarters);
        }
        int quarters = (degreeManager.getQuarters(degree).getQuarters()) + extraQuarters;
        double grants = (Double) session.getAttribute("school_grants");
        double schoolInterest = (Double) session.getAttribute("school_interest");
        double initialSchoolPay = (quarters * 7200) - grants - savings;
        double studentLoanPayment = (((initialSchoolPay) + (initialSchoolPay * (schoolInterest / 100))) / 120) * (studentLoanPercent / 100);
        double studentHousingPayment = getStudentHousingRent(session);
        int totalLoanPayment = (int) (studentLoanPayment + studentHousingPayment);

        //===== Income tax
        double taxPercent = salaryManager.getSalaryByDegreeAndRegion(degree, region).getTaxBracket();
        double incomeTax = salary * taxPercent;
        int incomeTaxPerMonth = (int) (incomeTax / 12);


        //===== Miscellaneous
        double foodBudgetWeekly = (Double) session.getAttribute("weekly_food_budget");
        double monthlyFoodExpense = (foodBudgetWeekly * 52) / 12;
        double gameSpending = (Double) session.getAttribute("lifestyle_gameSpending");
        double otherSpending = (Double) session.getAttribute("other_spending");
        int miscellaneous = (int) (foodBudgetWeekly + monthlyFoodExpense + gameSpending + otherSpending);

        //===== Car
        String carCondition = (String) session.getAttribute("aspirations_carCondition");
        String carQuality = (String) session.getAttribute("aspirations_carQuality");
        int carCost;
        if (carCondition.contains("No")) {
            carCost = 0;
        } else if (carQuality.contains("Above")) {
            carCost = carManager.getCarByQuality(carCondition).getHigh();
        } else if (carQuality.contains("Below")) {
            carCost = carManager.getCarByQuality(carCondition).getLow();
        } else {// Average
            carCost = carManager.getCarByQuality(carCondition).getMiddle();
        }
        double carInterest = (Double) session.getAttribute("aspirations_interest");
        int monthlyCarExpenses = (int) ((carCost / (12 * 5)) + (carCost * (carInterest / 100)));

        //===== Post-grad housing
        int postGradHousingPayment = getPostGradHousing(session);

        //===== Other debt
        double creditDebt = (Double) session.getAttribute("school_creditDebt");
        double medicalDebt = (Double) session.getAttribute("school_medicalDebt");
        double loanDebt = (Double) session.getAttribute("school_loanDebt");
        int otherDebt = (int) (creditDebt + medicalDebt + loanDebt);

        //===== Discretionary income
        int discretionaryIncome = (int) (salaryPerMonth - totalLoanPayment - incomeTaxPerMonth - miscellaneous - monthlyCarExpenses - postGradHousingPayment);

        request.setAttribute("salary", salaryPerMonth);
        request.setAttribute("studentLoans", totalLoanPayment);
        request.setAttribute("incomeTax", incomeTaxPerMonth);
        request.setAttribute("miscellaneous", miscellaneous);
        request.setAttribute("carExpenses", monthlyCarExpenses);
        request.setAttribute("mortgageRent", postGradHousingPayment);
        request.setAttribute("otherDebt", otherDebt);
        request.setAttribute("savings", savings);
        request.setAttribute("discretionaryIncome", discretionaryIncome);
        request.getRequestDispatcher(getServletContext().getInitParameter("result")).forward(request, response);
    }


    public int getStudentHousingRent(HttpSession session) {
        int totalHousingOrRent = 0;// If you are living for free
        String housingSituation = (String) session.getAttribute("lifestyle_housing");
        if (housingSituation != null) {
            String s = new String(housingSituation);
            s = s.toLowerCase();
            if (s.contains("neumont")) {
                totalHousingOrRent = (RegionManager.NUEMONT_HOUSING_COST) / 3;
            } else if (s.contains("rent")) {
                int utility = (Integer) session.getAttribute("lifestyle_bills");
                int rent = (Integer) session.getAttribute("lifestyle_rent");
                // If we are Apartment based
                totalHousingOrRent = utility + rent;
            }
        }
        return totalHousingOrRent;
    }

    public int getPostGradHousing(HttpSession session) {
        int totalHousingOrRent = 0;// If you are commuting for free
        String housingSituation = (String) session.getAttribute("aspirations_house");
        if (housingSituation != null) {
            String s = new String(housingSituation);
            s = s.toLowerCase();
            String region = (String) session.getAttribute("aspirations_region");
            int utility = (Integer) session.getAttribute("lifestyle_bills");
            if (s.contains("own")) {
                totalHousingOrRent = (regionManager.getMortgageBasedOffRegionName(region)) + utility;
            } else if (s.contains("rent")) {
                int rent = regionManager.getRentBasedOffRegionName(region);
                // If we are Apartment based
                totalHousingOrRent = utility + rent;
            }
        }
        return totalHousingOrRent;
    }
}//end of class