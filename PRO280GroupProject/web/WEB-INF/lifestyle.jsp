<%--
  Created by IntelliJ IDEA.
  User: cknox
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lifestyle</title>
    <link rel="stylesheet" href="css/sunny/jquery-ui-1.9.2.custom.css"/>
    <style>
        .slider {
            width: 300px;
        }
    </style>
</head>
<body>
<h2><i>These questions will focus on the housing and lifestyle choices while still in school:</i></h2>
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
    <%--Insert slider ranging 0-7--%>
    <label for="LunchDays">Loan Percentage: </label>
    <input type="text" id="LunchDays" style="border: 0; color: #f6931f; font-weight: bold;">

    <div id="LunchSlider" class="slider"></div>
    <br/>
    3. On average, how many days out of the week do you eat out for dinner?<br/>
    <%--Insert slider ranging 0-7--%>
    <label for="DinnerDays">Loan Percentage: </label>
    <input type="text" id="DinnerDays" style="border: 0; color: #f6931f; font-weight: bold;">

    <div id="DinnerSlider" class="slider"></div>
    <br/>
    4. On average, how much do you spend on video games per month?<br/>
    <%--Insert slider ranging 0-some number--%>
    <label for="VideoGamesBudget">Loan Percentage: </label>
    <input type="text" id="VideoGamesBudget" style="border: 0; color: #f6931f; font-weight: bold;">

    <div id="VideoGameSlider" class="slider"></div>
    <br/>
    <input type="submit" value="Next Step">
</form>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script>
    function setUpSlider(slidesu, slidi,max) {
        $(slidesu).slider({
            min: 0, max: max, value: 0,
            slide: function (event, ui) {
                $(slidi).val(ui.value);
            }
        });
        $(slidi).val($(slidesu).slider("value"));
    }
    $(function(){
                setUpSlider("#LunchSlider","#LunchDays",7);
                setUpSlider("#DinnerSlider","#DinnerDays",7);
                setUpSlider("#VideoGameSlider","#VideoGamesBudget",200);
            }
    );
</script>

</body>
</html>