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
        <option value="newEngland">New England</option>
        <option value="">Pull regions from database</option>
    </select>
    <br/>
    2.  Please describe your preferred car:<br/>
    <input type="radio" name="carCondition" value="new">New car
    <input type="radio" name="carFuelEconomy" value="above">Above average fuel economy
    <input type="radio" name="carQuality" value="high">High end car
    <br/>
    <input type="radio" name="carCondition" value="used">Used car
    <input type="radio" name="carFuelEconomy" value="average">Average fuel economy
    <input type="radio" name="carQuality" value="average">Average car
    <br/>
    <input type="radio" name="carCondition" value="none">No car
    <input type="radio" name="carFuelEconomy" value="below">Below average fuel economy
    <input type="radio" name="carQuality" value="low">Low end car
    <br/>
    3.  Please describe your preferred house:<br/>
    <input type="radio" name="house" value="own">Own<br/>
    <input type="radio" name="house" value="rent">Rent<br/>
    <input type="radio" name="house" value="free">Live with parents
    <br/>
    <input type="submit" value="Finish">
</form>
</body>
</html>