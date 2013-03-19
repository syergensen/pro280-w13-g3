<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cknox
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aspirations</title>
    <link rel="stylesheet" href="css/Global/global.css"/>
</head>
<body>
<c:import url="tags/HeaderBand.tag"/>
<div class="cssGuardian">
    <h2><i>In order to provide more accurate results we would like to know more about your aspirations, things that you
        desire to have after graduation:</i></h2>

    <c:if test="${requestScope.error ne null}">${requestScope.error}<br/></c:if>
    <form method="post" action="postGraduation.do">
        <p>


            1. After graduating Neumont what is your preferred region to live in the United States:

            <select name="region">
                <%--${aspirations_region eq loopVar(rename) ? 'checked' : ''}--%>
                <c:forEach items="${regions}" var="region">
                    <option value="${region.regionName}" ${sessionScope.aspirations_region eq region.regionName ? 'selected' : ''}>${region.regionName}</option>
                </c:forEach>
            </select>
        </p>
        <p>


            2. Please describe your preferred car:<br/>

        <p class="marginLeft">
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
            <span class="marginLeft">Interest Payment: <input type="number" name="interest" min="0" step="any" required
                                                              value="${aspirations_interest eq null ? 0 : aspirations_interest}">%</span>
        </p>
        </p>


        3. Please describe your preferred house:

        <p class="marginLeft">
            <c:forEach items="${housePreferences}" var="preference">
                <input type="radio" name="house" required
                       value="${preference.itemName}" ${sessionScope.aspirations_house eq preference.itemName ? 'checked' : ''}> ${preference.itemName}
                <br/>
            </c:forEach>
        </p>
        <input type="submit" value="Finish">
    </form>

</div>

</body>
</html>