<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Choose Outlet</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link type="text/css" href="<c:url value='/resources/css/login.css' />" rel="stylesheet"/>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <div class="fadeIn first">
        </div>
        <br>
        <h1 class="display-4 text-dark">Select Outlet</h1>
        <br>
        <!-- Login Form -->
        <div class="form-group col-md-12">
            <form:form style="margin-top: 10px" commandName="outlet" action="/chooseOutlet" method="POST">
            <form:select id="outlet" path="id" class="target form-control">
                <form:option value="0" label="-SELECT OUTLET-"/>
                <form:options items="${outlets}"/>
            </form:select>
            <br>
            <input type="submit" class="fadeIn fourth" value="Select">
        </div>
        </form:form>
    </div>
</div>
</body>
</html>
