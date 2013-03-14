<%--
  Created by IntelliJ IDEA.
  User: cknox
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Results</title>
    <link rel="stylesheet" href="css/Global/global.css"/>
</head>
<body>
<c:import url="tags/HeaderBand.tag"/>
<div class="cssGuardian">
    <form method="post" action="result.do">
        <input type="hidden" name="additionalQuarter" value="1">
        <input type="submit" value="+1 Quarter">
    </form>
    <table>
        <tr>
            <td>Salary</td>
            <td>$${salary eq null ? 0 : salary}/month</td>
        </tr>
        <tr>
            <td>Student Loan</td>
            <td>$${studentLoans eq null ? 0: studentLoans}/month</td>
        </tr>
        <tr>
            <td>Income Tax</td>
            <td>$${incomeTax eq null ? 0 : incomeTax}/month</td>
        </tr>
        <tr>
            <td>Misc. Expenses</td>
            <td>$${miscellaneous eq null ? 0 : miscellaneous}/month</td>
        </tr>
        <tr>
            <td>Car Expenses</td>
            <td>$${carExpenses eq null ? 0 : carExpenses}/month</td>
            <td>
                <form method="get" action="postGraduation.do"><input type="submit" value="Revise"></form>
            </td>
        </tr>
        <tr>
            <td>Mortgage/Rent</td>
            <td>$${mortgageRent eq null ? 0 : mortgageRent}/month</td>
            <td>
                <form method="get" action="postGraduation.do"><input type="submit" value="Revise"></form>
            </td>
        </tr>
        <tr>
            <td>Other Debt</td>
            <td>$${otherDebt eq null ? 0 : otherDebt}</td>
            <td>
                <form method="get" action="school.do"><input type="submit" value="Revise"></form>
            </td>
        </tr>
        <tr>
            <td>Savings Account Contribution</td>
            <td>$${savings eq null ? 0 : savings}</td>
        </tr>
        <tr>
            <td>Discretionary Income</td>
            <%--subtract other results--%>
            <td>$${discretionaryIncome}/month</td>
        </tr>
    </table>
    <input type="submit" value="Print">
</div>
</body>
</html>