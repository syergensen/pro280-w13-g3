<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cknox
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lifestyle</title>
    <link rel="stylesheet" href="css/Global/global.css"/>
    <style>
        .slider {
            width: 300px;
        }
    </style>
</head>
<body>
<c:import url="tags/HeaderBand.tag"/>
<h2><i>These questions will focus on the housing and lifestyle choices while still in school:</i></h2>
<br/>

<c:if test="${requestScope.error ne null}">${requestScope.error}<br/></c:if>
<form method="post" action="lifestyle.do">
    <%--Change later to pull from database--%>
    1. What is your housing situation?<br/>
    <c:forEach items="${housingOptions}" var="option">
        <input type="radio" name="housing"
               value="${option.itemName}" ${lifestyle_housing eq option.itemName ? 'checked' : ''}>${option.itemName}
        <br/>
    </c:forEach>
    If you rent:<br/>

    a. How much do you spend monthly for rent?
    $<input type="number" name="rent" value="${lifestyle_rent eq null ? 0 : lifestyle_rent}" min="0"
            step="any" required><br/>
    b. On average, how much per month is spent on utilities/bills?
    $<input type="number" name="bills" value="${lifestyle_bills eq null ? 0 : lifestyle_bills}" min="0" step="any"
            required>
    </br>
    2. On average, how money do you spend on food every week?<br/>
    $<input type="number" name="weeklyFoodMoney" value="${weekly_food_budget eq null ? 0 : weekly_food_budget}"
            step="any" required>
    </br>
    <%--Insert slider ranging 0-7--%>
    3. How much money do you spend on entertainment such as movies or video games each month?
    $<input type="number" name="gameSpending" value="${lifestyle_gameSpending eq null ? 0 : lifestyle_gameSpending}"
            step="any" required>
    <br/>
    <input type="submit" value="Next Step">
</form>
</body>
</html>