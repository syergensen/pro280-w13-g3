<%--
  Created by IntelliJ IDEA.
  User: cknox
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/Global/global.css"/>
    <title>Start</title>
</head>
<body>
<c:import url="WEB-INF/tags/HeaderBand.tag"/>
<div style=" height:400px;width:800px;border:1px solid #ccc;font:16px/26px Georgia, Garamond, Serif;overflow:auto;">
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
</body>
</html>