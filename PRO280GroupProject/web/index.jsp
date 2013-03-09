<%--
  Created by IntelliJ IDEA.
  User: cknox
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start</title>
</head>
<body>
<div style="height:600px;width:500px;border:1px solid #ccc;font:16px/26px Georgia, Garamond, Serif;overflow:auto;">
    Put user agreement here.
</div>
<br/>
<form method="post" action="start.do">
    <input type="checkbox" name="agree" checked>I have read the Terms of Service</input><br/>
    <input type="submit" value="Begin">
</form>
</body>
</html>