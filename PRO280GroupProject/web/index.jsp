<%--
  Created by IntelliJ IDEA.
  User: cknox
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Start</title>
    <link rel="stylesheet" href="css/Global/global.css"
    <%--<link rel="stylesheet" href="css/NeumontWebSite/global.css"/>--%>
    <%--<link rel="stylesheet" href="css/NeumontWebSite/forms.css"/>--%>
    <%--<link rel="stylesheet" href="css/NeumontWebSite/style1.css"/>--%>
    <%--<link rel="stylesheet" href="http://www.neumont.edu/cmscss/content.css"/>--%>
</head>
<body>
<c:import url="WEB-INF/tags/HeaderBand.tag"/>
<div class="cssGuardian">
    <div class="termsAndConditionsBorder">
        <c:choose>
            <c:when test="${not empty conditions}">
                ${conditions}
            </c:when>
            <c:when test="${conditions eq null}">
                Put User agreement Here AKA it didn't WORK!!!
            </c:when>

        </c:choose>
    </div>
    <br/>

    <form method="post" action="start.do">
        <input type="checkbox" name="agree" checked>I have read the Terms of Service</input><br/>
        <input type="submit" value="Begin">
    </form>
</div>
</body>
</html>