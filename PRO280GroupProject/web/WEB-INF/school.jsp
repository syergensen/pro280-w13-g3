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
    <link rel="stylesheet" href="css/Global/global.css"/>
    <style>
        #loanSlider {
            width: 300px;
        }
    </style>
<body>
<c:import url="tags/HeaderBand.tag"/>
<div class="cssGuardian">
    <h2><i>Please answer the following questions about your school and funding:</i></h2>

    <c:if test="${requestScope.error ne null}">${requestScope.error}<br/></c:if>
    <form method="post" action="school.do">
        <p>

            1. When did you start attending Neumont:

        <p class="marginLeft"><select name="quarter">
            <c:forEach items="${quarters}" var="quarter">
                <option value="${quarter.itemName}" ${sessionScope.school_quarter eq quarter.itemName ? 'selected' : ''}>${quarter.itemName}</option>
            </c:forEach> 8
        </select>
            <select name="year">
                <c:forEach var="year" begin="${currentYear - 10}" end="${currentYear}">
                    <option value="${year}" ${sessionScope.school_year eq year ? 'selected' : ''}>${year}</option>
                </c:forEach>
            </select>
        </p>
        </p>
        <p>2. Which program are you enrolled in:<br/>

        <p class="marginLeft">
            <select name="program">
                <c:forEach items="${programs}" var="program">
                    <option value="${program.degree}" ${sessionScope.school_program eq program.degree ? 'selected' : ''}>${program.degree}</option>
                </c:forEach>
            </select>
        </p>
        </p>
        <p>3. How many additional quarters do you expect to attend Neumont:<br/>

        <p class="marginLeft">Full-time:
            <input type="number" name="fullTime" value="${school_fullTime eq null ? 0 : school_fullTime}" min="0"
                   required>
            Part-time:
            <input type="number" name="partTime" value="${school_partTime eq null ? 0 : school_partTime}" min="0"
                   required>
        </p>
        </p>
        <%--Change later to pull from database--%>
        <p>4. Please select the ratio of funding provided loans versus out-of-pocket contributions:<br/>
            <label for="SliderAmount">Loan Percentage: </label>
            <input type="text" name="loanPercent" id="SliderAmount"
                   style="border: 0; color: #EA9919; font-weight: bold;"
                   readonly>

        <div id="loanSlider"></div>
        <p class="marginLeft">Loan Information:<br/>
            Total amount of grants/scholarships:
            $<input type="number" name="grants" value="${school_grants eq null ? 0 : school_grants}" min="0.0"
                    step="any" required><br/>
            Monthly interest Rate:
            <input type="number" name="interest" value="${school_interest eq null ? 0 : school_interest}" min="0.0"
                   max="100.0"
                   step="any" required>%
        </p>
        </p>
        <p>5. How much (if any) outstanding credit card debt do you have?
            $<input type="number" name="creditDebt" value="${school_creditDebt eq null ? 0 : school_creditDebt}"
                    min="0.0"
                    step="any" required>
        </p>

        <p>6. How much (if any) outstanding medical debt do you have?
            $<input type="number" name="medicalDebt" value="${school_medicalDebt eq null ? 0 : school_medicalDebt}"
                    min="0.0"
                    step="any" required>
        </p>

        <p>7. How much (if any) outstanding loan debt (school, car) do you have?
            $<input type="number" name="loanDebt" value="${school_loanDebt eq null ? 0 : school_loanDebt}" min="0.0"
                    step="any" required>
        </p>
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
</div>
</body>
</html>