<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cknox
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>School</title>
    <link rel="stylesheet" href="css/sunny/jquery-ui-1.9.2.custom.css"/>
    <style>
        #loanSlider {
            width: 300px;
        }
    </style>
<body>
<h2><i>Please answer the following questions about your school and funding:</i></h2>

<c:if test="${requestScope.error ne null}">${requestScope.error}<br/></c:if>
<form method="post" action="school.do">
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
    <input type="number" name="fullTime" value="${school_fullTime}" min="0">
    Part-time:
    <input type="number" name="partTime" value="${school_partTime}" min="0">
    <br/>
    <%--Change later to pull from database--%>
    4. Please select the ratio of funding provided loans versus out-of-pocket contributions:<br/>
    <label for="SliderAmount">Loan Percentage: </label>
    <input type="text" name="loanPercent" id="SliderAmount" style="border: 0; color: #EA9919; font-weight: bold;">

    <div id="loanSlider"></div>
    Loan Information:<br/>
    Total amount of grants/scholarships:
    $<input type="number" name="grants" value="${school_grants}" min="0.0" step="any"><br/>
    Interest Rate:
    <input type="number" name="interest" value="${school_interest}" min="0.0" max="100.0" step="any">%
    <br/>
    5. How much (if any) outstanding credit card debt do you have?
    $<input type="number" name="creditDebt" value="${school_creditDebt}" min="0.0" step="any">
    <br/>
    6. How much (if any) outstanding medical debt do you have?
    $<input type="number" name="medicalDebt" value="${school_medicalDebt}" min="0.0" step="any">
    <br/>
    7. How much (if any) outstanding loan debt (school, car) do you have?
    $<input type="number" name="loanDebt" value="${school_loanDebt}" min="0.0" step="any">
    <br/>
    <input type="submit" value="Next Step">

    <%--Script pages--%>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $('#loanSlider').slider({
                min: 0, max: 100, value: ${school_loanPercent eq null ? 50 : school_loanPercent},
                slide: function (event, ui) {
                    $("#SliderAmount").val(ui.value);
                }
            });
            $("#SliderAmount").val($("#loanSlider").slider("value"));
        });
    </script>
</form>
</body>
</html>