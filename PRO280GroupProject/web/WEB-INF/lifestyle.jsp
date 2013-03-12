<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cknox
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lifestyle</title>
    <link rel="stylesheet" href="css/sunny/jquery-ui-1.9.2.custom.css"/>
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
    $<input type="number" name="rent" value="${lifestyle_rent eq null ? 0 : lifestyle_rent}" min="0" step="any"><br/>
    b. On average, how much per month is spent on utilities/bills?
    $<input type="number" name="bills" value="${lifestyle_bills eq null ? 0 : lifestyle_bills}" min="0" step="any">
    <br/>
    2. On average, how many days out of the week do you eat out for lunch?<br/>
    <%--Insert slider ranging 0-7--%>
    <label for="LunchDays">Days: </label>
    <input type="text" name="lunchDays" id="LunchDays" style="border: 0; color: #EA9919; font-weight: bold;">

    <div id="LunchSlider" class="slider"></div>
    <br/>
    3. On average, how many days out of the week do you eat out for dinner?<br/>
    <%--Insert slider ranging 0-7--%>
    <label for="DinnerDays">Days: </label>
    <input type="text" name="dinnerDays" id="DinnerDays" style="border: 0; color: #EA9919; font-weight: bold;">

    <div id="DinnerSlider" class="slider"></div>
    <br/>
    4. On average, how much do you spend on entertainment per month? (movies, video games, etc.)<br/>
    <%--Insert slider ranging 0-some number--%>
    <label for="VideoGamesBudget">Money Spent: $</label>
    <input type="text" name="gameSpending" id="VideoGamesBudget" style="border: 0; color: #EA9919; font-weight: bold;">

    <div id="VideoGameSlider" class="slider"></div>
    <br/>
    <input type="submit" value="Next Step">
</form>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script>
    function setUpSlider(slidesu, slidi, max, val) {
        $(slidesu).slider({
            min: 0, max: max, value: val,
            slide: function (event, ui) {
                $(slidi).val(ui.value);
            }
        });
        $(slidi).val($(slidesu).slider("value"));
    }
    $(function () {
                setUpSlider("#LunchSlider", "#LunchDays", 7, ${lifestyle_lunchDays eq null ? 0 : lifestyle_lunchDays});
                setUpSlider("#DinnerSlider", "#DinnerDays", 7, ${lifestyle_dinnerDays eq null ? 0 : lifestyle_dinnerDays});
                setUpSlider("#VideoGameSlider", "#VideoGamesBudget", 200, ${lifestyle_gameSpending eq null ? 0 : lifestyle_gameSpending});
            }
    );
</script>

</body>
</html>