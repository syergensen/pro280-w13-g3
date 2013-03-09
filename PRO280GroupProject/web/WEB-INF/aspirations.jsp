<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cknox
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aspirations</title>
</head>
<body>
<h2><i>In order to provide more accurate results we would like to know more about your aspirations, things that you desire to have after graduation:</i></h2>
<form method="post" action="aspirations.do">
    1. After graduating Neumont what is your preferred region to live in the United States:
    <select name="region">
        <%--${aspirations_region eq loopVar(rename) ? 'checked' : ''}--%>
        <c:forEach items="${regions}" var="region">
            <option value="${region.regionName}" ${sessionScope.aspirations_region eq region ? 'selected' : ''}>${region.regionName}</option>
        </c:forEach>
    </select>
    <br/>
    2.  Please describe your preferred car:<br/>
    <select name="carCondition">
        <c:forEach items="${conditions}" var="condition">
            <option value="${condition.itemName}" ${sessionScope.aspirations_carCondition eq condition.itemName ? 'selected' : ''}>${condition.itemName}</option>
        </c:forEach>
    </select>
    <select name="carFuelEconomy">
        <c:forEach items="${economies}" var="economy">
            <option value="${economy.itemName}" ${sessionScope.aspirations_carFuelEconomy eq economy.itemName ? 'selected' : ''}>${economy.itemName}</option>
        </c:forEach>
    </select>
    <select name="carQuality">
        <c:forEach items="${qualities}" var="quality">
            <option value="${quality.itemName}" ${sessionScope.aspirations_carQuality eq quality.itemName ? 'selected' : ''}>${quality.itemName}</option>
        </c:forEach>
    </select>
    <br/>
    3.  Please describe your preferred house:<br/>
    <c:forEach items="${housePreferences}" var="preference">
        <input type="radio" name="house" value="${preference.itemName}" ${sessionScope.aspirations_house eq preference.itemName ? 'checked' : ''}>${preference.itemName}<br/>
    </c:forEach>
    <input type="submit" value="Finish">
</form>
</body>
</html>