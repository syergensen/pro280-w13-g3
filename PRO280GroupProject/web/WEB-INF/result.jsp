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
            <td class="BoldMe">Salary</td>
            <td>......</td>
            <td class="marginLeft">$${salary eq null ? 0 : salary}/month</td>
        </tr>
        <tr>
            <td class="BoldMe">Student Loan</td>
            <td>......</td>
            <td class="marginLeft">$${studentLoans eq null ? 0: studentLoans}/month</td>
        </tr>
        <tr>
            <td class="BoldMe">Income Tax</td>
            <td>......</td>
            <td class="marginLeft">$${incomeTax eq null ? 0 : incomeTax}/month</td>
        </tr>
        <tr>
            <td class="BoldMe">Misc. Expenses</td>
            <td>......</td>
            <td class="marginLeft">$${miscellaneous eq null ? 0 : miscellaneous}/month</td>
        </tr>
        <tr>
            <td class="BoldMe">Car Expenses</td>
            <td>......</td>
            <td class="marginLeft">$${carExpenses eq null ? 0 : carExpenses}/month</td>
            <td>
                <form method="get" action="postGraduation.do"><input type="submit" value="Revise"></form>
            </td>
        </tr>
        <tr>
            <td class="BoldMe">Mortgage/Rent</td>
            <td>......</td>
            <td class="marginLeft">$${mortgageRent eq null ? 0 : mortgageRent}/month</td>
            <td>
                <form method="get" action="postGraduation.do"><input type="submit" value="Revise"></form>
            </td>
        </tr>
        <tr>
            <td class="BoldMe">Other Debt</td>
            <td>......</td>
            <td class="marginLeft">$${otherDebt eq null ? 0 : otherDebt}</td>
            <td>
                <form method="get" action="school.do"><input type="submit" value="Revise"></form>
            </td>
        </tr>
        <tr>
            <td class="BoldMe">Savings Account Contribution</td>
            <td>......</td>
            <td class="marginLeft">$${savings eq null ? 0 : savings}</td>
        </tr>
        <tr>
            <td class="BoldMe">Discretionary Income</td>
            <td>......</td>
            <%--subtract other results--%>
            <td class="marginLeft">$${discretionaryIncome}/month</td>
        </tr>
    </table>
</div>
</body>
</html>