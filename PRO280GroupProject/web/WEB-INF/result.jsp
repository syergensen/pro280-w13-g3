<%--
  Created by IntelliJ IDEA.
  User: cknox
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
</head>
<body>
<form method="post" action="result.do">
    <input type="submit" value="+1 Quarter">
</form>
<table>
    <tr>
        <td>Salary</td>
        <td>$${salary}/month</td>
    </tr>
    <tr>
        <td>Income Tax</td>
        <td>income tax result acquired</td>
    </tr>
    <tr>
        <td>Misc. Expenses</td>

    </tr>
    <tr>
        <td>Car Expenses</td>
        <td>Car result acquired</td>
        <td><form method="get" action="aspirations.do"><input type="submit" value="Revise"></form></td>
    </tr>
    <tr>
        <td>Mortgage/Rent</td>
        <td>Mortgage/rent result acquired</td>
        <td><form method="get" action="aspirations.do"><input type="submit" value="Revise"></form></td>
    </tr>
    <tr>
        <td>Utilities</td>
        <td>Utilities result acquired</td>
    </tr>
    <tr>
        <td>Total Loans</td>
        <td>Loan result acquired</td>
        <td><form method="get" action="school.do"><input type="submit" value="Revise"></form></td>
    </tr>
    <tr>
        <td>In-School Savings</td>
        <td>Savings result acquired</td>
    </tr>
    <tr>
        <td>Discretionary Income</td>
        <%--subtract other results--%>
        <td>${salary}</td>
    </tr>
</table>
<input type="submit" value="Print">
</body>
</html>