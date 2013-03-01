<%--
  Created by IntelliJ IDEA.
  User: cknox
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>School</title>
</head>
<body>
<h2><i>Please answer the following questions about your school and funding:</i></h2>
1. When did you start attending Neumont:<br/>
<select name="quarter">
    <option value="fall">Fall Quarter</option>
    <option value="">Pull quarter items from database</option>
</select>
<select name="year">
    <option value="2013">2013</option>
    <option value="">Iterate through necessary years</option>
</select>
<br/>
2. Which program are you enrolled in:<br/>
<select name="program">
    <option value="bscs">BSCS</option>
    <option value="">Pull program items from database</option>
</select>
<br/>
3. How many additional quarters do you expect to attend Neumont:<br/>
Full-time:
<input type="number" name="fulltime" value="0" min="0">
Part-time
<input type="number" name="parttime" value="0" min="0">
<br/>
4. Please select an approximate ratio of funding provided loans versus out-of-pocket contributions:<br/>
<input type="range" min="0" max="100">
</body>
</html>