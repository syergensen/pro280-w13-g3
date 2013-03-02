<%--
  Created by IntelliJ IDEA.
  User: cknox
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lifestyle</title>
</head>
<body>
<h3><i>These questions will focus on the housing and lifestyle choices while still in school.</i></h3>
<br/>
<form method="post" action="lifeStyle.do">
    <%--Change later to pull from database--%>
    1. What is your housing situation?<br/>
    <input type="radio" name="housing" value="neumont">Neumont University housing<br/>
    <input type="radio" name="housing" value="free">Live with family or friends for free<br/>
    <input type="radio" name="housing" value="rent">Renting an apartment or similar<br/>
    a. How much do you spend monthly for rent?
    $<input type="number" name="rent" min="0" step="any"><br/>
    b. On average, how much per month is spent on utilities/bills?
    $<input type="number" name="bills" min="0" step="any">
    <br/>
    2. On average, how many days out of the week do you eat out for lunch?<br/>
    <input type="range" min="0" max="7">
</form>
</body>
</html>